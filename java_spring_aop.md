    
    
### java spring AOP 
    
---
最近的案子常常在做一些交易的事情，一個交易會有預先處理和最後觸裡的一些作業，除了交易還有GUI前端的同步
所以這裡大概說明一個交易會圍繞兩個method interception，第一層是GUI的處理，第二層是會update單子的flow前置作業，例如要和遠端的訂單先同步flow，
遠端成功後再去處理本地端的邏輯。

---

##### 會用到的概念

* ProxyFactoryBean
* NameMatchMethodPointcutAdvisor
* MethodInterceptor

---

##### 說明
    spring aop的方式有很多樣，最後選擇對自己較直覺的作法，interception都用環繞式的，
    當然interception也有前後的方式可以攔截，這裡還有一點是攔截方法的過濾器，如果沒有這過濾器，就是針對邏輯的class所有方法都會實現interception

---
#### spring aop .xml setting
```xml
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://www.springframework.org/schema/beans
	http://www.springframework.org/schema/beans/spring-beans-3.0.xsd">

	<bean id="businessBean" class="org.springframework.aop.framework.ProxyFactoryBean">
		<!-- 也可以用interface實現 -->
		<!-- <property name="proxyInterfaces"> -->
		<!-- <value>aop.OrderServiceImp</value> -->
		<!-- </property> -->

		<!-- 用class 實現 -->
		<property name="target">
			<ref bean="orderServiceImp" />
		</property>

		<property name="interceptorNames">
			<list>
				<value>dialogProcessInterceptor</value>
				<value>morderInterceptor</value>
				
				<!-- imp也可以在這裡實現 -->
				<!-- <value>orderServiceImp</value> -->
				
				<value>customerMethodAdvisor</value>
			</list>
		</property>
	</bean>

	<bean id="customerMethodAdvisor"
		class="org.springframework.aop.support.NameMatchMethodPointcutAdvisor">
		<!--通知  這邊去設計一個空的method interceptor-->
		<property name="advice" ref="emptyInterceptor"></property>
		
		<!-- 哪個方法被攔截？ -->
		<property name="mappedNames">
			<value>show</value>
		</property>
	</bean>

</beans>

```
    
#### GUI 第一層
```java 

@Component
public class DialogProcessInterceptor implements MethodInterceptor{
    DialogProc diaProc;
	final static String updateDone="receive.updateDone";
	final static String updateError="receive.updateError";
	private Object result;
	
	@Override
	public Object invoke(final MethodInvocation me){
		result = null;
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				diaProc=new DialogProc(Main.primaryStage);
				diaProc.showit();
				String rsmsg=Main.rb.getString(updateDone);
				try {
					result=me.proceed();
				} catch (Throwable e) {
					e.printStackTrace();
					rsmsg=updateError;
				}finally{
					diaProc.dismiss();
					new DialogMsg(Main.primaryStage).showit(rsmsg);
				}
			}
		});
		return result;
	}
}

```

#### 更新flow 第二層
```java 
@Component
public class MorderInterceptor implements MethodInterceptor{

    @Override
	public Object invoke(MethodInvocation me) throws Throwable {
		updateflow("comfrom 1");
		Object result=me.proceed();
		updateflow("comfirm end");
		return result;
	}
	
	
	private void updateflow(String str){
		System.out.println("update flow is "+str);
	}

}

```

#### 主要邏輯程式
```java 
@Component
public class OrderServiceImp {
    
	public void show(String orderId,int flow,SOrder stationOrder) throws Exception {
		Thread.sleep(5000);
	}

}

```

