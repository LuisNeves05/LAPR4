package eapli.base.atividadeRealizacao.persistence;

import eapli.base.atividadeRealizacao.domain.AtividadeRealizacao;
import eapli.base.fluxoAtividade.domain.FluxoAtividade;
import eapli.framework.domain.repositories.DomainRepository;

public interface AtividadeRealizacaoRepositorio extends DomainRepository<Long, AtividadeRealizacao> {

    void removePeloID(AtividadeRealizacao ativRealizacaoDoFluxo);
}