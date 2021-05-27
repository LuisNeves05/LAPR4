package eapli.base.fluxoAtividade.domain;

import com.sun.istack.NotNull;
import com.sun.istack.Nullable;
import eapli.base.atividadeAprovacao.domain.AtividadeAprovacao;
import eapli.base.atividadeRealizacao.domain.AtividadeRealizacao;
import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;

@Entity
public class FluxoAtividade implements AggregateRoot<Long>, Comparable<Long> {

    @Id
    private Long id;

    @OneToOne
    @Nullable
    private AtividadeAprovacao atividadeAprovacao;

    @OneToOne
    @NotNull
    private AtividadeRealizacao atividadeRealizacao;

    protected FluxoAtividade(){}

    public FluxoAtividade(AtividadeRealizacao atividadeRealizacao){
        this.atividadeRealizacao = atividadeRealizacao;
    }

    public FluxoAtividade(AtividadeAprovacao atividadeAprovacao, AtividadeRealizacao atividadeRealizacao) {
        this.atividadeAprovacao = atividadeAprovacao;
        this.atividadeRealizacao = atividadeRealizacao;
    }

    public AtividadeRealizacao ativRealizacaoDoFluxo(){
        return this.atividadeRealizacao;
    }

    public AtividadeAprovacao ativAprovacaoDoFluxo(){
        return this.atividadeAprovacao;
    }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public Long identity() {
        return this.id;
    }
}
