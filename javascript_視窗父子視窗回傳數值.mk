javascript 跳出視窗B 回填到視窗A
===

情境
---
    很多表單可能利用select去做表格內需要填入特定值得輸入元件，但也可以用按鈕跳出另一個視窗，填入特定的數值，這樣不用在原本的視窗內撰寫select的控制元件

A 視窗
----

####javasciprt
```javascript
var pa='top='+$('#qbtn').offset().top+',left='+$('#qbtn').offset().left+',height=100,width=400,toolbar=no,menubar=no,scrollbars=no, resizable=no,location=no, status=no';
var retValue =window.open ('showAuthSelectDialog','newwindow',pa); 
```

####html
```html
<form action="/member/query" method="get" id="queryForm" name="queryForm">
	<input type="text" name="qtel" id="qtel" value="<c:out value="${qtel}"/>"/><button id="qbtn" onclick="openDialog(this)">說明</button>
</form>
```


---
B視窗
---
```javascript
function closeit(){
    //代表回填到A視窗queryForm底下name為qtel的input
    window.opener.document.queryForm.qtel.value='return value from B';
	window.close(); 
}

```
