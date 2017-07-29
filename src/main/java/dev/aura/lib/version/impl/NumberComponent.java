package dev.aura.lib.version.impl;

import java.math.BigInteger;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(includeFieldNames = false)
public class NumberComponent extends VersionComponent {
    /**
     *
     */
    private static final long serialVersionUID = -9162941048683749831L;
    protected final BigInteger number;

    @Override
    public final VersionComponentType getVersionComponentType() {
        return VersionComponentType.NUMBER;
    }

    @Override
    public int compareTo(VersionComponent that) {
        VersionComponentType thatType = that.getVersionComponentType();

        if (thatType == VersionComponentType.LIST)
            return -that.compareTo(this);
        else if (thatType == VersionComponentType.STRING)
            return 1;

        NumberComponent thatNumber = (NumberComponent) that;

        return number.compareTo(thatNumber.number);
    }
}
