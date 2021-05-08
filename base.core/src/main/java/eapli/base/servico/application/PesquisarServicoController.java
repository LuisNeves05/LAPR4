package eapli.base.servico.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.servico.domain.Servico;
import eapli.base.servico.persistencia.ServicoRepositorio;

public class PesquisarServicoController {

    /**
     * Repositório do Serviço
     */
    private final ServicoRepositorio repoServ = PersistenceContext.repositories().servicoRepositorio();

    public Iterable<Servico> pesquisarServicoPorIdentificador(final String identificador){
        return repoServ.servicoPorIdentificador(identificador);
    }

    public Iterable<Servico> pesquisarServicoPorTitulo(final String titulo){
        return repoServ.servicoPorTitulo(titulo);
    }

    public Iterable<Servico> pesquisarServicoPorDescBreve(final String descBreve){
        return repoServ.servicoPorDescBreve(descBreve);
    }

    public Iterable<Servico> pesquisarServicoPorKeyword(final String keyword){
        return repoServ.servicoPorKeyword(keyword);
    }
}
