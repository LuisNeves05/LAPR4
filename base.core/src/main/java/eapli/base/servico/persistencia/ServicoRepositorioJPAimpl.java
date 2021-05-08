package eapli.base.servico.persistencia;

import eapli.base.Application;
import eapli.base.servico.domain.Servico;
import eapli.base.servico.domain.ServicoIdentificador;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;
import java.util.HashMap;
import java.util.Map;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;


public class ServicoRepositorioJPAimpl extends JpaAutoTxRepository<Servico, Long, ServicoIdentificador>
        implements ServicoRepositorio {

    public ServicoRepositorioJPAimpl(String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "eapli.base");
    }

    @Override
    public Iterable<Servico> servicoPorIdentificador(final String servicoIdent){
        final Map<String, Object> params = new HashMap<>();
        params.put("servicoIdent", servicoIdent);
        return match("e.servico.servicoIdent=:servicoIdent", params);
    }

    @Override
    public Iterable<Servico> servicoPorTitulo(final String titulo) {
        final Map<String, Object> params = new HashMap<>();
        params.put("titulo", titulo);
        return match("e.servico.titulo=:titulo", params);
    }

    @Override
    public Iterable<Servico> servicoPorDescBreve(final String descBreve) {
        final Map<String, Object> params = new HashMap<>();
        params.put("descBreve", descBreve);
        return match("e.servico.descBreve=:descBreve", params);
    }

    @Override
    public Iterable<Servico> servicoPorKeyword(final String keyword) {
        final Map<String, Object> params = new HashMap<>();
        params.put("descBreve", keyword);
        return match("e.servico.keyword=:keyword", params);
    }


    @Override
    public Iterable<Servico> findByEstado(final String estado) {
        final Map<String, Object> params = new HashMap<>();

        params.put("estado", estado);

        return match("e.servico.estado = :estado ", params);
    }
}
