package eapli.base.formulario.persistencia;

import eapli.base.Application;
import eapli.base.formulario.domain.Atributo;
import eapli.base.formulario.domain.Formulario;
import eapli.base.servico.domain.Servico;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class FormularioRepositorioJPAimpl extends JpaAutoTxRepository<Formulario, Long, Formulario> implements FormularioRepositorio{

    public FormularioRepositorioJPAimpl(String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "eapli.base");
    }

    @Override
    public Iterable<Formulario> formularioPorServico(final Servico servico) {
        Query query = super.createQuery("SELECT formularios from Servico s where :servico = s", Iterable.class);
        query.setParameter("servico", servico);
        return query.getResultList();
    }

    @Override
    public List<Atributo> atributosPorFormulario(final Formulario formulario) {
        Query query = super.createQuery("SELECT conjuntoAtributos from Formulario f where :formulario = f", Iterable.class);
        query.setParameter("formulario", formulario);
        return query.getResultList();
    }

    @Override
    public void removePeloID(final Formulario formulario) {
        EntityManager em =  super.entityManager();

        em.getTransaction().begin();
        em.remove(em.find(Formulario.class, formulario.identity()));
        em.getTransaction().commit();
        em.flush();
        em.clear();
        em.close();
    }
}
