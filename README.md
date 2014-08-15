J2EE學習筆記
=========

* 用java內建程式產生wsdl webwervice client方法
* maven設定local denpendency的路徑格式
* springMVC + hibernate的pom可運行版本



用java內建程式產生wsdl webwervice client方法
----
在cmd目錄底下輸入
````bat
wsimport -d . -s . http://192.168.20.102:8081/wms/webservice/ShipOutWebService?wsdl
````
-d後面參數代表編譯完成的class檔案放置位址
-s後面參數拜表解析wsdl完成的原始碼擺放位址

使用client方法
````java
//找到編譯完成的xxxx_Service.java
//mmm代表wsdl method name
xxxx_Service.getXXXXPort().mmm();
````
動態修改ip(節錄)
````java
// Get the service and the port
SampleService service = new SampleService();
Sample port = service.getESamplePort();

// Use the BindingProvider's context to set the endpoint
BindingProvider bp = (BindingProvider)port;
bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, "http://www.aviramsegal.com/ws/sample");

/* Optional  credentials */
bp.getRequestContext().put(BindingProvider.USERNAME_PROPERTY, "user");
bp.getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, "password");
````

參考資料

[webservice client]

[webservice dynamic ip]



maven設定local denpendency的路徑格式
----
```xml
		<!-- orcale maven local lib設定${basedir}代表projectt的dir -->
		<dependency>
			<groupId>com.oracle</groupId>
			<artifactId>ojdbc</artifactId>
			<version>14</version>
			<scope>system</scope>
			<systemPath>${basedir}/lib/ojdbc6.jar</systemPath>
		</dependency>
		<dependency>
			<groupId>org.xerial</groupId>
			<artifactId>sqlite-jdbc</artifactId>
			<version>3.7.2</version>
			<scope>system</scope>
			<systemPath>${basedir}/lib/sqlite-jdbc-3.7.2.jar</systemPath>
		</dependency>
		
```


springMVC + hibernate的pom可運行版本
----

```xml
	<properties>
		<spring.version>3.2.0.RELEASE</spring.version>
		<jackson.version>1.9.10</jackson.version>
	</properties>
	
	
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-context-support</artifactId>
			<version>${spring.version}</version>
		</dependency>
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-core</artifactId>
			<version>${spring.version}</version>
		</dependency>

		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-web</artifactId>
			<version>${spring.version}</version>
		</dependency>

		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-webmvc</artifactId>
			<version>${spring.version}</version>
		</dependency>

		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-tx</artifactId>
			<version>${spring.version}</version>
		</dependency>

		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-orm</artifactId>
			<version>${spring.version}</version>
		</dependency>

		<dependency>
			<groupId>javax.transaction</groupId>
			<artifactId>jta</artifactId>
			<version>1.1</version>
		</dependency>

		<dependency>
			<groupId>org.hibernate</groupId>
			<artifactId>hibernate-entitymanager</artifactId>
			<version>3.3.2.GA</version>
		</dependency>

		<dependency>
			<groupId>javax.validation</groupId>
			<artifactId>validation-api</artifactId>
			<version>1.1.0.Final</version>
		</dependency>

		<dependency>
			<groupId>org.hibernate</groupId>
			<artifactId>hibernate-validator</artifactId>
			<version>5.0.1.Final</version>
		</dependency>
				<!-- Jackson JSON Mapper -->
		<dependency>
			<groupId>org.codehaus.jackson</groupId>
			<artifactId>jackson-mapper-asl</artifactId>
			<version>${jackson.version}</version>
		</dependency>

		<!-- free marker <dependency> <groupId>org.freemarker</groupId> <artifactId>freemarker</artifactId> 
			<version>2.3.19</version> </dependency> -->
		<!-- jstl -->
		<dependency>
			<groupId>jstl</groupId>
			<artifactId>jstl</artifactId>
			<version>1.2</version>
		</dependency>
		<dependency>
			<groupId>taglibs</groupId>
			<artifactId>standard</artifactId>
			<version>1.1.2</version>
			<scope>compile</scope>
		</dependency>
```

[webservice client]:http://www.oseye.net/user/kevin/blog/90
[webservice dynamic ip]:http://stackoverflow.com/questions/5158537/jaxws-how-to-change-the-endpoint-address
