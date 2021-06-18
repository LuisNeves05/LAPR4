package eapli.base.fluxoAtividade.dto;

import eapli.base.atividadeAprovacao.domain.AtividadeAprovacao;
import eapli.base.fluxoAtividade.domain.StatusFluxo;
import eapli.framework.representations.dto.DTO;

@DTO
public class FluxoAtividadeDTO {

    public String id;

    public String estado;

    public String estaApr;

    public String estaRes;

    public FluxoAtividadeDTO(String id, String estado, String estaApr, String estaRes) {
        this.id = id;
        this.estado = estado;
        this.estaApr = estaApr;
        this.estaRes = estaRes;
    }

    public FluxoAtividadeDTO(Long id, StatusFluxo estado, String estaRes){
        this.id = id.toString();
        this.estado = estado.toString();
        this.estaRes = estaRes;
    }

    public FluxoAtividadeDTO(Long id, StatusFluxo estado, AtividadeAprovacao estaApr, String realizao){
        this.id = id.toString();
        this.estado = estado.toString();
        if(estaApr == null){
            this.estaApr = "[NAO TEM APROVACAO]";
        }else{
            this.estaApr = estaApr.toString();
        }

        this.estaRes = realizao.toString();
    }


    @Override
    public String toString() {
        if(this.estaApr == null){
            return  id + "!" + estado + "!" + this.estaRes;
        }

        return id + "!" + estado + "!" + this.estaApr + "!" + this.estaRes + ";";

    }
}
