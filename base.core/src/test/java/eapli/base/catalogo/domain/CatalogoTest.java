package eapli.base.catalogo.domain;

import junit.framework.TestCase;

public class CatalogoTest extends TestCase {

    public static Catalogo dummyCatalogo() {

        final CatalogoBuilder catalogoBuilder = new CatalogoBuilder();
        return catalogoBuilder.comTitulo("teste").comDescBreve("teste").comDescComp("teste").build();
    }

    private Catalogo getNewDummyCatalogo() {
        return dummyCatalogo();
    }

    public void testMesmoCatalogo() {
        Catalogo catalogo = getNewDummyCatalogo();

        final boolean expected = catalogo.equals(catalogo);

        assertTrue(expected);
    }

    public void testObjetoDiferenteCatalogo() {

        Catalogo catalogo = new CatalogoBuilder().comTitulo("sou eu").comDescBreve("teste").comDescComp("teste").build();

        final boolean expected = catalogo.equals(dummyCatalogo());

        assertFalse(expected);
    }
}