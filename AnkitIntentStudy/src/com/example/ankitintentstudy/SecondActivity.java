package com.example.ankitintentstudy;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends Activity {

	EditText ed1;
	TextView tvName;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);

		tvName = (TextView) findViewById(R.id.textView2);
		ed1 = (EditText) findViewById(R.id.editText1);

		Intent obtainedIntent = getIntent();
		String obName = obtainedIntent.getStringExtra("USERNAME");

		tvName.setText(obName);

		int obAge = obtainedIntent.getIntExtra("AGE", 0);

		Toast.makeText(getBaseContext(), "Age " + obAge, Toast.LENGTH_LONG)
				.show();

		Bundle obBag1 = obtainedIntent.getBundleExtra("BAG1");
		String obCom = obBag1.getString("COMICS");
		double obWt = obBag1.getDouble("WEIGHT");

		Toast.makeText(getBaseContext(), "Comics " + obCom, Toast.LENGTH_LONG)
				.show();
		Toast.makeText(getBaseContext(), "Wt " + obWt, Toast.LENGTH_LONG)
				.show();

		Bundle obBag2 = obtainedIntent.getBundleExtra("BAG2");
		ArrayList<String> obFavWords = obBag2.getStringArrayList("FAV_WORDS");

		Toast.makeText(getBaseContext(), "FAV Words", Toast.LENGTH_LONG).show();
		for (String s : obFavWords) {
			Toast.makeText(getBaseContext(), s, Toast.LENGTH_LONG).show();
		}

	}

	public void goBack(View v) {

		String dat = ed1.getText().toString();

		Intent i = new Intent();
		i.putExtra("MSG", dat);

		setResult(RESULT_OK, i);

		finish();
	}
}
