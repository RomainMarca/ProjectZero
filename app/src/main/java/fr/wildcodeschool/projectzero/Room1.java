package fr.wildcodeschool.projectzero;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static android.view.View.INVISIBLE;
import static android.view.View.VISIBLE;


public class Room1 extends AppCompatActivity {


    private int compteur = 5;
    public TextView textEvent = findViewById(R.id.text_eventporte);
    public Button X = findViewById(R.id.button_hollow);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room1);

        Toast.makeText(this, R.string.ToastIntro, Toast.LENGTH_LONG).show();



        final ImageView imgActionDoor = findViewById(R.id.image_actionPorte);
        final ImageView imgObsDoor = findViewById(R.id.image_obsPorte);
        final ImageView imgActionBed = findViewById(R.id.image_actionbed);
        final ImageView imgObsBed = findViewById(R.id.image_obsbed);

        //view on Action counter
        final TextView textCounter = (TextView) findViewById(R.id.text_action);
        textCounter.setText(String.valueOf(compteur));



        //click on observation door
        imgObsDoor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Show and close textEvent
                showTextEvent(true, textEvent, X);
                textEvent.setText(R.string.PorteBarreau);

                X.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showTextEvent(false, textEvent, X);
                //End Show and close textEvent
                        imgObsDoor.setVisibility(INVISIBLE);
                        imgActionDoor.setVisibility(VISIBLE);
                    }
                });
            }
        });

        //click on observation bed
        imgObsBed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                imgObsBed.setVisibility(INVISIBLE);

                // Show and close textEvent
                textEvent.setVisibility(VISIBLE);
                X.setVisibility(VISIBLE);
                textEvent.setText(R.string.ObsBed);

                X.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        textEvent.setVisibility(INVISIBLE);
                        X.setVisibility(INVISIBLE);
                        //End Show and close textEvent

                        imgActionBed.setVisibility(VISIBLE);
                    }
                });
            }
        });

        //cilck on action door
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
                textEvent.setVisibility(VISIBLE);
                X.setVisibility(VISIBLE);
                textEvent.setText(R.string.EchecPorteBarreau);

                X.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        textEvent.setVisibility(INVISIBLE);
                        X.setVisibility(INVISIBLE);
                //End Show and close textEvent
                    }
                });
            }
        });

        //click on action bed
        imgActionBed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Method drop counter and verify if is dead
                if (isDead(compteur)) {
                    // Intent
                    Intent goTodead = new Intent(Room1.this, DeadActivity.class);
                    Room1.this.startActivity(goTodead);
                }
                textCounter.setText(String.valueOf(compteur));
                //End Method drop counter and verify if is dead


                // Show and close textEvent
                textEvent.setVisibility(VISIBLE);
                X.setVisibility(VISIBLE);
                textEvent.setText(R.string.ActionBed);

                X.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        textEvent.setVisibility(INVISIBLE);
                        X.setVisibility(INVISIBLE);
                        //End Show and close textEvent
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

    public void showTextEvent(boolean openEvent, TextView textEvent, Button X){
           if(openEvent){
               textEvent.setVisibility(VISIBLE);
               X.setVisibility(VISIBLE);
           }else{
               textEvent.setVisibility(INVISIBLE);
               X.setVisibility(INVISIBLE);
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
