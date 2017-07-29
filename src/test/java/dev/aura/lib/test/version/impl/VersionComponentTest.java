package dev.aura.lib.test.version.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import java.util.Arrays;

import org.junit.Test;

import dev.aura.lib.version.impl.VersionComponent;

public class VersionComponentTest {
    @Test
    public void integrityTest() {
        assertEquals("Enum does not contain the expected values", "[LIST, NUMBER, STRING]",
                Arrays.toString(VersionComponent.Type.values()));

        for (VersionComponent.Type type : VersionComponent.Type.values()) {
            assertSame("Turning the type into a string and back doesn't work!", type,
                    VersionComponent.Type.valueOf(type.toString()));
        }
    }
}
