package com.tiaa;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import com.tiaa.dto.Branch;
import com.tiaa.dto.BranchType;
import com.tiaa.dto.CmfoodchainType;
import com.tiaa.factory.ProcessorFactory;
import com.tiaa.processor.Processor;

public class Engine {
	
	private static String path = "C:/My WorkSpaces/NewWS1/example/src/main/resources/in/";
	private static Processor processor;

	public static void main(String[] args) {
		
		File folder = new File(path);
		File[] listOfFiles = folder.listFiles();
		CmfoodchainType output = null;
		Branch branchesMatch = new Branch();
		Branch branchesMismatch = new Branch();

		for (File file : listOfFiles) {
		    if (file.isFile()) {
		    	BranchType branch = new BranchType();
		    	processor = ProcessorFactory.getInstance(file.getAbsolutePath());
		    	CmfoodchainType input = processor.parse(file.getAbsolutePath());
		    	branch.setLocation(input.getBranch().getLocation());
		    	branch.setLocationid(input.getBranch().getLocationid());
		    	branch.setTotalcollection(input.getBranch().getTotalcollection());
		    	branch.setSumoforder(processor.calculateTotalCollection(input.getOrders().getOrderdetail()));
		    	if(branch.getTotalcollection() != branch.getSumoforder()){
		    		branchesMismatch.getBranch().add(branch);
		    	}else{
		    		branchesMatch.getBranch().add(branch);
		    	}	    	
		    	
		    }
		}
		if(branchesMatch.getBranch().size() != 0){
			output = new CmfoodchainType();
			output.setBranches(branchesMatch);			
			processor.createOutput(output, path + "Match.json");
		}else if(branchesMismatch.getBranch().size() != 0){
			output = new CmfoodchainType();
			output.setBranches(branchesMismatch);			
			processor.createOutput(output, path + "Mismatch.json");
		}else if(branchesMatch.getBranch().size() == 0){
			processor.createFile( path + "Match.json" );
		}else if(branchesMatch.getBranch().size() == 0){
			processor.createFile( path + "Mismatch.json" );
		}
		
		

	}

}
