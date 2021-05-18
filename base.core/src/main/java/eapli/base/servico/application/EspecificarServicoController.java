package eapli.base.servico.application;

import eapli.base.catalogo.domain.Catalogo;
import eapli.base.catalogo.persistencia.CatalogoRepositorio;
import eapli.base.formulario.domain.Formulario;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.servico.domain.Keyword;
import eapli.base.servico.domain.ServiceBuilder;
import eapli.base.servico.domain.Servico;
import eapli.base.servico.persistencia.ServicoRepositorio;

import java.util.List;
import java.util.Set;

/**
 * Classe Controller da Especificação de um Serviço
 */
public class EspecificarServicoController {

    /**
     * Repositório do Serviço
     */
    private final ServicoRepositorio repoServ = PersistenceContext.repositories().servicoRepositorio();
    private final CatalogoRepositorio repoCat = PersistenceContext.repositories().catalogoRepositorio();

    /**
     * Especificação de um novo Serviço
     */
    public Servico especificarServico(Servico servico) {
       return this.repoServ.save(servico);
    }

    public Iterable<Servico> servivoExistente(String identificador, Catalogo catalogo){
        return repoServ.servicoPorIdentificadorCatalogo(identificador, catalogo);
    }

    /**
     * Listar todas os Catalogos da base de dados
     */
    public Iterable<Catalogo> listaCatalogos() {
        return repoCat.findAll();
    }

    public void adicionaFormulario(Servico s, Formulario formulario){
        s.adicionaFormulario(formulario);
        repoServ.save(s);
        s.limpaForms();
    }

    public List<Servico> servicosIncompletos() {
        return null;
    }
}
