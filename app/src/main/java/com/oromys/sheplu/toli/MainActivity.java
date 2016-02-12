package com.oromys.sheplu.toli;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
        startActivity(intent);
    }
}
