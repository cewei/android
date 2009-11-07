package apress.book.example;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginScreen extends Activity {
	
	private OnClickListener buttonListener =
		new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				grabEnteredText();
			}
		};
	
	Button btn = null;
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.login);
	    
	    btn = (Button) findViewById(R.id.loginbutton);
	    btn.setOnClickListener(buttonListener);
	}
	
	public void grabEnteredText() {
		// Get pointer to the status text
		TextView status = (TextView) findViewById(R.id.status);
		
		// Grab handles to both text-entry fields
		EditText username = (EditText) findViewById(R.id.username);
		EditText password = (EditText) findViewById(R.id.password);
		
		// Extract Strings from the EditText objects
		// and format into strings.
		String userTxt = username.getText().toString();
		String passTxt = password.getText().toString();
		
		//HTTP transaction would spin up a
		//new thread here
		status.setText("Login " +userTxt +" : " +passTxt);
		
		// Show dialog box that would eventually turn into
		//this.showDialog("Login Data", 0, "Login " +userTxt +" : " +passTxt, "OK!", false);
				new AlertDialog.Builder(this)
				.setTitle("Login Data")
				.setMessage("Login " +userTxt +" : " +passTxt).create();
				
	}

}
