package io.vvar.base.model;

/**
 * Arena class defines size of the battlefield and current state of each cell
 *
 * 0 - empty
 *
 *
 *
 *
 */



public class Arena {

    private ArenaCell[][] battleGround;

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
}
