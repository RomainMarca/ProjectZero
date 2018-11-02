package fr.wildcodeschool.projectzero;

public class Player {
    private int c1Counter;
    private boolean r1Visited;
    private boolean r2AllVisited;

    public Player(int c1Counter, boolean r1Visited, boolean r2AllVisited) {
        this.c1Counter = c1Counter;
        this.r1Visited = r1Visited;
        this.r2AllVisited = r2AllVisited;
    }

    public Player(int c1Counter) {
        this.c1Counter = c1Counter;
    }

    public int getC1Counter() {
        return c1Counter;
    }

    public void setC1Counter(int c1Counter) {
        this.c1Counter = c1Counter;
    }

    public boolean isR1Visited() {
        return r1Visited;
    }

    public void setR1Visited(boolean r1Visited) {
        this.r1Visited = r1Visited;
    }

    public boolean isR2AllVisited() {
        return r2AllVisited;
    }

    public void setR2AllVisited(boolean r2AllVisited) {
        this.r2AllVisited = r2AllVisited;
    }
}
