package eapli.base.atividadeRealizacao.domain;

import com.sun.istack.Nullable;
import eapli.base.colaborador.domain.Colaborador;
import eapli.base.equipa.domain.Equipa;
import eapli.base.formulario.domain.Formulario;
import eapli.base.tarefaAutomatica.domain.TarefaAutomatica;
import eapli.base.tarefaManualExecucao.domain.TarefaManualExecucao;
import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class AtividadeRealizacao implements AggregateRoot<Long>, Comparable<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Colaborador colabExecucao;

    @ManyToMany
    private Set<Equipa> equipasExecucao;

    @OneToMany
    private Set<TarefaManualExecucao> tarefasManualExecucao;


    @OneToMany
    private Set<TarefaAutomatica> tarefasAutomaticas;

    @Enumerated(EnumType.STRING)
    private TipoExecucao tipoExecucao;

    @Nullable
    private String scriptAutomatico;

    @OneToMany
    private Set<Formulario> formularios;

    public AtividadeRealizacao(TipoExecucao tipoExecucao, String scriptAutomatico) {
        this.tipoExecucao = tipoExecucao;
        if (this.tipoExecucao == TipoExecucao.AUTOMATICA) {
            this.tarefasAutomaticas = new HashSet<>();
            this.scriptAutomatico = scriptAutomatico;
        } else {
            formularios = new HashSet<>();
            this.equipasExecucao = new HashSet<>();
            this.tarefasManualExecucao = new HashSet<>();

        }
    }

    public AtividadeRealizacao(Colaborador colabExec, TipoExecucao tipoExecucao, String ignore) {
        this.tarefasManualExecucao = new HashSet<>();
        this.colabExecucao = colabExec;
        this.tipoExecucao = tipoExecucao;
        formularios = new HashSet<>();
    }

    protected AtividadeRealizacao() {
    }

    public void adicionarTarefaExecucao(TarefaManualExecucao tarExec) {
        tarefasManualExecucao.add(tarExec);
    }

    public void adicionarEquipaExecucao(Equipa eqExec) {
        equipasExecucao.add(eqExec);
    }

    public void adicionarTarefaAutomatica(TarefaAutomatica tarefaAutomatica) {
        tarefasAutomaticas.add(tarefaAutomatica);
    }

    public void adicionaFormulario(Formulario f) {
        if (!this.formularios.contains(f)) {
            formularios.add(f);
        }
    }

    public Set<Equipa> equipasExecucao() {
        return this.equipasExecucao;
    }

    public Colaborador colabExec() {
        return this.colabExecucao;
    }

    public TipoExecucao tipoExecucao() {
        return tipoExecucao;
    }

    public String scriptAutomatico() {
        return scriptAutomatico;
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
    public String toString() {
        if (tipoExecucao == TipoExecucao.MANUAL) {
            if (colabExecucao == null)
                return "Manual com realização da(s) equipa(s) -->" + equipasExecucao.toString();
            return "Manual com realização do colaborador -->" + colabExecucao.toString();
        } else
            return "Execução automática";
    }

    public Set<TarefaManualExecucao> tarefaManualExecucaoList() {
        return tarefasManualExecucao;
    }
}
