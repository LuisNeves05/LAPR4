package eapli.base.servico.domain;

import eapli.base.servico.builder.ServiceBuilder;
import junit.framework.TestCase;

public class ServiceBuilderTest extends TestCase {

    public void testComIdentificador() {

        ServiceBuilder serviceBuilder1 =  new ServiceBuilder().comIdentificador("teste");
        ServiceBuilder serviceBuilder2 =  new ServiceBuilder().comIdentificador("teste");

        final boolean expected = serviceBuilder1.equals(serviceBuilder2);

        assertTrue(expected);
    }

    public void testBuild() {
        final Servico servico1 = new ServiceBuilder().comIdentificador("falso").comTitulo("teste")
                .comDescBreve("teste").comDescComp("teste").build();
        final Servico servico2 = new ServiceBuilder().comIdentificador("falso").comTitulo("teste")
                .comDescBreve("teste").comDescComp("teste").build();

        final boolean expected = servico1.sameAs(servico2);

        assertTrue(expected);
    }

    public void testDiferentesServicoBuilder(){
        ServiceBuilder serviceBuilder1 =  new ServiceBuilder().comIdentificador("teste");
        ServiceBuilder serviceBuilder2 =  new ServiceBuilder().comIdentificador("falso");

        final boolean expected = serviceBuilder1.equals(serviceBuilder2);

        assertFalse(expected);
    }
}