package io.vvar.base.util;

import io.vvar.base.model.Arena;
import io.vvar.base.model.ArenaCell;
import io.vvar.base.model.type.Marker;

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
                stringBuilder.append(arenaCell != null ? colorCell(arenaCell): ".");
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public static String colorCell(ArenaCell arenaCell) {

        String colorCell;

        switch (arenaCell.getPlayer()) {
            case 1: {
                colorCell = ANSI_GREEN+arenaCell.getMarker().byteValue+ANSI_RESET;
                break;
            }
            case 2: {
                colorCell = ANSI_RED+arenaCell.getMarker().byteValue+ANSI_RESET;
                break;
            }
            default: {
                colorCell = ""+arenaCell.getMarker().byteValue;
            }
        }

        return colorCell;
    }


}
