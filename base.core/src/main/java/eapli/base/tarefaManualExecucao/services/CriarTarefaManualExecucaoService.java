package eapli.base.tarefaManualExecucao.services;

import eapli.base.Utils.bibliotecaTarefa.TiposDeTarefa;
import eapli.base.atividadeRealizacao.domain.AtividadeRealizacao;
import eapli.base.atividadeRealizacao.domain.TipoExecucao;
import eapli.base.atividadeRealizacao.persistence.AtividadeRealizacaoRepositorio;
import eapli.base.equipa.domain.Equipa;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.servico.domain.Servico;
import eapli.base.tarefaAutomatica.domain.TarefaAutomatica;
import eapli.base.tarefaAutomatica.persistance.TarefaAutomaticaRepositorio;
import eapli.base.tarefaManualExecucao.domain.EstadoRealizacao;
import eapli.base.tarefaManualExecucao.domain.TarefaManualExecucao;
import eapli.base.tarefaManualExecucao.persistance.TarefaManualExecucaoRepositorio;
import eapli.base.ticket.domain.Ticket;
import eapli.framework.domain.repositories.TransactionalContext;


public class CriarTarefaManualExecucaoService {

    private final TarefaManualExecucaoRepositorio tarefaManualExecucaoRep;
    private final TarefaAutomaticaRepositorio tarefaAutomaticaRepositorio;
    private final TiposDeTarefa tiposDeTarefa = new TiposDeTarefa();

    public CriarTarefaManualExecucaoService(final TransactionalContext autoTx){
        tarefaManualExecucaoRep = PersistenceContext.repositories().tarefaManualExecucaoRepositorio(autoTx);
        tarefaAutomaticaRepositorio  = PersistenceContext.repositories().tarefaAutomaticaRepositorio(autoTx);
    }

    public void criarTarefaExecucao(Servico s, Ticket ticket) {
        AtividadeRealizacao ar = s.fluxoDoServico().ativRealizacaoDoFluxo();

        if (ar.tipoExecucao() == TipoExecucao.MANUAL) {
            if (!ar.equipasExecucao().isEmpty()) {
                TarefaManualExecucao tme = tiposDeTarefa().novaTarefaManualExecucaoEquipa(ticket, ar.equipasExecucao(), ar);
                for (Equipa equipa : ar.equipasExecucao()) {
                    tme.adicionaEquipaExecucao(equipa);
                }
                tarefaManualExecucaoRep.save(tme);
            } else if (ar.colabExec() != null) {
                tarefaManualExecucaoRep.save(tiposDeTarefa().
                        novaTarefaManualExecucaoColaborador(ticket, ar.colabExec(), EstadoRealizacao.POR_EXECUTAR, ar));
            }
        } else {
            tarefaAutomaticaRepositorio.save(tiposDeTarefa().novaTarefaAutomatica(ticket, ar.scriptAutomatico(), ar));
        }
    }

    public TiposDeTarefa tiposDeTarefa() {
        return tiposDeTarefa;
    }
}
