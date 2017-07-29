package dev.aura.lib.version.impl;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import lombok.experimental.UtilityClass;

@UtilityClass
public class VersionParser {
    protected static final NumberComponent ZERO = new NumberComponent(BigInteger.ZERO);

    private static final Pattern[] listSeparators = new Pattern[] { Pattern.compile("_"), Pattern.compile("-"),
            Pattern.compile("\\."), Pattern.compile("(?=\\d)(?<=[a-z])|(?=[a-z])(?<=\\d)", Pattern.CASE_INSENSITIVE) };
    private static final Pattern number = Pattern.compile("^\\d+$");

    public static VersionComponent parse(String version) {
        Matcher matcher;

        for (Pattern separator : listSeparators) {
            matcher = separator.matcher(version);

            if (matcher.find())
                return new ListComponent(Arrays.stream(separator.split(version)).map(VersionParser::parse));
        }

        if (number.matcher(version).find())
            return new NumberComponent(new BigInteger(version));
        else
            return new StringComponent(version);
    }
}
