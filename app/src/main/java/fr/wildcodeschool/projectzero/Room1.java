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
        final ImageView keyCage = findViewById(R.id.image_keycage);
        final ImageView imgActionDoorR3 = findViewById(R.id.image_door_r3);
        final ImageView imgActionWorplan2 = findViewById(R.id.image_workplan2);
        final ImageView imgFinalDoor = findViewById(R.id.image_final_door);
        final ImageView imgActionRack = findViewById(R.id.image_rack_r1);
        final ImageView imgActionRack2 = findViewById(R.id.image_rack2_r1);
        final ImageView imgActionRack3 = findViewById(R.id.image_rack3_r1);
        final ImageView imgGoRoom3 = findViewById(R.id.image_intent_r3);

        //view on Action counter
        final TextView textCounter = (TextView) findViewById(R.id.text_action);
        textCounter.setText(String.valueOf(PlayerSingleton.getInstance().getCounter()));

        //TODO resize Icons -directly on Inkscape.
        //TODO make firebase for log user and save advanced or shared preferencese...
        //TODO make rest of action on room1

        //TODO for test
        PlayerSingleton.getInstance().setKeyCage(true);

        //Verify player progress
        room1Verify(textEvent, X, imgActionWc, imgGoRoom2, keyDoor, keyCage);

        imgObsWorkpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showEvent(true,textEvent, X);
                textEvent.setText(R.string.ObsWorkplan);

                X.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showEvent(false,textEvent, X);
                        if (PlayerSingleton.getInstance().isR1OpenDoor()) {
                            imgObsWorkpan.setVisibility(View.INVISIBLE);
                            imgActionWorkpan.setVisibility(View.VISIBLE);
                        }
                    }
                });
            }
        });

        imgActionDoorR3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String actionStr = getString(R.string.actionFlag);
                String actionStr2 = getString(R.string.actionDoorR3);
                String eventStr = getString(R.string.eventPull);
                String eventStr2 = getString(R.string.eventOpen);
                String buttonStr = getString(R.string.buttonActionFlag);
                String buttonStr2 = getString(R.string.AREVOIR);
                actionFlagClick(textEvent, buttonEvent, X, actionStr, actionStr2, buttonStr, eventStr, eventStr2, buttonStr2,
                        textCounter, imgGoRoom3, imgActionDoorR3);
            }
        });
                                            //Icon Action
        imgActionDoor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String actionStr = getString(R.string.ActionDoor);
                String eventStr = getString(R.string.eventOpen);
                String buttonStr = getString(R.string.ActionButtonDoorNull);
                String buttonStr2 = getString(R.string.buttonActionDoorOpen);
                actionDoorClick(textEvent, X, buttonEvent, textCounter, actionStr, eventStr, buttonStr,buttonStr2, keyCage,
                        imgActionDoor, imgActionWorplan2, imgFinalDoor, imgActionRack, imgActionRack2, imgActionRack3, imgActionDoorR3, imgObsWorkpan);
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


    @Override
    public void onBackPressed() {
        //Polymorphisme. Vide la méthode onBackPressed pour empêcher son utilisation pendant la partie
    }

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
                            ImageView imgGoRoom2, ImageView keyDoor, ImageView keyCage) {
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

        if (PlayerSingleton.getInstance().isKeyCage()) {
            keyCage.setVisibility(View.VISIBLE);
        }
    }

    public void actionDoorClick(final TextView textEvent, final Button X, final Button buttonEvent, final TextView textCounter,
                                String actionStr, String eventStr, final String buttonStr, final String buttonStr2,
                                final ImageView keyCage, final ImageView imgActionDoor, final ImageView imgActionWorplan2,
                                final ImageView imgFinalDoor, final ImageView imgActionRack,final ImageView imgActionRack2,
                                final ImageView imgActionRack3, final ImageView imgActionDoorR3, final ImageView imgObsWorkpan) {

        showEvent(true,textEvent, X);
        textEvent.setText(actionStr);
        buttonEvent.setVisibility(View.VISIBLE);
        buttonEvent.setText(eventStr);

        buttonEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!PlayerSingleton.getInstance().isKeyCage()) {
                    textEvent.setText(buttonStr);
                    buttonEvent.setVisibility(View.INVISIBLE);
                } else {
                    textEvent.setText(buttonStr2);
                    buttonEvent.setVisibility(View.INVISIBLE);
                    PlayerSingleton.getInstance().setKeyCage(false);
                    if (!PlayerSingleton.getInstance().isKeyCage()) {
                        keyCage.setVisibility(View.INVISIBLE);
                    }
                    PlayerSingleton.getInstance().setR1OpenDoor(true);
                    imgActionDoor.setVisibility(View.INVISIBLE);
                    imgActionDoorR3.setVisibility(View.VISIBLE);
                    imgActionWorplan2.setVisibility(View.VISIBLE);
                    imgFinalDoor.setVisibility(View.VISIBLE);
                    imgActionRack.setVisibility(View.VISIBLE);
                    imgActionRack2.setVisibility(View.VISIBLE);
                    imgActionRack3.setVisibility(View.VISIBLE);
                    imgObsWorkpan.setVisibility(View.VISIBLE);
                }

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

    public void actionFlagClick(final TextView textEvent, final Button buttonEvent, final Button X, String actionStr,
                                String actionStr2, final String buttonStr, String eventStr, String eventStr2, final String buttonStr2,
                                final TextView textCounter, final ImageView imgGoRoom3, final ImageView imgActionDoorR3) {

        if(!PlayerSingleton.getInstance().isFlagRockDoor()) {
            showEvent(true,textEvent, X);
            textEvent.setText(actionStr);
            buttonEvent.setVisibility(View.VISIBLE);
            buttonEvent.setText(eventStr);

            buttonEvent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    textEvent.setText(buttonStr);
                    buttonEvent.setVisibility(View.INVISIBLE);
                    PlayerSingleton.getInstance().setFlagRockDoor(true);

                    if (isDead()) {

                        Intent goTodead = new Intent(Room1.this, DeadActivity.class);
                        Room1.this.startActivity(goTodead);
                    }
                    textCounter.setText(String.valueOf(PlayerSingleton.getInstance().getCounter()));
                }
            });
        } else {
            showEvent(true,textEvent, X);
            textEvent.setText(actionStr2);
            buttonEvent.setVisibility(View.VISIBLE);
            buttonEvent.setText(eventStr2);

            buttonEvent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    textEvent.setText(buttonStr2);
                    buttonEvent.setVisibility(View.INVISIBLE);

                    //TODO  make Edit text for the blue code and red code + boolean in Singelton case of success.
                    imgGoRoom3.setVisibility(View.VISIBLE);
                    imgActionDoorR3.setVisibility(View.INVISIBLE);
                }
            });
        }

        X.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showEvent(false,textEvent, X);
                buttonEvent.setVisibility(View.INVISIBLE);
            }
        });
    }

}
