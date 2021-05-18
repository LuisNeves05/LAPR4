package eapli.base.formulario.persistencia;

import eapli.base.formulario.domain.Atributo;
import eapli.base.formulario.domain.Formulario;
import eapli.base.servico.domain.Servico;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.List;
import java.util.Set;

public interface FormularioRepositorio extends DomainRepository<Formulario, Formulario> {

    Iterable<Formulario> formularioPorServico(final Servico servico);

    List<Atributo> atributosPorFormulario(final Formulario formulario);

}
