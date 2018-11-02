package fr.wildcodeschool.projectzero;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DeadActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dead);

        Button buttonRetour = findViewById(R.id.button_retry);

        buttonRetour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PlayerSingleton.getInstance().setCounter(10);
                PlayerSingleton.getInstance().setR2AllVisited(false);
                PlayerSingleton.getInstance().setR2isVisited(false);
                PlayerSingleton.getInstance().setR1isVisited(false);
                Intent goToMain = new Intent(DeadActivity.this , MainActivity.class);
                DeadActivity.this.startActivity(goToMain);
            }
        });


    }
}
