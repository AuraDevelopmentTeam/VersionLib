package dev.aura.lib.version;

import java.util.Comparator;
import java.util.function.Function;

import lombok.experimental.UtilityClass;

/**
 * This class defines a bunch of default comparators for simplicity.
 */
@UtilityClass
public class VersionComparators {
    /**
     * Compares two {@link Version} objects.<br>
     * <br>
     * Equivalent to {@link Comparator#naturalOrder() Comparator.naturalOrder()}
     *
     * @see Comparator#naturalOrder()
     */
    public static final Comparator<Version> VERSION = Comparator.naturalOrder();
    /**
     * Converts two strings to {@link Version} objects and compares these.<br>
     * <br>
     * Equivalent to {@link Comparator#comparing(Function)
     * Comparator.comparing(Version::new, VersionComparators.VERSION)}
     *
     * @see Comparator#comparing(Function)
     * @see Comparator#naturalOrder()
     */
    public static final Comparator<String> VERSION_STRING = Comparator.comparing(Version::new, VERSION);

    /**
     * Compares two {@link Version} objects in reversed order.<br>
     * <br>
     * Equivalent to {@link Comparator#reversed()
     * VersionComparators.VERSION.reversed()}
     *
     * @see Comparator#reversed()
     * @see Comparator#naturalOrder()
     */
    public static final Comparator<Version> VERSION_REVERSE = VERSION.reversed();
    /**
     * Converts two strings to {@link Version} objects and compares these in
     * reversed order.<br>
     * <br>
     * Equivalent to {@link Comparator#reversed()
     * VersionComparators.VERSION_STRING.reversed()}
     *
     * @see Comparator#reversed()
     * @see Comparator#comparing(Function)
     * @see Comparator#naturalOrder()
     */
    public static final Comparator<String> VERSION_STRING_REVERSE = VERSION_STRING.reversed();
}
