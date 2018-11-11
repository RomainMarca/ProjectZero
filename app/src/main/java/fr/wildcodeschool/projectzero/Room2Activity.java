package fr.wildcodeschool.projectzero;

import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class Room2Activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room2);

        final ConstraintLayout background = (ConstraintLayout) findViewById(R.id.constraintLayout);

        //Method showEvent
        final TextView textEvent = findViewById(R.id.text_event);
        final Button X = findViewById(R.id.button_hollow);
        final Button buttonEvent = findViewById(R.id.button_action);

        final ImageView imgActionDoorLockerR2 = findViewById(R.id.image_actiondoor_locker_r2);
        final ImageView imgActionWoodDoorR2 = findViewById(R.id.image_action_wooddoor);
        final TextView textCounter = findViewById(R.id.text_counter2);
        ImageView imgGoRoom1 = findViewById(R.id.image_intent_r2);
        final ImageView imgObsLockerR2 = findViewById(R.id.image_obs_locker);
        final ImageView imgActionLocker1R2 = findViewById(R.id.image_action_locker1);
        final ImageView imgActionLocker2R2 = findViewById(R.id.image_action_locker2);
        final ImageView imgActionShelfR2 = findViewById(R.id.image_shelf);
        final ImageView imgActionTable = findViewById(R.id.image_table);
        final ImageView imgActionTools = findViewById(R.id.image_tools);
        final ImageView imgActionCarton = findViewById(R.id.image_carton);
        final ImageView imgActionRack2 = findViewById(R.id.image_rack2);
        final ImageView imgActionRack1 = findViewById(R.id.image_rack);
        final ImageView keyDoor = findViewById(R.id.image_keydoor);
        final ImageView imgGoRoom3 = findViewById(R.id.image_intent_r3);
        final ImageView keyCage = findViewById(R.id.image_keycage);
        final ImageView diary = findViewById(R.id.diary);

        //TODO make actionLocker2, Rack1 and 2

        //Verify player progress
        room2Verify(textCounter, imgActionShelfR2,keyDoor, textEvent, X, imgActionDoorLockerR2, background, imgActionWoodDoorR2, imgGoRoom3,
                imgActionTable, imgActionTools, imgActionCarton, imgActionRack2, imgActionRack1, keyCage, imgObsLockerR2, imgActionLocker2R2,
                diary);

        imgObsLockerR2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Show and close textEvent
                showEvent(true, textEvent, X);
                textEvent.setText(R.string.ObsLockerR2);

                X.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showEvent(false, textEvent, X);
                        imgObsLockerR2.setVisibility(View.INVISIBLE);
                        imgActionLocker1R2.setVisibility(View.VISIBLE);
                        imgActionLocker2R2.setVisibility(View.VISIBLE);
                    }
                });
            }
        });

        imgActionLocker2R2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String actionStr = getString(R.string.actionLocker2);
                String eventStr = getString(R.string.eventRead);
                String buttonStr = getString(R.string.buttonActionLocker2) +
                        getString(R.string.buttonActionLocker22);
                actionDiaryClick(textEvent, X, buttonEvent, textCounter, actionStr, eventStr, buttonStr, diary, imgActionLocker2R2);
            }
        });

        imgActionLocker1R2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String actionStr = getString(R.string.actionLocker1);
                String eventStr = getString(R.string.eventOpen);
                String buttonStr = getString(R.string.buttonActionLocker1);
                action2Click(textEvent, X, buttonEvent, textCounter, actionStr, eventStr, buttonStr);
            }
        });

        imgActionDoorLockerR2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String actionStr = getString(R.string.porteR2);
                String eventStr = getString(R.string.eventOpen);
                String buttonStr = getString(R.string.ButtonActionDoorR2);
                actionLockerClick(textEvent, X, buttonEvent, textCounter, actionStr, eventStr, buttonStr,
                        imgActionDoorLockerR2, background, imgActionTable, imgActionTools, imgActionCarton, imgActionRack2,
                        imgActionRack1, imgActionShelfR2, imgActionWoodDoorR2);
            }
        });

        imgActionTable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String actionStr = getString(R.string.actionTable);
                String eventStr = getString(R.string.eventExploration);
                String buttonStr = getString(R.string.buttonAtcionTable);
                actionClick(textEvent, X, buttonEvent, textCounter, actionStr, eventStr, buttonStr);
            }
        });

        imgActionTools.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String actionStr = getString(R.string.actionTools);
                String eventStr = getString(R.string.eventExploration);
                String buttonStr = getString(R.string.buttonActonTols);
                actionClick(textEvent, X, buttonEvent, textCounter, actionStr, eventStr, buttonStr);
            }
        });

        imgActionCarton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String actionStr = getString(R.string.actionCarton);
                String eventStr = getString(R.string.eventOpen);
                String buttonStr = getString(R.string.buttonActionCarton);
                actionClick(textEvent, X, buttonEvent, textCounter, actionStr, eventStr, buttonStr);
            }
        });

        imgActionShelfR2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String actionStr = getString(R.string.ActionShelf);
                String eventStr = getString(R.string.eventOpen);
                String buttonStr = getString(R.string.findKeydoor);
                actionKeyClick(textEvent, X, buttonEvent, textCounter, actionStr, eventStr, buttonStr, keyDoor, imgActionShelfR2);
            }
        });

        imgActionWoodDoorR2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String actionStr = getString(R.string.actionWooddoor);
                String eventStr = getString(R.string.eventOpen);
                String buttonStr = getString(R.string.DoorClose);
                String buttonStr2 = getString(R.string.DoorOpenKey);
                actionDoorClick(textEvent, X, buttonEvent, textCounter, actionStr, eventStr, buttonStr, buttonStr2,
                        keyDoor, imgActionWoodDoorR2, imgGoRoom3);
            }
        });

        imgGoRoom1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Method drop counter and verify if dead
                if (isDead()) {
                    // Intent
                    Intent goTodead = new Intent(Room2Activity.this, DeadActivity.class);
                    Room2Activity.this.startActivity(goTodead);
                }
                textCounter.setText(String.valueOf(PlayerSingleton.getInstance().getCounter()));
                PlayerSingleton.getInstance().setR2isVisited(true);
                Intent goToRoom1 = new Intent(Room2Activity.this, Room1.class);
                Room2Activity.this.startActivity(goToRoom1);
            }
        });

        imgGoRoom3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isDead()) {
                    // Intent
                    Intent goTodead = new Intent(Room2Activity.this, DeadActivity.class);
                    Room2Activity.this.startActivity(goTodead);
                }
                textCounter.setText(String.valueOf(PlayerSingleton.getInstance().getCounter()));
                PlayerSingleton.getInstance().setR2isVisited(true);  
                Intent goToRoom3 = new Intent(Room2Activity.this, room3Activity.class);
                Room2Activity.this.startActivity(goToRoom3);
            }
        });

        diary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToDiary = new Intent(Room2Activity.this, DiaryActivity.class);
                Room2Activity.this.startActivity(goToDiary);
            }
        });
    }

    /////////////////////METHOD///////////////////////////////////////////////////////


    @Override
    public void onBackPressed() {
        //Polymorphisme. Vide la méthode onBackPressed pour empêcher son utilisation pendant la partie
    }

    public void isVisited(boolean visited, ConstraintLayout background, ImageView imgActionDoorLockerR2) {
        if (visited) {
            background.setBackgroundResource(R.drawable.room2);
            imgActionDoorLockerR2.setVisibility(View.INVISIBLE);
        }
    }

    public void showEvent(boolean openEvent, TextView textEvent, Button X) {
        if (openEvent) {
            textEvent.setVisibility(View.VISIBLE);
            X.setVisibility(View.VISIBLE);
        } else {
            textEvent.setVisibility(View.INVISIBLE);
            X.setVisibility(View.INVISIBLE);
        }
    }

    public boolean isDead() {
        PlayerSingleton.getInstance().setCounter(PlayerSingleton.getInstance().getCounter() - 1);
        if (PlayerSingleton.getInstance().getCounter() < 0) {
            return true;
        } else {
            return false;
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

                    Intent goTodead = new Intent(Room2Activity.this, DeadActivity.class);
                    Room2Activity.this.startActivity(goTodead);
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

    public void action2Click(final TextView textEvent, final Button X, final Button buttonEvent,
                             final TextView textCounter, String actionStr, String eventStr, final String buttonStr) {
        showEvent(true,textEvent, X);
        textEvent.setText(actionStr);
        buttonEvent.setVisibility(View.VISIBLE);
        buttonEvent.setText(eventStr);

        buttonEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textEvent.setText(buttonStr);
                buttonEvent.setVisibility(View.INVISIBLE);
                PlayerSingleton.getInstance().setCounter(PlayerSingleton.getInstance().getCounter() - 1);
                if (isDead()) {

                    Intent goTodead = new Intent(Room2Activity.this, DeadActivity.class);
                    Room2Activity.this.startActivity(goTodead);
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

    public void actionLockerClick(final TextView textEvent, final Button X, final Button buttonEvent, final TextView textCounter,
                                  String actionStr, String eventStr, final String buttonStr, final ImageView imgActionDoorLockerR2,
                                  final ConstraintLayout background, final ImageView imgActionTable, final ImageView imgActionTools,
                                  final ImageView imgActionCarton, final ImageView imgActionRack2, final ImageView imgActionRack1,
                                  final ImageView imgActionShelfR2, final ImageView imgActionWoodDoorR2) {

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

                    Intent goTodead = new Intent(Room2Activity.this, DeadActivity.class);
                    Room2Activity.this.startActivity(goTodead);
                }
                textCounter.setText(String.valueOf(PlayerSingleton.getInstance().getCounter()));
                imgActionDoorLockerR2.setVisibility(View.INVISIBLE);
                PlayerSingleton.getInstance().setR2AllVisited(true);
                background.setBackgroundResource(R.drawable.room2);
                imgActionShelfR2.setVisibility(View.VISIBLE);
                imgActionTable.setVisibility(View.VISIBLE);
                imgActionTools.setVisibility(View.VISIBLE);
                imgActionCarton.setVisibility(View.VISIBLE);
                imgActionRack2.setVisibility(View.VISIBLE);
                imgActionRack1.setVisibility(View.VISIBLE);
                imgActionWoodDoorR2.setVisibility(View.VISIBLE);
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

    public void actionKeyClick(final TextView textEvent, final Button X, final Button buttonEvent,
                               final TextView textCounter, String actionStr, String eventStr,
                               final String buttonStr, final ImageView keyDoor, final ImageView imgActionShelfR2) {
        showEvent(true,textEvent, X);
        textEvent.setText(actionStr);
        buttonEvent.setVisibility(View.VISIBLE);
        buttonEvent.setText(eventStr);

        buttonEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textEvent.setText(buttonStr);
                buttonEvent.setVisibility(View.INVISIBLE);
                PlayerSingleton.getInstance().setKeydoor(true);
                keyDoorVerify(keyDoor);

                if (isDead()) {

                    Intent goTodead = new Intent(Room2Activity.this, DeadActivity.class);
                    Room2Activity.this.startActivity(goTodead);
                }
                textCounter.setText(String.valueOf(PlayerSingleton.getInstance().getCounter()));
                imgActionShelfR2.setVisibility(View.INVISIBLE);
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

    public void actionDoorClick(final TextView textEvent, final Button X, final Button buttonEvent, final TextView textCounter,
                                  String actionStr, String eventStr, final String buttonStr, final String buttonStr2,
                                final ImageView keyDoor, final ImageView imgActionWoodDoorR2, final ImageView imgGoRoom3) {

        showEvent(true,textEvent, X);
        textEvent.setText(actionStr);
        buttonEvent.setVisibility(View.VISIBLE);
        buttonEvent.setText(eventStr);

        buttonEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!PlayerSingleton.getInstance().isKeydoor()) {
                    textEvent.setText(buttonStr);
                    buttonEvent.setVisibility(View.INVISIBLE);
                } else {
                    textEvent.setText(buttonStr2);
                    buttonEvent.setVisibility(View.INVISIBLE);
                    PlayerSingleton.getInstance().setKeydoor(false);
                    keyDoorVerify(keyDoor);
                    PlayerSingleton.getInstance().setR2OpenDoor(true);
                    imgActionWoodDoorR2.setVisibility(View.INVISIBLE);
                    imgGoRoom3.setVisibility(View.VISIBLE);
                }

                if (isDead()) {

                    Intent goTodead = new Intent(Room2Activity.this, DeadActivity.class);
                    Room2Activity.this.startActivity(goTodead);
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

    public void room2Verify(TextView textCounter, ImageView imgActionShelfR2, ImageView keyDoor, final TextView textEvent,
                            final Button X, ImageView imgActionDoorLockerR2, ConstraintLayout background,
                            ImageView imgActionWoodDoorR2, ImageView imgGoRoom3, ImageView imgActionTable,
                            ImageView imgActionTools, ImageView imgActionCarton, ImageView imgActionRack2,
                            ImageView imgActionRack1, ImageView keyCage, ImageView imgObsLockerR2, ImageView imgActionDoorLocker2R2,
                            ImageView diary) {

        if (isDeadVerify()) {
            // Intent
            Intent goTodead = new Intent(Room2Activity.this, DeadActivity.class);
            Room2Activity.this.startActivity(goTodead);
        }
        textCounter.setText(String.valueOf(PlayerSingleton.getInstance().getCounter()));

        keyDoorVerify(keyDoor);
        if (PlayerSingleton.getInstance().isKeydoor()) {
            imgActionShelfR2.setVisibility(View.INVISIBLE);
        }

        if (!PlayerSingleton.getInstance().isR2isVisited()) {
            showEvent(true, textEvent, X);
            textEvent.setText(R.string.enterRoom2);
            X.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showEvent(false, textEvent, X);
                }
            });
        }

        if (PlayerSingleton.getInstance().isR2AllVisited()) {
            isVisited(true, background, imgActionDoorLockerR2);
            imgActionShelfR2.setVisibility(View.VISIBLE);
            imgActionTable.setVisibility(View.VISIBLE);
            imgActionTools.setVisibility(View.VISIBLE);
            imgActionCarton.setVisibility(View.VISIBLE);
            imgActionRack2.setVisibility(View.VISIBLE);
            imgActionRack1.setVisibility(View.VISIBLE);
            imgActionWoodDoorR2.setVisibility(View.VISIBLE);
        }

        if (PlayerSingleton.getInstance().isR2OpenDoor()) {
            imgActionShelfR2.setVisibility(View.INVISIBLE);
            imgActionWoodDoorR2.setVisibility(View.INVISIBLE);
            imgGoRoom3.setVisibility(View.VISIBLE);
        }

        if (PlayerSingleton.getInstance().isKeyCage()) {
            keyCage.setVisibility(View.VISIBLE);
        }

        if (PlayerSingleton.getInstance().isDiary()) {
            imgObsLockerR2.setVisibility(View.INVISIBLE);
            imgActionDoorLocker2R2.setVisibility(View.INVISIBLE);
            imgActionDoorLockerR2.setVisibility(View.VISIBLE);
            diary.setVisibility(View.VISIBLE);
        }
    }

    public void actionDiaryClick(final TextView textEvent, final Button X, final Button buttonEvent, final TextView textCounter,
                                 String actionStr, String eventStr, final String buttonStr, final ImageView diary, final ImageView imgActionLocker2R2) {
        showEvent(true,textEvent, X);
        textEvent.setText(actionStr);
        buttonEvent.setVisibility(View.VISIBLE);
        buttonEvent.setText(eventStr);

        buttonEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textEvent.setText(buttonStr);
                buttonEvent.setVisibility(View.INVISIBLE);
                PlayerSingleton.getInstance().setDiary(true);
                diary.setVisibility(View.VISIBLE);

                if (isDead()) {

                    Intent goTodead = new Intent(Room2Activity.this, DeadActivity.class);
                    Room2Activity.this.startActivity(goTodead);
                }
                textCounter.setText(String.valueOf(PlayerSingleton.getInstance().getCounter()));
            }
        });

        X.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showEvent(false,textEvent, X);
                buttonEvent.setVisibility(View.INVISIBLE);
                imgActionLocker2R2.setVisibility(View.INVISIBLE);
            }
        });
    }
}
