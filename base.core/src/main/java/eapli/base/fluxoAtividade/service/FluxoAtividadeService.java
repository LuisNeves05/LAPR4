package eapli.base.fluxoAtividade.service;

import eapli.base.fluxoAtividade.domain.FluxoAtividade;
import eapli.base.fluxoAtividade.persistence.FluxoAtividadeRepositorio;
import eapli.base.infrastructure.persistence.PersistenceContext;

import java.util.List;

public class FluxoAtividadeService {

    public String dashboardData() {
        FluxoAtividadeRepositorio repoFluxosRepo = PersistenceContext.repositories().fluxoAtividadeRepositorio();

        StringBuilder stringData = new StringBuilder();
        List<FluxoAtividade> repoFluxos = (List<FluxoAtividade>) repoFluxosRepo.fluxosTotal();


        for (FluxoAtividade elems : repoFluxos) {
            stringData.append(elems.toDTO().toString());
        }


        //System.out.println(stringData.toString());
        return stringData.toString();
    }
}
