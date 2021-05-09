package eapli.base.servico.domain;

import junit.framework.TestCase;

public class DescricaoBreveTest extends TestCase {

    public void testValueOf() {
        DescricaoBreve descricaoBreve1= new DescricaoBreve("teste");
        DescricaoBreve descricaoBreve2 = DescricaoBreve.valueOf("teste");

        final boolean expected = descricaoBreve1.equals(descricaoBreve2);

        assertTrue(expected);
    }

    public void testEquals() {
        DescricaoBreve descricaoBreve1 = new DescricaoBreve("teste");
        DescricaoBreve descricaoBreve2 = new DescricaoBreve("teste");

        final boolean expected = descricaoBreve1.equals(descricaoBreve2);

        assertTrue(expected);
    }

    public void testHashCode() {
        DescricaoBreve descricaoBreve1 = new DescricaoBreve("teste");
        DescricaoBreve descricaoBreve2 = new DescricaoBreve("teste");

        final boolean expected = descricaoBreve1.hashCode() == descricaoBreve2.hashCode();

        assertTrue(expected);
    }

    public void testCompareTo() {
        DescricaoBreve descricaoBreve1 = new DescricaoBreve("teste");
        DescricaoBreve descricaoBreve2 = new DescricaoBreve("teste");

        final boolean expected = descricaoBreve1.compareTo(descricaoBreve2) == 0;

        assertTrue(expected);
    }

    public void testToString() {
        DescricaoBreve descricaoBreve1 = new DescricaoBreve("teste");
        DescricaoBreve descricaoBreve2 = new DescricaoBreve("teste");

        final boolean expected = descricaoBreve1.toString().equals(descricaoBreve2.toString());

        assertTrue(expected);
    }
}