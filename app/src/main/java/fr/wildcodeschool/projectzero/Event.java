package fr.wildcodeschool.projectzero;

public class Event {


    private boolean Action;

    public Event(boolean Icon, boolean Action){

        this.Action = Action;
    }

    //getter

    public boolean isAction() {
        return Action;
    }

    //setter


    public void setAction(boolean action) {
        Action = action;
    }




}
