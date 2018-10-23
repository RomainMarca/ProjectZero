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

    public int counter;
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

        final ImageView imgActionDoorR2 = findViewById(R.id.image_actiondoor_r2);
        TextView Counter2 = findViewById(R.id.text_counter2);
        ImageView imgGoRoom1 = findViewById(R.id.image_intent_r2);
        final ImageView imgObsLockerR2 = findViewById(R.id.image_obs_locker);
        final ImageView imgActionLocker1R2 = findViewById(R.id.image_action_locker1);
        final ImageView imgActionLocker2R2 = findViewById(R.id.image_action_locker2);

        Bundle bundle = getIntent().getExtras();
        counter = bundle.getInt("counter", counter);
        Counter2.setText(String.valueOf(counter));

        showEvent(true, textEvent, X);
        textEvent.setText(R.string.enterRoom2);
        X.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showEvent(false, textEvent, X);
            }
        });

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

        imgActionDoorR2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isVisited(true, background);
                imgActionDoorR2.setVisibility(View.INVISIBLE);
            }
        });

        imgGoRoom1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
}
