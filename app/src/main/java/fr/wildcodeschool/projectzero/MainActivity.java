package fr.wildcodeschool.projectzero;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final Button Enter = findViewById(R.id.button_enter);


        //enter menu
        Enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Enter.setVisibility(View.INVISIBLE);

                TextView description = findViewById(R.id.text_description);
                description.setVisibility(View.VISIBLE);

                Button RealEnter = findViewById(R.id.button_realenter);
                RealEnter.setVisibility(View.VISIBLE);

                Button buttonRules = findViewById(R.id.button_rules);
                buttonRules.setVisibility(View.VISIBLE);


                //go to Rules page
                buttonRules.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent goToRules = new Intent(MainActivity.this , RulesActivity.class);
                        MainActivity.this.startActivity(goToRules);
                    }
                });


                //got to game page
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
