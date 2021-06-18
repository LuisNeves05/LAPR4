package eapli.base.fluxoAtividade.service;

import eapli.base.fluxoAtividade.domain.FluxoAtividade;
import eapli.base.fluxoAtividade.domain.StatusFluxo;
import eapli.base.fluxoAtividade.persistence.FluxoAtividadeRepositorio;
import eapli.base.infrastructure.persistence.PersistenceContext;

public class AtivarDesativarFluxoService {

    private final FluxoAtividadeRepositorio fluxoAtividadeRepositorio = PersistenceContext.repositories().fluxoAtividadeRepositorio();

    public boolean ativarFluxo(FluxoAtividade fluxoAtividade){
        if(fluxoAtividade.estadoFluxo() == StatusFluxo.INATIVO) {
            fluxoAtividade.ativar();
            fluxoAtividadeRepositorio.save(fluxoAtividade);
            return true;
        }
        return false;
    }

    public boolean desativarFluxo(FluxoAtividade fluxoAtividade){
        if(fluxoAtividade.estadoFluxo() == StatusFluxo.ATIVO) {
            fluxoAtividade.desativar();
            fluxoAtividadeRepositorio.save(fluxoAtividade);
            return true;
        }
        return false;
    }


}
