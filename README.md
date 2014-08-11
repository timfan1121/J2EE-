J2EE學習筆記
=========


* maven設定local denpendency的路徑格式
* springMVC + hibernate的pom可運行版本

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

