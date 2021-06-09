package eapli.base.atividadeAprovacao.persistence;

import eapli.base.Application;
import eapli.base.Utils.QueryMaker;
import eapli.base.atividadeAprovacao.domain.AtividadeAprovacao;
import eapli.base.fluxoAtividade.domain.FluxoAtividade;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.EntityManager;


public class AtividadeAprovacaoRepositorioJPAimpl extends JpaAutoTxRepository<AtividadeAprovacao, Long, Long>
        implements AtividadeAprovacaoRepositorio {

    public AtividadeAprovacaoRepositorioJPAimpl(String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "eapli.base");
    }

    @Override
    public void removePeloID(AtividadeAprovacao atividadeAprovacao) {

        QueryMaker qm = new QueryMaker();
        EntityManager em = qm.criarEntityManager("eapli.base");

        em.getTransaction().begin();
        em.remove(em.find(AtividadeAprovacao.class, atividadeAprovacao.identity()));
        em.getTransaction().commit();
        em.flush();
        em.clear();
        em.close();
    }
}
