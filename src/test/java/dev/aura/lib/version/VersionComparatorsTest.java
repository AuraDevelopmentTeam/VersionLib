package dev.aura.lib.version;

import java.util.Arrays;
import java.util.Collections;
import org.junit.Test;

public class VersionComparatorsTest {
  @Test
  public void stringComparatorTest() {
    final String[] expectedOrder = new String[] {"1.2.3", "1.2.4", "1.3.3", "2.2.3"};

    TestUtils.assertSortsCorrectly(expectedOrder, VersionComparators.VERSION_STRING);

    // Reverses array
    Collections.reverse(Arrays.asList(expectedOrder));

    TestUtils.assertSortsCorrectly(expectedOrder, VersionComparators.VERSION_STRING_REVERSE);
  }

  @Test
  public void versionComparatorTest() {
    final Version[] expectedOrder =
        Arrays.asList("1.2.3", "1.2.4", "1.3.3", "2.2.3")
            .stream()
            .map(Version::new)
            .toArray(Version[]::new);

    TestUtils.assertSortsCorrectly(expectedOrder, VersionComparators.VERSION);

    // Reverses array
    Collections.reverse(Arrays.asList(expectedOrder));

    TestUtils.assertSortsCorrectly(expectedOrder, VersionComparators.VERSION_REVERSE);
  }
}
