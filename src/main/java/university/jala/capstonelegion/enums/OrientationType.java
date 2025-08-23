package university.jala.capstonelegion.enums;

public enum OrientationType {
    SOUTH_TO_NORTH ("n"),
    NORTH_TO_SOUTH("s"),
    EAST_TO_WEST("w"),
    WEST_TO_EAST("e");

    private final String orientation;

    OrientationType(String orientation) {
        this.orientation = orientation;
    }

    public String getOrientation() {
        return orientation;
    }

}
