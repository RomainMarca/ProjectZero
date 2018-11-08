package fr.wildcodeschool.projectzero;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class room3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room3);

        final ConstraintLayout background = (ConstraintLayout) findViewById(R.id.constraintLayout);
        //TODO modif background for part
        //TODO make keyCage in nailBoard

        //Metthode arguments showEvent
        final TextView textEvent = findViewById(R.id.text_event);
        final Button X = findViewById(R.id.button_hollow);
        final Button buttonEvent = findViewById(R.id.button_action);

        ImageView imgGoRoom2 = findViewById(R.id.img_intentr2);
        final TextView textCounter = findViewById(R.id.text_counter3);
        final ImageView imgNailBoard = findViewById(R.id.image_nailboard);
        final ImageView keyCage = findViewById(R.id.image_keycage);

        room3Verify(textCounter, keyCage, imgNailBoard);

        imgNailBoard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String actionStr = getString(R.string.actionNailBoard);
                String eventStr = getString(R.string.eventTake);
                String buttonStr = getString(R.string.buttonActionNailBorad);
                actionKeyClick(textEvent, X, buttonEvent, textCounter, actionStr, eventStr, buttonStr, keyCage, imgNailBoard);
            }
        });

        imgGoRoom2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isDead()) {
                    // Intent
                    Intent goTodead = new Intent(room3Activity.this, DeadActivity.class);
                    room3Activity.this.startActivity(goTodead);
                }
                textCounter.setText(String.valueOf(PlayerSingleton.getInstance().getCounter()));

                Intent goToRoom2 = new Intent(room3Activity.this, Room2Activity.class);
                room3Activity.this.startActivity(goToRoom2);
            }
        });
    }

    ////////////////////////////METHOD//////////////////////////////////////////////////////////

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

    public void showEvent(boolean openEvent, TextView textEvent, Button X) {
        if (openEvent) {
            textEvent.setVisibility(View.VISIBLE);
            X.setVisibility(View.VISIBLE);
        } else {
            textEvent.setVisibility(View.INVISIBLE);
            X.setVisibility(View.INVISIBLE);
        }
    }

    public void room3Verify(TextView textCounter, ImageView keyCage, ImageView imgNailBoard) {

        if (isDeadVerify()) {
            // Intent
            Intent goTodead = new Intent(room3Activity.this, DeadActivity.class);
            room3Activity.this.startActivity(goTodead);
        }
        textCounter.setText(String.valueOf(PlayerSingleton.getInstance().getCounter()));

        if (PlayerSingleton.getInstance().isKeyCage()) {
            keyCage.setVisibility(View.VISIBLE);
            imgNailBoard.setVisibility(View.INVISIBLE);
        }
    }

    public void actionClick(final TextView textEvent, final Button X, final Button buttonEvent,
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

                if (isDead()) {

                    Intent goTodead = new Intent(room3Activity.this, DeadActivity.class);
                    room3Activity.this.startActivity(goTodead);
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

    public void actionKeyClick(final TextView textEvent, final Button X, final Button buttonEvent,
                               final TextView textCounter, String actionStr, String eventStr,
                               final String buttonStr, final ImageView keyCage, final ImageView imgNailBoard) {

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

                    Intent goTodead = new Intent(room3Activity.this, DeadActivity.class);
                    room3Activity.this.startActivity(goTodead);
                }
                textCounter.setText(String.valueOf(PlayerSingleton.getInstance().getCounter()));
                PlayerSingleton.getInstance().setKeyCage(true);
                keyCage.setVisibility(View.VISIBLE);
                imgNailBoard.setVisibility(View.INVISIBLE);
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
}
