package dev.aura.updatechecker.version;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Version implements Comparable<Version> {
    private static final Pattern[] listSeparators = new Pattern[] { Pattern.compile("_"), Pattern.compile("-"),
            Pattern.compile("\\."), Pattern.compile("(?=\\d)(?<=[a-z])|(?=[a-z])(?<=\\d)", Pattern.CASE_INSENSITIVE) };
    private static final Pattern number = Pattern.compile("^\\d+$");

    private final VersionComponent component;

    public Version(String version) {
        component = parse(version);
    }

    @Override
    public int compareTo(Version other) {
        return component.compareTo(other.component);
    }

    private static VersionComponent parse(String version) {
        Matcher matcher;
        
        for (Pattern separator : listSeparators) {
            matcher = separator.matcher(version);
            
            if (matcher.find()) {
                return new ListComponent(Arrays.stream(separator.split(version)).map(Version::parse)
                        .collect(Collectors.toList()));
            }
        }
        
        if(number.matcher(version).find()) {
            return new NumberComponent(version);
        } else {
            return new StringComponent(version);
        }
    }
}
