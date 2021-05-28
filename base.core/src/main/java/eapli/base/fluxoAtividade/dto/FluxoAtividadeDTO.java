package eapli.base.fluxoAtividade.dto;

import eapli.base.fluxoAtividade.domain.StatusFluxo;
import eapli.framework.representations.dto.DTO;

@DTO
public class FluxoAtividadeDTO {

    public String id;

    public String estado;

    public FluxoAtividadeDTO(Long id, StatusFluxo estado){
        this.id = id.toString();
        this.estado = estado.toString();
    }
}
