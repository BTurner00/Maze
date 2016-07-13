package com.theironyard;

/**
 * Created by Ben on 7/13/16.
 */
public class Room{
    int row;
    int col;
    boolean hasBottom = true;
    boolean hasRight = true;
    boolean wasVisited = false;



    public Room(int row, int col, boolean hasBottom, boolean hasRight, boolean wasVisited) {
        this.row = row;
        this.col = col;
        this.hasBottom = hasBottom;
        this.hasRight = hasRight;
        this.wasVisited = wasVisited;
    }

    public Room(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public boolean isWasVisited() {
        return wasVisited;
    }

    public void setWasVisited(boolean wasVisited) {
        this.wasVisited = wasVisited;
    }

    public boolean isHasBottom() {
        return hasBottom;
    }

    public void setHasBottom(boolean hasBottom) {
        this.hasBottom = hasBottom;
    }

    public boolean isHasRight() {
        return hasRight;
    }

    public void setHasRight(boolean hasRight) {
        this.hasRight = hasRight;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }
}
