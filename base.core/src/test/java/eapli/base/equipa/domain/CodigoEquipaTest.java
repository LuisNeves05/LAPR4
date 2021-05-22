package eapli.base.equipa.domain;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class CodigoEquipaTest{

    @Test
    public void testValidaIdentificadorValid() {
        CodigoEquipa cQ = new CodigoEquipa();
        Assert.assertTrue(cQ.validaIdentificador("TEXT"));
    }

    @Test
    public void testValidaIdentificadorInvalid() {
        CodigoEquipa cQ = new CodigoEquipa();
        Assert.assertFalse(cQ.validaIdentificador("TEXT#"));
    }
}