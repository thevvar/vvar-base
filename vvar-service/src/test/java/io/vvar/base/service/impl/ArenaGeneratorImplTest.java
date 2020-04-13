/*
 * Copyright (c) 2020. vvar.io
 */

package io.vvar.base.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ArenaGeneratorImplTest {

    private final ArenaGeneratorImpl arenaGenerator = new ArenaGeneratorImpl();

    @Test
    void addition() {
        assertEquals(arenaGenerator.generate(), arenaGenerator.generate());
    }


}
