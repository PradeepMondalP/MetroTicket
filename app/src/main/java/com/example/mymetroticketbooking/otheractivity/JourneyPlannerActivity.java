package com.example.mymetroticketbooking.otheractivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mymetroticketbooking.R;

public class JourneyPlannerActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private AutoCompleteTextView srcedt , dstedt;
    private Button planJrnyBtn;

    String [] stations;
    ArrayAdapter<String>adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_journey_planner);

        initialization();

        setAutoComplete();

        planJrnyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                showTheThings();
            }
        });
    }

    private void showTheThings() {
        String x =srcedt.getText().toString();
        String y = dstedt.getText().toString();

        if(!x.equals(y))
        {
            Toast.makeText(this,
                    "Will implement Later..", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this,
                    "Source and Destination Cant be Same", Toast.LENGTH_SHORT).show();
        }
    }

    private void setAutoComplete() {
        adapter = new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.select_dialog_item , stations);
        srcedt.setThreshold(1);
        srcedt.setAdapter(adapter);
        dstedt.setThreshold(1);
        dstedt.setAdapter(adapter);
    }

    private void initialization() {
        toolbar = (Toolbar)findViewById(R.id.id_toolbar_jp);
        srcedt = (AutoCompleteTextView) findViewById(R.id.id_src_stn);
        dstedt = (AutoCompleteTextView) findViewById(R.id.id_dst_stn);
        planJrnyBtn = (Button)findViewById(R.id.id_submit);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        stations = new String[]
                {
                        "Nagasandra","Dasarahalli","Jalahalli","Peenya Industry",
                        "Peenya","Goraguntepalya","Yeshwanthpur","Sandal Soap Factory",
                        "Mahalakshmi","Rajajinagar","Kuvempu road","Srirampura","Matri square sampige road",
                        "Chickpete","KR market","National College","Lalbagh","South End Circle",
                        "Jayanagar","Rashtriya Vidhyalaya Road","Banashankari",
                        "Jayaprakash Nagar","Yelchenahalli"
                };
    }
}
