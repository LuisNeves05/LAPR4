package eapli.base.formulario.persistence;

import eapli.base.Application;
import eapli.base.formulario.domain.Formulario;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

public class FormularioRepositorioJPAimpl extends JpaAutoTxRepository<Formulario, Long, Formulario> implements FormularioRepositorio{

    public FormularioRepositorioJPAimpl(String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "eapli.base");
    }
}
