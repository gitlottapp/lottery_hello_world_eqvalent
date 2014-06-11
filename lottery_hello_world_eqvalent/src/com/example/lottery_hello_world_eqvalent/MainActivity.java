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
import android.widget.EditText;
import android.widget.TextView;

//hover over the Activity with your mouse and eclipse will display a drop down, the best explain on this topic
public class MainActivity extends Activity {
	// Intialize every thing here
	EditText editText01;
	EditText editText02;
	EditText editText03;
	EditText editText04;
	EditText editText05;
	EditText editText06;
	String[] textArray;
	TextView displayNumbers;

	// THis is the equavalent of java main method
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
		displayNumbers.setText(textArray[0]);

	}

	// THis method is used to intialized all the required obj in our project and
	// it gets run right after....
	// ....the setContentView() method runs (it is onCreate)
	public void intialized_every_thing_here() {
		editText01 = (EditText) findViewById(R.id.EditText01);
		editText02 = (EditText) findViewById(R.id.EditText02);
		editText03 = (EditText) findViewById(R.id.EditText03);
		editText04 = (EditText) findViewById(R.id.EditText04);
		editText05 = (EditText) findViewById(R.id.EditText05);
		editText06 = (EditText) findViewById(R.id.EditText06);

		textArray = new String[] { editText01.getText().toString(),
				editText02.getText().toString(),
				editText03.getText().toString(),
				editText04.getText().toString(),
				editText05.getText().toString(),
				editText06.getText().toString() };

		// System.out.println(textArray);
		displayNumbers = (TextView) findViewById(R.id.DisplayNumbers);
	}

	// This method is used to display a menu in your app , we don't need to
	// worry abt that for nw.
	/*
	 * @Override public boolean onCreateOptionsMenu(Menu menu) { // Inflate the
	 * menu; this adds items to the action bar if it is present.
	 * getMenuInflater().inflate(R.menu.main, menu); return true; }
	 */

}
