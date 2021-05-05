package eapli.base.clientusermanagement.repositories;

import eapli.base.clientusermanagement.domain.Formulario;
import eapli.base.clientusermanagement.jpa.JpaRepositorio;

public class FormularioRepositorioJPAImpl extends JpaRepositorio<Formulario, Long> implements RepositorioFormulario {

    @Override
    protected String persistenceUnitName() {
        return "eapli.base";
    }
}
