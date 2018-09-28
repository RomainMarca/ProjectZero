package fr.wildcodeschool.projectzero;

import android.widget.ImageView;

public class Event {


    private boolean Action;


    public Event(boolean action){
        this.Action = action;
    }

    //getter
    public boolean isAction() {
        return Action;
    }

    //setter
    public void setAction(boolean action) {
        action = action;
    }

}
