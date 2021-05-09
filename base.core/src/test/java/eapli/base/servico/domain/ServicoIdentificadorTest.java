package eapli.base.servico.domain;
import junit.framework.TestCase;
import org.junit.Test;

public class ServicoIdentificadorTest extends TestCase {

    private final ServicoIdentificador servicoIdentificador = new ServicoIdentificador("teste");

    public ServicoIdentificador getDummyServicoIdentificador(){
        return servicoIdentificador;
    }

    public void testValueOf() {
        ServicoIdentificador servicoIdentificador = getDummyServicoIdentificador();
        ServicoIdentificador valueOf = ServicoIdentificador.valueOf("teste");

        final boolean expected = servicoIdentificador.equals(valueOf);

        assertTrue(expected);
    }

    public void testEquals() {
        ServicoIdentificador servicoIdentificador1 = getDummyServicoIdentificador();

        final boolean expected = servicoIdentificador.equals(servicoIdentificador1);

        assertTrue(expected);
    }

    public void testHashCode() {
        ServicoIdentificador servicoIdentificador = new ServicoIdentificador("teste");

        assertEquals(servicoIdentificador.hashCode(), getDummyServicoIdentificador().hashCode());
    }

    public void testCompareTo() {
        ServicoIdentificador servicoIdentificador = new ServicoIdentificador("teste");

        final int compareTo = servicoIdentificador.compareTo(getDummyServicoIdentificador());

        final int expected = 0;

        assertEquals(expected, compareTo);

    }

    public void testToString() {
        String expected = "teste";

        assertEquals(expected, getDummyServicoIdentificador().toString());
    }
}