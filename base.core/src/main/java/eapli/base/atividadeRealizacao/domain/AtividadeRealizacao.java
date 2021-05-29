package eapli.base.atividadeRealizacao.domain;

import com.sun.istack.Nullable;
import eapli.base.colaborador.domain.Colaborador;
import eapli.base.equipa.domain.Equipa;
import eapli.base.servico.domain.TipoExecucao;
import eapli.base.tarefa.domain.TarefaAutomatica;
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

    @OneToMany(cascade = CascadeType.ALL)
    private Set<TarefaManualExecucao> tarefasManualExecucao;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<TarefaAutomatica> tarefasAutomaticas;

    @Enumerated(EnumType.STRING)
    private TipoExecucao tipoExecucao;

    @Nullable
    private String scriptAutomatico;

    public AtividadeRealizacao(TipoExecucao tipoExecucao, String scriptAutomatico){
        this.tarefasAutomaticas = new HashSet<>();
        this.equipasExecucao = new HashSet<>();
        this.tipoExecucao = tipoExecucao;
        if(tipoExecucao == TipoExecucao.AUTOMATICA)
            this.scriptAutomatico = scriptAutomatico;
    }

    public AtividadeRealizacao(Colaborador colabExec, TipoExecucao tipoExecucao, String scriptAutomatico){
        this.tarefasManualExecucao = new HashSet<>();
        this.colabExecucao = colabExec;
        this.tipoExecucao = tipoExecucao;
        if(tipoExecucao == TipoExecucao.AUTOMATICA)
            this.scriptAutomatico = scriptAutomatico;
    }

    protected AtividadeRealizacao() {}

    public void adicionarTarefaExecucao(TarefaManualExecucao tarExec){
        tarefasManualExecucao.add(tarExec);
    }

    public void adicionarEquipaExecucao(Equipa eqExec){
        equipasExecucao.add(eqExec);
    }

    public void adicionarTarefaAutomatica(TarefaAutomatica tarefaAutomatica){
        tarefasAutomaticas.add(tarefaAutomatica);
    }

    public Set<Equipa> equipasExecucao(){
        return this.equipasExecucao;
    }

    public Colaborador colabExec(){return this.colabExecucao;}

    public TipoExecucao tipoExecucao(){return tipoExecucao;}

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
