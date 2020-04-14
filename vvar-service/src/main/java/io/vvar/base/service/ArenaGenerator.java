package io.vvar.base.service;

import io.vvar.base.model.Arena;
import io.vvar.base.model.Position;

import java.util.Map;

public interface ArenaGenerator {

    public static final String PLAYER_PREFIX = "player";

    Arena generate();

    Arena generate(int rows, int columns);

    Map<Character, Position> generateStartingPositions(Arena arena);

    Map<Character, Position> generateStartingPositions(int sizeR, int sizeC);

}
