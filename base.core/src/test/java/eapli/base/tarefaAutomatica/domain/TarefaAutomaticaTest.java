package eapli.base.tarefaAutomatica.domain;

import eapli.base.atividadeRealizacao.domain.AtividadeRealizacao;
import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.colaborador.domain.*;
import eapli.base.criticidade.domain.NivelCriticidade;
import eapli.base.criticidade.domain.Objetivo;
import eapli.base.servico.builder.ServiceBuilder;
import eapli.base.servico.domain.Servico;
import eapli.base.ticket.domain.EstadoTicket;
import eapli.base.ticket.domain.Ticket;
import junit.framework.TestCase;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TarefaAutomaticaTest extends TestCase {

    public static TarefaAutomatica dummyTarefaAutomatica() {

        AtividadeRealizacao atividadeRealizacao = new AtividadeRealizacao();
        Ticket ticket = new Ticket(dummyColab(), dummyServico(), "baixa", EstadoTicket.POR_APROVAR);

        return new TarefaAutomatica(ticket, "scriptTeste", atividadeRealizacao);
    }

    public static Servico dummyServico() {

        final ServiceBuilder serviceBuilder = new ServiceBuilder();
        serviceBuilder.comNivelCrit(new NivelCriticidade(null, null, null,  new Objetivo(10, 15, 20, 25), false));
        return serviceBuilder.comIdentificador("verdadeiro").comTitulo("teste").comDescBreve("teste").comDescComp("teste").build();
    }

    public static Colaborador dummyColab() {
        Date date = null;
        try {
            String pattern = "05-12-2000";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            date = simpleDateFormat.parse(pattern);
        }catch (ParseException x){
            x.getErrorOffset();
        }


        ColaboradorBuilder colaboradorBuilder = new ColaboradorBuilder();
        return colaboradorBuilder.comNomeCurto(new NomeCurto("Rui")).comNomeCompleto(new NomeCompleto("Rui Alves")).comNumMecanografico(new MecanographicNumber("1181597"))
                .comLocalResidencia(new Morada("Porto", "Marco de Canaveses")).comNrContacto(new NrContacto(927206840)).comDataNascimento(date).comColaboradorResponsavel(null).build();
    }

    private TarefaAutomatica getNewDummyTarefaAutomatica1(){
        return dummyTarefaAutomatica();
    }

    private TarefaAutomatica getNewDummyTarefaAutomatica2(){
        AtividadeRealizacao atividadeRealizacao = new AtividadeRealizacao();
        Ticket ticket = new Ticket(dummyColab(), dummyServico(), "baixa", EstadoTicket.POR_APROVAR);

        return new TarefaAutomatica(ticket, "scriptTeste2" , atividadeRealizacao);
    }

    public void testMesmaTarefaAutomaticaEqualsSercico(){

        final TarefaAutomatica tar1 = getNewDummyTarefaAutomatica1();

        final TarefaAutomatica tar2 = getNewDummyTarefaAutomatica2();

        final boolean expected = tar1.ticketDaTarefa().servicoDoTicket().identity().equals(tar2.ticketDaTarefa().servicoDoTicket().identity());

        assertTrue(expected);
    }

    public void testDiferentesTarefasAprovacaoEquals() {

        final TarefaAutomatica tar1 = getNewDummyTarefaAutomatica1();

        final TarefaAutomatica tar2 = getNewDummyTarefaAutomatica2();

        final boolean expected = tar2.equals(tar1);

        assertFalse(expected);
    }

    public void testMesmaTarefaAprovacao() {
        final TarefaAutomatica tar1 = getNewDummyTarefaAutomatica1();

        final boolean expected = tar1.sameAs(tar1);
        assertTrue(expected);
    }

}