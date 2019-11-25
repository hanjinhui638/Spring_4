package com.jh.s4.transfer;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

@Component
public class Card {
	

	
	public void cash() {
		System.out.println("==== 현금 내기 ====");
		
	}
	
	public Object cardCheck(ProceedingJoinPoint join) {
		//advice
		//join -> getBus 메서드
			System.out.println("==== 승차	전 카드 찍기 ====");
			Object obj = null;
				try {
					Object [] args = join.getArgs();	//args 매개변수 
					for(Object object:args) {
						System.out.println(object);
						
					}
					obj = join.proceed();
				} catch (Throwable e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			System.out.println("==== 내린 후 카드 찍기 ====");
			
			return obj;
	}

}
