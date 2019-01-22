package dev.aura.lib.version.impl;

import static org.junit.Assert.assertEquals;

import dev.aura.lib.version.TestUtils;
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
    final VersionComponent expected =
        new ListComponent(new NumberComponent(BigInteger.ONE), new NumberComponent(BigInteger.TEN));
    final VersionComponent unexpected =
        new ListComponent(new NumberComponent(BigInteger.ONE), new NumberComponent(BigInteger.ONE));

    final String[] versions = new String[] {"1_10", "1-10", "1.10"};

    for (final String version : versions) {
      final VersionComponent actual = VersionParser.parse(version);

      TestUtils.compareVersionComponents(expected, unexpected, actual);
    }
  }

  @Test
  public void numberTest() {
    final VersionComponent expected = new NumberComponent(BigInteger.TEN);
    final VersionComponent unexpected = new NumberComponent(BigInteger.ONE);

    final VersionComponent actual = VersionParser.parse("10");

    TestUtils.compareVersionComponents(expected, unexpected, actual);
  }

  @Test
  public void stringListTest() {
    final VersionComponent expected =
        new ListComponent(new StringComponent("abc"), new StringComponent("def"));
    final VersionComponent unexpected =
        new ListComponent(new StringComponent("abc"), new StringComponent("defg"));

    final String[] versions = new String[] {"abc_def", "abc-def", "abc.def"};

    for (final String version : versions) {
      final VersionComponent actual = VersionParser.parse(version);

      TestUtils.compareVersionComponents(expected, unexpected, actual);
    }
  }

  @Test
  public void stringTest() {
    final VersionComponent expected = new StringComponent("abc");
    final VersionComponent unexpected = new StringComponent("abcd");

    final VersionComponent actual = VersionParser.parse("abc");

    TestUtils.compareVersionComponents(expected, unexpected, actual);
  }

  @Test
  public void transitionTest() {
    final VersionComponent expected1 =
        new ListComponent(new NumberComponent(BigInteger.ONE), new StringComponent("abc"));
    final VersionComponent expected2 =
        new ListComponent(new StringComponent("abc"), new NumberComponent(BigInteger.ONE));

    final VersionComponent actual1 = VersionParser.parse("1abc");
    final VersionComponent actual2 = VersionParser.parse("abc1");

    TestUtils.compareVersionComponents(expected1, expected2, actual1);
    TestUtils.compareVersionComponents(expected2, expected1, actual2);
  }

  // TODO: More tests for more cases!

  @Test(expected = UnsupportedOperationException.class)
  public void hiddenConstuctorTest() throws Throwable {
    TestUtils.checkHiddenConstructor(VersionParser.class);
  }
}
