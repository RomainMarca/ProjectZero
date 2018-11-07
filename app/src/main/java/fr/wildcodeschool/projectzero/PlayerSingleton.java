package fr.wildcodeschool.projectzero;

class PlayerSingleton {

    private static final PlayerSingleton ourInstance = new PlayerSingleton();
    private int counter;
    private boolean r1isVisited;
    private boolean r2isVisited;
    private boolean r2AllVisited;
    private boolean r2OpenDoor;
    private boolean keydoor;


    static PlayerSingleton getInstance() {
        return ourInstance;
    }

    private PlayerSingleton() {

       counter = 10;
       r1isVisited = false;
       r2isVisited = false;
       r2AllVisited = false;
       keydoor= false;
       r2OpenDoor= false;
    }

    public boolean isR2OpenDoor() { return r2OpenDoor; }

    public void setR2OpenDoor(boolean r2OpenDoor) { this.r2OpenDoor = r2OpenDoor; }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public boolean isR1isVisited() {
        return r1isVisited;
    }

    public void setR1isVisited(boolean r1isVisited) {
        this.r1isVisited = r1isVisited;
    }

    public boolean isR2isVisited() { return r2isVisited; }

    public void setR2isVisited(boolean r2isVisited) {
        this.r2isVisited = r2isVisited;
    }

    public boolean isR2AllVisited() { return r2AllVisited; }

    public void setR2AllVisited(boolean r2AllVisited) {
        this.r2AllVisited = r2AllVisited;
    }

    public boolean isKeydoor() {
        return keydoor;
    }

    public void setKeydoor(boolean keydoor) {
        this.keydoor = keydoor;
    }
}
