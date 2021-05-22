package eapli.base.equipa.domain;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class EquipaTest {

    @Test(expected = IllegalArgumentException.class)
    public void testEquipaCodigoInvalid(){
        CodigoEquipa cEquipa = new CodigoEquipa("LAP4#");
        Equipa newEquipa = new Equipa(cEquipa, new Acronimo("TXT"), "TEST", null, null);
    }


    @Test
    public void testEquipaCodigoValid(){
        CodigoEquipa cEquipa = new CodigoEquipa("LAP4");
        Equipa newEquipa = new Equipa(cEquipa, new Acronimo("TXT"), "TEST", null, null);
        Assert.assertNotNull(newEquipa);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEquipaAcronimoInvalid(){
        CodigoEquipa cEquipa = new CodigoEquipa("LAP4");
        Equipa newEquipa = new Equipa(cEquipa, new Acronimo("TXT#"), "TEST", null, null);
    }


    @Test
    public void testEquipaAcronimoValid(){
        CodigoEquipa cEquipa = new CodigoEquipa("LAP4");
        Equipa newEquipa = new Equipa(cEquipa, new Acronimo("TXT"), "TEST", null, null);
        Assert.assertNotNull(newEquipa);
    }


}