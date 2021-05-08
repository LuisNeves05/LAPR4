package eapli.base.servico.application;


import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.servico.domain.Servico;
import eapli.base.servico.persistencia.ServicoRepositorio;

import java.util.List;

public class ListarServicosController {

    private final ServicoRepositorio repoServico = PersistenceContext.repositories().servicoRepositorio();

    public List<Servico> listarServico(){
        return (List<Servico>) repoServico.findAll();
    }

}