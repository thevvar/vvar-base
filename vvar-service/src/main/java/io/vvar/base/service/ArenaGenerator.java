package io.vvar.base.service;

import io.vvar.base.model.Arena;

public interface ArenaGenerator {

    Arena generate();

    Arena generate(int rows, int columns, char players);


}
