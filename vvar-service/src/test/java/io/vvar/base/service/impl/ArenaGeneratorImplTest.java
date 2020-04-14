/*
 * Copyright (c) 2020. vvar.io
 */

package io.vvar.base.service.impl;

import io.vvar.base.model.Arena;
import static org.junit.jupiter.api.Assertions.*;

import io.vvar.base.model.ArenaCell;
import io.vvar.base.util.BattlegroundUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class ArenaGeneratorImplTest {

    private ArenaGeneratorImpl test;

    private static final int TEST_SIZE_R = 88;

    private static final int TEST_SIZE_C = 88;

    private static final int P1_STARTING_POSITION_R = 43;

    private static final int P1_STARTING_POSITION_C = 0;

    private static final int P2_STARTING_POSITION_R = 44;

    private static final int P2_STARTING_POSITION_C = 87;


    @BeforeEach
    void init() {
        test = new ArenaGeneratorImpl();
    }

    @Test
    void testGenerate() {

        Arena arena = test.generate();

        assertNotNull(arena);
        assertEquals(ArenaGeneratorImpl.defaultArenaSizeColumns, arena.getSizeC());
        assertEquals(ArenaGeneratorImpl.defaultArenaSizeRows, arena.getSizeR());

        assertStartingPositions(arena.getStartingPositions(),
                31, 0,
                32, 63);

        ArenaCell p1StartingCell = arena.getBattleGround()[arena.getStartingPositions().get("1r")][arena.getStartingPositions().get("1c")];

        assertNotNull(p1StartingCell);

        System.out.println(BattlegroundUtils.battelgroundToString(arena));
    }

    @Test
    void testGenerateStartingPositionsEven() {

        Map<String, Integer> startingPositions = test.generateStartingPositions(TEST_SIZE_R, TEST_SIZE_C);

        assertStartingPositions(startingPositions,
                P1_STARTING_POSITION_R, P1_STARTING_POSITION_C,
                P2_STARTING_POSITION_R, P2_STARTING_POSITION_C);

    }

    @Test
    void testGenerateStartingPositionsOdd() {

        Map<String, Integer> startingPositions = test.generateStartingPositions(TEST_SIZE_R+1,
                TEST_SIZE_C+1);

        assertStartingPositions(startingPositions,
                P1_STARTING_POSITION_R, P1_STARTING_POSITION_C,
                P2_STARTING_POSITION_R+1, P2_STARTING_POSITION_C+1);

    }

    private void assertStartingPositions(Map<String, Integer> startingPositions,
                                        int p1StartingPositionR, int p1StartingPositionC,
                                        int p2StartingPositionR, int p2StartingPositionC) {

        assertNotNull(startingPositions);

        assertTrue(startingPositions.containsKey("1c"));
        assertTrue(startingPositions.containsKey("2c"));
        assertTrue(startingPositions.containsKey("1r"));
        assertTrue(startingPositions.containsKey("2r"));

        assertEquals(startingPositions.get("1r"),p1StartingPositionR);
        assertEquals(startingPositions.get("1c"),p1StartingPositionC);
        assertEquals(startingPositions.get("2r"),p2StartingPositionR);
        assertEquals(startingPositions.get("2c"),p2StartingPositionC);

        System.out.println(startingPositions);

    }




}
