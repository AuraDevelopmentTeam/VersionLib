package dev.aura.lib.version.impl;

import java.math.BigInteger;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(includeFieldNames = false)
public class NumberComponent extends VersionComponent {
    private static final long serialVersionUID = -9162941048683749831L;

    protected final BigInteger number;

    @Override
    public final VersionComponent.Type getVersionComponentType() {
        return VersionComponent.Type.NUMBER;
    }

    @Override
    public int compareTo(VersionComponent that) {
        VersionComponent.Type thatType = that.getVersionComponentType();

        if (thatType == VersionComponent.Type.LIST)
            return -that.compareTo(this);
        else if (thatType == VersionComponent.Type.STRING)
            return 1;

        NumberComponent thatNumber = (NumberComponent) that;

        return number.compareTo(thatNumber.number);
    }
}
