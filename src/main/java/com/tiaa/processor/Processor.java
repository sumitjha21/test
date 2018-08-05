package com.tiaa.processor;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;

import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.eclipse.persistence.jaxb.JAXBContext;
import org.eclipse.persistence.jaxb.UnmarshallerProperties;

import com.tiaa.dto.CmfoodchainType;
import com.tiaa.dto.OrderdetailType;

public abstract class Processor {
		
	abstract public CmfoodchainType parse(String file);
	
	public float calculateTotalCollection(List<OrderdetailType> orderDetail){
		
		float sum = 0;
		
		for(OrderdetailType order: orderDetail){
			sum = sum + order.getBillamount();
		}
		return sum;		
	}
	
	public void createOutput(CmfoodchainType cmfoodchainType, String filePath){
		
		try {	
			
			JAXBContext jc = (JAXBContext) JAXBContext.newInstance(CmfoodchainType.class);
			 Marshaller marshaller = jc.createMarshaller();
			 marshaller.setProperty(UnmarshallerProperties.MEDIA_TYPE, "application/json");
			 marshaller.setProperty(UnmarshallerProperties.JSON_INCLUDE_ROOT, true);
			 marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			 
			 OutputStream os = new FileOutputStream( filePath );
	         marshaller.marshal( cmfoodchainType, os );
	
		} catch (JAXBException e) {
			System.out.println("JAXBException in Processor");
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException in Processor");
			e.printStackTrace();
		} 
	}
	
	public void createFile(String filePath){
		try {
			OutputStream os = new FileOutputStream( filePath );
		} catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException in Processor");
			e.printStackTrace();
		}
	}

	
}
