/*
 * Copyright (c) 2020. vvar.io
 */

package io.vvar.base.service.impl;

import io.vvar.base.model.Arena;
import io.vvar.base.model.ArenaCell;
import io.vvar.base.service.ArenaGenerator;

public class ArenaGeneratorImpl implements ArenaGenerator {

    private static final int defaultArenaSizeRows = 64;

    private static final int defaultArenaSizeColumns = 64;

    private static final char defaultPlayersNumber = 2;

    @Override
    public Arena generate() {
        return generate(defaultArenaSizeRows, defaultArenaSizeColumns, defaultPlayersNumber);
    }

    @Override
    public Arena generate(int rows, int columns, char players) {

        ArenaCell[][] battleGround = new ArenaCell[rows][columns];

        Arena arena = new Arena(new ArenaCell[rows][columns]);
        return null;
    }
}
