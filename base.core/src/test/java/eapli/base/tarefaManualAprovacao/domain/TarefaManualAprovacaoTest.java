package eapli.base.tarefaManualAprovacao.domain;

import eapli.base.atividadeAprovacao.domain.AtividadeAprovacao;
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

public class TarefaManualAprovacaoTest extends TestCase {

    public static TarefaManualAprovacao dummyTarefaManualExecucao() {

        AtividadeAprovacao atividadeAprovacao = new AtividadeAprovacao();
        Ticket ticket = new Ticket(dummyColab(), dummyServico(), "baixa", EstadoTicket.POR_APROVAR);

        return new TarefaManualAprovacao(ticket, atividadeAprovacao, dummyColab());
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

    private TarefaManualAprovacao getNewDummyTarefaManualAprovacao1(){
        return dummyTarefaManualExecucao();
    }

    private TarefaManualAprovacao getNewDummyTarefaManualAprovacao2(){
        TarefaManualAprovacao tar2 = dummyTarefaManualExecucao();
        tar2.aprovado();
        return tar2;
    }

    public void testMesmaTarefaAprovacaoEqualsSercico(){

        final TarefaManualAprovacao tarefaManualAprovacao1 = getNewDummyTarefaManualAprovacao1();

        final TarefaManualAprovacao tarefaManualAprovacao2 = getNewDummyTarefaManualAprovacao2();

        final boolean expected = tarefaManualAprovacao1.ticketDaTarefa().servicoDoTicket().identity().equals(tarefaManualAprovacao2.ticketDaTarefa().servicoDoTicket().identity());

        assertTrue(expected);
    }

    public void testDiferentesTarefasAprovacaoEquals() {

        final TarefaManualAprovacao tarefaManualAprovacao1 = getNewDummyTarefaManualAprovacao1();

        final TarefaManualAprovacao tarefaManualAprovacao2 = getNewDummyTarefaManualAprovacao2();

        final boolean expected = tarefaManualAprovacao1.equals(tarefaManualAprovacao2);

        assertFalse(expected);
    }

    public void testMesmaTarefaAprovacao() {
        final TarefaManualAprovacao tarefaManualAprovacao1 = getNewDummyTarefaManualAprovacao1();

        final boolean expected = tarefaManualAprovacao1.sameAs(tarefaManualAprovacao1);
        assertTrue(expected);
    }
}