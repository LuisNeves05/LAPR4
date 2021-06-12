package eapli.base.fluxoAtividade.service;

import eapli.base.colaborador.domain.Colaborador;
import eapli.base.fluxoAtividade.domain.FluxoAtividade;
import eapli.base.fluxoAtividade.persistence.FluxoAtividadeRepositorio;
import eapli.base.infrastructure.persistence.PersistenceContext;

import java.util.List;

public class FluxoAtividadeService {

    private final FluxoAtividadeRepositorio repoFluxosRepo = PersistenceContext.repositories().fluxoAtividadeRepositorio();


    public String dashboardData(){
        StringBuilder stringData = new StringBuilder();
        List<FluxoAtividade> repoFluxos = (List<FluxoAtividade>) repoFluxosRepo.fluxosTotal();

        for(FluxoAtividade elems : repoFluxos){
            stringData.append(elems.toDTO().toString());
        }


        System.out.println(stringData.toString());
        return stringData.toString();
    }
}
