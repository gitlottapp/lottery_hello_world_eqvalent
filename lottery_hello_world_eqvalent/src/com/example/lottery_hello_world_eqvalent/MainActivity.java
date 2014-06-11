package com.example.lottery_hello_world_eqvalent;

//Note to Each Other- 
/*
 * To Amar-
 * Spend extra time on comments(since we will be learning from each other)
 * I changed the layout of the code it helps a lot in debugging				
 * 
 * To Harminder-
 * 
 * 
 * 
 * */

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

//hover over the Activity with your mouse and eclipse will display a drop down, the best explain on this topic
public class MainActivity extends Activity {
	// Intialize every thing here
	EditText editText01;
	//below lines comment to make the code simpler
	/*EditText editText02;
	EditText editText03;
	EditText editText04;
	EditText editText05;
	EditText editText06;*/
	String[] textArray;
	TextView displayNumbers;
	CharSequence store_value_from_editText01;
	
	// THis is the equavalent of java main methods
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		System.out.println("onCreate() is called");
		
		//??????
		super.onCreate(savedInstanceState);
		
		// @param determine how to screen will look like
		setContentView(R.layout.activity_main);

		intialized_every_thing_here();
		System.out.println("intialized_every_thing_here() is called");

		//displays the array first element in the textView
		//comment the below line
		//displayNumbers.setText(textArray[0]);

		get_user_data_manually();
		System.out.println("get_user_data_manually() is called");
		
	}

	// THis method is used to intialized all the required obj in our project and it gets run right after....
	// ....the setContentView() method (its onCreate)
	public void intialized_every_thing_here() {
		editText01 = (EditText) findViewById(R.id.EditText01);
		//below lines comment to make the code simpler
		/*editText02 = (EditText) findViewById(R.id.EditText02);
		editText03 = (EditText) findViewById(R.id.EditText03);
		editText04 = (EditText) findViewById(R.id.EditText04);
		editText05 = (EditText) findViewById(R.id.EditText05);
		editText06 = (EditText) findViewById(R.id.EditText06);*/
		//get the text as user enter it in the text
		
		textArray = new String[] { editText01.getText().toString()};	
		//below lines comment to make the code simpler
		//,editText02.getText().toString(),editText03.getText().toString(),editText04.getText().toString(),editText05.getText().toString(),editText06.getText().toString() 

		displayNumbers = (TextView) findViewById(R.id.DisplayNumbers);
	}

	//let the user type the lottery manually and save the data in a string and display it back to the user
	//http://www.learn2crack.com/2014/02/android-textwatcher-example.html
	//http://rajeshvijayakumar.blogspot.com/2013/03/text-watcher-example-in-android.html
	public void get_user_data_manually(){
		System.out.println("get_user_data_manually() is called");
		
		//TextWatcher is an interface, thus need to override the following methods(eclipse automatically create these methods)
		editText01.addTextChangedListener(new TextWatcher(){

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
				
				store_value_from_editText01 = s;
			
			}
			
			//method is use to notify the user after he has entered the value
			@Override
			public void afterTextChanged(Editable s) {
				System.out.println("afterTextChanged() is called");
			
				displayNumbers.setText(store_value_from_editText01);
				
				
			}});
		
	}
	
	// This method is used to display a menu in your app , we don't need to
	// worry about that for now
	/*
	 * @Override public boolean onCreateOptionsMenu(Menu menu) { // Inflate the
	 * menu; this adds items to the action bar if it is present.
	 * getMenuInflater().inflate(R.menu.main, menu); return true; }
	 */

}
