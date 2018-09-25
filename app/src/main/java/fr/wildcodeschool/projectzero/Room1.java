package fr.wildcodeschool.projectzero;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class Room1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room1);

        Toast.makeText(this, R.string.ToastIntro, Toast.LENGTH_LONG).show();


        final Compteur Action = new Compteur(5);
        final ImageView imageAction = findViewById(R.id.image_action);

        final TextView textAction = (TextView) findViewById(R.id.text_action);
        textAction.setText(String.valueOf(Action.getCompteurAction()));


        imageAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Action.setCompteurAction(Action.getCompteurAction()-1);
                textAction.setText(String.valueOf(Action.getCompteurAction()));

                //Event
                final TextView textEventPorte = findViewById(R.id.text_eventporte);
                final Button X = findViewById(R.id.button_hollow);
                textEventPorte.setVisibility(View.VISIBLE);
                X.setVisibility(View.VISIBLE);

                X.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        textEventPorte.setVisibility(View.INVISIBLE);
                        X.setVisibility(View.INVISIBLE);
                    }
                });


                //Verification if player's dead.
                if (Action.getCompteurAction()==0){

                    Intent goTodead = new Intent(Room1.this , DeadActivity.class);
                    Room1.this.startActivity(goTodead);
                }

            }
        });
    }

}
