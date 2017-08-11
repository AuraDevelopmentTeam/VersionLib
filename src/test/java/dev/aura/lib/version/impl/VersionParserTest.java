package dev.aura.lib.version.impl;

import static org.junit.Assert.assertEquals;

import java.math.BigInteger;

import org.junit.Test;

public class VersionParserTest {
    @Test
    public void emptyTest() {
        final VersionComponent expected = new StringComponent("");

        assertEquals("Parser produced wrong result", expected, VersionParser.parse(""));
    }

    @Test
    public void nullTest() {
        final VersionComponent expected = VersionParser.ZERO;

        assertEquals("Parser produced wrong result", expected, VersionParser.parse(null));
    }

    @Test
    public void numberListTest() {
        final VersionComponent expected = new ListComponent(new NumberComponent(BigInteger.ONE),
                new NumberComponent(BigInteger.TEN));

        assertEquals("Parser produced wrong result", expected, VersionParser.parse("1_10"));
        assertEquals("Parser produced wrong result", expected, VersionParser.parse("1-10"));
        assertEquals("Parser produced wrong result", expected, VersionParser.parse("1.10"));
    }

    @Test
    public void numberTest() {
        final VersionComponent expected = new NumberComponent(BigInteger.ONE);

        assertEquals("Parser produced wrong result", expected, VersionParser.parse("1"));
    }

    @Test
    public void stringListTest() {
        final VersionComponent expected = new ListComponent(new StringComponent("abc"), new StringComponent("def"));

        assertEquals("Parser produced wrong result", expected, VersionParser.parse("abc_def"));
        assertEquals("Parser produced wrong result", expected, VersionParser.parse("abc-def"));
        assertEquals("Parser produced wrong result", expected, VersionParser.parse("abc.def"));
    }

    @Test
    public void stringTest() {
        final VersionComponent expected = new StringComponent("abc");

        assertEquals("Parser produced wrong result", expected, VersionParser.parse("abc"));
    }

    @Test
    public void transitionTest() {
        final VersionComponent expected1 = new ListComponent(new NumberComponent(BigInteger.ONE),
                new StringComponent("abc"));
        final VersionComponent expected2 = new ListComponent(new StringComponent("abc"),
                new NumberComponent(BigInteger.ONE));

        assertEquals("Parser produced wrong result", expected1, VersionParser.parse("1abc"));
        assertEquals("Parser produced wrong result", expected2, VersionParser.parse("abc1"));
    }

    // TODO: More tests for more cases!
}
