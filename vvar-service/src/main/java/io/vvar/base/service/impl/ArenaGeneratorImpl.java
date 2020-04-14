/*
 * Copyright (c) 2020. vvar.io
 */

package io.vvar.base.service.impl;

import io.vvar.base.model.Arena;
import io.vvar.base.model.ArenaCell;
import io.vvar.base.service.ArenaGenerator;

import javax.jnlp.IntegrationService;
import java.util.HashMap;
import java.util.Map;

public class ArenaGeneratorImpl implements ArenaGenerator {

    protected static final int defaultArenaSizeRows = 64;

    protected static final int defaultArenaSizeColumns = 64;

    protected static final char defaultPlayersNumber = 2;

    public Arena generate() {
        return generate(defaultArenaSizeRows, defaultArenaSizeColumns);
    }

    public Arena generate(int rows, int columns) {

        ArenaCell[][] battleGround = new ArenaCell[rows][columns];

        Arena arena = new Arena(battleGround);

        arena.setStartingPositions(generateStartingPositions(arena));

        return arena;
    }

    @Override
    public Map<String, Integer> generateStartingPositions(int sizeR, int sizeC) {
        return generateStartingPositions(sizeR, sizeC, defaultPlayersNumber);
    }

    @Override
    public Map<String, Integer> generateStartingPositions(Arena arena) {
        return generateStartingPositions(arena.getSizeR(), arena.getSizeC());
    }

    // Current implementation works only for 2 players

    private Map<String, Integer> generateStartingPositions(int sizeR, int sizeC, char numberOfPlayers) {
        Map<String, Integer> positionsMap = new HashMap<>();

        boolean evenRows = sizeR % 2 == 0;

        int middle = sizeR / 2;

        positionsMap.put(1 + "r", middle - 1);
        positionsMap.put(1 + "c", 0);

        positionsMap.put(2 + "r", evenRows ? middle : middle + 1);
        positionsMap.put(2 + "c", sizeC - 1);

        return positionsMap;
    }

}
