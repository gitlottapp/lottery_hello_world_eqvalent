package com.example.lottery_hello_world_eqvalent;

import android.app.Activity;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;


/* SUMMARY OF CLASS--
 * intialize this class in the main activity with param (textview, edittext)
 * use the constructor to refer these param passed to this class
 * declare required objs for textview, edittext param refrence 
 * create a constructor with param (class object, edittext, textview)
 * set the param obj equal to local class objects
 * Initialized the textview and edittext using the intialized_every_thing_here() method
 * set a listener on the edittext (getting the data from user and displaying happens in the get_user_data_manually() method)
 * create a getter method for the data typed in by user
 * */


public class Step1_class {
	
	//declare refrence objs for the constructor parameters
	Context context_obj;
	EditText refrence_edittext_obj;
	TextView refrence_textview_obj;
	
	//declare objs for this class use
	CharSequence get_data_from_user_obj;
	
	
	//a construtor without arguments, so that i can use it in Step2_class to create an obj of this class to access the getter method
	public Step1_class() {
		System.out.println("Step1_class() constructor without param is called");
	
	}
	
	//://stackoverflow.com/questions/10996479/how-to-update-a-textview-of-an-activity-from-another-class
	//the constructor is used to set the refrence variable the we will pass in to objects of this class
	/*
	 * @param 	the obj of the MainActivity class
	 * @param 	edittext obj where the user will enter stuff
	 * @param 	textview obj where the user enter value will be displayed
	 * 
	 * */
	public Step1_class(Context x, EditText y, TextView z) {
		System.out.println("Step1_class() constructor with param is called");
		
		this.context_obj = x; 
		this.refrence_edittext_obj = y;
		this.refrence_textview_obj=z;
	
		//call the required methods
		intialized_every_thing_here();
		get_user_data_manually();
		
	}
	
	
	// THis method is used to intialized all the required obj in our project 
	public void intialized_every_thing_here() {
		System.out.println("intialized_every_thing_here() is called");	
		
		    //use the context_obj to reference to the MainActivity class
			refrence_edittext_obj = (EditText) ((Activity) context_obj).findViewById(R.id.EditText01);
			//below lines comment to make the code simpler
			/*editText02 = (EditText) findViewById(R.id.EditText02);
			editText03 = (EditText) findViewById(R.id.EditText03);
			editText04 = (EditText) findViewById(R.id.EditText04);
			editText05 = (EditText) findViewById(R.id.EditText05);
			editText06 = (EditText) findViewById(R.id.EditText06);*/
			//get the text as user enter it in the text
			
			//don't need the below array to store for nw... all the getting user text happens in the listener
			//textArray = new String[] { editText01.getText().toString()};	
			//below lines comment to make the code simpler
			//,editText02.getText().toString(),editText03.getText().toString(),editText04.getText().toString(),editText05.getText().toString(),editText06.getText().toString() 

			refrence_textview_obj = (TextView) ((Activity) context_obj).findViewById(R.id.DisplayNumbers);
		}

	//let the user type the lottery manually and save the data in a string and display it back to the user
		//http://www.learn2crack.com/2014/02/android-textwatcher-example.html
		//http://rajeshvijayakumar.blogspot.com/2013/03/text-watcher-example-in-android.html
	public void get_user_data_manually(){
			System.out.println("get_user_data_manually() is called");
			
			//TextWatcher is an interface, thus need to override the following methods(eclipse automatically create these methods)
			refrence_edittext_obj.addTextChangedListener(new TextWatcher(){

				//method is used to display a note to use before he start typing
				@Override
				public void beforeTextChanged(CharSequence s, int start, int count,
						int after) {
					System.out.println("beforeTextChanged() is called");
					
				}

				//as user type the stuff in the edittext, it is displayed in the textview
				/*
				 * @param 	its the whatever the use type in 
				 * @param	the max value that a user can type
				 * @param	
				 * @param
				 * */
				@Override
				public void onTextChanged(CharSequence s, int start, int before,
						int count) {
					System.out.println("onTextChanged() is called");
					
					get_data_from_user_obj = s;
					
					//display the text
					refrence_textview_obj.setText(get_data_from_user_obj);
					System.out.println("Value of get_data_from_user_obj is   : "+ get_data_from_user_obj);
					
				}
				
				//method is use to notify the user after he has entered the value
				@Override
				public void afterTextChanged(Editable s) {
					System.out.println("afterTextChanged() is called");
					System.out.println("Value of get_data_from_user_obj is   : "+ get_data_from_user_obj);
					
					System.out.println("Step2_class is called");
					Step2_class step2_class_obj = new Step2_class();
				
				}});
			
		}
	
	public CharSequence getter_for_user_typed_data(){
		System.out.println("getter_for_user_typed_data() is called");
		System.out.println("The value of the get_data_from_user_obj is  :" + get_data_from_user_obj);
		
		return get_data_from_user_obj;
		
	}
	
	

}
