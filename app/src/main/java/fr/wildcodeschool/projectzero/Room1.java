package fr.wildcodeschool.projectzero;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class Room1 extends AppCompatActivity {
    
    public int counter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room1);

            //Metthode arguments showEvent
        final TextView textEvent = findViewById(R.id.text_event);
        final Button X = findViewById(R.id.button_hollow);

            //Intro
        showEvent(true,textEvent, X);
        textEvent.setText(R.string.Intro);

        X.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showEvent(false,textEvent, X);
            }
        });

        final ImageView imgActionDoor = findViewById(R.id.image_actionPorte);
        final ImageView imgActionBed = findViewById(R.id.image_actionbed);
        final ImageView imgActionWc = findViewById(R.id.image_actionwc);
        final ImageView imgObsWorkpan = findViewById(R.id.image_obsworkplan);
        final ImageView imgActionWorkpan = findViewById(R.id.image_actionworkplan);
        final ImageView imgGoRoom2 = findViewById(R.id.image_intent_r1);
        final Button buttonEvent = findViewById(R.id.button_action);

        //view on Action counter
        final TextView textCounter = (TextView) findViewById(R.id.text_action);
        textCounter.setText(String.valueOf(counter));

        //TODO resize Icons -directly on Inkscape.
        //TODO make Icon four direction on Inkscape.
        //TODO make a singleton for counter by chapter and by room visited
        //TODO make firebase for log user and save advanced

        imgObsWorkpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Show and close textEvent
                showEvent(true,textEvent, X);
                textEvent.setText(R.string.ObsWorkplan);

                X.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showEvent(false,textEvent, X);
                        imgObsWorkpan.setVisibility(View.INVISIBLE);
                        imgActionWorkpan.setVisibility(View.VISIBLE);
                    }
                });
            }
        });
                                            //Icon Action
        imgActionDoor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Show and close textEvent
                showEvent(true,textEvent, X);
                textEvent.setText(R.string.ActionDoor);
                buttonEvent.setVisibility(View.VISIBLE);
                buttonEvent.setText(R.string.eventOpen);

                buttonEvent.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        textEvent.setText(R.string.ActionButtonDoorNull);
                        buttonEvent.setVisibility(View.INVISIBLE);

                        //Method drop counter and verify if dead
                        if (isDead(counter)) {
                            // Intent
                            Intent goTodead = new Intent(Room1.this, DeadActivity.class);
                            Room1.this.startActivity(goTodead);
                        }
                        textCounter.setText(String.valueOf(counter));
                    }
                });

                X.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showEvent(false,textEvent, X);
                        buttonEvent.setVisibility(View.INVISIBLE);
                    }
                });
            }
        });

        imgActionBed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Show and close textEvent
                showEvent(true,textEvent, X);
                textEvent.setText(R.string.ActionBed);
                buttonEvent.setVisibility(View.VISIBLE);
                buttonEvent.setText(R.string.eventMove);

                buttonEvent.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        textEvent.setText(R.string.actionButtonBed);
                        buttonEvent.setVisibility(View.INVISIBLE);

                        //Method drop counter and verify if dead
                        if (isDead(counter)) {
                            // Intent
                            Intent goTodead = new Intent(Room1.this, DeadActivity.class);
                            Room1.this.startActivity(goTodead);
                        }
                        textCounter.setText(String.valueOf(counter));
                    }
                });

                X.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showEvent(false,textEvent, X);
                        buttonEvent.setVisibility(View.INVISIBLE);
                    }
                });
            }
        });

        imgActionWc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Show and close textEvent
                showEvent(true,textEvent, X);
                textEvent.setText(R.string.ActionWc);
                buttonEvent.setVisibility(View.VISIBLE);
                buttonEvent.setText(R.string.eventMove);

                buttonEvent.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        textEvent.setText(R.string.ActionButtonWc);
                        imgActionWc.setVisibility(View.INVISIBLE);
                        imgGoRoom2.setVisibility(View.VISIBLE);
                        buttonEvent.setVisibility(View.INVISIBLE);

                        //Method drop counter and verify if dead
                        if (isDead(counter)) {
                            // Intent
                            Intent goTodead = new Intent(Room1.this, DeadActivity.class);
                            Room1.this.startActivity(goTodead);
                        }
                        textCounter.setText(String.valueOf(counter));
                    }
                });

                X.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showEvent(false,textEvent, X);
                        buttonEvent.setVisibility(View.INVISIBLE);
                    }
                });
            }
        });
                    //Pass Room2
        imgGoRoom2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent goToRoom2 = new Intent(Room1.this, Room2Activity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("counter", counter);
                goToRoom2.putExtras(bundle);
                Room1.this.startActivity(goToRoom2);

            }
        });

        imgActionWorkpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Show and close textEvent
                showEvent(true,textEvent, X);
                textEvent.setText(R.string.ActionWorkplan);
                buttonEvent.setVisibility(View.VISIBLE);
                buttonEvent.setText(R.string.eventRead);

                buttonEvent.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        textEvent.setText(R.string.ActionButtonWorkplanNull);
                        buttonEvent.setVisibility(View.INVISIBLE);

                        //Method drop counter and verify if dead
                        if (isDead(counter)) {
                            // Intent
                            Intent goTodead = new Intent(Room1.this, DeadActivity.class);
                            Room1.this.startActivity(goTodead);
                        }
                        textCounter.setText(String.valueOf(counter));
                    }
                });

                X.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showEvent(false,textEvent, X);
                        buttonEvent.setVisibility(View.INVISIBLE);
                    }
                });
            }
        });
    }


    public boolean isDead(int counter) {
        this.counter--;
        if (this.counter < 0) {
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

    private int counter = 5;

    public void onCreate() {


        Button event = findViewById(R.id.eventButton);
        event.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // récupérer le nombre de point restant
                if (isDead(counter)) {
                    // Intent
                }
            }
        }
    }

    public boolean isDead() {
        counter--;
        if (counter < 0) {
            return true;
        } else {
            return false;
        }
    }
}
     */
}
