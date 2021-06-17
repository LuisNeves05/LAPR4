package eapli.base.servico.service;

import eapli.base.atividadeAprovacao.domain.AtividadeAprovacao;
import eapli.base.atividadeAprovacao.persistence.AtividadeAprovacaoRepositorio;
import eapli.base.atividadeRealizacao.domain.AtividadeRealizacao;
import eapli.base.atividadeRealizacao.domain.TipoExecucao;
import eapli.base.atividadeRealizacao.persistence.AtividadeRealizacaoRepositorio;
import eapli.base.fluxoAtividade.builder.FluxoAtividadeBuilder;
import eapli.base.fluxoAtividade.domain.FluxoAtividade;
import eapli.base.fluxoAtividade.persistence.FluxoAtividadeRepositorio;
import eapli.base.formulario.domain.Formulario;
import eapli.base.formulario.persistencia.FormularioRepositorio;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.servico.builder.ServiceBuilder;
import eapli.base.servico.domain.Servico;

import java.util.List;

public class CriaServicoService {

    private final FormularioRepositorio formRep = PersistenceContext.repositories().formularioRepositorio();
    private final FluxoAtividadeRepositorio fluxoAtivRepositorio = PersistenceContext.repositories().fluxoAtividadeRepositorio();
    private final AtividadeAprovacaoRepositorio ativAprovRep = PersistenceContext.repositories().atividadeAprovacaoRepositorio();
    private final AtividadeRealizacaoRepositorio ativRealRep = PersistenceContext.repositories().atividadeRealizacaoRepositorio();
    private final FormularioRepositorio formularioRepositorio = PersistenceContext.repositories().formularioRepositorio();

    public Servico especificarServico(ServiceBuilder serviceBuilder, List<Formulario> formularios, FluxoAtividadeBuilder fluxoAtividadeBuilder) {

        FluxoAtividade fluxoAtividade = fluxoAtividadeBuilder.build();
        Servico serv = serviceBuilder.build();

        if (serv.fluxoDoServico() != null) {
            FluxoAtividade fluxoExistente = serv.fluxoDoServico();

            if (fluxoAtividade.ativAprovacaoDoFluxo() == null) {
                fluxoExistente.definirAtividadeAprovacao(null);
            } else {
                Formulario f = guardaFormulario(fluxoAtividade.ativAprovacaoDoFluxo().formularioAprovacao());
                fluxoAtividade.ativAprovacaoDoFluxo().adicionaFormulario(f);
                fluxoExistente.definirAtividadeAprovacao(guardaAtividadeAprovacao(fluxoAtividade.ativAprovacaoDoFluxo()));
            }
            if (fluxoAtividade.ativRealizacaoDoFluxo() == null) {
                fluxoExistente.definirAtividadeRealizacao(null);
            } else {
                if(fluxoAtividade.ativRealizacaoDoFluxo().tipoExecucao().equals(TipoExecucao.MANUAL)) {
                    Formulario f = guardaFormulario(fluxoAtividade.ativRealizacaoDoFluxo().formularioRealizacao());
                    fluxoAtividade.ativRealizacaoDoFluxo().adicionaFormulario(f);
                }
                fluxoExistente.definirAtividadeRealizacao(guardaAtividadeRealizacao(fluxoAtividade.ativRealizacaoDoFluxo()));
            }

            serviceBuilder.comFluxo(guardaFluxo(fluxoExistente));
        } else {
            AtividadeRealizacao atReal = null;
            AtividadeAprovacao atAprov = null;
            if (fluxoAtividade.ativRealizacaoDoFluxo() != null) {
                atReal = fluxoAtividade.ativRealizacaoDoFluxo();
                if(fluxoAtividade.ativRealizacaoDoFluxo().tipoExecucao().equals(TipoExecucao.MANUAL)) {
                    Formulario f = guardaFormulario(fluxoAtividade.ativRealizacaoDoFluxo().formularioRealizacao());
                    atReal.adicionaFormulario(f);
                }
                atReal = guardaAtividadeRealizacao(atReal);
            }
            if (fluxoAtividade.ativAprovacaoDoFluxo() != null) {
                Formulario f = guardaFormulario(fluxoAtividade.ativAprovacaoDoFluxo().formularioAprovacao());
                atAprov = fluxoAtividade.ativAprovacaoDoFluxo();
                atAprov.adicionaFormulario(f);
                atAprov = guardaAtividadeAprovacao(atAprov);
            }
            if(fluxoAtividade.ativRealizacaoDoFluxo() != null || fluxoAtividade.ativRealizacaoDoFluxo() != null)
                serviceBuilder.comFluxo(guardaFluxo(new FluxoAtividade(atAprov, atReal)));
        }
        Servico servv = serviceBuilder.build();

        if(!formularios.isEmpty())
        for (Formulario formulario : formularios) {
            adicionaFormulario(servv, guardaFormulario(formulario));
        }

        return servv;
    }

    public Formulario guardaFormulario(Formulario formulario) {
        return formRep.save(formulario);
    }

    public FluxoAtividade guardaFluxo(FluxoAtividade fluxoAtividade) {
        return fluxoAtivRepositorio.save(fluxoAtividade);
    }

    public AtividadeRealizacao guardaAtividadeRealizacao(AtividadeRealizacao atividadeRealizacao) {
        return ativRealRep.save(atividadeRealizacao);
    }

    public AtividadeAprovacao guardaAtividadeAprovacao(AtividadeAprovacao atividadeAprovacao) {
        return ativAprovRep.save(atividadeAprovacao);
    }

    public void removerAtividadeRealizacao(AtividadeRealizacao ativRealizacaoDoFluxo) {
        ativRealRep.removePeloID(ativRealizacaoDoFluxo);
    }

    public void removerAtividadeAprovacao(AtividadeAprovacao atividadeAprovacao) {
        ativAprovRep.removePeloID(atividadeAprovacao);
    }

    public void removeFormulario(Formulario form){
        formularioRepositorio.removePeloID(form);
    }

    public void adicionaFormulario(Servico s, Formulario formulario){
        s.adicionaFormulario(formulario);
    }
}
