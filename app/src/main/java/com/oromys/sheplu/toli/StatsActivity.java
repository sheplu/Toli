package com.oromys.sheplu.toli;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;


public class StatsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_stats);

        Bundle extra = getIntent().getExtras();
        if(extra != null) {
            String value = extra.getString("note_paul");
            Integer value2 = extra.getInt("note_miche");

            TextView paul = (TextView) findViewById(R.id.paul);
            paul.setText(value);
            TextView miche = (TextView) findViewById(R.id.miche);
            miche.setText(value2.toString());

        }





    }
}
