package com.jh.s4.transfer;

import org.springframework.stereotype.Component;

@Component
public class Transfer {				
//Join Point 
	
	public void car() {
		System.out.println("---- MyCar ----");
		System.out.println(" 운전하기 ");
		System.out.println("---- MyCar ----");
		
		
	}
	
	public void taxi(){
		
		 System.out.println("---- Taxi ----");
		 System.out.println(" 기사님과 대화하기 ");
		 System.out.println("---- Taxi ----");
		
	}
	
	public void getBus(String cardName) {
	//Point cut
		
		System.out.println("---- Bus ----");
		System.out.println("---- 음악듣기 -----");
		System.out.println("---- Bus ----");
		
	}
	
	public void getSubway(String cardName) {
	//Point cut 	
		System.out.println("---- SubWay ----");
		System.out.println("핸드폰 보기");
		System.out.println("---- SubWay ----");
		
	}


}
