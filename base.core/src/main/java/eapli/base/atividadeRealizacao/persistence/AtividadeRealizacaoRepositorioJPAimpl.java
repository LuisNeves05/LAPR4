package eapli.base.atividadeRealizacao.persistence;

import eapli.base.Application;
import eapli.base.atividadeRealizacao.domain.AtividadeRealizacao;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.EntityManager;


public class AtividadeRealizacaoRepositorioJPAimpl extends JpaAutoTxRepository<AtividadeRealizacao, Long, Long>
        implements AtividadeRealizacaoRepositorio {

    public AtividadeRealizacaoRepositorioJPAimpl(final TransactionalContext autoTx) {
        super(autoTx,"eapli.base");
    }

    public AtividadeRealizacaoRepositorioJPAimpl(String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "eapli.base");
    }

    @Override
    public void removePeloID(AtividadeRealizacao ativRealizacaoDoFluxo) {
        /*
        EntityManager em = super.entityManager();

        em.getTransaction().begin();
        em.remove(em.find(AtividadeRealizacao.class, ativRealizacaoDoFluxo.identity()));
        em.getTransaction().commit();
        em.flush();
        em.clear();
        em.close();

         */
    }
}
