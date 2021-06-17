package eapli.base.atividadeAprovacao.service;

import eapli.base.atividadeAprovacao.domain.AtividadeAprovacao;
import eapli.base.atividadeAprovacao.domain.ColaboradoresAprovacao;
import eapli.base.fluxoAtividade.builder.FluxoAtividadeBuilder;
import eapli.base.formulario.domain.Formulario;

import java.util.List;

public class CriarAtividadeAprovacaoService {


    public void fluxoComAtividadeAprovacao(FluxoAtividadeBuilder fluxoAtivBuilder, List<ColaboradoresAprovacao> colabsAprov, Formulario form) {
        AtividadeAprovacao atividadeAprovacao = new AtividadeAprovacao();
        atividadeAprovacao.adicionaFormulario(form);
        for (ColaboradoresAprovacao ca : colabsAprov)
            atividadeAprovacao.adicionaColabAprov(ca);
        fluxoAtivBuilder.comAtividadeAprovacao(atividadeAprovacao);
    }
}
