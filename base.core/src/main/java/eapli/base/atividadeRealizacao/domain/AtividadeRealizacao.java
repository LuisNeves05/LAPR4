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

    @Enumerated(EnumType.STRING)
    private TipoExecucao tipoExecucao;

    @Nullable
    private String scriptAutomatico;

    @OneToOne
    private Formulario formulario;

    public AtividadeRealizacao(String scriptAutomatico) {
        this.tipoExecucao = TipoExecucao.AUTOMATICA;
        this.scriptAutomatico = scriptAutomatico;
    }

    public AtividadeRealizacao() {
        this.tipoExecucao = TipoExecucao.MANUAL;
        this.equipasExecucao = new HashSet<>();
    }

    public AtividadeRealizacao(Colaborador colabExec, TipoExecucao tipoExecucao) {
        this.colabExecucao = colabExec;
        this.tipoExecucao = tipoExecucao;
    }

    public void adicionarEquipaExecucao(Equipa eqExec) {
        equipasExecucao.add(eqExec);
    }

    public void adicionaFormulario(Formulario f) {
        this.formulario = f;
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

    public Formulario formularioRealizacao() {
        return formulario;
    }
}
