package dev.aura.lib.version.impl;

import java.io.Serializable;

public abstract class VersionComponent implements Comparable<VersionComponent>, Serializable {
    private static final long serialVersionUID = -2749335799078827962L;

    public abstract VersionComponentType getVersionComponentType();

    @Override
    public final boolean equals(Object other) {
        if ((other == null) || !(other instanceof VersionComponent))
            return false;

        return compareTo((VersionComponent) other) == 0;
    }
}
