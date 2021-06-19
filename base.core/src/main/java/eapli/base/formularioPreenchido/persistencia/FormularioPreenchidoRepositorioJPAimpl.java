package eapli.base.formularioPreenchido.persistencia;

import eapli.base.Application;
import eapli.base.Utils.QueryMaker;
import eapli.base.formulario.domain.Formulario;
import eapli.base.formularioPreenchido.domain.FormularioPreenchido;
import eapli.base.ticket.domain.EstadoTicket;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.Query;
import java.util.LinkedHashSet;
import java.util.Set;

public class FormularioPreenchidoRepositorioJPAimpl extends JpaAutoTxRepository<FormularioPreenchido, Long, Long> implements FormularioPreenchidoRepositorio {

    public FormularioPreenchidoRepositorioJPAimpl(String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "eapli.base");
    }

    @Override
    public Set<FormularioPreenchido> formularioRespostas() {
        Query query = super.createQuery("select fp from FormularioPreenchido fp inner join Ticket t on fp.ticket=t inner join TarefaAutomatica taut on t=taut.ticket where t.estadoTicket =:emExec", FormularioPreenchido.class);
        query.setParameter("emExec", EstadoTicket.EM_EXECUCAO);
        return new LinkedHashSet<>(query.getResultList());
    }

}
