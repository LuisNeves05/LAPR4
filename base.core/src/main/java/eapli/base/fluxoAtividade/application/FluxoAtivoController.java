package eapli.base.fluxoAtividade.application;

import eapli.base.Utils.HelpMethods;
import eapli.base.fluxoAtividade.domain.FluxoAtividade;
import eapli.base.fluxoAtividade.persistence.FluxoAtividadeRepositorio;
import eapli.base.infrastructure.persistence.PersistenceContext;

import java.util.ArrayList;
import java.util.List;

public class FluxoAtivoController {

    private final FluxoAtividadeRepositorio repoFluxo= PersistenceContext.repositories().fluxoAtividadeRepositorio();

    public String fluxosAtivos (){
        Iterable<FluxoAtividade> fluxoList= repoFluxo.fluxosAtivos();
        List<String> fluxo = new ArrayList<>();

        for(FluxoAtividade elem : fluxoList){
            fluxo.add(elem.toDTO().toString());
        }


        return HelpMethods.arrayToString(fluxo);
    }

    public String fluxosTotaisQueries(){
        Iterable<FluxoAtividade> fluxoList= repoFluxo.fluxosTotal();
        List<String> fluxo = new ArrayList<>();

        for(FluxoAtividade elem : fluxoList){
            fluxo.add(elem.toDTO().toString());
        }


        return HelpMethods.arrayToString(fluxo);
    }


}
