package com.tiaa.processor;

import java.io.File;

import com.tiaa.dto.CmfoodchainType;

public class Test {
	
	private static String path = "C:/My WorkSpaces/NewWS1/example/src/main/";

	public static void main(String[] args) {
		/*XSDValidator.validateXMLSchema(path + "resources/cafe.xsd", path + "resources/in/BOM-1234-456.xml");
		System.out.println("Validated");*/
		
		XMLProcessor processor1 = new XMLProcessor();
		CmfoodchainType chain = processor1.parse(path + "resources/in/BOM-1234-456.xml");
		System.out.println(processor1.calculateTotalCollection(chain.getOrders().getOrderdetail()));
		
		/*JSONProcessor processor2 = new JSONProcessor();
		CmfoodchainType chain = processor2.parse(path + "resources/in/BOM-1234-457.json");
		System.out.println(processor2.calculateTotalCollection(chain.getOrders().getOrderdetail()));*/
		
		

	}

}
