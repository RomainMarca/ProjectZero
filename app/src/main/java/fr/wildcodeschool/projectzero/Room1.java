package fr.wildcodeschool.projectzero;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.Drawable;
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

        final Drawable ImageAction = getResources().getDrawable(R.drawable.buttonaction);
        Drawable ImageObs = getResources().getDrawable(R.drawable.buttonvue);
        final ImageView ImageEmpty = findViewById(R.id.image_empty);
        ImageEmpty.setImageDrawable(ImageObs);

        //view on Action counter
        final TextView textCounter = (TextView) findViewById(R.id.text_action);
        textCounter.setText(String.valueOf(compteur));

        final TextView textEvent = findViewById(R.id.text_eventporte);
        final Button X = findViewById(R.id.button_hollow);

        //click on observation door
        ImageEmpty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Event
                textEvent.setVisibility(View.VISIBLE);
                X.setVisibility(View.VISIBLE);
                textEvent.setText(R.string.PorteBarreau);

                ImageEmpty.setImageDrawable(ImageAction);

                X.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        textEvent.setVisibility(View.INVISIBLE);
                        X.setVisibility(View.INVISIBLE);

                    }
                });
            }
        });

        //cilck on action door
        ImageEmpty.setOnClickListener(new View.OnClickListener() {
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


                //Show and close textEvent
                textEvent.setVisibility(View.VISIBLE);
                X.setVisibility(View.VISIBLE);
                textEvent.setText(R.string.EchecPorteBarreau);

                X.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        textEvent.setVisibility(View.INVISIBLE);
                        X.setVisibility(View.INVISIBLE);
                //End show and close textEvent

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
