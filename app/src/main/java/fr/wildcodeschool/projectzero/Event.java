package fr.wildcodeschool.projectzero;

public class Event {

    private boolean Icon;
    private boolean Action;

    public Event(boolean Icon, boolean Action){
        this.Icon = Icon;
        this.Action = Action;
    }

    //getter
    public boolean isIcon() {
        return Icon;
    }

    public boolean isAction() {
        return Action;
    }

    //setter

    public void setIcon(boolean icon) {
        Icon = icon;
    }

    public void setAction(boolean action) {
        Action = action;
    }


}
