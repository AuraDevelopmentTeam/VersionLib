package dev.aura.lib.version;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import dev.aura.lib.version.impl.VersionComponent;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import lombok.experimental.UtilityClass;
import org.junit.internal.ArrayComparisonFailure;

@UtilityClass
public class TestUtils {
  private static final int SHUFFLES = 10000;

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
        assertArrayEquals(
            "Sorting failed for shuffle:\n"
                + versions
                + "\nSorted result:\n"
                + Arrays.toString(sortedVersions)
                + '\n',
            expectedOrder,
            sortedVersions);
      }
    }
  }

  public static void compareVersionComponents(
      final VersionComponent expected,
      final VersionComponent unexpected,
      final VersionComponent actual) {
    assertEquals("Parser produced wrong result", 0, expected.compareTo(actual));
    assertEquals("Parser produced wrong result", 0, actual.compareTo(expected));
    assertEquals("equals did not return the same as compareTo", expected, actual);
    assertEquals("equals did not return the same as compareTo", actual, expected);
    assertEquals("hashCode returned a wrong value", expected.hashCode(), actual.hashCode());

    assertNotEquals("Parser produced wrong result", 0, unexpected.compareTo(actual));
    assertNotEquals("Parser produced wrong result", 0, actual.compareTo(unexpected));
    assertNotEquals("equals did not return the same as compareTo", unexpected, actual);
    assertNotEquals("equals did not return the same as compareTo", actual, unexpected);
  }

  public static void checkIfVersionsEqual(final Version expected, final Object actual) {
    assertEquals("expected should be equal to actual", expected, actual);
    assertEquals("actual should be equal to expected", actual, expected);

    assertEquals(
        "expected.hashCode() should be equal to actual.hashCode()",
        expected.hashCode(),
        actual.hashCode());
  }

  public static void checkIfVersionsEqual(final Version expected, final Version actual) {
    checkIfVersionsEqual(expected, (Object) actual);

    assertEquals("expected.compareTo(actual) should be equal to 0", 0, expected.compareTo(actual));
    assertEquals("actual.compareTo(expected) should be equal to 0", 0, actual.compareTo(expected));
  }

  public static void checkIfVersionsNotEqual(final Version expected, final Object actual) {
    assertNotEquals("expected should not be equal to actual", expected, actual);
    assertNotEquals("actual should not be equal to expected", actual, expected);

    assertNotEquals(
        "expected.hashCode() should not be equal to actual.hashCode()",
        expected.hashCode(),
        (actual == null) ? 0 : actual.hashCode());
  }

  public static void checkIfVersionsNotEqual(final Version expected, final Version actual) {
    checkIfVersionsNotEqual(expected, (Object) actual);

    if (actual != null) {
      assertNotEquals(
          "expected.compareTo(actual) should not be equal to 0", 0, expected.compareTo(actual));
      assertNotEquals(
          "actual.compareTo(expected) should not be equal to 0", 0, actual.compareTo(expected));
    }
  }

  public static void checkHiddenConstructor(Class<?> utilityClass) throws Throwable {
    try {
      final Constructor<?> constructor = utilityClass.getDeclaredConstructor();
      constructor.setAccessible(true);

      constructor.newInstance();
    } catch (InvocationTargetException e) {
      throw e.getTargetException();
    }
  }
}
