package com.fju.water;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.text.TextUtils;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {



    private int degree;
    private double cost;
    private EditText month;
    private EditText next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        month = findViewById(R.id.month);
        next = findViewById(R.id.next);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
//
    public void monthly() {
        degree = Integer.parseInt(month.getText().toString());
        if (degree > 0 && degree < 10) {
            cost = degree * 7.35;
        } else if (degree > 10 && degree <= 30) {
            cost = (degree * 9.45) - 21;
        }
        if (degree > 30 && degree <= 50) {
            cost = (degree * 11.55) - 84;
        } else {
            cost = (degree * 12.075) - 110.25;
        }
    }
    public void next() {
        degree = Integer.parseInt(month.getText().toString());
        if (degree > 0 && degree < 20) {
            cost = degree * 7.35;
        } else if (degree > 20 && degree < 60) {
            cost = (degree * 9.45) - 42;
        }
        if (degree > 60 && degree <= 100) {
            cost = (degree * 11.55) - 168;
        } else {
            cost = (degree * 12.075) - 220.5;
        }
    }
    public void caculation (View view){
        month.setText(month + "");

        if(TextUtils.isEmpty(month)){
            next();
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("隔月抄表費用")
                    .setMessage(""+cost+"元")
                    .setPositiveButton("ok",null)
                    .show();

        }else{
            monthly();
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("本月抄表費用")
                    .setMessage(""+cost+"元")
                    .setPositiveButton("ok",null)
                    .show();
        }

        }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
