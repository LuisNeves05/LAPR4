package eapli.base.servico.application;

import eapli.base.catalogo.domain.Catalogo;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.servico.domain.Servico;
import eapli.base.servico.persistencia.ServicoRepositorio;

import java.util.List;

public class PesquisarServicoController {

    /**
     * Repositório do Serviço
     */
    private final ServicoRepositorio repoServ = PersistenceContext.repositories().servicoRepositorio();

    public List<Servico> pesquisarServicoPorIdentificador(final String identificador, final Catalogo catalogo){
        return repoServ.servicoPorIdentificador(identificador, catalogo);
    }

    public List<Servico> pesquisarServicoPorTitulo(final String titulo, final Catalogo catalogo){
        return repoServ.servicoPorTitulo(titulo, catalogo);
    }

    public List<Servico> pesquisarServicoPorDescBreve(final String descBreve, final Catalogo catalogo){
        return repoServ.servicoPorDescBreve(descBreve, catalogo);
    }

    public List<Servico> pesquisarServicoPorKeyword(final String keyword, final Catalogo catalogo){
        return repoServ.servicoPorKeyword(keyword, catalogo);
    }
}
