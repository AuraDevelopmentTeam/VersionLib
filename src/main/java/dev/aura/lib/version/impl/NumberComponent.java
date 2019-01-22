package dev.aura.lib.version.impl;

import java.math.BigInteger;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
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

    @SuppressFBWarnings(value = "RV_NEGATING_RESULT_OF_COMPARETO", justification = "Implementation requires the inversion of the value. The deeper implementations will never return Integer.MIN_VALUE in any realistic case")
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
    
    @Override
    public int hashCode() {
        return number.hashCode();
    }
}
