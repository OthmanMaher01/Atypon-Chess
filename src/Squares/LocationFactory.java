package Squares;

import enums.File;

public class LocationFactory {
    private static final File[] files = File.values();

    public static Location build(Location currentLocation, Integer fileOffset, Integer rankOffset) {
        Integer currentFile = currentLocation.getFile().ordinal();
        if (currentFile + fileOffset >= files.length || currentFile + fileOffset < 0) {
            return new Location(files[currentFile], currentLocation.getRank() + rankOffset);
        }
        return new Location(files[currentFile + fileOffset], currentLocation.getRank() + rankOffset);

    }
}
