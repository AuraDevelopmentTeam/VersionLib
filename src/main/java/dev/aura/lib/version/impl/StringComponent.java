package dev.aura.lib.version.impl;

import lombok.ToString;

@ToString(includeFieldNames = false)
public class StringComponent extends VersionComponent {
    protected final String string;

    protected StringComponent(String string) {
        this.string = string.toLowerCase();
    }

    @Override
    public final VersionComponentType getVersionComponentType() {
        return VersionComponentType.STRING;
    }

    @Override
    public int compareTo(VersionComponent that) {
        // TODO: Implement comparison logic! With special cases etc!

        VersionComponentType thatType = that.getVersionComponentType();

        if (thatType != VersionComponentType.STRING)
            return -that.compareTo(this);

        StringComponent thatString = (StringComponent) that;

        return string.compareTo(thatString.string);
    }
}
