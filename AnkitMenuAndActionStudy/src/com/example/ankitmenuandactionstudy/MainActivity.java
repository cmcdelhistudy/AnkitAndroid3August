package com.example.ankitmenuandactionstudy;

import android.app.ActionBar;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

public class MainActivity extends Activity {

	ActionBar ab;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// requestWindowFeature(Window.FEATURE_NO_TITLE);

		setContentView(R.layout.activity_main);

		ab = getActionBar();

		Drawable dw = getResources().getDrawable(R.drawable.des);
		// ColorDrawable cd = new ColorDrawable(Color.YELLOW);

		ab.setBackgroundDrawable(dw);
	}

	public void showMe(View v) {
		ab.show();
	}

	public void hideMe(View v) {
		ab.hide();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		MenuItem mnu1 = menu.add(0, 1, 1, "Apple");
		mnu1.setIcon(R.drawable.airplane);
		mnu1.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);

		MenuItem mnu2 = menu.add(0, 2, 2, "Settings");
		mnu2.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
		mnu2.setIcon(R.drawable.settings);

		MenuItem mnu3 = menu.add(0, 3, 3, "Cat");
		mnu3.setIcon(R.drawable.headphones);
		mnu3.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM
				| MenuItem.SHOW_AS_ACTION_WITH_TEXT);

		MenuItem mnu4 = menu.add(0, 4, 4, "Rat");

		return true;
	}

	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {

		switch (item.getItemId()) {
		case 1:
			Toast.makeText(getBaseContext(), "Apple", Toast.LENGTH_SHORT)
					.show();
			break;
		case 2:
			Toast.makeText(getBaseContext(), "Settings", Toast.LENGTH_SHORT)
					.show();
			break;
		case 3:
			Toast.makeText(getBaseContext(), "Cat", Toast.LENGTH_SHORT).show();
			break;
		case 4:
			Toast.makeText(getBaseContext(), "Rat", Toast.LENGTH_SHORT).show();
			break;

		default:
			break;
		}

		return super.onMenuItemSelected(featureId, item);
	}
}
