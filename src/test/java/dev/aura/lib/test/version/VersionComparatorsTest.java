package dev.aura.lib.test.version;

import java.util.Arrays;
import java.util.Collections;

import org.junit.Test;

import dev.aura.lib.version.Version;
import dev.aura.lib.version.VersionComparators;

public class VersionComparatorsTest {
    @Test
    public void stringComparatorTest() {
        final String[] expectedOrder = new String[] { "1.2.3", "1.2.4", "1.3.3", "2.2.3" };

        TestUtils.testArray(expectedOrder, VersionComparators.VERSION_STRING);

        // Reverses array
        Collections.reverse(Arrays.asList(expectedOrder));

        TestUtils.testArray(expectedOrder, VersionComparators.VERSION_STRING_REVERSE);
    }

    @Test
    public void versionComparatorTest() {
        final Version[] expectedOrder = Arrays.asList("1.2.3", "1.2.4", "1.3.3", "2.2.3").stream().map(Version::new)
                .toArray(Version[]::new);

        TestUtils.testArray(expectedOrder, VersionComparators.VERSION);

        // Reverses array
        Collections.reverse(Arrays.asList(expectedOrder));

        TestUtils.testArray(expectedOrder, VersionComparators.VERSION_REVERSE);
    }
}