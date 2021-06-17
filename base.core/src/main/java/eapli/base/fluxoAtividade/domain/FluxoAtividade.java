package eapli.base.fluxoAtividade.domain;

import eapli.base.atividadeAprovacao.domain.AtividadeAprovacao;
import eapli.base.atividadeRealizacao.domain.AtividadeRealizacao;
import eapli.base.fluxoAtividade.dto.FluxoAtividadeDTO;
import eapli.base.tarefaManualAprovacao.domain.TarefaManualAprovacao;
import eapli.base.tarefaManualExecucao.domain.TarefaManualExecucao;
import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class FluxoAtividade implements AggregateRoot<Long>, Comparable<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private AtividadeAprovacao atividadeAprovacao;

    @OneToOne
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

    public StatusFluxo estadoFluxo(){
        return this.statusFluxo;
    }

    public void comAtividadeRealizacao(AtividadeRealizacao atividadeRealizacao){
        this.atividadeRealizacao = atividadeRealizacao;
    }

    public void comAtividadeAprovacao(AtividadeAprovacao atividadeAprovacao){
        this.atividadeAprovacao = atividadeAprovacao;
    }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public Long identity() {
        return this.id;
    }

    public FluxoAtividadeDTO toDTO(){
        return new FluxoAtividadeDTO(this.id, this.statusFluxo, this.atividadeAprovacao, this.atividadeRealizacao.tipoExecucao().toString());
    }

    @Override
    public String toString() {
        return "FluxoAtividade{" +
                "id=" + id +
                ", atividadeAprovacao=" + atividadeAprovacao +
                ", atividadeRealizacao=" + atividadeRealizacao +
                ", statusFluxo=" + statusFluxo +
                '}';
    }
}
