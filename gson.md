Gson
=========

millseconds解析遇到的問題
=========

08-26 10:28:10.233: W/System.err(10094): com.google.gson.JsonSyntaxException: 1409018841000



做一個parser
===========
```java
public class JsonDateDeserializer implements JsonDeserializer<Date> {
   public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
      String s = json.getAsJsonPrimitive().getAsString();
      long l = Long.parseLong(s.substring(6, s.length() - 2));
      Date d = new Date(l);
      return d; 
   } 
}
```

產生
===========
```java
Gson gson = new GsonBuilder().registerTypeAdapter(Date.class, new JsonDateDeserializer()).create();
```

參考資料
http://stackoverflow.com/questions/12878693/gson-jsonsyntaxexception-on-date
