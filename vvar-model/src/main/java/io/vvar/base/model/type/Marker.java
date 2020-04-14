package io.vvar.base.model.type;

/**
 *
 * 0 - empty
 * 1 - base
 * 2 - head
 *
 * 3 - body, was moving up
 * 4 - body, was moving down
 * 5 - body, was moving left
 * 6 - body, was moving right
 *
 */


public enum Marker {

    EMPTY((byte)0),
    BASE((byte)1),
    HEAD((byte)2),

    BODY_MOVE_UP((byte)3),
    BODY_MOVE_DOWN((byte)4),
    BODY_MOVE_LEFT((byte)5),
    BODY_MOVE_RIGHT((byte)6);

    public final byte byteValue;

    private Marker(byte byteValue) {
        this.byteValue = byteValue;
    }

}
