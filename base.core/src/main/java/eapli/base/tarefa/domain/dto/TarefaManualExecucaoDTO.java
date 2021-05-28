package eapli.base.tarefa.domain.dto;

import eapli.base.colaborador.domain.Colaborador;
import eapli.base.equipa.domain.Equipa;
import eapli.base.tarefa.domain.estado.EstadoRealizacao;
import eapli.framework.representations.dto.DTO;

import java.util.ArrayList;
import java.util.List;

@DTO
public class TarefaManualExecucaoDTO {
    public String id;

    public String estadoRealizacao;

    public String colabExecuta;

    public List<String> equipasExecuta = new ArrayList<>();

    public TarefaManualExecucaoDTO(Long id, EstadoRealizacao estadoRealizacao,List<Equipa> equipasExecuta){
        this.id = id.toString();
        this.estadoRealizacao = estadoRealizacao.toString();
        for(Equipa eq : equipasExecuta)
            this.equipasExecuta.add(eq.identity().toString());
    }

    public TarefaManualExecucaoDTO(Long id, EstadoRealizacao estadoRealizacao, Colaborador colabExecuta){
        this.id = id.toString();
        this.estadoRealizacao = estadoRealizacao.toString();
        this.colabExecuta = colabExecuta.identity().toString();
    }
}
