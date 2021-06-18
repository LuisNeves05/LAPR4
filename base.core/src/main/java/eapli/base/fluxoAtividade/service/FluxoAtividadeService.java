package eapli.base.fluxoAtividade.service;

import eapli.base.fluxoAtividade.domain.FluxoAtividade;
import eapli.base.fluxoAtividade.persistence.FluxoAtividadeRepositorio;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.framework.domain.repositories.TransactionalContext;

import java.util.List;

public class FluxoAtividadeService {

    private final TransactionalContext txCtx = PersistenceContext.repositories().newTransactionalContext();


    public String dashboardData() {

        txCtx.beginTransaction();
        FluxoAtividadeRepositorio repoFluxosRepo = PersistenceContext.repositories().fluxoAtividadeRepositorio();



        StringBuilder stringData = new StringBuilder();
        //List<FluxoAtividade> repoFluxos = (List<FluxoAtividade>) repoFluxosRepo.fluxosTotal();


        for (FluxoAtividade elems : repoFluxosRepo.fluxosTotal()) {
            stringData.append(elems.toDTO().toString());
        }

        txCtx.commit();
        txCtx.close();

        //System.out.println(stringData.toString());
        return stringData.toString();
    }
}
