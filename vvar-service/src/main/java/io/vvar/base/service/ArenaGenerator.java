package io.vvar.base.service;

import io.vvar.base.model.Arena;

import java.util.Map;

public interface ArenaGenerator {

    Arena generate();

    Arena generate(int rows, int columns);

    Map<String, Integer> generateStartingPositions(Arena arena);

    Map<String, Integer> generateStartingPositions(int sizeR, int sizeC);

}
