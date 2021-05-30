package eapli.base.fluxoAtividade.dto;

import eapli.base.fluxoAtividade.domain.StatusFluxo;
import eapli.framework.representations.dto.DTO;

@DTO
public class FluxoAtividadeDTO {

    public String id;

    public String estado;

    public String estaApr;

    public String estaRes;

    public FluxoAtividadeDTO(Long id, StatusFluxo estado, String estaRes){
        this.id = id.toString();
        this.estado = estado.toString();
        this.estaRes = estaRes;
    }

    public FluxoAtividadeDTO(Long id, StatusFluxo estado, String estaApr, String ignore){
        this.id = id.toString();
        this.estado = estado.toString();
        this.estaApr = estaApr;
    }

    @Override
    public String toString() {
        if(this.estaApr == null){
            return "[" + id + "!" + estado + "!" + this.estaRes + "]";
        }

        return "[" + id + "!" + estado + "!" + this.estaApr + "!" + this.estaRes + "]";

    }
}
