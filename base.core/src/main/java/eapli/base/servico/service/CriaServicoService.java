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
import eapli.framework.domain.repositories.TransactionalContext;

import java.util.List;

public class CriaServicoService {

    private final FormularioRepositorio formRep = PersistenceContext.repositories().formularioRepositorio();
    private final FluxoAtividadeRepositorio fluxoAtivRepositorio = PersistenceContext.repositories().fluxoAtividadeRepositorio();
    private final AtividadeAprovacaoRepositorio ativAprovRep = PersistenceContext.repositories().atividadeAprovacaoRepositorio();
    private final AtividadeRealizacaoRepositorio ativRealRep = PersistenceContext.repositories().atividadeRealizacaoRepositorio();

    public Servico especificarServico(ServiceBuilder serviceBuilder, List<Formulario> formularios, FluxoAtividadeBuilder fluxoAtividadeBuilder) {

        FluxoAtividade fluxoAtividade = fluxoAtividadeBuilder.build();
        Servico serv = serviceBuilder.build();

        if (serv.fluxoDoServico() != null) {
            FluxoAtividade fluxoExistente = serv.fluxoDoServico();

            if (fluxoAtividade.ativAprovacaoDoFluxo() == null) {
                fluxoExistente.comAtividadeAprovacao(null);
            } else {
                Formulario f = formRep.save(fluxoAtividade.ativAprovacaoDoFluxo().formularioAprovacao());
                fluxoAtividade.ativAprovacaoDoFluxo().adicionaFormulario(f);
                fluxoExistente.comAtividadeAprovacao(ativAprovRep.save(fluxoAtividade.ativAprovacaoDoFluxo()));
            }
            if (fluxoAtividade.ativRealizacaoDoFluxo() == null) {
                fluxoExistente.comAtividadeRealizacao(null);
            } else {
                if(fluxoAtividade.ativRealizacaoDoFluxo().tipoExecucao().equals(TipoExecucao.MANUAL)) {
                    Formulario f = formRep.save(fluxoAtividade.ativRealizacaoDoFluxo().formularioRealizacao());
                    fluxoAtividade.ativRealizacaoDoFluxo().adicionaFormulario(f);
                }
                fluxoExistente.comAtividadeRealizacao(ativRealRep.save(fluxoAtividade.ativRealizacaoDoFluxo()));
            }

            serviceBuilder.comFluxo(fluxoAtivRepositorio.save(fluxoExistente));
        } else {
            AtividadeRealizacao atReal = null;
            AtividadeAprovacao atAprov = null;
            if (fluxoAtividade.ativRealizacaoDoFluxo() != null) {
                atReal = fluxoAtividade.ativRealizacaoDoFluxo();
                if(fluxoAtividade.ativRealizacaoDoFluxo().tipoExecucao().equals(TipoExecucao.MANUAL)) {
                    Formulario f = formRep.save(fluxoAtividade.ativRealizacaoDoFluxo().formularioRealizacao());
                    atReal.adicionaFormulario(f);
                }
                atReal = ativRealRep.save(atReal);
            }
            if (fluxoAtividade.ativAprovacaoDoFluxo() != null) {
                Formulario f = formRep.save(fluxoAtividade.ativAprovacaoDoFluxo().formularioAprovacao());
                atAprov = fluxoAtividade.ativAprovacaoDoFluxo();
                atAprov.adicionaFormulario(f);
                atAprov = ativAprovRep.save(atAprov);
            }
            if(fluxoAtividade.ativRealizacaoDoFluxo() != null || fluxoAtividade.ativRealizacaoDoFluxo() != null)
                serviceBuilder.comFluxo(fluxoAtivRepositorio.save(new FluxoAtividade(atAprov, atReal)));
        }
        Servico servv = serviceBuilder.build();

        if(!formularios.isEmpty())
        for (Formulario formulario : formularios) {
            servv.adicionaFormulario(formRep.save(formulario));
        }

        return servv;
    }
}
