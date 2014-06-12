package com.example.lottery_hello_world_eqvalent;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/*SUMMARY OF CLASS- 
 * get the data from the Step1_class via getter method and store it in a obj
 * method to send the data to a php script via POST request(laptop XAMPP server for now)
 * go to the server and write the php script, which will post the recieved data to mysql server
 * read the response of the server and system.out it
 * 
 * 
 * */

public class Step2_class {

	//declare the objs to be used in this class
	CharSequence store_user_returned_data;
	String string_url_obj = "http://10.0.3.2/Example/Android/amars_lottery_app/post_data_to_mysql.php";
	
	//do everything in the constructor so that i gets run automatically
	public Step2_class() {
		System.out.println("Step2_class constructor is called");
		
		Step1_class step1_class_obj = new Step1_class();
		store_user_returned_data = step1_class_obj.getter_for_user_typed_data();
		System.out.println("getter_for_user_typed_data()  return value is:  " + store_user_returned_data);
		
		send_data_to_php_script((String) store_user_returned_data);
		
		
		//send_data_to_php_script("1");
		
	}
	
	//send the get that i got from the Step1_class getter method
	public void send_data_to_php_script(String c){
		System.out.println("send_data_to_php_script() is called");
		
		//declare the required objs
		String temp_obj = "key="+c;
		HttpURLConnection httpURLConnection_obj;
		URL url_obj;
		OutputStreamWriter outputStreamWriter_obj;
		InputStreamReader inputStreamReader_obj;
		
		
		//all the networking and reading/writing stuff needs to be surrounded in try catch
		try {
			/*
			 * intialize url via constructor
			 * open a connection
			 * set the method type
			 * set data to be send
			 * set output to true
			 * create a output stream and put the http data into it
			 * close everything
			 * 
			 * */
			
			//you have to use 10.0.0.3 when accessing your local XAMPP server from an emulator
			url_obj = new URL(string_url_obj);		
			httpURLConnection_obj = (HttpURLConnection)url_obj.openConnection();
			httpURLConnection_obj.setRequestMethod("POST");
			httpURLConnection_obj.setDoOutput(true);
			httpURLConnection_obj.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

			outputStreamWriter_obj = new OutputStreamWriter(httpURLConnection_obj.getOutputStream());
			outputStreamWriter_obj.write(temp_obj);
			outputStreamWriter_obj.flush();
			outputStreamWriter_obj.close();
			
			httpURLConnection_obj.connect();
			
			inputStreamReader_obj = new InputStreamReader(httpURLConnection_obj.getInputStream());
			BufferedReader bufferedReader_obj = new BufferedReader(inputStreamReader_obj);
			
			String s = bufferedReader_obj.readLine();
			System.out.println("The return data from server:   " + s );
			
		} catch (Exception e) {
			System.out.println("Error: send_data_to_php_scrpit() threw an exception");
			e.printStackTrace();
		
		}
		
	}
		
		
	
	
	
	
}
