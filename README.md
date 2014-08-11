J2EE學習筆記
=========


* maven設定local denpendency的路徑格式

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

