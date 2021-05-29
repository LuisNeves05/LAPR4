package eapli.base.tarefa.domain;

import eapli.base.colaborador.domain.Colaborador;
import eapli.base.equipa.domain.Equipa;
import eapli.base.tarefa.domain.estado.EstadoRealizacao;
import eapli.base.ticket.domain.Ticket;

import java.util.Set;

public interface TipoTarefa {

    TarefaAutomatica novaTarefaAutomatica(Ticket ticket);

    TarefaManualExecucao novaTarefaManualExecucaoEquipa(Ticket ticket, Set<Equipa> equipasExecuta);

    TarefaManualExecucao novaTarefaManualExecucaoColaborador(Ticket ticket, Colaborador colabExecuta, EstadoRealizacao estadoRealizacao);

    TarefaManualAprovacao novaTarefaManualAprovacao(Ticket ticket);
}
