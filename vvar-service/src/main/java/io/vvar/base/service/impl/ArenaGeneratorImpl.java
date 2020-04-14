/*
 * Copyright (c) 2020. vvar.io
 */

package io.vvar.base.service.impl;

import io.vvar.base.model.Arena;
import io.vvar.base.model.ArenaCell;
import io.vvar.base.model.Position;
import io.vvar.base.model.type.Marker;
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

        initStartingPositions(arena);

        return arena;
    }

    @Override
    public Map<Character, Position> generateStartingPositions(Arena arena) {
        return generateStartingPositions(arena.getSizeR(), arena.getSizeC());
    }

    @Override
    public Map<Character, Position> generateStartingPositions(int sizeR, int sizeC) {
        return generateStartingPositions(sizeR, sizeC, defaultPlayersNumber);
    }


    // Current implementation works only for 2 players
    private Map<Character, Position> generateStartingPositions(int sizeR, int sizeC, char numberOfPlayers) {
        Map<Character, Position> positionsMap = new HashMap<>();

        boolean evenRows = sizeR % 2 == 0;

        int middle = sizeR / 2;

        Position playerOnePosition = new Position(middle-1, 0);
        positionsMap.put((char)1, playerOnePosition);

        Position playerTwoPosition = new Position(evenRows ? middle : middle + 1, sizeC-1);
        positionsMap.put((char)2, playerTwoPosition);

        return positionsMap;
    }

    private void initStartingPositions(Arena arena) {
        Map<Character, Position> map = arena.getStartingPositions();

        for (Character player:map.keySet()) {
            arena.getBattleGround()[map.get(player).getRow()][map.get(player).getColumn()]
                    = new ArenaCell(player, Marker.BASE);
        }
    }

}
