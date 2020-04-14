package io.vvar.base.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Arena class defines size of the battlefield and current state of each cell
 *
 *
 *
 */



public class Arena {

    private ArenaCell[][] battleGround;

    private Map<String, Integer> startingPositions = new HashMap<>();


    public Arena(int sizeR, int sizeC) {
        battleGround = new ArenaCell[sizeR][sizeC];
    }

    public Arena(ArenaCell[][] battleGround) {
        this.battleGround = battleGround;
    }

    public int getSizeR() {
        return battleGround.length;
    }

    public int getSizeC() {
        return battleGround[0].length;
    }

    public ArenaCell[][] getBattleGround() {
        return battleGround;
    }

    public void setBattleGround(ArenaCell[][] battleGround) {
        this.battleGround = battleGround;
    }

    public Map<String, Integer> getStartingPositions() {
        return startingPositions;
    }

    public void setStartingPositions(Map<String, Integer> startingPositions) {
        this.startingPositions = startingPositions;
    }
}
