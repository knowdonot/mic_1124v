package com.duo.test;

@FunctionalInterface
public interface InterfaceDefault<F,T> {
	
	 static void display(String name){
		
		System.out.println("Inter   display "+name);
	}
	 
	 default void show(String name){
		 display(name);
	 }
	 
	 
	 void play();

}
