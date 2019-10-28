package com.example.mymetroticketbooking.otheractivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.mymetroticketbooking.MainActivity;
import com.example.mymetroticketbooking.R;
import com.github.ahmadnemati.wind.WindView;
import com.github.ahmadnemati.wind.enums.TrendType;

public class LoginActivity extends AppCompatActivity {

    private Button btn;
    WindView windView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initialization();

        setWindView();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext() , MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void setWindView() {

//        windView.setPressure(20);
//        windView.setPressureUnit("in Hg");
        windView.setWindSpeed(2);
//        windView.setWindSpeedUnit(" km/h");
        windView.setTrendType(TrendType.UP);
        windView.start();


    }

    private void initialization() {
        btn = (Button)findViewById(R.id.id_loginbtn);
        windView= (WindView) findViewById(R.id.windview);
    }

}
