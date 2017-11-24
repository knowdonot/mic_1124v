package com.duo.test;

import java.awt.event.ActionListener;

public class JButton {
	
	public JButton(){
		System.out.println("  JButton   init....");
	}

	public void addActionListener(ActionListener actionListener){
		System.out.println(actionListener.toString()+"............");
	}

}
