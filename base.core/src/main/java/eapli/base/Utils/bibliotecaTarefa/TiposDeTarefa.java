package eapli.base.Utils.bibliotecaTarefa;

import eapli.base.colaborador.domain.Colaborador;
import eapli.base.equipa.domain.Equipa;
import eapli.base.tarefaAutomatica.domain.TarefaAutomatica;
import eapli.base.tarefaManualAprovacao.domain.TarefaManualAprovacao;
import eapli.base.tarefaManualExecucao.domain.EstadoRealizacao;
import eapli.base.tarefaManualExecucao.domain.TarefaManualExecucao;
import eapli.base.ticket.domain.Ticket;

import java.util.Set;

public class TiposDeTarefa implements TipoTarefa{

    @Override
    public TarefaAutomatica novaTarefaAutomatica(Ticket ticket, String sriptExecucao) {
        return new TarefaAutomatica(ticket, sriptExecucao);
    }

    @Override
    public TarefaManualExecucao novaTarefaManualExecucaoEquipa(Ticket ticket, Set<Equipa> equipasExecuta) {
        return new TarefaManualExecucao(ticket, equipasExecuta);
    }

    @Override
    public TarefaManualExecucao novaTarefaManualExecucaoColaborador(Ticket ticket, Colaborador colabExecuta, EstadoRealizacao estadoRealizacao) {
        return new TarefaManualExecucao(ticket, colabExecuta, estadoRealizacao);
    }

    @Override
    public TarefaManualAprovacao novaTarefaManualAprovacao(Ticket ticket) {
        return new TarefaManualAprovacao(ticket);
    }
}
