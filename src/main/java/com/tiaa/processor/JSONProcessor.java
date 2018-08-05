package com.tiaa.processor;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.eclipse.persistence.jaxb.JAXBContext;
import org.eclipse.persistence.jaxb.UnmarshallerProperties;

import com.tiaa.dto.CmfoodchainType;
import com.tiaa.dto.OrderdetailType;

public class JSONProcessor extends Processor{
	
public CmfoodchainType parse(String file){
		
		CmfoodchainType cmFoodChain = null;
		try {	
			
			JAXBContext jc = (JAXBContext) JAXBContext.newInstance(CmfoodchainType.class);
			 Unmarshaller unmarshaller = jc.createUnmarshaller();
			 unmarshaller.setProperty(UnmarshallerProperties.MEDIA_TYPE, "application/json");
			 unmarshaller.setProperty(UnmarshallerProperties.JSON_INCLUDE_ROOT, true);
		     cmFoodChain = (CmfoodchainType) unmarshaller.unmarshal(new File(file));
		     
		} catch (JAXBException e) {
			System.out.println("JAXBException in XMLProcessor");
			e.printStackTrace();
		}  
		
		return cmFoodChain;
	}


	
	
	
}
