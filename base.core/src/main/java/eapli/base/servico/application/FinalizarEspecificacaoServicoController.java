package eapli.base.servico.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.servico.domain.Servico;
import eapli.base.servico.persistencia.ServicoRepositorio;

import java.util.List;

public class FinalizarEspecificacaoServicoController {

    private final ServicoRepositorio servRep = PersistenceContext.repositories().servicoRepositorio();

    public List<Servico> servicosIncompletos() {
        return servRep.servicosIncompletos();
    }

    public Servico guardarServico(Servico servico){
        return servRep.save(servico);
    }
}
