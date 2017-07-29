package dev.aura.lib.version;

import java.io.Serializable;

import dev.aura.lib.version.impl.VersionComponent;
import dev.aura.lib.version.impl.VersionParser;
import lombok.Getter;
import lombok.ToString;

@ToString
public class Version implements Comparable<Version>, Serializable {
    private static final long serialVersionUID = -984773425303989357L;

    @Getter
    private final String input;
    private final VersionComponent component;

    public Version(String version) {
        input = version;
        component = VersionParser.parse(version);
    }

    @Override
    public int compareTo(Version other) {
        return component.compareTo(other.component);
    }

    @Override
    public boolean equals(Object other) {
        if ((other == null) || !(other instanceof Version))
            return false;

        return compareTo((Version) other) == 0;
    }
}
