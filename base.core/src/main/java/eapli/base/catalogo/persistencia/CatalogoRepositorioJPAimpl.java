package eapli.base.catalogo.persistencia;

import eapli.base.Application;
import eapli.base.catalogo.domain.Catalogo;
import eapli.base.servico.domain.Servico;
import eapli.base.servico.domain.ServicoIdentificador;
import eapli.base.servico.persistencia.ServicoRepositorio;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.management.Query;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class CatalogoRepositorioJPAimpl extends JpaAutoTxRepository<Catalogo, Long, Long>
        implements CatalogoRepositorio {

    public CatalogoRepositorioJPAimpl(String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "eapli.base");
    }

    @Override
    public Iterable<Catalogo> catalogoPorTitulo(final String titulo) {
        final Map<String, Object> params = new HashMap<>();
        params.put("titulo", titulo);
        return match("e.catalogo.titulo=:titulo", params);
    }

    @Override
    public Iterable<Catalogo> catalogoPorDescBreve(final String descBreve) {
        final Map<String, Object> params = new HashMap<>();
        params.put("descBreve", descBreve);
        return match("e.catalogo.descBreve=:descBreve", params);
    }
}
