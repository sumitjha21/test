package com.tiaa.processor;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.tiaa.dto.CmfoodchainType;
import com.tiaa.dto.OrderdetailType;

public class XMLProcessor extends Processor{
	
	public CmfoodchainType parse(String file){
		
		CmfoodchainType cmFoodChain = null;
		try {
			JAXBContext jc = JAXBContext.newInstance(CmfoodchainType.class);
			 Unmarshaller unmarshaller = jc.createUnmarshaller();
		     cmFoodChain = (CmfoodchainType) unmarshaller.unmarshal(new File(file));

		     Marshaller marshaller = jc.createMarshaller();
		     marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		     marshaller.marshal(cmFoodChain, System.out);
		} catch (JAXBException e) {
			System.out.println("JAXBException in XMLProcessor");
			e.printStackTrace();
		}   
		
		return cmFoodChain;
	}
	
	public float calculateTotalCollection(List<OrderdetailType> orderDetail){
		
		float sum = 0;
		
		for(OrderdetailType order: orderDetail){
			sum = sum + order.getBillamount();
		}
		return sum;		
	}	
	
	

}
