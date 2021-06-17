package eapli.base.Utils.bibliotecaTarefa;

import eapli.base.atividadeAprovacao.domain.AtividadeAprovacao;
import eapli.base.atividadeRealizacao.domain.AtividadeRealizacao;
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
    public TarefaAutomatica novaTarefaAutomatica(Ticket ticket, String sriptExecucao, AtividadeRealizacao ar) {
        return new TarefaAutomatica(ticket, sriptExecucao, ar);
    }

    @Override
    public TarefaManualExecucao novaTarefaManualExecucaoEquipa(Ticket ticket, Set<Equipa> equipasExecuta, AtividadeRealizacao ar) {
        return new TarefaManualExecucao(ticket, equipasExecuta, ar);
    }

    @Override
    public TarefaManualExecucao novaTarefaManualExecucaoColaborador(Ticket ticket, Colaborador colabExecuta, EstadoRealizacao estadoRealizacao, AtividadeRealizacao ar) {
        return new TarefaManualExecucao(ticket, colabExecuta, estadoRealizacao, ar);
    }

    @Override
    public TarefaManualAprovacao novaTarefaManualAprovacao(Ticket ticket, AtividadeAprovacao aa) {
        return new TarefaManualAprovacao(ticket, aa);
    }
}
