package fr.wildcodeschool.projectzero;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class Room1 extends AppCompatActivity {


    private int compteur = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room1);

        Toast.makeText(this, R.string.ToastIntro, Toast.LENGTH_LONG).show();



        final ImageView imageAction = findViewById(R.id.image_action);
        final ImageView imageObsPorte = findViewById(R.id.image_obsPorte);

        //view on Action counter
        final TextView textCounter = (TextView) findViewById(R.id.text_action);
        textCounter.setText(String.valueOf(compteur));

        final TextView textEventPorte = findViewById(R.id.text_eventporte);
        final Button X = findViewById(R.id.button_hollow);

        //click on observation door
        imageObsPorte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Event


                textEventPorte.setVisibility(View.VISIBLE);
                X.setVisibility(View.VISIBLE);
                textEventPorte.setText(R.string.PorteBarreau);

                X.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        textEventPorte.setVisibility(View.INVISIBLE);
                        X.setVisibility(View.INVISIBLE);
                        imageObsPorte.setVisibility(View.INVISIBLE);
                        imageAction.setVisibility(View.VISIBLE);
                    }
                });
            }
        });

        //cilck on action door
        imageAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Method drop counter and verify if dead
                if (isDead(compteur)) {
                    // Intent
                    Intent goTodead = new Intent(Room1.this, DeadActivity.class);
                    Room1.this.startActivity(goTodead);
                }
                textCounter.setText(String.valueOf(compteur));
                //End Method drop counter and verify if dead


                //Event
                textEventPorte.setVisibility(View.VISIBLE);
                X.setVisibility(View.VISIBLE);
                textEventPorte.setText(R.string.EchecPorteBarreau);

                X.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        textEventPorte.setVisibility(View.INVISIBLE);
                        X.setVisibility(View.INVISIBLE);

                    }
                });

            }
        });
    }

    public boolean isDead(int compteur) {
        this.compteur--;
        if (this.compteur < 0) {
            return true;
        } else {
            return false;
        }

    }






        //Methode du isDead by Bastien
    /*
    class MainActivity {

    private int compteur = 5;

    public void onCreate() {


        Button event = findViewById(R.id.eventButton);
        event.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // récupérer le nombre de point restant
                if (isDead(compteur)) {
                    // Intent
                }
            }
        }
    }

    public boolean isDead() {
        compteur--;
        if (compteur < 0) {
            return true;
        } else {
            return false;
        }
    }
}

//Ancienne methode//
                //down action level
                Action.setCompteurAction(Action.getCompteurAction() - 1);
                textAction.setText(String.valueOf(Action.getCompteurAction()));

                //Verification if player's dead.
                if (Action.getCompteurAction() < 0) {

                    Intent goTodead = new Intent(Room1.this, DeadActivity.class);
                    Room1.this.startActivity(goTodead);
                }
     */
}
