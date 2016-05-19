package com.restful.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Anil Kumar
 * @email: anitowrite@hotmail.com
 * @Description: Rest Jersy Web Service example
 * @Agenda: where two service method expose fetch users and save users using GET and POST Http
 * methods.Data is saving to flat file using object persistent. 
 */

public class UserDao {

	@SuppressWarnings("unchecked")
	public List<User> getAllUsers(){
		List<User> userList=null;
		try{
			File file=new File("C:\\Anil\\User.dat");
			if(!file.exists()){
				User user=new User(20031,"Anil Kumar","Software Engineer");
				User user2=new User(20032,"Avinash Singh","Software Engineer");
				User user3=new User(20033,"Gaurav chadha","Software Engineer");
				userList=new ArrayList<User>();
				userList.add(user);
				userList.add(user2);
				userList.add(user3);
				saveUserList(userList);
			}else{
				FileInputStream fis=new FileInputStream(file);
				ObjectInputStream ois=new ObjectInputStream(fis);
				userList=(List<User>)ois.readObject();
				ois.close();
			}
		}catch(IOException ioexp){
			ioexp.printStackTrace();
		}catch(Exception exp){
			exp.printStackTrace();
		}
		return userList;
	}

	private void saveUserList(List<User> userList) {
		try{
			File file=new File("C:\\Anil\\User.dat");
			FileOutputStream fos=new FileOutputStream(file);
			
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			oos.writeObject(userList);
			oos.close();
		}catch(IOException ioexp){
			ioexp.printStackTrace();
		}catch(Exception exp){
			exp.printStackTrace();
		}
		
	}
	public void saveUsers(User user){
		List<User> userList=getAllUsers();
		userList.add(user);
		saveUserList(userList);
	}
	
}
