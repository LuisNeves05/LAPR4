package eapli.base.formularioPreenchido.persistencia;

import eapli.base.Application;
import eapli.base.formularioPreenchido.domain.FormularioPreenchido;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

public class FormularioPreenchidoRepositorioJPAimpl extends JpaAutoTxRepository<FormularioPreenchido, Long, Long> implements FormularioPreenchidoRepositorio {

    public FormularioPreenchidoRepositorioJPAimpl(String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "eapli.base");
    }

}
