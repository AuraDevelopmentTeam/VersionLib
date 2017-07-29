package dev.aura.lib.version;

import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.internal.ArrayComparisonFailure;

import lombok.experimental.UtilityClass;

@UtilityClass
public class TestUtils {
    private final static int SHUFFLES = 10000;

    public static void assertSortsCorrectly(Version[] expectedOrder) throws ArrayComparisonFailure {
        assertSortsCorrectly(expectedOrder, VersionComparators.VERSION);
    }

    @SuppressWarnings("unchecked")
    public static <T> void assertSortsCorrectly(T[] expectedOrder, Comparator<T> comparator)
            throws ArrayComparisonFailure {
        List<T> versions = new ArrayList<>(Arrays.asList(expectedOrder));
        T[] sortedVersions;

        for (int i = 0; i < SHUFFLES; ++i) {
            Collections.shuffle(versions);
            sortedVersions = (T[]) versions.stream().sorted(comparator).toArray(Object[]::new);

            try {
                assertArrayEquals(expectedOrder, sortedVersions);
            } catch (ArrayComparisonFailure e) {
                assertArrayEquals("Sorting failed for shuffle:\n" + versions + "\nSorted result:\n"
                        + Arrays.toString(sortedVersions) + '\n', expectedOrder, sortedVersions);
            }
        }
    }
}
