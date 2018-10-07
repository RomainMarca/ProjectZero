package fr.wildcodeschool.projectzero;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class Room2Activity extends AppCompatActivity {

    public int counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room2);


        final ConstraintLayout background = (ConstraintLayout) findViewById(R.id.constraintLayout);

        ImageView imgObsDoorR2 = findViewById(R.id.image_obsdoor_r2);
        ImageView imgActionDoorR2 = findViewById(R.id.image_actiondoor_r2);
        TextView Counter2 = findViewById(R.id.text_counter2);
        ImageView imgGoRoom1 = findViewById(R.id.image_intent_r2);

        Bundle bundle = getIntent().getExtras();
        counter = bundle.getInt("counter", counter);



        Counter2.setText(String.valueOf(counter));

        imgObsDoorR2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                isVisited(true, background);
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


    public void isVisited(boolean visited, ConstraintLayout background){
        if(visited){
            background.setBackgroundResource(R.drawable.room2);
        }
    }
}
