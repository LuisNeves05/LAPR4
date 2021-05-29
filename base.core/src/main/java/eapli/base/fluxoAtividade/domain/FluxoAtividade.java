package eapli.base.fluxoAtividade.domain;

import eapli.base.atividadeAprovacao.domain.AtividadeAprovacao;
import eapli.base.atividadeRealizacao.domain.AtividadeRealizacao;
import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;

@Entity
public class FluxoAtividade implements AggregateRoot<Long>, Comparable<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private AtividadeAprovacao atividadeAprovacao;

    @OneToOne(cascade = CascadeType.ALL)
    private AtividadeRealizacao atividadeRealizacao;

    @Enumerated(EnumType.STRING)
    private StatusFluxo statusFluxo;

    protected FluxoAtividade(){}

    public FluxoAtividade(AtividadeRealizacao atividadeRealizacao){
        this.atividadeRealizacao = atividadeRealizacao;
        this.statusFluxo = StatusFluxo.INATIVO;
    }

    public FluxoAtividade(AtividadeAprovacao atividadeAprovacao, AtividadeRealizacao atividadeRealizacao) {
        this.atividadeAprovacao = atividadeAprovacao;
        this.atividadeRealizacao = atividadeRealizacao;
        this.statusFluxo = StatusFluxo.INATIVO;
    }

    public AtividadeRealizacao ativRealizacaoDoFluxo(){
        return this.atividadeRealizacao;
    }

    public AtividadeAprovacao ativAprovacaoDoFluxo(){
        return this.atividadeAprovacao;
    }

    public void ativar(){
        this.statusFluxo = StatusFluxo.ATIVO;
    }

    public void desativar(){
        this.statusFluxo = StatusFluxo.INATIVO;
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
