package com.abhi.addicted;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity implements OnItemClickListener {
	public static long data = Background.time;
	public static int days = Background.day;
	public static TextView time, title;
	ListView lv;
	public static long[] array = new long[0];
	public static int[] dayarray = new int[0];

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initialize();
		// setArray();
		Intent i = new Intent(this, Background.class);
		if (Background.mReceiver == null)
			startService(i);
		// time.setText(""+array[array.length-1]);
		lv.setAdapter(new InfoAdapter(this, array, dayarray));
		lv.setOnItemClickListener(this);
		if (Background.nm == null) {
		} else {
			Background.nm.cancel(Background.id);
		}
	}

	/*
	 * private void setArray() { // TODO Auto-generated method stub int i =
	 * array.length; if (i == 0) { dayarray = new int[1]; array = new long[1];
	 * dayarray[0] = days; array[0] = data; } else { if (dayarray[i-1] != days)
	 * { long[] temp = array; int[] temp2 = dayarray; dayarray = new int[i + 1];
	 * array = new long[i + 1]; for (int j = 0; j < i; j++) { array[j] =
	 * temp[j]; dayarray[j] = temp2[j]; } array[i] = data; dayarray[i] = days; }
	 * else { array[i - 1] = data; } } }
	 */

	private void initialize() {
		time = (TextView) findViewById(R.id.tvtime);
		title = (TextView) findViewById(R.id.tvtitle);
		lv = (ListView) findViewById(android.R.id.list);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		super.onCreateOptionsMenu(menu);
		MenuInflater extras = getMenuInflater();
		extras.inflate(R.menu.addicmen, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		case R.id.timelim:
			Intent i = new Intent(this,setTime.class);
			startActivity(i);
			break;
		case R.id.setting:
			break;
		case R.id.exit:
			finish();
			break;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub

	}

}
