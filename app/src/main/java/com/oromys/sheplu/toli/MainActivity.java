package com.oromys.sheplu.toli;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements View.OnTouchListener, View.OnClickListener {

    private TextView text = null;
    RelativeLayout layout = null;
    private Button button = null;
    private Button b = null;
    private TextView value = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        layout = (RelativeLayout) RelativeLayout.inflate(this,
                R.layout.activity_main, null);

        text = (TextView) layout.findViewById(R.id.textView);
        text.setText("Mon nouveau texte");
        text.setPadding(10, 100, 20, 150);
        text.setTextColor(Color.RED);

        setContentView(layout);

        button = (Button) layout.findViewById(R.id.button);
        button.setOnClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        TextView test = null;
        if(id == R.id.menu_refresh) {
            test = (TextView) findViewById(R.id.count);
            test.setText("refresh");
            return true;
        }
        else if(id == R.id.menu_about){
            test = (TextView) findViewById(R.id.count);
            test.setText("about");
            return true;
        }
        else if(id == R.id.menu_setting) {
            test = (TextView) findViewById(R.id.count);
            test.setText("setting");
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        b = (Button) v;
        b.setTextColor(Color.GREEN);
        value = (TextView) findViewById(R.id.count);
        Integer test = Integer.parseInt(value.getText().toString());
        test += 1;
        value.setText(test.toString());

        return true;
    }

    @Override
    public void onClick(View v) {
        b = (Button) v;
        b.setTextColor(Color.GREEN);
        value = (TextView) findViewById(R.id.count);
        Integer test = Integer.parseInt(value.getText().toString());
        test += 1;
        value.setText(test.toString());
    }

    public void changeActivity(View v) {
        Intent intent = new Intent(MainActivity.this,
                StatsActivity.class);

        TextView count = (TextView) findViewById(R.id.count);

        intent.putExtra("note_paul", count.getText().toString());
        intent.putExtra("note_miche", 19);
        startActivity(intent);
    }
}
