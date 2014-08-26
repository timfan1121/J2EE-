Gson
=========

### exception
```
>08-26 10:28:10.233: W/System.err(10094): com.google.gson.JsonSyntaxException: 1409018841000
```

### 說明
```
原因在於oracle的DB column格式為timestamp所以會有毫秒的數值
對於gson預設的parser沒有辦法處理毫秒問題
所以會丟出exception
解決的方法為至做一個gson的paser來處理毫秒問題
```

### 做一個parser
``` java
public class JsonDateDeserializer implements JsonDeserializer<Date> {
   public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
      String s = json.getAsJsonPrimitive().getAsString();
      long l = Long.parseLong(s.substring(6, s.length() - 2));
      Date d = new Date(l);
      return d; 
   } 
}
```

### 產生一個gson物件
``` java
Gson gson = new GsonBuilder().registerTypeAdapter(Date.class, new JsonDateDeserializer()).create();
```

參考資料
http://stackoverflow.com/questions/12878693/gson-jsonsyntaxexception-on-date
