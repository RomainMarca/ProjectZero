package fr.wildcodeschool.projectzero;

class PlayerSingleton {

    private static final PlayerSingleton ourInstance = new PlayerSingleton();
    private int counter;
    private boolean r1isVisited;
    private boolean r2isVisited;
    private boolean r2AllVisited;
    private boolean r3AllVisited;
    private boolean r2OpenDoor;
    private boolean r1OpenDoor;
    private boolean keydoor;
    private boolean keyCage;
    private boolean flagRockDoor;
    private boolean padlockRedOpen;
    private boolean padlockBlueOpen;


    static PlayerSingleton getInstance() {
        return ourInstance;
    }

    private PlayerSingleton() {

       counter = 15;
       r1isVisited = false;
       r2isVisited = false;
       r2AllVisited = false;
       r3AllVisited = false;
       keydoor= false;
       keyCage= false;
       r2OpenDoor= false;
       r1OpenDoor= false;
       flagRockDoor= false;
       padlockRedOpen= false;
       padlockBlueOpen= false;
    }

    public boolean isPadlockBlueOpen() {
        return padlockBlueOpen;
    }

    public void setPadlockBlueOpen(boolean padlockBlueOpen) {
        this.padlockBlueOpen = padlockBlueOpen;
    }

    public boolean isPadlockRedOpen() {
        return padlockRedOpen;
    }

    public void setPadlockRedOpen(boolean padlockRedOpen) {
        this.padlockRedOpen = padlockRedOpen;
    }

    public boolean isFlagRockDoor() {
        return flagRockDoor;
    }

    public void setFlagRockDoor(boolean flagRockDoor) {
        this.flagRockDoor = flagRockDoor;
    }

    public boolean isR1OpenDoor() {
        return r1OpenDoor;
    }

    public void setR1OpenDoor(boolean r1OpenDoor) {
        this.r1OpenDoor = r1OpenDoor;
    }

    public boolean isKeyCage() { return keyCage; }

    public void setKeyCage(boolean keyCage) { this.keyCage = keyCage; }

    public boolean isR3AllVisited() { return r3AllVisited; }

    public void setR3AllVisited(boolean r3AllVisited) { this.r3AllVisited = r3AllVisited; }

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
