hibernate & oracle DB 
=========

auto insert id 問題
---
如果沒有在oracle產生物件，在insert資料的時候會出現error，u因此解決方法為新增oracle裡面產生seq物件

##### sql語法如下
```sql
CREATE SEQUENCE epos_sq START WITH 20 INCREMENT BY 1;
```

##### hibernate model id設定如下
```java
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="my_seq_gen")
	@SequenceGenerator(name="my_seq_gen", sequenceName="epos_sq")
	@Column(name="ID")
	int id;
```


##### 刪除SEQ物件
```sql
DROP SEQUENCE epos_sq;
```
