
##### 情況說明
使用dynatable的時候，用jquery提供的ajax去刷新table裡面的資料，如果直接把資料再重新丟給table會沒有作用
假使更新table裡面的資料要用process的方式去更新table裡面資料

##### 現況的程式碼 
如過使用下面的code沒辦法更新table裡面的資料
```javascript
$.ajax({
  url: 'ajax_data.json',
  success: function(data){
    $('#my-final-table').dynatable({
      dataset: {
        records: data
      }
    });
  }
});

```


##### import
```
<script src="<c:out value="${pageContext.request.contextPath}"/>/js/jquery2.1.1.min.js" type="text/javascript"></script>
<script src="<c:out value="${pageContext.request.contextPath}"/>/js/jquery.dynatable.js" type="text/javascript"></script>

<link href="<c:out value="${pageContext.request.contextPath}"/>/css/jquery.dynatable.css" rel="stylesheet"/>
```

##### javascript ajax 刷新
```javascript
    	$.getJSON('<c:out value="${pageContext.request.contextPath}"/>/dialog/getProduct?barcode='+barcode+'&prodName='+prodName, function(json){
			dynatable.records.updateFromJson({records: json});
			dynatable.records.init();
			dynatable.process();
		});
```

##### html部分
```html
    		<table id="my-final-table">
				<thead>
						<th data-dynatable-column="BARCODE">商品條碼</th>
						<th data-dynatable-column="PROD_NAME">商品名稱</th>
						<th data-dynatable-column="UNIT_NAME">單位</th>
				</thead>
				<tbody>
				</tbody>
			</table>
```


##參考
* [dynatable](http://www.dynatable.com/) 
