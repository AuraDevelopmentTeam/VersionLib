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
  public void negativeTest() {
    final VersionComponent expected = VersionParser.ZERO;

    assertEquals("Parser produced wrong result", expected, VersionParser.parse("", -1));
  }

  @Test
  public void numberListTest() {
    final VersionComponent expected1 =
        new ListComponent(
            new ListComponent(
                new ListComponent(new ListComponent(new NumberComponent(BigInteger.ONE)))),
            new ListComponent(
                new ListComponent(new ListComponent(new NumberComponent(BigInteger.TEN)))));
    final VersionComponent expected2 =
        new ListComponent(
            new ListComponent(
                new ListComponent(new ListComponent(new NumberComponent(BigInteger.ONE))),
                new ListComponent(new ListComponent(new NumberComponent(BigInteger.TEN)))));
    final VersionComponent expected3 =
        new ListComponent(
            new ListComponent(
                new ListComponent(
                    new ListComponent(new NumberComponent(BigInteger.ONE)),
                    new ListComponent(new NumberComponent(BigInteger.TEN)))));

    final VersionComponent actual1 = VersionParser.parse("1_10");
    final VersionComponent actual2 = VersionParser.parse("1-10");
    final VersionComponent actual3 = VersionParser.parse("1.10");

    TestUtils.compareVersionComponents(expected1, expected2, actual1);
    TestUtils.compareVersionComponents(expected2, expected1, actual2);
    TestUtils.compareVersionComponents(expected3, expected1, actual3);
  }

  @Test
  public void numberTest() {
    final VersionComponent expected =
        new ListComponent(
            new ListComponent(
                new ListComponent(new ListComponent(new NumberComponent(BigInteger.TEN)))));
    final VersionComponent unexpected =
        new ListComponent(
            new ListComponent(
                new ListComponent(new ListComponent(new NumberComponent(BigInteger.ONE)))));

    final VersionComponent actual = VersionParser.parse("10");

    TestUtils.compareVersionComponents(expected, unexpected, actual);
  }

  @Test
  public void stringListTest() {
    final VersionComponent expected1 =
        new ListComponent(
            new ListComponent(new ListComponent(new ListComponent(new StringComponent("abc")))),
            new ListComponent(new ListComponent(new ListComponent(new StringComponent("def")))));
    final VersionComponent expected2 =
        new ListComponent(
            new ListComponent(
                new ListComponent(new ListComponent(new StringComponent("abc"))),
                new ListComponent(new ListComponent(new StringComponent("def")))));
    final VersionComponent expected3 =
        new ListComponent(
            new ListComponent(
                new ListComponent(
                    new ListComponent(new StringComponent("abc")),
                    new ListComponent(new StringComponent("def")))));

    final VersionComponent actual1 = VersionParser.parse("abc_def");
    final VersionComponent actual2 = VersionParser.parse("abc-def");
    final VersionComponent actual3 = VersionParser.parse("abc.def");

    TestUtils.compareVersionComponents(expected1, expected2, actual1);
    TestUtils.compareVersionComponents(expected2, expected1, actual2);
    TestUtils.compareVersionComponents(expected3, expected1, actual3);
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
        new ListComponent(
            new ListComponent(
                new ListComponent(
                    new ListComponent(
                        new NumberComponent(BigInteger.ONE), new StringComponent("abc")))));
    final VersionComponent expected2 =
        new ListComponent(
            new ListComponent(
                new ListComponent(
                    new ListComponent(
                        new StringComponent("abc"), new NumberComponent(BigInteger.ONE)))));

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
