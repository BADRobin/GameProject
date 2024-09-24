package dci.j24e1.group1;


import dci.j24e1.group1.types.Area;

public class GameState {

    Area location = Area.SPRING;
    Area toLeft;
    Area toRight ;

    public Area getLocation() {
        return location;
    }

    public void setLocation(Area location) {
        this.location = location;
    }

    public Area getToLeft() {
        return toLeft;
    }

    public void setToLeft(Area toLeft) {
        this.toLeft = toLeft;
    }

    public Area getToRight() {
        return toRight;
    }

    public void setToRight(Area toRight) {
        this.toRight = toRight;
    }
}
