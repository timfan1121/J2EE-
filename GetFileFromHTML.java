package tool;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import application.Main;
import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
 
public class GetFile {
    private static final int BUFFER_SIZE = 4194304;
    static int p=0;
    public static void downloadFile(String fileName,String fileURL, String saveDir,final TextArea result,final Label updatedate,final String now)throws IOException {
        URL url = new URL(fileURL);
        HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
        int responseCode = httpConn.getResponseCode();
 
        if (responseCode == HttpURLConnection.HTTP_OK) {
            String disposition = httpConn.getHeaderField("Content-Disposition");
            String contentType = httpConn.getContentType();
            int contentLength = httpConn.getContentLength();
 
            if (disposition != null) {
                int index = disposition.indexOf("filename=");
                if (index > 0) {
                    fileName = disposition.substring(index + 10,
                            disposition.length() - 1);
                }
            } else {
                fileName = fileURL.substring(fileURL.lastIndexOf("/") + 1,fileURL.length());
            }
 
            System.out.println("Content-Type = " + contentType);
            System.out.println("Content-Disposition = " + disposition);
            System.out.println("Content-Length = " + contentLength);
            System.out.println("fileName = " + fileName);
 
            // opens input stream from the HTTP connection
            InputStream inputStream = httpConn.getInputStream();
            String saveFilePath = saveDir + File.separator + fileName;
             
            // opens an output stream to save into file
            FileOutputStream outputStream = new FileOutputStream(saveFilePath);
 
            int bytesRead = -1;
            byte[] buffer = new byte[BUFFER_SIZE];
            p=0;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
            	p++;
            	if(p%100==0){
                    Platform.runLater(new Runnable() {
                        @Override public void run() {
                        	result.appendText("\n\r");
                        	result.appendText(Main.rb.getString("downing")+(p/100)+"MB");
                        }
                    });

            	}
                outputStream.write(buffer, 0, bytesRead);
            }
 
            outputStream.close();
            inputStream.close();
 
            System.out.println("File downloaded");
            Platform.runLater(new Runnable() {
                @Override public void run() {
                	result.appendText("\n\r");
                	result.appendText(Main.rb.getString("downDone"));
                	updatedate.setText(now);
                }
            });
        } else {
            System.out.println("No file to download. Server replied HTTP code: " + responseCode);
        }
        httpConn.disconnect();
    }
}
