package eapli.base.servico.domain;

import junit.framework.TestCase;

public class DescricaoCompletaTest extends TestCase {

    public void testValueOf() {

        DescricaoCompleta descricaoCompleta1 = new DescricaoCompleta("teste");
        DescricaoCompleta descricaoCompleta2 = DescricaoCompleta.valueOf("teste");

        final boolean expected = descricaoCompleta1.equals(descricaoCompleta2);

        assertTrue(expected);
    }

    public void testEquals() {
        DescricaoCompleta descricaoCompleta1 = new DescricaoCompleta("teste");
        DescricaoCompleta descricaoCompleta2 = new DescricaoCompleta("teste");

        final boolean expected = descricaoCompleta1.equals(descricaoCompleta2);

        assertTrue(expected);
    }

    public void testHashCode() {
        DescricaoCompleta descricaoCompleta1 = new DescricaoCompleta("teste");
        DescricaoCompleta descricaoCompleta2 = new DescricaoCompleta("teste");

        final boolean expected = descricaoCompleta1.hashCode() == descricaoCompleta2.hashCode();

        assertTrue(expected);
    }

    public void testCompareTo() {
        DescricaoCompleta descricaoCompleta1 = new DescricaoCompleta("teste");
        DescricaoCompleta descricaoCompleta2 = new DescricaoCompleta("teste");

        final boolean expected = descricaoCompleta1.compareTo(descricaoCompleta2) == 0;

        assertTrue(expected);
    }

    public void testToString() {
        DescricaoCompleta descricaoCompleta1 = new DescricaoCompleta("teste");
        DescricaoCompleta descricaoCompleta2 = new DescricaoCompleta("teste");

        final boolean expected = descricaoCompleta1.toString().equals(descricaoCompleta2.toString());

        assertTrue(expected);
    }
}