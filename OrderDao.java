package com.restful.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.ws.rs.WebApplicationException;

public class OrderDao {
	
	public int saveOrder(Map<String,String> orderdata){		
		int status=-1;		
		Map<String,String> savedData=getOrderList();
		if(savedData !=null ){
			
			for(Map.Entry<String, String> neworder:orderdata.entrySet()){
				savedData.put(neworder.getKey(), neworder.getValue());
			}			
		}else{
			savedData=orderdata;
		}
		try{
			File file=new File("C:\\Anil\\ordersdata.dat");
			FileOutputStream fos=new FileOutputStream(file);
			
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			oos.writeObject(savedData);
			oos.close();
			status=1;
		}catch(Exception e){
			e.printStackTrace();			
		}
		return status;
	}


	public Map<String,String> findOrder(String order){
		Map<String,String> orderdata=null;
		try{
			FileInputStream fis=new FileInputStream("C:\\Anil\\ordersdata.dat");
			ObjectInputStream ois=new ObjectInputStream(fis);
			orderdata=(Map<String,String>)ois.readObject();
			ois.close();
		}catch(Exception e){
			throw new WebApplicationException();
		}
		return orderdata;
	}

	public Map<String, String> getOrderList() {
		Map<String,String> orderdata=null;
		try{
			FileInputStream fis=new FileInputStream("C:\\Anil\\ordersdata.dat");
			ObjectInputStream ois=new ObjectInputStream(fis);
			orderdata=(Map<String,String>)ois.readObject();
			ois.close();
		}catch(Exception e){
			throw new WebApplicationException();
		}
		return orderdata;
	}
}
