package dev.aura.lib.version;

interface VersionComponent extends Comparable<VersionComponent> {
    public VersionComponentType getVersionComponentType();
}
