package com.example.ankitintentstudy;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	EditText ed;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ed = (EditText) findViewById(R.id.editText1);
	}

	public void doWork(View v) {

		// Intent i = new Intent();
		// i.setAction(Intent.ACTION_VIEW);
		// i.setData(Uri.parse("http://www.facebook.com"));
		// i.setData(Uri.parse("geo:78.454,91.454"));
		// startActivity(i);

		// Intent i = new Intent();
		// i.setAction(Intent.ACTION_VIEW);
		// i.setData(Uri.parse("content://contacts/people/1"));
		//
		// startActivity(i);

		// Intent i = new Intent();
		// i.setAction(Intent.ACTION_DIAL);
		// i.setData(Uri.parse("tel:748374"));
		//
		// startActivity(i);

		Intent i = new Intent();
		i.setAction(Intent.ACTION_CALL);
		i.setData(Uri.parse("tel:748374"));

		startActivity(i);

	}

	public void openSecond(View v) {

		String username = ed.getText().toString();

		Intent i = new Intent(getBaseContext(), SecondActivity.class);

		i.putExtra("USERNAME", username);
		i.putExtra("AGE", 12);

		Bundle vip = new Bundle();
		vip.putString("COMICS", "Batman");
		vip.putDouble("WEIGHT", 50.78);

		// Fav Words
		ArrayList<String> favWords = new ArrayList<String>();
		favWords.add("Hakunamatata");
		favWords.add("Bazinga");
		favWords.add("Bingo");

		Bundle carlton = new Bundle();
		carlton.putStringArrayList("FAV_WORDS", favWords);

		i.putExtra("BAG1", vip);
		i.putExtra("BAG2", carlton);
		// startActivity(i);
		startActivityForResult(i, 23);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode,
			Intent returnedIntentF) {
		if (requestCode == 23) {
			if (resultCode == RESULT_OK) {

				String returnedMsg = returnedIntentF.getStringExtra("MSG");

				Toast.makeText(getBaseContext(),
						"Returned Msg : " + returnedMsg, Toast.LENGTH_LONG)
						.show();

			}
		}
	}

}
