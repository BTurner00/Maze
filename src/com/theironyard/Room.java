package com.theironyard;

/**
 * Created by Ben on 7/13/16.
 */
public class Room{
    int row;
    int col;

    public Room(int row, int col) {
        this.row = row;
        this.col = col;
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
