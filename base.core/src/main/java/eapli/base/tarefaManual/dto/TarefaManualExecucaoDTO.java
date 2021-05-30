package eapli.base.tarefaManual.dto;

import eapli.base.colaborador.domain.Colaborador;
import eapli.base.equipa.domain.Equipa;
import eapli.base.tarefaManual.domain.estado.EstadoRealizacao;
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

    public TarefaManualExecucaoDTO(Long id, EstadoRealizacao estadoRealizacao, Colaborador colabExecuta, String ignore){
        this.id = id.toString();
        this.estadoRealizacao = estadoRealizacao.toString();
        this.colabExecuta = colabExecuta.identity().toString();
    }


    public static String arrayToString(List<String> array){
        StringBuilder sb = new StringBuilder();
        sb.append("(");

        for(String elem : array){
            sb.append(elem);
            sb.append(",");
        }

        StringBuilder sb1 = new StringBuilder();
        sb1.append(sb.substring(0,sb.length()-1));
        sb1.append(")");
        

        return String.valueOf(sb1);
    }

    @Override
    public String toString() {
        return "[" + id  + "!" + estadoRealizacao + "!"+ colabExecuta + "!" + arrayToString(equipasExecuta) +"]";
    }
}
