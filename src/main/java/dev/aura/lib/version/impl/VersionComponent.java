package dev.aura.lib.version.impl;

public abstract class VersionComponent implements Comparable<VersionComponent> {
    public abstract VersionComponentType getVersionComponentType();

    @Override
    public final boolean equals(Object other) {
        if ((other == null) || !(other instanceof VersionComponent))
            return false;

        return compareTo((VersionComponent) other) == 0;
    }
}
