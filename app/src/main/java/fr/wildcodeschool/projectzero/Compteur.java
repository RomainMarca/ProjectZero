package fr.wildcodeschool.projectzero;

public class Compteur {

    private  int compteurAction;

    public Compteur(int compteurAction){
        this.compteurAction= compteurAction;
    }

    //getter
    public int getCompteurAction(){
        return this.compteurAction;
    }

    //setter
    public void setCompteurAction(int compteurAction){
        this.compteurAction=compteurAction;
    }

    public int MethCompteur(){
        return this.compteurAction;
    }

}


