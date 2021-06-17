package eapli.base.fluxoAtividade.service;

import eapli.base.fluxoAtividade.domain.FluxoAtividade;
import eapli.base.fluxoAtividade.domain.StatusFluxo;
import eapli.base.fluxoAtividade.persistence.FluxoAtividadeRepositorio;
import eapli.base.infrastructure.persistence.PersistenceContext;

public class AtivarDesativarFluxoService {

    private final FluxoAtividadeRepositorio fluxoAtividadeRepositorio = PersistenceContext.repositories().fluxoAtividadeRepositorio();

    public FluxoAtividade ativarFluxo(FluxoAtividade fluxoAtividade){
        if(fluxoAtividade.estadoFluxo() == StatusFluxo.INATIVO)
            fluxoAtividade.ativar();
        return fluxoAtividadeRepositorio.save(fluxoAtividade);
    }

    public FluxoAtividade desativarFluxo(FluxoAtividade fluxoAtividade){
        if(fluxoAtividade.estadoFluxo() == StatusFluxo.ATIVO)
            fluxoAtividade.desativar();
        return fluxoAtividadeRepositorio.save(fluxoAtividade);
    }
}
