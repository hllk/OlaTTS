package com.example.olatts;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.app.DatePickerDialog.OnDateSetListener;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

public class DateActivity extends ActionBarActivity implements
		OnDateSetListener {

	private EditText et;
	private Button btn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_date);
		
		final TextToSpeech tts = new TextToSpeech(this,
				new TextToSpeech.OnInitListener() {

					@Override
					public void onInit(int status) {
						// TODO Auto-generated method stub
						Log.d("Mówi", "jeee");
					}
				});

		et = (EditText) findViewById(R.id.writeDate);
		et.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				DialogFragment datePicker = new DateDialog();
				datePicker.show(getSupportFragmentManager(), "datePicker");

			}
		});

		btn = (Button) findViewById(R.id.dateButton);
		btn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				tts.speak(et.getText().toString(), TextToSpeech.QUEUE_FLUSH, null);
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.date, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onDateSet(DatePicker view, int year, int monthOfYear,
			int dayOfMonth) {
		// TODO Auto-generated method stub
		String month;
		switch (monthOfYear + 1) {
		case 1:
			month = " stycznia ";
			break;
		case 2:
			month = " lutego ";
			break;
		case 3:
			month = " marca ";
			break;
		case 4:
			month = " kwietnia ";
			break;
		case 5:
			month = " maja ";
			break;
		case 6:
			month = " czerwca ";
			break;
		case 7:
			month = " lipca ";
			break;
		case 8:
			month = " sierpnia ";
			break;
		case 9:
			month = " września ";
			break;
		case 10:
			month = " października ";
			break;
		case 11:
			month = " listopada ";
			break;
		case 12:
			month = " grudnia ";
			break;
		default:
			month = " błąd ";
			break;
		}
		et.setText(dayOfMonth + month + year);
	}

}
