package dev.aura.lib.version;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import lombok.Cleanup;
import org.junit.Test;

public class VersionTest {
  @Test
  public void basicTest() {
    final Version[] expectedOrder =
        Arrays.asList("0.0.0", "0.0.1", "0.1.0", "0.1.1", "1.0.0", "1.0.1", "1.1.0", "1.1.1")
            .stream()
            .map(Version::new)
            .toArray(Version[]::new);

    TestUtils.assertSortsCorrectly(expectedOrder);
  }

  @Test
  public void bigIntTest() {
    final Version[] expectedOrder =
        Arrays.asList(
                "1234567890123456789012345678901234567890123456789012345678901234567890",
                "12345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890",
                "123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890")
            .stream()
            .map(Version::new)
            .toArray(Version[]::new);

    TestUtils.assertSortsCorrectly(expectedOrder);
  }

  @Test
  public void duplicateTest() {
    final Version[] expectedOrder =
        Arrays.asList("1.0.0", "1.0.0", "2.0.0", "2.0.0", "3.0.0", "3.0.0")
            .stream()
            .map(Version::new)
            .toArray(Version[]::new);

    TestUtils.assertSortsCorrectly(expectedOrder);
  }

  @Test
  public void equalsTest() {
    final Version versionA1 = new Version("1.2.3.A");
    final Version versionA2 = new Version("1.2.3.A");
    final Version versionB = new Version("1.2.3.B");
    final Version versionNull = null;
    final Object versionObj = "";

    TestUtils.checkIfVersionsEqual(versionA1, versionA1);
    TestUtils.checkIfVersionsEqual(versionA1, versionA2);
    TestUtils.checkIfVersionsNotEqual(versionA1, versionB);
    TestUtils.checkIfVersionsNotEqual(versionA1, versionNull);
    TestUtils.checkIfVersionsNotEqual(versionA1, versionObj);

    TestUtils.checkIfVersionsEqual(versionA2, versionA1);
    TestUtils.checkIfVersionsEqual(versionA2, versionA2);
    TestUtils.checkIfVersionsNotEqual(versionA2, versionB);
    TestUtils.checkIfVersionsNotEqual(versionA2, versionNull);
    TestUtils.checkIfVersionsNotEqual(versionA2, versionObj);

    TestUtils.checkIfVersionsNotEqual(versionB, versionA1);
    TestUtils.checkIfVersionsNotEqual(versionB, versionA2);
    TestUtils.checkIfVersionsEqual(versionB, versionB);
    TestUtils.checkIfVersionsNotEqual(versionB, versionNull);
    TestUtils.checkIfVersionsNotEqual(versionB, versionObj);
  }

  @Test
  public void lengthTest() {
    final Version[] expectedOrder =
        Arrays.asList("0.0.0.0.0.1", "0.0.0.0.1", "0.0.0.1", "0.0.1", "0.1", "1")
            .stream()
            .map(Version::new)
            .toArray(Version[]::new);

    TestUtils.assertSortsCorrectly(expectedOrder);
  }

  @Test
  public void lengthTest2() {
    final Version[] expectedOrder =
        Arrays.asList("1", "1.1", "1.1.1", "1.1.1.1", "1.1.1.1.1", "1.1.1.1.1.1")
            .stream()
            .map(Version::new)
            .toArray(Version[]::new);

    TestUtils.assertSortsCorrectly(expectedOrder);
  }

  @Test
  public void listPriorityTest() {
    final Version[] expectedOrder =
        Arrays.asList(
                "1-2",
                "1.1-2",
                "1.1.1-2",
                "1.1.1.1-2",
                "1.1.1.1.1-2",
                "1.1.1.1.1.1-2",
                "1.1.1.1.1.1.1-2",
                "1.1.1.1.1.1.1.1-2",
                "1.1.1.1.1.1.1.1.1-2")
            .stream()
            .map(Version::new)
            .toArray(Version[]::new);

    TestUtils.assertSortsCorrectly(expectedOrder);
  }

  @Test
  public void mixedTypesTest() {
    final Version[] expectedOrder =
        Arrays.asList(".", ".", "A.A", "A", "1", "1.1")
            .stream()
            .map(Version::new)
            .toArray(Version[]::new);

    TestUtils.assertSortsCorrectly(expectedOrder);
  }

  @Test
  public void serializationTest() throws IOException, ClassNotFoundException {
    final Version versionIn = new Version("1.12-5.4.9_1.10.2-0.4.1.66-beta_1.12-1.3.0.15");

    @Cleanup ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();
    @Cleanup ObjectOutputStream outStream = new ObjectOutputStream(outByteStream);

    outStream.writeObject(versionIn);

    outStream.close();

    @Cleanup
    ByteArrayInputStream inByteStream = new ByteArrayInputStream(outByteStream.toByteArray());
    @Cleanup ObjectInputStream inStream = new ObjectInputStream(inByteStream);

    Version versionOut = (Version) inStream.readObject();

    assertEquals("Serialization and Deserialization did not work", versionIn, versionOut);
  }

  @Test
  public void sublistTest() {
    final Version[] expectedOrder =
        Arrays.asList(
                "0.0-0.0", "0.0-0.1", "0.0-1.0", "0.0-1.1", "0.1-0.0", "0.1-0.1", "0.1-1.0",
                "0.1-1.1", "1.0-0.0", "1.0-0.1", "1.0-1.0", "1.0-1.1", "1.1-0.0", "1.1-0.1",
                "1.1-1.0", "1.1-1.1")
            .stream()
            .map(Version::new)
            .toArray(Version[]::new);

    TestUtils.assertSortsCorrectly(expectedOrder);
  }

  @Test
  public void sublistMissingTest() {
    final Version[] expectedOrder =
        Arrays.asList(
                "0.0", "0.0-0.1", "0.0-1.0", "0.0-1.1", "0.1", "0.1-0.1", "0.1-1.0", "0.1-1.1",
                "1.0", "1.0-0.1", "1.0-1.0", "1.0-1.1", "1.1", "1.1-0.1", "1.1-1.0", "1.1-1.1")
            .stream()
            .map(Version::new)
            .toArray(Version[]::new);

    TestUtils.assertSortsCorrectly(expectedOrder);
  }

  @Test
  public void toStringTest() {
    final Version version = new Version("1.2.3_DEV");

    assertEquals(
        "Version(input=1.2.3_DEV, component=ListComponent([ListComponent([ListComponent([ListComponent([NumberComponent(1)]), ListComponent([NumberComponent(2)]), ListComponent([NumberComponent(3)])])]), ListComponent([ListComponent([ListComponent([StringComponent(dev)])])])]))",
        version.toString());
  }

  // TODO: More tests for more cases!
}
