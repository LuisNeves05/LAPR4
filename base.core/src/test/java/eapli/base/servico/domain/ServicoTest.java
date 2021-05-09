package eapli.base.servico.domain;

import eapli.base.catalogo.domain.Catalogo;
import eapli.base.catalogo.domain.CatalogoBuilder;
import junit.framework.TestCase;

public class ServicoTest extends TestCase {

    public static Servico dummyServico() {

        final ServiceBuilder serviceBuilder = new ServiceBuilder();
        return serviceBuilder.comIdentificador("verdadeiro").comTitulo("teste").comDescBreve("teste").comDescComp("teste").build();
    }

    private Servico getNewDummyServico() {
        return dummyServico();
    }

    public void testMesmoIdentificadorServicoEquals(){

        final Servico servico1 = new ServiceBuilder().comIdentificador("identificador").comTitulo("teste").comDescBreve("teste").comDescComp("teste").build();

        final Servico servico2 = new ServiceBuilder().comIdentificador("identificador").comTitulo("teste").comDescBreve("teste").comDescComp("teste").build();

        final boolean expected = servico1.identity().equals(servico2.identity());

        assertTrue(expected);
    }

    public void testDiferentesIdentificadorServicoEquals() {

        final Servico servico1 = new ServiceBuilder().comIdentificador("falso").comTitulo("teste").comDescBreve("teste").comDescComp("teste").build();

        final Servico servico2 = new ServiceBuilder().comIdentificador("verdadeiro").comTitulo("teste").comDescBreve("teste").comDescComp("teste").build();

        final boolean expected = servico1.equals(servico2);

        assertFalse(expected);
    }

    public void testMesmoServico() {
        Servico servico = getNewDummyServico();

        final boolean expected = servico.equals(servico);

        assertTrue(expected);
    }

    public void testObjetoDiferenteServico() {

        Catalogo catalogo = new CatalogoBuilder().comTitulo("sou eu").comDescBreve("teste").comDescComp("teste").build();

        final boolean expected = catalogo.equals(dummyServico());

        assertFalse(expected);
    }

    public void testMesmaInstanciaServico() {

        final Servico servico = new ServiceBuilder().comIdentificador("verdadeiro").comTitulo("teste").comDescBreve("teste").comDescComp("teste").build();

        final boolean expected = servico.sameAs(dummyServico());

        assertTrue(expected);
    }

    public void testDoisServicosIdentificadorDiferentes() {

        final Servico servico1 = new ServiceBuilder().comIdentificador("verdadeiro").comTitulo("IGUAL").comDescBreve("teste").comDescComp("teste").build();

        final Servico servico2 = new ServiceBuilder().comIdentificador("falso").comTitulo("IGUAL").comDescBreve("teste").comDescComp("teste").build();

        final boolean expected = servico1.sameAs(servico2);

        assertFalse(expected);
    }

}
