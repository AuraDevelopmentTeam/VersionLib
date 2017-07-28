package dev.aura.lib.test.version;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.Arrays;

import org.junit.Test;

import dev.aura.lib.version.Version;

public class VersionTest {
    @Test
    public void basicTest() {
        final Version[] expectedOrder = Arrays
                .asList("0.0.0", "0.0.1", "0.1.0", "0.1.1", "1.0.0", "1.0.1", "1.1.0", "1.1.1").stream()
                .map(Version::new).toArray(Version[]::new);

        TestUtils.testArray(expectedOrder);
    }

    @Test
    public void bigIntTest() {
        final Version[] expectedOrder = Arrays.asList(
                "1234567890123456789012345678901234567890123456789012345678901234567890",
                "12345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890",
                "123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890")
                .stream().map(Version::new).toArray(Version[]::new);

        TestUtils.testArray(expectedOrder);
    }

    @Test
    public void duplicateTest() {
        final Version[] expectedOrder = Arrays.asList("1.0.0", "1.0.0", "2.0.0", "2.0.0", "3.0.0", "3.0.0").stream()
                .map(Version::new).toArray(Version[]::new);

        TestUtils.testArray(expectedOrder);
    }

    @Test
    public void equalsTest() {
        final Version versionA1 = new Version("1.2.3.A");
        final Version versionA2 = new Version("1.2.3.A");
        final Version versionB = new Version("1.2.3.B");
        final Version versionNull = null;
        final Object versionObj = "";

        assertEquals("versionA1 should be equal to versionA1", versionA1, versionA1);
        assertEquals("versionA1 should be equal to versionA2", versionA1, versionA2);
        assertNotEquals("versionA1 should not be equal to versionB", versionA1, versionB);
        assertNotEquals("versionA1 should not be equal to versionNull", versionA1, versionNull);
        assertNotEquals("versionA1 should not be equal to versionObj", versionA1, versionObj);

        assertEquals("versionA2 should be equal to versionA1", versionA2, versionA1);
        assertEquals("versionA2 should be equal to versionA2", versionA2, versionA2);
        assertNotEquals("versionA2 should not be equal to versionB", versionA2, versionB);
        assertNotEquals("versionA2 should not be equal to versionNull", versionA2, versionNull);
        assertNotEquals("versionA1 should not be equal to versionObj", versionA2, versionObj);

        assertNotEquals("versionB should not be equal to versionA1", versionB, versionA1);
        assertNotEquals("versionB should not be equal to versionA2", versionB, versionA2);
        assertEquals("versionB should be equal to versionB", versionB, versionB);
        assertNotEquals("versionB should not be equal to versionNull", versionB, versionNull);
        assertNotEquals("versionA1 should not be equal to versionObj", versionB, versionObj);
    }

    @Test
    public void lengthTest() {
        final Version[] expectedOrder = Arrays.asList("0.0.0.0.0.1", "0.0.0.0.1", "0.0.0.1", "0.0.1", "0.1", "1")
                .stream().map(Version::new).toArray(Version[]::new);

        TestUtils.testArray(expectedOrder);
    }

    @Test
    public void lengthTest2() {
        final Version[] expectedOrder = Arrays.asList("1", "1.1", "1.1.1", "1.1.1.1", "1.1.1.1.1", "1.1.1.1.1.1")
                .stream().map(Version::new).toArray(Version[]::new);

        TestUtils.testArray(expectedOrder);
    }

    @Test
    public void mixedTypesTest() {
        final Version[] expectedOrder = Arrays.asList(".", ".", "A.A", "A", "1", "1.1").stream().map(Version::new)
                .toArray(Version[]::new);

        TestUtils.testArray(expectedOrder);
    }

    @Test
    public void sublistTest() {
        final Version[] expectedOrder = Arrays
                .asList("0.0-0.0", "0.0-0.1", "0.0-1.0", "0.0-1.1", "0.1-0.0", "0.1-0.1", "0.1-1.0", "0.1-1.1",
                        "1.0-0.0", "1.0-0.1", "1.0-1.0", "1.0-1.1", "1.1-0.0", "1.1-0.1", "1.1-1.0", "1.1-1.1")
                .stream().map(Version::new).toArray(Version[]::new);

        TestUtils.testArray(expectedOrder);
    }

    @Test
    public void toStringTest() {
        final Version version = new Version("1.2.3_DEV");

        assertEquals(
                "Version(input=1.2.3_DEV, component=ListComponent([ListComponent([NumberComponent(1), NumberComponent(2), NumberComponent(3)]), StringComponent(DEV)]))",
                version.toString());
    }

    // TODO: More tests for more cases!
}
