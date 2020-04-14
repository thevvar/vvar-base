/*
 * Copyright (c) 2020. vvar.io
 */

package io.vvar.base.service.impl;

import io.vvar.base.model.Arena;

import static org.junit.jupiter.api.Assertions.*;

import io.vvar.base.model.ArenaCell;
import io.vvar.base.model.Position;
import io.vvar.base.model.type.Marker;
import io.vvar.base.service.ArenaGenerator;
import io.vvar.base.util.BattlegroundUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.apachecommons.ReflectionEquals;

import java.util.Map;

public class ArenaGeneratorImplTest {

    private ArenaGeneratorImpl test;

    private static final int TEST_SIZE_R = 88;

    private static final int TEST_SIZE_C = 88;

    private static final Position P1_STARTING_POSITION = new Position(43, 0);

    private static final Position P2_STARTING_POSITION = new Position(44, 87);

    @BeforeEach
    void init() {
        test = new ArenaGeneratorImpl();
    }

    @Test
    void testGenerate() {

        Arena arena = test.generate();

        // 1. Check if Arena created
        assertNotNull(arena);

        // 2. Verify that no args method generates default size arena
        assertEquals(ArenaGeneratorImpl.defaultArenaSizeColumns, arena.getSizeC());
        assertEquals(ArenaGeneratorImpl.defaultArenaSizeRows, arena.getSizeR());

        // 3. Make sure player starting positions properly initialized
        assertStartingPositions(arena.getStartingPositions(),
                new Position(31, 0),
                new Position(32, 63));

        // 4. Verify that player starting positions properly added to the battlefield
        Position p1Position = arena.getStartingPositions().get((char)1);
        ArenaCell p1StartingCell = arena.getBattleGround()[p1Position.getRow()][p1Position.getColumn()];
        assertNotNull(p1StartingCell);
        assertEquals(p1StartingCell.getMarker(), Marker.BASE);
        assertEquals(p1StartingCell.getPlayer(), 1);

        Position p2Position = arena.getStartingPositions().get((char)2);
        ArenaCell p2StartingCell = arena.getBattleGround()[p2Position.getRow()][p2Position.getColumn()];
        assertNotNull(p2StartingCell);
        assertEquals(p2StartingCell.getMarker(), Marker.BASE);
        assertEquals(p2StartingCell.getPlayer(), 2);

        System.out.println(BattlegroundUtils.battelgroundToString(arena));
    }

    @Test
    void testGenerateStartingPositionsEven() {

        Map<Character, Position> startingPositions = test.generateStartingPositions(TEST_SIZE_R, TEST_SIZE_C);

        assertStartingPositions(startingPositions, P1_STARTING_POSITION, P2_STARTING_POSITION);

    }

    @Test
    void testGenerateStartingPositionsOdd() {

        Map<Character, Position> startingPositions = test.generateStartingPositions(TEST_SIZE_R + 1,
                TEST_SIZE_C + 1);

        assertStartingPositions(startingPositions,
                new Position(P1_STARTING_POSITION.getRow(), P1_STARTING_POSITION.getColumn()),
                new Position (P2_STARTING_POSITION.getRow()+1, P2_STARTING_POSITION.getColumn()+1));

    }

    private void assertStartingPositions(Map<Character, Position> startingPositions,
                                         Position p1StartingPosition,
                                         Position p2StartingPosition) {

        assertNotNull(startingPositions);

        assertTrue(startingPositions.containsKey((char)1));
        assertTrue(startingPositions.containsKey((char)2));

        assertTrue(new ReflectionEquals(startingPositions.get((char)1)).matches(p1StartingPosition));
        assertTrue(new ReflectionEquals(startingPositions.get((char)2)).matches(p2StartingPosition));

        System.out.println(startingPositions);

    }


}
