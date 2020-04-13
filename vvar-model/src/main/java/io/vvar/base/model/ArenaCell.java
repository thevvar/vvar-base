/*
 * Copyright (c) 2020. vvar.io
 */

package io.vvar.base.model;

/**
 * ArenaCell represents state of the cell
 *
 * player - symbol of a player in the current game who marked the cell: 'a','b','c' and so on.
 *
 * marker - code of the body part and direction where the player was moving:
 *
 *      0 - empty
 *      1 - body, was moving up
 *      2 - body, was moving down
 *      3 - body, was moving left
 *      4 - body, was moving right
 *      5 - head
 *      6 - base
 *
 */


public class ArenaCell {

    private char player;

    private byte marker;

    public char getPlayer() {
        return player;
    }

    public void setPlayer(char player) {
        this.player = player;
    }

    public byte getMarker() {
        return marker;
    }

    public void setMarker(byte marker) {
        this.marker = marker;
    }
}
