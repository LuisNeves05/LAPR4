package eapli.base.servico.domain;

import junit.framework.TestCase;

public class TituloTest extends TestCase {

    public void testValueOf() {
        Titulo titulo1 = new Titulo("teste");
        Titulo titulo2 = Titulo.valueOf("teste");

        final boolean expected = titulo1.equals(titulo2);

        assertTrue(expected);
    }

    public void testTestEquals() {
        Titulo titulo1 = new Titulo("teste");
        Titulo titulo2 = new Titulo("teste");

        final boolean expected = titulo1.equals(titulo2);

        assertTrue(expected);
    }

    public void testTestHashCode() {
        Titulo titulo1 = new Titulo("teste");
        Titulo titulo2 = new Titulo("teste");

        final boolean expected = titulo1.hashCode() == titulo2.hashCode();

        assertTrue(expected);
    }

    public void testCompareTo() {
        Titulo titulo1 = new Titulo("teste");
        Titulo titulo2 = new Titulo("teste");

        final boolean expected = titulo1.compareTo(titulo2) == 0;

        assertTrue(expected);
    }

    public void testTestToString() {
        Titulo titulo1 = new Titulo("teste");
        Titulo titulo2 = new Titulo("teste");

        final boolean expected = titulo1.toString().equals(titulo2.toString());

        assertTrue(expected);
    }
}