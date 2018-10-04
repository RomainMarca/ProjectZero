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


        final TextView textEvent = findViewById(R.id.text_eventporte);
        final Button X = findViewById(R.id.button_hollow);
        showEvent(true,textEvent, X);
        textEvent.setText(R.string.ToastIntro);
        X.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showEvent(false,textEvent, X);
            }
        });

        final ImageView imgActionDoor = findViewById(R.id.image_actionPorte);
        final ImageView imgObsDoor = findViewById(R.id.image_obsPorte);
        final ImageView imgActionBed = findViewById(R.id.image_actionbed);
        final ImageView imgObsBed = findViewById(R.id.image_obsbed);

        //view on Action counter
        final TextView textCounter = (TextView) findViewById(R.id.text_action);
        textCounter.setText(String.valueOf(compteur));

        //Text Event and button X
//todo put in the toast on textevent
        //todo add style.xml
        
        imgObsDoor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Show and close textEvent
                showEvent(true,textEvent, X);
                textEvent.setText(R.string.PorteBarreau);

                X.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showEvent(false,textEvent, X);
                        imgObsDoor.setVisibility(View.INVISIBLE);
                        imgActionDoor.setVisibility(View.VISIBLE);
                    }
                });
            }
        });

        imgObsBed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                // Show and close textEvent
                showEvent(true,textEvent, X);
                textEvent.setText(R.string.ObsBed);

                X.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showEvent(false,textEvent, X);
                        imgObsBed.setVisibility(View.INVISIBLE);
                        imgActionBed.setVisibility(View.VISIBLE);
                    }
                });
            }
        });

        imgActionDoor.setOnClickListener(new View.OnClickListener() {
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

                // Show and close textEvent
                showEvent(true,textEvent, X);
                textEvent.setText(R.string.EchecPorteBarreau);

                X.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showEvent(false,textEvent, X);
                    }
                });
            }
        });

        imgActionBed.setOnClickListener(new View.OnClickListener() {
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


                // Show and close textEvent
                textEvent.setVisibility(View.VISIBLE);
                showEvent(true,textEvent, X);

                X.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showEvent(false,textEvent, X);
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

    public void showEvent(boolean openEvent, TextView textEvent, Button X){
        if(openEvent){
            textEvent.setVisibility(View.VISIBLE);
            X.setVisibility(View.VISIBLE);
        }else{
            textEvent.setVisibility(View.INVISIBLE);
            X.setVisibility(View.INVISIBLE);
        }
    }






        //Methode isDead by Bastien
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

//Old method//
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
