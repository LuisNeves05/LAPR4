package eapli.base.servico.domain;

import junit.framework.TestCase;

public class KeywordTest extends TestCase {

    public void testValueOf() {
        Keyword keyword1 = new Keyword("teste");
        Keyword keyword2 = Keyword.valueOf("teste");

        final boolean expected = keyword1.equals(keyword2);

        assertTrue(expected);
    }

    public void testEquals() {
        Keyword keyword1 = new Keyword("teste");
        Keyword keyword2 = new Keyword("teste");

        final boolean expected = keyword1.equals(keyword2);

        assertTrue(expected);
    }

    public void testHashCode() {
        Keyword keyword1 = new Keyword("teste");
        Keyword keyword2 = new Keyword("teste");

        final boolean expected = keyword1.hashCode() == keyword2.hashCode();

        assertTrue(expected);
    }


    public void testCompareTo() {
        Keyword keyword1 = new Keyword("teste");
        Keyword keyword2 = new Keyword("teste");

        final boolean expected = keyword1.compareTo(keyword2) == 0;

        assertTrue(expected);
    }

    public void testToString() {
        Keyword keyword = new Keyword("teste");

        final boolean expected = keyword.toString().equals("teste");

        assertTrue(expected);
    }
}