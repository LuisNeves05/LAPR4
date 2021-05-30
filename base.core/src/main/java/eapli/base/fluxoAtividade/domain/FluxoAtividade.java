package eapli.base.fluxoAtividade.domain;

import eapli.base.atividadeAprovacao.domain.AtividadeAprovacao;
import eapli.base.atividadeRealizacao.domain.AtividadeRealizacao;
import eapli.base.fluxoAtividade.statusFluxo.StatusFluxo;
import eapli.base.fluxoAtividade.dto.FluxoAtividadeDTO;
import eapli.base.tarefaManual.domain.TarefaManualAprovacao;
import eapli.base.tarefaManual.domain.TarefaManualExecucao;
import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    public FluxoAtividadeDTO toDTO(){
        List<TarefaManualAprovacao> tarAp = new ArrayList<>();
        
        if(this.atividadeAprovacao != null){
            tarAp = new ArrayList<>(this.atividadeAprovacao.tarefasAprovList());
        }
        
        List<TarefaManualExecucao> tarEx = new ArrayList<>(this.atividadeRealizacao.tarefaManualExecucaoList());

        if(tarAp.isEmpty()){
            return new FluxoAtividadeDTO(this.id, this.statusFluxo, tarEx.get(0).estadoRealizacao().toString());
        }

        if(tarEx.isEmpty()){
            return new FluxoAtividadeDTO(this.id, this.statusFluxo, tarAp.get(0).estadoAprov().toString());
        }

        return null;
    }
}
