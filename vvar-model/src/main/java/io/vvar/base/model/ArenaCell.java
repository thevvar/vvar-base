/*
 * Copyright (c) 2020. vvar.io
 */

package io.vvar.base.model;

import io.vvar.base.model.type.Marker;

/**
 * ArenaCell represents state of the cell
 *
 * player - symbol of a player in the current game who marked the cell: 'a','b','c' and so on.
 *
 * marker - code of the body part and direction where the player was moving:
 *
 */


public class ArenaCell {

    private char player;

    private Marker marker;

    public ArenaCell() {
    }

    public ArenaCell(char player, Marker marker) {
        this.player = player;
        this.marker = marker;
    }

    public char getPlayer() {
        return player;
    }

    public void setPlayer(char player) {
        this.player = player;
    }

    public Marker getMarker() {
        return marker;
    }

    public void setMarker(Marker marker) {
        this.marker = marker;
    }

    @Override
    public String toString() {
        return "ArenaCell{" +
                "player=" + player +
                ", marker=" + marker +
                '}';
    }
}
