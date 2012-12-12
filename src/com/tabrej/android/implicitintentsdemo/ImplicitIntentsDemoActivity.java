package com.tabrej.android.implicitintentsdemo;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.Menu;
import android.view.View;

public class ImplicitIntentsDemoActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_implicit_intents_demo);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_implicit_intents_demo, menu);
		return true;
	}

	public void openBrowser(View view){
        invokeAnotherApp(Intent.ACTION_VIEW, Uri.parse("http://www.google.co.in"));
	}
	
	public void openPhoneBook(View view){
		invokeAnotherApp(Intent.ACTION_VIEW, ContactsContract.Contacts.CONTENT_URI);
	}
	
	public void makeACall(View view){
		invokeAnotherApp(Intent.ACTION_CALL, Uri.parse("tel:0123456789"));
	}
	
	private void invokeAnotherApp(String strAction, Uri uriData){
		Intent intent = new Intent(strAction, uriData);
		startActivity(intent);
	}
}
