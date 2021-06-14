package eapli.base.tarefaManualAprovacao.service;

import eapli.base.Utils.bibliotecaTarefa.TiposDeTarefa;
import eapli.base.atividadeAprovacao.domain.AtividadeAprovacao;
import eapli.base.atividadeAprovacao.domain.ColaboradoresAprovacao;
import eapli.base.atividadeAprovacao.persistence.AtividadeAprovacaoRepositorio;
import eapli.base.colaborador.domain.Colaborador;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.servico.domain.Servico;
import eapli.base.tarefaManualAprovacao.domain.TarefaManualAprovacao;
import eapli.base.tarefaManualAprovacao.persistance.TarefaManualAprovacaoRepositorio;
import eapli.base.ticket.domain.Ticket;

import java.util.Set;

public class CriarTarefaManualAprovacaoService {

    private final AtividadeAprovacaoRepositorio atividadeAprovacaoRepositorio = PersistenceContext.repositories().atividadeAprovacaoRepositorio();

    private final TarefaManualAprovacaoRepositorio tarefaManualAprovacaoRep = PersistenceContext.repositories().tarefaManualAprovacaoRepositorio();

    private final TiposDeTarefa tiposDeTarefa = new TiposDeTarefa();

    public boolean criarTarefaAprovacao(Servico s, Ticket ticket, Colaborador colabLogado) {
        AtividadeAprovacao at = s.fluxoDoServico().ativAprovacaoDoFluxo();

        if (at != null) {
            Set<ColaboradoresAprovacao> colabsApov = at.colabsDeAprovacao();
            TarefaManualAprovacao tarefaManualAprovacao = tiposDeTarefa().novaTarefaManualAprovacao(ticket);
            if (colabsApov.contains(ColaboradoresAprovacao.RESPONSAVEL_HIERARQUICO)) {
                Colaborador respHierarquico = colabLogado.seuColabResponsavel();
                tarefaManualAprovacao.assignaColabAprovacao(respHierarquico);
            }
            if (colabsApov.contains(ColaboradoresAprovacao.RESPONSAVEL_PELO_SERVICO)) {
                Colaborador respServico = s.catalogo().colaboradorResponsavelDoCatalogo();
                tarefaManualAprovacao.assignaColabAprovacao(respServico);
            }
            TarefaManualAprovacao tarManAprov = tarefaManualAprovacaoRep.save(tarefaManualAprovacao);
            at.adicionaTarefaAprov(tarManAprov);
            atividadeAprovacaoRepositorio.save(at);
            return true;
        }else{
            return false;
        }
    }

    public TiposDeTarefa tiposDeTarefa(){
        return tiposDeTarefa;
    }
}
