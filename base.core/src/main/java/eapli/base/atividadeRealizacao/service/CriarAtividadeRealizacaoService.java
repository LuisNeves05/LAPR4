package eapli.base.atividadeRealizacao.service;

import eapli.base.atividadeRealizacao.domain.AtividadeRealizacao;
import eapli.base.atividadeRealizacao.domain.TipoExecucao;
import eapli.base.colaborador.domain.Colaborador;
import eapli.base.equipa.domain.Equipa;
import eapli.base.fluxoAtividade.builder.FluxoAtividadeBuilder;
import eapli.base.formulario.domain.Formulario;

import java.util.List;

public class CriarAtividadeRealizacaoService {

    public void fluxoComAtividadeRealizacaoEquipas(FluxoAtividadeBuilder fluxoAtivBuilder, List<Equipa> equipasExec, Formulario form) {
        AtividadeRealizacao ativRealizacao = new AtividadeRealizacao();
        ativRealizacao.adicionaFormulario(form);
        for (Equipa eq : equipasExec)
            ativRealizacao.adicionarEquipaExecucao(eq);
        fluxoAtivBuilder.comAtividadeRealizacao(ativRealizacao);
    }

    public void fluxoComAtividadeRealizacaoColaborador(FluxoAtividadeBuilder fluxoAtivBuilder, Colaborador colab, TipoExecucao tipoExec, Formulario form) {
        AtividadeRealizacao ativRealizacao = new AtividadeRealizacao(colab, tipoExec);
        ativRealizacao.adicionaFormulario(form);
        fluxoAtivBuilder.comAtividadeRealizacao(ativRealizacao);
    }

    public void fluxoComAtividadeRealizacaoAutomatica(FluxoAtividadeBuilder fluxoAtivBuilder, String scriptAutomatico) {
        AtividadeRealizacao ativRealizacao = new AtividadeRealizacao(scriptAutomatico);
        fluxoAtivBuilder.comAtividadeRealizacao(ativRealizacao);
    }
}
