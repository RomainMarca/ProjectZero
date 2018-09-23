package fr.wildcodeschool.projectzero;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button Enter = findViewById(R.id.button_enter);



        Enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TextView description = findViewById(R.id.text_description);
                description.setVisibility(View.VISIBLE);

                Button RealEnter = findViewById(R.id.button_realenter);
                RealEnter.setVisibility(View.VISIBLE);



                RealEnter.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent goToroom1 = new Intent(MainActivity.this , Room1.class);
                        MainActivity.this.startActivity(goToroom1);

                    }
                });

            }

        });















    }
}
