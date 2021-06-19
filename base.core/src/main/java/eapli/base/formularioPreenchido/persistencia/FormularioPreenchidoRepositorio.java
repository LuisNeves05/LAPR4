package eapli.base.formularioPreenchido.persistencia;

import eapli.base.formulario.domain.Formulario;
import eapli.base.formularioPreenchido.domain.FormularioPreenchido;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.Set;

public interface FormularioPreenchidoRepositorio extends DomainRepository<Long, FormularioPreenchido> {

    Set<FormularioPreenchido> formularioRespostas();
}
