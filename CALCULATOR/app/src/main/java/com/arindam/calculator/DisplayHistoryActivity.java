package com.arindam.calculator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class DisplayHistoryActivity extends Activity {

    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.history_display);

        lv=(ListView) findViewById(R.id.listView);

        Intent in = getIntent();
        ArrayList<String> list =(ArrayList<String>) in.getSerializableExtra("key");
        /*for(int i=0;i<list.size();i++)
        {
            String s[]= list.get(i);
            for(int iv=0;iv<s.length;iv++)*/



        //}

        ArrayAdapter adapter ;

       if(list.isEmpty()){

           list.add(0,"History of your last calculations .");
           adapter = new ArrayAdapter(this,
                   android.R.layout.simple_list_item_1, android.R.id.text1,list);
       }
        else {
           ArrayList<String> list_string =(ArrayList<String>) in.getSerializableExtra("key");
           adapter = new ArrayAdapter(this,
                   android.R.layout.simple_list_item_1, android.R.id.text1,list_string);
       }




        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1,
                                    int position, long arg3) {
                // TODO Auto-generated method stub
                int itemPosition     = position;

                // ListView Clicked item value
                String  itemValue    = (String) lv.getItemAtPosition(position);

                // Show Alert
                Toast.makeText(getApplicationContext(),
                        "Position :"+itemPosition+"  ListItem : " +itemValue , Toast.LENGTH_LONG)
                        .show();
            }
        });



    }


}
