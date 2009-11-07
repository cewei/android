/**
 * 
 */
package apress.book.example;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * @author Lancer-Matrix
 *
 */
public class MainMenu extends Activity {
	
	TextView status;
	public static final int IdOne = 1;
	public static final int IdTwo = 2;
	public static final int IdThree = 3;
	
	OnFocusChangeListener focusListener = 
		new OnFocusChangeListener() {
			
			@Override
			public void onFocusChange(View v, boolean hasFocus) {
				adjustTextColor(v, hasFocus);
			}
		};
		
	OnClickListener clickListener = 
		new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String text = "You selected Item: ";
				
				switch(v.getId()) {
				case IdOne:
					text += "1";
					startActivity(new Intent(MainMenu.this, LoginScreen.class));
					break;
					
				case IdTwo:
					text += "2";
					startActivity(new Intent("com.apress.example.CUSTOM_VIEW"));
					break;
				
				case IdThree:
					text += "3";
					break;
				}
				
				status.setText(text);
				
			}
		};
	
	private void adjustTextColor(View v, boolean hasFocus) {
		//Dangerous cast. Be sure you are
		//listening only to TextView focus changes
		// or this could go horribly wrong.
		TextView t = (TextView) v;
		if (hasFocus) {
			t.setTextColor(Color.RED);
		} else {
			t.setTextColor(Color.WHITE);
		}
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		LinearLayout layout = new LinearLayout(this);
		layout.setBackgroundResource(R.drawable.general_bg);
		layout.setOrientation(LinearLayout.VERTICAL);
		layout.setLayoutParams(
			new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT)
		);
		
		//setContentView(R.layout.main);
		setContentView(layout);
		
		TextView title = new TextView(this);
		title.setText(R.string.man_menu_title);
		title.setLayoutParams(
			new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT)
		);
		title.setGravity(Gravity.CENTER);
		
		layout.addView(title);
		
		TextView ItemOne = new TextView(this);
		ItemOne.setFocusable(true);
		ItemOne.setText("Login Screen");
		ItemOne.setTextColor(Color.WHITE);
		ItemOne.setLayoutParams(
			new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT)
		);
		ItemOne.setOnFocusChangeListener(focusListener);
		ItemOne.setOnClickListener(clickListener);
		
		//Give the menu item an ID for tracking reasons.
		//The ID is a static int defined locally to the class
		ItemOne.setId(IdOne);
		//Add it to our linear layout
		layout.addView(ItemOne);
		
		TextView ItemTwo = new TextView(this);
		ItemTwo.setFocusable(true);
		ItemTwo.setText("Custom View Demo");
		ItemTwo.setTextColor(Color.WHITE);
		ItemTwo.setLayoutParams(
			new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT)
		);
		ItemTwo.setOnFocusChangeListener(focusListener);
		ItemTwo.setOnClickListener(clickListener);
		
		ItemTwo.setId(IdTwo);
		layout.addView(ItemTwo);
		
		TextView ItemThree = new TextView(this);
		ItemThree.setFocusable(true);
		ItemThree.setTextColor(Color.WHITE);
		ItemThree.setText("Menu Item Three");
		ItemThree.setLayoutParams(
			new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT)
		);
		ItemThree.setOnFocusChangeListener(focusListener);
		ItemThree.setOnClickListener(clickListener);
		
		ItemThree.setId(IdThree);
		layout.addView(ItemThree); 
		
		status = new TextView(this);
		status.setLayoutParams(
			new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT)
		);
		layout.addView(status);
	}

}
