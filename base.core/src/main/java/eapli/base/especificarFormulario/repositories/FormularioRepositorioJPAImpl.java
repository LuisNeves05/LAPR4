package eapli.base.especificarFormulario.repositories;

import eapli.base.especificarFormulario.domain.Formulario;
import eapli.base.especificarservico.jpa.JpaRepositorioServico;

public class FormularioRepositorioJPAImpl extends JpaRepositorioServico<Formulario, Long> implements RepositorioFormulario {

    /**
     * Unit Name de persistência
     */
    @Override
    protected String persistenceUnitName() {
        return "eapli.base";
    }
}
