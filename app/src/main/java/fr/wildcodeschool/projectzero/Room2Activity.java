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


    //TODO make the background complete for build in room2.xml

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room2);

        final ConstraintLayout background = (ConstraintLayout) findViewById(R.id.constraintLayout);

        //Metthode arguments showEvent
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

        keyDoorVerify(keyDoor);
        if (PlayerSingleton.getInstance().isKeydoor()) {
            imgActionShelfR2.setVisibility(View.INVISIBLE);
        }

        if (isDeadVerify()) {
            // Intent
            Intent goTodead = new Intent(Room2Activity.this, DeadActivity.class);
            Room2Activity.this.startActivity(goTodead);
        }
        textCounter.setText(String.valueOf(PlayerSingleton.getInstance().getCounter()));

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
            isVisited(true, background);
            imgActionDoorLockerR2.setVisibility(View.INVISIBLE);
        }

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

        imgActionLocker1R2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showEvent(true, textEvent, X);
                textEvent.setText(getString(R.string.actionLocker1) + getString(R.string.actionLocker1_1));
                buttonEvent.setVisibility(View.VISIBLE);
                buttonEvent.setText(R.string.eventOpen);

                buttonEvent.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        textEvent.setText(R.string.buttonActionLocker1);
                        buttonEvent.setVisibility(View.INVISIBLE);

                        if (isDead()) {
                            // Intent
                            Intent goTodead = new Intent(Room2Activity.this, DeadActivity.class);
                            Room2Activity.this.startActivity(goTodead);
                        }
                        textCounter.setText(String.valueOf(PlayerSingleton.getInstance().getCounter()));

                        if (isDead()) {
                            // Intent
                            Intent goTodead = new Intent(Room2Activity.this, DeadActivity.class);
                            Room2Activity.this.startActivity(goTodead);
                        }
                        textCounter.setText(String.valueOf(PlayerSingleton.getInstance().getCounter()));
                    }
                });

                X.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showEvent(false, textEvent, X);
                        buttonEvent.setVisibility(View.INVISIBLE);
                    }
                });
            }
        });

        imgActionDoorLockerR2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showEvent(true, textEvent, X);
                textEvent.setText(R.string.porteR2);
                buttonEvent.setVisibility(View.VISIBLE);
                buttonEvent.setText(R.string.eventOpen);

                buttonEvent.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        textEvent.setText(R.string.ButtonActionDoorR2);
                        buttonEvent.setVisibility(View.INVISIBLE);
                        isVisited(true, background);
                        PlayerSingleton.getInstance().setR2AllVisited(true);

                        //Method drop counter and verify if dead
                        if (isDead()) {
                            // Intent
                            Intent goTodead = new Intent(Room2Activity.this, DeadActivity.class);
                            Room2Activity.this.startActivity(goTodead);
                        }
                        textCounter.setText(String.valueOf(PlayerSingleton.getInstance().getCounter()));
                    }
                });

                X.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showEvent(false, textEvent, X);
                        imgActionDoorLockerR2.setVisibility(View.INVISIBLE);
                        buttonEvent.setVisibility(View.INVISIBLE);
                    }
                });
            }
        });

        imgActionTable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showEvent(true, textEvent, X);
                textEvent.setText(R.string.actionTable);
                buttonEvent.setVisibility(View.VISIBLE);
                buttonEvent.setText(R.string.eventExploration);

                buttonEvent.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        textEvent.setText(R.string.buttonAtcionTable);
                        buttonEvent.setVisibility(View.INVISIBLE);

                        //Method drop counter and verify if dead
                        if (isDead()) {
                            // Intent
                            Intent goTodead = new Intent(Room2Activity.this, DeadActivity.class);
                            Room2Activity.this.startActivity(goTodead);
                        }
                        textCounter.setText(String.valueOf(PlayerSingleton.getInstance().getCounter()));
                    }
                });

                X.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showEvent(false, textEvent, X);
                        buttonEvent.setVisibility(View.INVISIBLE);
                    }
                });

            }
        });

        imgActionTools.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showEvent(true, textEvent, X);
                textEvent.setText(R.string.actionTools);
                buttonEvent.setVisibility(View.VISIBLE);
                buttonEvent.setText(R.string.eventExploration);

                buttonEvent.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        textEvent.setText(R.string.buttonActonTols);
                        buttonEvent.setVisibility(View.INVISIBLE);

                        //Method drop counter and verify if dead
                        if (isDead()) {
                            // Intent
                            Intent goTodead = new Intent(Room2Activity.this, DeadActivity.class);
                            Room2Activity.this.startActivity(goTodead);
                        }
                        textCounter.setText(String.valueOf(PlayerSingleton.getInstance().getCounter()));
                    }
                });

                X.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showEvent(false, textEvent, X);
                        buttonEvent.setVisibility(View.INVISIBLE);
                    }
                });
            }
        });

        imgActionCarton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showEvent(true, textEvent, X);
                textEvent.setText(R.string.actionCarton);
                buttonEvent.setVisibility(View.VISIBLE);
                buttonEvent.setText(R.string.eventOpen);

                buttonEvent.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        textEvent.setText(R.string.buttonActionCarton);
                        buttonEvent.setVisibility(View.INVISIBLE);

                        //Method drop counter and verify if dead
                        if (isDead()) {
                            // Intent
                            Intent goTodead = new Intent(Room2Activity.this, DeadActivity.class);
                            Room2Activity.this.startActivity(goTodead);
                        }
                        textCounter.setText(String.valueOf(PlayerSingleton.getInstance().getCounter()));
                    }
                });

                X.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showEvent(false, textEvent, X);
                        buttonEvent.setVisibility(View.INVISIBLE);
                    }
                });
            }
        });

        imgActionShelfR2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showEvent(true, textEvent, X);
                textEvent.setText(R.string.ActionShelf);
                buttonEvent.setVisibility(View.VISIBLE);
                buttonEvent.setText(R.string.eventOpen);

                buttonEvent.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        textEvent.setText(R.string.findKeydoor);
                        buttonEvent.setVisibility(View.INVISIBLE);
                        PlayerSingleton.getInstance().setKeydoor(true);
                        keyDoorVerify(keyDoor);

                        //Method drop counter and verify if dead
                        if (isDead()) {
                            // Intent
                            Intent goTodead = new Intent(Room2Activity.this, DeadActivity.class);
                            Room2Activity.this.startActivity(goTodead);
                        }
                        textCounter.setText(String.valueOf(PlayerSingleton.getInstance().getCounter()));
                    }
                });

                X.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showEvent(false, textEvent, X);
                        imgActionShelfR2.setVisibility(View.INVISIBLE);
                        buttonEvent.setVisibility(View.INVISIBLE);
                    }
                });
            }
        });

        imgActionWoodDoorR2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showEvent(true, textEvent, X);
                textEvent.setText(R.string.actionWooddoor);
                buttonEvent.setVisibility(View.VISIBLE);
                buttonEvent.setText(R.string.eventOpen);

                buttonEvent.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (!PlayerSingleton.getInstance().isKeydoor()) {
                            textEvent.setText(R.string.DoorClose);
                            buttonEvent.setVisibility(View.INVISIBLE);
                        } else {
                            textEvent.setText(R.string.DoorOpenKey);
                            buttonEvent.setVisibility(View.INVISIBLE);
                            PlayerSingleton.getInstance().setKeydoor(false);
                            keyDoorVerify(keyDoor);
                            imgActionWoodDoorR2.setVisibility(View.INVISIBLE);
                            imgGoRoom3.setVisibility(View.VISIBLE);
                        }

                        //Method drop counter and verify if dead
                        if (isDead()) {
                            // Intent
                            Intent goTodead = new Intent(Room2Activity.this, DeadActivity.class);
                            Room2Activity.this.startActivity(goTodead);
                        }
                        textCounter.setText(String.valueOf(PlayerSingleton.getInstance().getCounter()));
                    }
                });
                X.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showEvent(false, textEvent, X);
                        buttonEvent.setVisibility(View.INVISIBLE);
                    }
                });
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
    }

    public void isVisited(boolean visited, ConstraintLayout background) {
        if (visited) {
            background.setBackgroundResource(R.drawable.room2);
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
}
