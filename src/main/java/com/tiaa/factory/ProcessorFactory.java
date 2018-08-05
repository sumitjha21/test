package com.tiaa.factory;

import com.tiaa.processor.JSONProcessor;
import com.tiaa.processor.Processor;
import com.tiaa.processor.XMLProcessor;

public class ProcessorFactory {
	
	private static Processor instance = null;
	
	private ProcessorFactory(){
		
	}
	
	public static Processor getInstance( String fileName){
		
		if(fileName.contains(".json")){
			instance = new JSONProcessor();
		} else if(fileName.contains(".xml")){
			instance = new XMLProcessor();
		}	
		
		return instance;
		
	}
	
	/*private boolean isJSONContent(String content){
		
		try{
			new ObjectMapper().readTree(content);
			return true;
		}catch(Exception ex){
			System.out.println("Exception in isJSONContent");
		}
		
		return false;
	}
	
	private boolean isXMLContent(String content){
		try{
			DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new StringReader(content)));
			
			return true;
		}catch(Exception ex){
			System.out.println("Exception in isXMLContent");
		}
		
		return false;
	}*/

}
