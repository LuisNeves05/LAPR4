package eapli.base.formulario.persistencia;

import eapli.base.Application;
import eapli.base.Utils.QueryMaker;
import eapli.base.atividadeRealizacao.domain.AtividadeRealizacao;
import eapli.base.catalogo.domain.Catalogo;
import eapli.base.formulario.domain.Atributo;
import eapli.base.formulario.domain.Formulario;
import eapli.base.servico.domain.Servico;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.Set;

public class FormularioRepositorioJPAimpl extends JpaAutoTxRepository<Formulario, Long, Formulario> implements FormularioRepositorio{

    public FormularioRepositorioJPAimpl(String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "eapli.base");
    }

    @Override
    public Iterable<Formulario> formularioPorServico(final Servico servico) {
        QueryMaker qm = new QueryMaker();
        Query query = qm.criarEntityManager("eapli.base").createQuery("SELECT formularios from Servico s where :servico = s", Iterable.class);
        query.setParameter("servico", servico);
        return query.getResultList();
    }

    @Override
    public List<Atributo> atributosPorFormulario(final Formulario formulario) {
        QueryMaker qm = new QueryMaker();
        Query query = qm.criarEntityManager("eapli.base").createQuery("SELECT conjuntoAtributos from Formulario f where :formulario = f", Iterable.class);
        query.setParameter("formulario", formulario);
        return query.getResultList();
    }

    @Override
    public void removePeloID(final Formulario formulario) {
        QueryMaker qm = new QueryMaker();
        EntityManager em = qm.criarEntityManager("eapli.base");

        em.getTransaction().begin();
        em.remove(em.find(Formulario.class, formulario.identity()));
        em.getTransaction().commit();
        em.flush();
        em.clear();
        em.close();
    }
}
