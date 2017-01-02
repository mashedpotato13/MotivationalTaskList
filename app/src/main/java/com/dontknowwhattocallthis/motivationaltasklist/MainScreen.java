package com.dontknowwhattocallthis.motivationaltasklist;

import android.icu.util.Calendar;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainScreen extends AppCompatActivity {
    ArrayList<HashMap<String,String>> taskData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO: add tasks with this action
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        //add listeners


        //create test data
        String[] testData = {"Feed tiger: Done", "Study", "Buy shrubberies"};
        String[] testDataDates = {"Today, 7:00 PM","","January 13"};
        taskData = new ArrayList<HashMap<String,String>>();
        for(int i = 0;i < 3;i++){
            HashMap<String,String> temp = new HashMap<String,String>(2);
            temp.put("task",testData[i]);
            temp.put("date",testDataDates[i]);
            taskData.add(temp);
        }
        ListView listView = (ListView) findViewById(R.id.list_tasks);
        //SimpleAdapter adapter = new SimpleAdapter(this,taskData,android.R.layout.simple_list_item_2,new String[]{"task","date"}, new int[]{android.R.id.text1,android.R.id.text2});
        SimpleAdapter adapter = new SimpleAdapter(this,taskData,R.layout.task_item,new String[]{"task","date"}, new int[]{R.id.task_item_task_desc,R.id.task_item_task_date});
        listView.setAdapter(adapter);
    }
    public void onTaskChecked(View v){
        if(((CheckBox) v).isChecked()){
            Toast.makeText(MainScreen.this, "Task checked!", Toast.LENGTH_LONG).show();
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_screen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
