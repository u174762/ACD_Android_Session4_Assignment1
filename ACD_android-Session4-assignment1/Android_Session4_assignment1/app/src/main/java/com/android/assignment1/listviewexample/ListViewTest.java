package com.android.vicky.listviewexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Arrays;
import java.util.Collections;

public class ListViewTest extends AppCompatActivity {
    ListView listItem;
    Button bttnASC,bttnDESC;
    private String[] monthsArray = { "JAN", "FEB", "MAR", "APR", "MAY", "JUNE", "JULY" };
    private ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_test);
        bttnASC = (Button) findViewById(R.id.buttonASC);
        bttnDESC = (Button) findViewById(R.id.buttonDESC);
        listItem = (ListView)findViewById(R.id.listView);

        arrayAdapter = new ArrayAdapter(ListViewTest.this,R.layout.list_link_up,monthsArray);
        listItem.setAdapter(arrayAdapter);

        bttnASC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Arrays.sort(monthsArray);
                arrayAdapter = new ArrayAdapter(ListViewTest.this,R.layout.list_link_up,monthsArray);
                listItem.setAdapter(arrayAdapter);
            }
        });

        bttnDESC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Arrays.sort(monthsArray, Collections.reverseOrder());
                arrayAdapter = new ArrayAdapter(ListViewTest.this,R.layout.list_link_up,monthsArray);
                listItem.setAdapter(arrayAdapter);
            }
        });

        listItem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),"You Clicked On "+((TextView)view).getText(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}
