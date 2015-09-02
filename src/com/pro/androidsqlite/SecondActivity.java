package com.pro.androidsqlite;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.project.androidsqlite.R;

public class SecondActivity extends Activity{
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add);
        final DatabaseHandler db = new DatabaseHandler(this);
        final EditText name = (EditText)findViewById(R.id.name);
        final EditText des = (EditText)findViewById(R.id.des);
        final EditText  price = (EditText)findViewById(R.id.price);
        Button sub = (Button)findViewById(R.id.summit);
        sub.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				db.addContact(new Item(name.getText().toString(), price.getText().toString() ,des.getText().toString()));
				finish();
				
			}
		});
	}

}

