package com.duo.test;

public class InterfaceDefaultImpl implements InterfaceDefault<String, String> {

	
	private static JButton ic = new JButton();
	
	public static void main(String[] args) {

//		new Thread(()->System.out.println("run ...")).start();
//		System.out.println("stop....");
		
		clickListenerEvent();
		System.out.println("-----------------");
		moveListenerEvent();
		
	}


	
	
	public static void clickListenerEvent(){
		ic.addActionListener(e -> System.out.println(" click  ...."));
	}
	
	
	public static void moveListenerEvent(){
		ic.addActionListener(e -> System.out.println(" move  ...."));
	}
	
	
	public void test1() {
		Runnable run = new Runnable() {

			@Override
			public void run() {
				System.out.println("run....");

			}
		};

		// run.run();
		new Thread(run).start();
		InterfaceDefault.display(InterfaceDefaultImpl.class.getName());
		System.out.println("stop");
	}

	@Override
	public void play() {
		// TODO Auto-generated method stub

	}
	
	

}
