package eapli.base.fluxoAtividade.builder;

import eapli.base.atividadeAprovacao.domain.AtividadeAprovacao;
import eapli.base.atividadeRealizacao.domain.AtividadeRealizacao;
import eapli.base.fluxoAtividade.domain.FluxoAtividade;
import eapli.framework.domain.model.DomainFactory;

public class FluxoAtividadeBuilder implements DomainFactory<FluxoAtividade> {

    private AtividadeAprovacao ativAprov;

    private AtividadeRealizacao ativReal;

    public FluxoAtividadeBuilder(){}

    public FluxoAtividadeBuilder comAtividadeAprovacao(final AtividadeAprovacao ativAprov) {
        this.ativAprov = ativAprov;
        return this;
    }

    public FluxoAtividadeBuilder comAtividadeRealizacao(final AtividadeRealizacao ativReal) {
        this.ativReal = ativReal;
        return this;
    }

    /**
     * Criação da instância Serviço
     */
    @Override
    public FluxoAtividade build() {
        // since the factory knows that all the parts are needed it could throw
        // an exception. however, we will leave that to the constructor
        if(this.ativAprov == null)
            return new FluxoAtividade(ativReal);
        else
            return new FluxoAtividade(ativAprov, ativReal);
    }
}
