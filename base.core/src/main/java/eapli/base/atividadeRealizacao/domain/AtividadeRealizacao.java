package eapli.base.atividadeRealizacao.domain;

import eapli.base.colaborador.domain.Colaborador;
import eapli.base.equipa.domain.Equipa;
import eapli.base.servico.domain.TipoExecucao;
import eapli.base.tarefa.domain.TarefaManual;
import eapli.base.tarefa.domain.TarefaManualExecucao;
import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class AtividadeRealizacao implements AggregateRoot<Long>, Comparable<Long>  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Colaborador colabExecucao;

    @OneToMany
    private Set<Equipa> equipasExecucao;

    @OneToMany
    private Set<TarefaManualExecucao> tarefasExecucao;

    private TipoExecucao tipoExecucao;

    public AtividadeRealizacao(TipoExecucao tipoExecucao){
        this.tarefasExecucao = new HashSet<>();
        this.equipasExecucao = new HashSet<>();
        this.tipoExecucao = tipoExecucao;
    }

    public AtividadeRealizacao(Colaborador colabExec, TipoExecucao tipoExecucao){
        this.tarefasExecucao = new HashSet<>();
        this.colabExecucao = colabExec;
        this.tipoExecucao = tipoExecucao;
    }

    protected AtividadeRealizacao() {}

    public void adicionarTarefaExecucao(TarefaManualExecucao tarExec){
        tarefasExecucao.add(tarExec);
    }

    public void adicionarEquipaExecucao(Equipa eqExec){
        equipasExecucao.add(eqExec);
    }

    public Set<Equipa> equipasExecucao(){
        return this.equipasExecucao;
    }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public Long identity() {
        return this.id;
    }

    @Override
    public String toString(){
        if(tipoExecucao == TipoExecucao.MANUAL){
        if(colabExecucao == null)
            return "Manual com realização da(s) equipa(s) -->" +  equipasExecucao.toString();
        return "Manual com realização do colaborador -->" + colabExecucao.toString();
        }else
            return "Execução automática";
    }
}
