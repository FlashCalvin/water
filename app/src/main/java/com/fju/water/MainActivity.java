package com.fju.water;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG =MainActivity.class.getSimpleName() ;
    private EditText edMonthly;
//    private EditText edNext;
    private float degree;
    private float fee = 0;
    boolean isNext = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        edMonthly = findViewById(R.id.month);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String monthString = edMonthly.getText().toString();
                if (!TextUtils.isEmpty(monthString)) {
                    degree = Float.parseFloat(monthString);
                    if (degree >= 1 && degree <= 10) {
                        fee = degree * 7.35f;
                    } else if (degree >= 11 && degree <= 30) {
                        fee = degree * 9.45f - 21;
                    } else if (degree >= 31 && degree <= 50) {
                        fee = degree * 11.55f - 84;
                    } else if (degree > 51) {
                        fee = degree * 12.075f - 110.25f;
                    }
                    Intent intent = new Intent(MainActivity.this,ResultActivity.class);
                    intent.putExtra(getString(R.string.fee),fee);
                    startActivity(intent);
//            new AlertDialog.Builder(this)
//                    .setTitle("本月抄表費用")
//                    .setMessage("費用" + fee)
//                    .setPositiveButton("OK", null)
//                    .show();
//                } else {
//                    String nextString = edNext.getText().toString();
//                    if (!TextUtils.isEmpty(nextString)) {
//                        float degree = Float.parseFloat(nextString);
//                        if (degree >= 1 && degree <= 20) {
//                            fee = degree * 7.35f;
//                        } else if (degree >= 21 && degree <= 60) {
//                            fee = degree * 9.45f - 42;
//                        } else if (degree >= 61 && degree <= 100) {
//                            fee = degree * 11.55f - 168;
//                        } else
//                            fee = degree * 12.075f - 220.5f;
//                    }
//            new AlertDialog.Builder(this)
//                    .setTitle("隔月抄表費用")
//                    .setMessage("費用" + fee)
//                    .setPositiveButton("OK", null)
//                    .show();
                }

            }
        });
        Switch sw = findViewById(R.id.swt);
        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isNext = isChecked;TextView text = findViewById(R.id.type);
                text.setText(isNext ? getString(R.string.every_other_month): getString(R.string.this_month));
            }
        });
        Spinner cities = findViewById(R.id.spinner);
        cities.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                             @Override
                                             public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                                 Log.d(TAG,getResources().getStringArray(R.array.cities)[position]);
                                             }

                                             @Override
                                             public void onNothingSelected(AdapterView<?> parent) {

                                             }
                                         });


                FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void caculation () {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"onDestroy");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG,"onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,"onPause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG,"onRestart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"onStart");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"onStart");
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
