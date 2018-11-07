package fr.wildcodeschool.projectzero;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class Room1 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room1);

            //Metthode arguments showEvent
        final TextView textEvent = findViewById(R.id.text_event);
        final Button X = findViewById(R.id.button_hollow);

        final ImageView imgActionDoor = findViewById(R.id.image_actionPorte);
        final ImageView imgActionBed = findViewById(R.id.image_actionbed);
        final ImageView imgActionWc = findViewById(R.id.image_actionwc);
        final ImageView imgObsWorkpan = findViewById(R.id.image_obsworkplan);
        final ImageView imgActionWorkpan = findViewById(R.id.image_actionworkplan);
        final ImageView imgGoRoom2 = findViewById(R.id.image_intent_r1);
        final Button buttonEvent = findViewById(R.id.button_action);
        final ImageView keyDoor = findViewById(R.id.image_keydoor);

        //view on Action counter
        final TextView textCounter = (TextView) findViewById(R.id.text_action);
        textCounter.setText(String.valueOf(PlayerSingleton.getInstance().getCounter()));

        //TODO resize Icons -directly on Inkscape.
        //TODO make Icon four direction on Inkscape.
        //TODO make firebase for log user and save advanced

        //Verify player progress
        room1Verify(textEvent, X, imgActionWc, imgGoRoom2, keyDoor);

        imgObsWorkpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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

                String actionStr = getString(R.string.ActionDoor);
                String eventStr = getString(R.string.eventOpen);
                String buttonStr = getString(R.string.ActionButtonDoorNull);
                actionClick(textEvent, X, buttonEvent, textCounter, actionStr, eventStr, buttonStr);
            }
        });

        imgActionBed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String actionStr = getString(R.string.ActionBed);
                String eventStr = getString(R.string.eventMove);
                String buttonStr = getString(R.string.actionButtonBed);
                actionClick(textEvent, X, buttonEvent, textCounter, actionStr, eventStr, buttonStr);
            }
        });

        imgActionWc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String actionStr = getString(R.string.ActionWc);
                String eventStr = getString(R.string.eventMove);
                String buttonStr = getString(R.string.ActionButtonWc);
                actionIntentClick(textEvent, X, buttonEvent, textCounter, actionStr, eventStr, buttonStr, imgActionWc, imgGoRoom2);            }
        });
                    //Pass Room2
        imgGoRoom2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Method drop counter and verify if dead
                if (isDead()) {
                    // Intent
                    Intent goTodead = new Intent(Room1.this, DeadActivity.class);
                    Room1.this.startActivity(goTodead);
                }
                textCounter.setText(String.valueOf(PlayerSingleton.getInstance().getCounter()));

                PlayerSingleton.getInstance().setR1isVisited(true);
                Intent goToRoom2 = new Intent(Room1.this, Room2Activity.class);
                Room1.this.startActivity(goToRoom2);
            }
        });

        imgActionWorkpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String actionStr = getString(R.string.ActionWorkplan);
                String eventStr = getString(R.string.eventRead);
                String buttonStr = getString(R.string.ActionButtonWorkplanNull);
                actionClick(textEvent, X, buttonEvent, textCounter, actionStr, eventStr, buttonStr);
            }
        });
    }

    ///////////////////////////////METHOD/////////////////////////////////////////////////////////////////////

    public boolean isDead() {
        PlayerSingleton.getInstance().setCounter(PlayerSingleton.getInstance().getCounter()-1);
        if (PlayerSingleton.getInstance().getCounter() < 0) {
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

    public boolean isDeadVerify() {
        if (PlayerSingleton.getInstance().getCounter() < 0) {
            return true;
        } else {
            return false;
        }
    }

    public void keyDoorVerify(ImageView keyDoor) {
        if (PlayerSingleton.getInstance().isKeydoor()) {
            keyDoor.setVisibility(View.VISIBLE);
        } else {
            keyDoor.setVisibility(View.INVISIBLE);
        }
    }

    public void actionClick(final TextView textEvent, final Button X, final Button buttonEvent, final TextView textCounter, String actionStr, String eventStr, final String buttonStr) {

        showEvent(true,textEvent, X);
        textEvent.setText(actionStr);
        buttonEvent.setVisibility(View.VISIBLE);
        buttonEvent.setText(eventStr);

        buttonEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textEvent.setText(buttonStr);
                buttonEvent.setVisibility(View.INVISIBLE);

                if (isDead()) {

                    Intent goTodead = new Intent(Room1.this, DeadActivity.class);
                    Room1.this.startActivity(goTodead);
                }
                textCounter.setText(String.valueOf(PlayerSingleton.getInstance().getCounter()));
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

    public void actionIntentClick(final TextView textEvent, final Button X, final Button buttonEvent, final TextView textCounter,
                                  String actionStr, String eventStr, final String buttonStr, final ImageView imgActionWc,
                                  final ImageView imgGoRoom2) {

        showEvent(true,textEvent, X);
        textEvent.setText(actionStr);
        buttonEvent.setVisibility(View.VISIBLE);
        buttonEvent.setText(eventStr);

        buttonEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textEvent.setText(buttonStr);
                buttonEvent.setVisibility(View.INVISIBLE);

                if (isDead()) {

                    Intent goTodead = new Intent(Room1.this, DeadActivity.class);
                    Room1.this.startActivity(goTodead);
                }
                textCounter.setText(String.valueOf(PlayerSingleton.getInstance().getCounter()));
                imgActionWc.setVisibility(View.INVISIBLE);
                imgGoRoom2.setVisibility(View.VISIBLE);
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

    public void room1Verify(final TextView textEvent, final Button X, ImageView imgActionWc,
                            ImageView imgGoRoom2, ImageView keyDoor) {
        if (isDeadVerify()) {
            // Intent
            Intent goTodead = new Intent(Room1.this, DeadActivity.class);
            Room1.this.startActivity(goTodead);
        }

        if (!PlayerSingleton.getInstance().isR1isVisited()) {

            showEvent(true,textEvent, X);
            textEvent.setText(R.string.Intro);

            X.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showEvent(false,textEvent, X);
                }
            });
        } else {
            imgActionWc.setVisibility(View.INVISIBLE);
            imgGoRoom2.setVisibility(View.VISIBLE);
        }
        keyDoorVerify(keyDoor);
    }
}
