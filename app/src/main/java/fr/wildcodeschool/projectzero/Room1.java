package fr.wildcodeschool.projectzero;

import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


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
        final ImageView padlockRed = findViewById(R.id.cadenas_rouge);
        final ImageView padlockBlue = findViewById(R.id.cadenas_bleu);
        final EditText etRed1 = findViewById(R.id.et_r_1);
        final EditText etRed2 = findViewById(R.id.et_r_2);
        final EditText etRed3 = findViewById(R.id.et_r_3);
        final EditText etBlue1 = findViewById(R.id.et_b_1);
        final EditText etBlue2 = findViewById(R.id.et_b_2);
        final EditText etBlue3 = findViewById(R.id.et_b_3);
        final ImageButton buttonRed = findViewById(R.id.imageButton_r);
        final ImageButton buttonBlue = findViewById(R.id.imageButton_b);
        final ImageView imagePadlocks = findViewById(R.id.Image_padlocks);
        final ImageButton buttonPadlocks  = findViewById(R.id.imageButton_success);
        final Button Xpadlocks  = findViewById(R.id.button_X_padlock);

        //view on Action counter
        final TextView textCounter = (TextView) findViewById(R.id.text_action);
        textCounter.setText(String.valueOf(PlayerSingleton.getInstance().getCounter()));

        //TODO resize Icons -directly on Inkscape.
        //TODO make firebase for log user and save advanced or shared preferencese...
        //TODO make rest of action on room1
        //TODO make flag draw

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
                        textCounter, imgGoRoom3, imgActionDoorR3, padlockRed, etRed1, etRed2, etRed3, buttonRed, padlockBlue, etBlue1,
                        etBlue2, etBlue3, buttonBlue, imagePadlocks, buttonPadlocks, Xpadlocks);
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
                                final TextView textCounter, final ImageView imgGoRoom3, final ImageView imgActionDoorR3,
                                final ImageView padlockRed, final EditText etRed1, final EditText etRed2, final EditText etRed3,
                                final ImageButton buttonRed, final ImageView padlockBlue, final EditText etBlue1, final EditText etBlue2,
                                final EditText etBlue3, final ImageButton buttonBlue, final ImageView imagePadlocks,
                                final ImageButton buttonPadlocks, final Button Xpadlocks) {

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

                    buttonEvent.setVisibility(View.INVISIBLE);
                    textEvent.setVisibility(View.INVISIBLE);
                    X.setVisibility(View.INVISIBLE);
                    imagePadlocks.setVisibility(View.VISIBLE);
                    buttonPadlocks.setVisibility(View.VISIBLE);
                    Xpadlocks.setVisibility(View.VISIBLE);
                    padlockRed.setVisibility(View.VISIBLE);
                    etRed1.setVisibility(View.VISIBLE);
                    etRed2.setVisibility(View.VISIBLE);
                    etRed3.setVisibility(View.VISIBLE);
                    padlockBlue.setVisibility(View.VISIBLE);
                    etBlue1.setVisibility(View.VISIBLE);
                    etBlue2.setVisibility(View.VISIBLE);
                    etBlue3.setVisibility(View.VISIBLE);
                    buttonBlue.setVisibility(View.VISIBLE);
                    buttonRed.setVisibility(View.VISIBLE);

                    if (PlayerSingleton.getInstance().isPadlockRedOpen()) {
                        padlockRed.setImageDrawable(getResources().getDrawable(R.drawable.key_cage));
                        etRed1.setVisibility(View.INVISIBLE);
                        etRed2.setVisibility(View.INVISIBLE);
                        etRed3.setVisibility(View.INVISIBLE);
                        buttonRed.setVisibility(View.INVISIBLE);
                    }

                    if (PlayerSingleton.getInstance().isPadlockBlueOpen()) {
                        padlockBlue.setImageDrawable(getResources().getDrawable(R.drawable.key_cage));
                        etBlue1.setVisibility(View.INVISIBLE);
                        etBlue2.setVisibility(View.INVISIBLE);
                        etBlue3.setVisibility(View.INVISIBLE);
                        buttonBlue.setVisibility(View.INVISIBLE);
                    }

                    Xpadlocks.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            imagePadlocks.setVisibility(View.INVISIBLE);
                            buttonPadlocks.setVisibility(View.INVISIBLE);
                            Xpadlocks.setVisibility(View.INVISIBLE);
                            padlockRed.setVisibility(View.INVISIBLE);
                            etRed1.setVisibility(View.INVISIBLE);
                            etRed2.setVisibility(View.INVISIBLE);
                            etRed3.setVisibility(View.INVISIBLE);
                            padlockBlue.setVisibility(View.INVISIBLE);
                            etBlue1.setVisibility(View.INVISIBLE);
                            etBlue2.setVisibility(View.INVISIBLE);
                            etBlue3.setVisibility(View.INVISIBLE);
                            buttonBlue.setVisibility(View.INVISIBLE);
                            buttonRed.setVisibility(View.INVISIBLE);
                        }
                    });

                    buttonRed.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String et1 = etRed1.getText().toString();
                            String et2 = etRed2.getText().toString();
                            String et3 = etRed3.getText().toString();

                            if (checkRedpadlock(et1, et2, et3)) {
                                padlockRed.setImageDrawable(getResources().getDrawable(R.drawable.key_cage));
                                etRed1.setVisibility(View.INVISIBLE);
                                etRed2.setVisibility(View.INVISIBLE);
                                etRed3.setVisibility(View.INVISIBLE);
                                buttonRed.setVisibility(View.INVISIBLE);
                                PlayerSingleton.getInstance().setPadlockRedOpen(true);
                            } else {
                                Toast.makeText(Room1.this, getString(R.string.padlockClose), Toast.LENGTH_SHORT).show();
                            }

                            if (isDead()) {

                                Intent goTodead = new Intent(Room1.this, DeadActivity.class);
                                Room1.this.startActivity(goTodead);
                            }
                            textCounter.setText(String.valueOf(PlayerSingleton.getInstance().getCounter()));
                        }
                    });

                    buttonBlue.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String et1 = etBlue1.getText().toString();
                            String et2 = etBlue2.getText().toString();
                            String et3 = etBlue3.getText().toString();

                            if (checkBluepadlock(et1, et2, et3)) {
                                padlockBlue.setImageDrawable(getResources().getDrawable(R.drawable.key_cage));
                                etBlue1.setVisibility(View.INVISIBLE);
                                etBlue2.setVisibility(View.INVISIBLE);
                                etBlue3.setVisibility(View.INVISIBLE);
                                buttonBlue.setVisibility(View.INVISIBLE);
                                PlayerSingleton.getInstance().setPadlockBlueOpen(true);
                            } else {
                                Toast.makeText(Room1.this, getString(R.string.padlockClose), Toast.LENGTH_SHORT).show();
                            }

                            if (isDead()) {

                                Intent goTodead = new Intent(Room1.this, DeadActivity.class);
                                Room1.this.startActivity(goTodead);
                            }
                            textCounter.setText(String.valueOf(PlayerSingleton.getInstance().getCounter()));
                        }
                    });

                    buttonPadlocks.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                           if (checkBluepadlock("2","4","5") && checkRedpadlock("1", "3", "4")) {
                               padlockBlue.setImageDrawable(getResources().getDrawable(R.drawable.key_cage));
                               etBlue1.setVisibility(View.INVISIBLE);
                               etBlue2.setVisibility(View.INVISIBLE);
                               etBlue3.setVisibility(View.INVISIBLE);
                               buttonBlue.setVisibility(View.INVISIBLE);
                               PlayerSingleton.getInstance().setPadlockBlueOpen(true);
                               padlockRed.setImageDrawable(getResources().getDrawable(R.drawable.key_cage));
                               etRed1.setVisibility(View.INVISIBLE);
                               etRed2.setVisibility(View.INVISIBLE);
                               etRed3.setVisibility(View.INVISIBLE);
                               buttonRed.setVisibility(View.INVISIBLE);
                               PlayerSingleton.getInstance().setPadlockRedOpen(true);
                           }
                        }
                    });

                    //imgGoRoom3.setVisibility(View.VISIBLE);
                    //imgActionDoorR3.setVisibility(View.INVISIBLE);
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

    public Boolean checkBluepadlock(String et1, String et2, String et3) {
        if (et1.equals("2") && et2.equals("4") && et3.equals("5")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkRedpadlock(String et1, String et2, String et3) {
        if (et1.equals("1") && et2.equals("3") && et3.equals("4")) {
            return true;
        } else {
            return false;
        }
    }
}
