package com.pro.androidsqlite;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;

import com.project.androidsqlite.R;


public class AndroidSQLiteTutorialActivity extends Activity {
    /** Called when the activity is first created. */
	
	ListView lv;
	ListViewAdapter adapter;
	ArrayList<HashMap<String, String>> menuItems = new ArrayList<HashMap<String,String>>();
	
	static final String KEY_PRICE = "price"; 
    static final String KEY_DES = "des";
    static final String KEY_NAME = "name";
    DatabaseHandler db ;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        lv = (ListView) findViewById(R.id.list);
        
        Button btn = (Button)findViewById(R.id.add);
        btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(AndroidSQLiteTutorialActivity.this, SecondActivity.class);
				 startActivity(i);
			}
		});
        
        db = new DatabaseHandler(this);
        
        /**
         * CRUD Operations
         * */
        // Inserting Contacts
        Log.d("Insert: ", "Inserting ..");
//        db.addContact(new Item("Coca cola", "91$" ,"It's a drink"));
//        db.addContact(new Item("Suger", "30$" , "Good good"));
        
 
        // Reading all contacts
        Log.d("Reading: ", "Reading all contacts..");
        List<Item> contacts = db.getAllContacts();       
 
        for (Item cn : contacts) {
            String log = "Id: "+cn.getID()+" ,Name: " + cn.getName() + " ,Price: " + cn.getPrice();
                // Writing Contacts to log
            addItem (cn.getName(),cn.getPrice(),cn.getDescription());
        Log.d("Name: ", log);
        
        }
        
     // Getting adapter
        adapter = new ListViewAdapter(this, menuItems);
        lv.setAdapter(adapter);
    }
    
    
    
    @Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		db = new DatabaseHandler(this); 
		List<Item> contacts = db.getAllContacts();       
		 menuItems.clear();
		 lv.setAdapter(null);
        for (Item cn : contacts) {
            String log = "Id: "+cn.getID()+" ,Name: " + cn.getName() + " ,Price: " + cn.getPrice();
                // Writing Contacts to log
            addItem (cn.getName(),cn.getPrice(),cn.getDescription());
        Log.d("Name: ", log);
        
        }
        
     // Getting adapter
        adapter = new ListViewAdapter(this, menuItems);
        lv.setAdapter(adapter);
	}



	private void addItem (String name , String price , String des)
    {
    	HashMap<String, String> map = new HashMap<String, String>();
        map.put(KEY_PRICE, price); 
        map.put(KEY_NAME, name);
        map.put(KEY_DES,des);

        // adding HashList to ArrayList
        menuItems.add(map);
    }
}