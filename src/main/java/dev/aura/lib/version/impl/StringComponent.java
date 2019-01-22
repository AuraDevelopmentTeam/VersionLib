package dev.aura.lib.version.impl;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
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

    @SuppressFBWarnings(value = "RV_NEGATING_RESULT_OF_COMPARETO", justification = "Implementation requires the inversion of the value. The deeper implementations will never return Integer.MIN_VALUE in any realistic case")
    @Override
    public int compareTo(VersionComponent that) {
        // TODO: Implement comparison logic! With special cases etc!

        VersionComponent.Type thatType = that.getVersionComponentType();

        if (thatType != VersionComponent.Type.STRING)
            return -that.compareTo(this);

        StringComponent thatString = (StringComponent) that;

        return string.compareTo(thatString.string);
    }
    
    @Override
    public int hashCode() {
        return string.hashCode();
    }
}
