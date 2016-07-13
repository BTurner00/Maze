package com.theironyard;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Collectors;

public class Main {
    static final int SIZE = 10;
    static ArrayList<Room> x = new ArrayList<>();

    static Room[][] createRooms(){
        Room[][] rooms = new Room[SIZE][SIZE];
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                rooms[row][col] = new Room(row, col);
            }
        }
        return rooms;
    }

    static ArrayList<Room> possibleNeighbors (Room[][] rooms, int row, int col) {
        ArrayList<Room> neighbors = new ArrayList<>();

        if (row>0) {
            neighbors.add(rooms[row-1][col]);
        }
        if (row < SIZE - 1) {
            neighbors.add(rooms[row+1][col]);
        }

        if (col > 0) {
            neighbors.add(rooms[row][col-1]);
        }
        if (col < SIZE -1) {
            neighbors.add(rooms[row][col+1]);
        }

        neighbors = neighbors.stream()
                .filter(room -> !room.wasVisited)
                .collect(Collectors.toCollection(ArrayList<Room>::new));

        return neighbors;
    }

    static Room randomNeighbor (Room[][] rooms, int row, int col) {
        ArrayList<Room> neighbors = possibleNeighbors(rooms, row, col);

        if (neighbors.size() > 0) {
            Random r = new Random();
            int index = r.nextInt(neighbors.size());
            return neighbors.get(index);
        }
        return null;
    }

    static void tearDownWall (Room oldRoom, Room newRoom) {
        if (newRoom.row < oldRoom.row) {
            newRoom.hasBottom = false;
        }
        else if (newRoom.row > oldRoom.row) {
            oldRoom.hasBottom = false;
        }
        else if (newRoom.col < oldRoom.col) {
            newRoom.hasRight = false;
        }
        else if (newRoom.col > oldRoom.col) {
            oldRoom.hasRight = false;
        }
    }

    static boolean createMaze(Room[][] rooms, Room room) {
        room.wasVisited = true;
        boolean end = false;
        Room nextRoom = randomNeighbor(rooms, room.row, room.col);
        if (nextRoom == null) {
            x.add(room);
            return false;
        }

        tearDownWall(room, nextRoom);
        while (createMaze(rooms, nextRoom));
        return true;
    }

    public static void main(String[] args) {
        boolean start = true;
        int ends = 0;
        Room[][] rooms = createRooms();
        createMaze(rooms, rooms[0][0]);
        for (Room[] row : rooms) {
            System.out.print(" _");
        }
        System.out.println();


        for (Room[] row: rooms) {
            System.out.print("|");
            for (Room room: row) {
                if (start) {
                    System.out.print("o");
                    start = false;
                } else if (room == x.get(0) && ends < 1) {
                    System.out.print("x");
                    ends++;
                } else {
                    System.out.print(room.hasBottom ? "_" : " ");
                }
                System.out.print(room.hasRight ? "|" : " ");
            }
            System.out.println();
        }


    }
}
