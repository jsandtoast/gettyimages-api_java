package com.gettyimages.search;

public enum Orientation
{
    NONE("none"),
    HORIZONTAL("horizontal"),
    PANORAMIC_HORIZONTAL("panoramic_horizontal"),
    PANORAMIC_VERTICAL("panoramic_vertical"),
    SQUARE("square"),
    VERTICAL("vertical");

    /**
     * Used for query parameter naming during the REST call.
     */
    private String val;

    Orientation(String val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return val;
    }
}
