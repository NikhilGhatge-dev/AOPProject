package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.manager.AuthenticationManager;
import com.nt.service.BankMgmtService;

public class BeforeAdviceTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		AuthenticationManager manager=null;
		BankMgmtService proxy=null;
		//create IOC conatiner
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//Get Manager
		manager=ctx.getBean("authManager",AuthenticationManager.class);
		proxy=ctx.getBean("bankService",BankMgmtService.class);
		manager.signIn("raja","ran");
		try {
			//withdraw
			System.out.println(proxy.withdrowMoney(1001,1000));
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("........................................................................");
		try {
			//withdraw
			System.out.println(proxy.depositeMoney(1002,5000));
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		manager.signOut();
		
		//close container
		((AbstractApplicationContext) ctx).close();

	}//main

}//class
