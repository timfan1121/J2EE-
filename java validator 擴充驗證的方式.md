    
    
### java validator 擴充驗證的方式
    


```javascript
jQuery.validator.addMethod("stringCheck", function(value, element) {      
        return this.optional(element) || /^[\u0391-\uFFE5\w]+$/.test(value);      
	}, "testRule");   
```
    
#### html部分
```html 
<input type="text" class="stringCheck" name="qstationId" id="qstationId"/>
```
[參考](http://bassistance.de/jquery-plugins/jquery-plugin-validation)
