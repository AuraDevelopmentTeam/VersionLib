package dev.aura.lib.version.impl;

import lombok.ToString;

@ToString(includeFieldNames = false)
public class StringComponent extends VersionComponent {
    private static final long serialVersionUID = -2611240828179218042L;

    protected final String string;

    protected StringComponent(String string) {
        this.string = string.toLowerCase();
    }

    @Override
    public final VersionComponent.Type getVersionComponentType() {
        return VersionComponent.Type.STRING;
    }

    @Override
    public int compareTo(VersionComponent that) {
        // TODO: Implement comparison logic! With special cases etc!

        VersionComponent.Type thatType = that.getVersionComponentType();

        if (thatType != VersionComponent.Type.STRING)
            return -that.compareTo(this);

        StringComponent thatString = (StringComponent) that;

        return string.compareTo(thatString.string);
    }
}
