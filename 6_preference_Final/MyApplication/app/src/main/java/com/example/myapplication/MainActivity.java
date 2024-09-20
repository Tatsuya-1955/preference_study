package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

	private TextView text_check1;
	private TextView text_check2;
	private TextView text_edittext;

	@SuppressLint("MissingInflatedId")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		EdgeToEdge.enable(this);
		setContentView(R.layout.activity_main);
		ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
			Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
			v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
			return insets;
		});

		text_check1 = findViewById(R.id.text_check1);
		text_check2 = findViewById(R.id.text_check2);
		text_edittext = findViewById(R.id.text_edittext);

	}

	protected void onResume() {
		super.onResume();

		// SharedPreference インスタンスを取得
		SharedPreferences prefs = getSharedPreferences("com.example.myapplication_preferences",MODE_PRIVATE);
		// あとは各設定値を参照するだけ
		Boolean b_check1 = prefs.getBoolean("check_box_preference_1",false);
		Boolean b_check2 = prefs.getBoolean("check_box_preference_2",false);
		String b_edittext = prefs.getString("edit_text_preference_1","edittext");
		text_check1.setText("check box 1 = " + String.valueOf(b_check1));
		text_check2.setText("check box 2 = " + String.valueOf(b_check2));
		text_edittext.setText("EditText = " + b_edittext);

	}

	// オプションメニュー作成時の処理
	@Override
	public boolean onCreateOptionsMenu( Menu menu )
	{
		getMenuInflater().inflate( R.menu.options, menu );
		return true;
	}

	// オプションメニューのアイテム選択時の処理
	@Override
	public boolean onOptionsItemSelected( MenuItem item )
	{
		if( R.id.menu_true_settings == item.getItemId() )
		{
			Intent intent = new Intent( this, SettingsActivity.class );
			startActivity( intent );
			return true;
		}
		return false;
	}

}