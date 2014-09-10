spring
=========

停止quartz問題
---
今天去到javafx關閉視窗但schedule還是一直在背景執行，解決的方式要透過spring的SchedulerFactoryBean關掉schedule。

##### spring xml 配置
```xml
	<bean class="org.springframework.scheduling.quartz.SchedulerFactoryBean" id="syncSchedule">
		<property name="jobDetails">
			<list>
				<ref bean="runJob" />
			</list>
		</property>
		<property name="triggers">
			<list>
				<ref bean="simpleTrigger" />
			</list>
		</property>
	</bean>
```

##### javafx 關閉視窗區段碼
```java
			 primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
				@Override
				public void handle(WindowEvent arg0) {
					Scheduler s=(Scheduler)Main.context.getBean("syncSchedule");
					try {
						s.shutdown(true);
					} catch (SchedulerException e) {
						e.printStackTrace();
					}
				}
			});
```
