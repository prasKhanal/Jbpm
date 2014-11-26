package com.app;
import  org.drools.core.util.KieFunctions;

public class SomeClass {
 private String value;
	public void setValue(String string) {
		this.value=string;
		String clientApproval="";
		KieFunctions.isTrue(Integer.parseInt(clientApproval)<=1);
		
	}
	public String getValue() { return value;}

}
