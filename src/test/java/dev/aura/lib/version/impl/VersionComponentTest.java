package dev.aura.lib.version.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;

import java.util.Arrays;
import org.junit.Test;

public class VersionComponentTest {
  @Test
  public void enumIntegrityTest() {
    assertEquals(
        "Enum does not contain the expected values",
        "[LIST, NUMBER, STRING]",
        Arrays.toString(VersionComponent.Type.values()));

    for (VersionComponent.Type type : VersionComponent.Type.values()) {
      assertSame(
          "Turning the type into a string and back doesn't work!",
          type,
          VersionComponent.Type.valueOf(type.toString()));
    }
  }

  @Test
  public void equalsTest() {
    assertEquals("equals returns false for same object", VersionParser.ZERO, VersionParser.ZERO);

    assertNotEquals("equals returns true for null", null, VersionParser.ZERO);
    assertNotEquals("equals returns true for null", VersionParser.ZERO, null);

    assertNotEquals("equals returns true for other Object", new Object(), VersionParser.ZERO);
    assertNotEquals("equals returns true for other Object", VersionParser.ZERO, new Object());
  }
}
