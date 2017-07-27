package dev.aura.lib.version.impl;

public interface VersionComponent extends Comparable<VersionComponent> {
    public VersionComponentType getVersionComponentType();
}
