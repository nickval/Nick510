package com.nick510;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignupActivity extends Activity {
	// Declare Variables
	Button signupToParse;

	String usernametxt;
	String userNameSurnametxt;
	String passwordtxt;
	String userEmailtxt;
	String phonetxt;
	String postaladresstxt;
	String dobtxt;

	EditText username;
	EditText userNameSurname;
	EditText password;
	EditText userEmail;
	EditText phone;
	EditText postaladress;
	EditText dob;

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.signup);

		username = (EditText) findViewById(R.id.usernameSignup);
		userNameSurname = (EditText) findViewById(R.id.userNameSurname);
		password = (EditText) findViewById(R.id.password);
		userEmail = (EditText) findViewById(R.id.userEmail);
		phone = (EditText) findViewById(R.id.phone);
		postaladress = (EditText) findViewById(R.id.postalAdress);
		dob = (EditText) findViewById(R.id.dob);

		signupToParse = (Button) findViewById(R.id.signupToParse);

		Log.d("Aplication from SignUp", getApplicationContext().toString());

		signupToParse.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				usernametxt = username.getText().toString();
//				userNameSurnametxt = userNameSurname.getText().toString();
				passwordtxt = password.getText().toString();
//				userEmailtxt = userEmail.getText().toString();
//				phonetxt = phone.getText().toString();
//				postaladresstxt = postaladress.getText().toString();
//				dobtxt = dob.getText().toString();

				if (usernametxt.equals("") || passwordtxt.equals("")) {

					// if (usernametxt.equals("") ||
					// userNameSurnametxt.equals("")
					// || passwordtxt.equals("") || userEmailtxt.equals("")
					// || phonetxt.equals("") || postaladresstxt.equals("")
					// || dobtxt.equals("")) {
//					Toast.makeText(getApplicationContext(),
//							"Empty Data, please reenter", Toast.LENGTH_LONG)
//							.show();
				} else {

					// Save new user data into Parse.com Data Storage
					ParseUser user = new ParseUser();
					user.setUsername(usernametxt);
					user.setPassword(passwordtxt);
					user.signUpInBackground(new SignUpCallback() {

						@Override
						public void done(ParseException e) {
							// TODO Auto-generated method stub
							if (e == null) {
								// Show a simple Toast message upon successful
								// registration
								Toast.makeText(
										getApplicationContext(),
										"Successfully Signed up, please log in.",
										Toast.LENGTH_LONG).show();
							} else {
								Toast.makeText(getApplicationContext(),
										"Sign up Error", Toast.LENGTH_LONG)
										.show();
							}

						}

					});

				}

			}
		});

	}
}
