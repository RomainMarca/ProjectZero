package fr.wildcodeschool.projectzero;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Room2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room2);

        ImageView imgObsDoorR2 = findViewById(R.id.image_obsdoor_r2);
        ImageView imgActionDoorR2 = findViewById(R.id.image_actiondoor_r2);

        imgObsDoorR2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConstraintLayout background = (ConstraintLayout) findViewById(R.id.constraintLayout);
                background.setBackgroundResource(R.drawable.room2);
            }
        });



    }
}
