package eapli.base.colaborador.application;

import eapli.base.colaborador.domain.Colaborador;
import eapli.base.colaborador.persistencia.ColaboradorRepositorio;
import eapli.base.infrastructure.persistence.PersistenceContext;

import java.util.List;

public class ListarColaboradoresController {

    private final ColaboradorRepositorio repoColab = PersistenceContext.repositories().colaboradorRepositorio();

    /**
     * Listar todas os Colaboradores da base de dados
     */

    public List<Colaborador> listaColaboradores(){
        return (List<Colaborador>) repoColab.findAll();
    }

}