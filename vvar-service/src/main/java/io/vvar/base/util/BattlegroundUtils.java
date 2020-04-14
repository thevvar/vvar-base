package io.vvar.base.util;

import io.vvar.base.model.Arena;
import io.vvar.base.model.ArenaCell;

public class BattlegroundUtils {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static String battelgroundToString(Arena arena) {
        
        StringBuilder stringBuilder = new StringBuilder();

        for (ArenaCell[] battleground:arena.getBattleGround()) {
            for (ArenaCell arenaCell:battleground) {
                stringBuilder.append(arenaCell != null ? arenaCell.getMarker(): ANSI_WHITE+"."+ANSI_RESET);
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

}
