package eapli.base.app.common.console.presentation.solicitarservicoUI;

import eapli.base.atividadeAprovacao.domain.AtividadeAprovacao;
import eapli.base.atividadeAprovacao.domain.ColaboradoresAprovacao;
import eapli.base.atividadeRealizacao.domain.AtividadeRealizacao;
import eapli.base.catalogo.domain.Catalogo;
import eapli.base.colaborador.domain.Colaborador;
import eapli.base.equipa.domain.Equipa;
import eapli.base.formulario.domain.Atributo;
import eapli.base.formulario.domain.Formulario;
import eapli.base.formulario.domain.TipoDados;
import eapli.base.formularioPreenchido.domain.FormularioPreenchido;
import eapli.base.formularioPreenchido.domain.Resposta;
import eapli.base.servico.application.SolicitarServicoController;
import eapli.base.servico.domain.Servico;
import eapli.base.servico.domain.TipoExecucao;
import eapli.base.tarefa.domain.TarefaAutomatica;
import eapli.base.tarefa.domain.TarefaManual;
import eapli.base.tarefa.domain.TarefaManualAprovacao;
import eapli.base.tarefa.domain.TarefaManualExecucao;
import eapli.base.tarefa.domain.estado.EstadoRealizacao;
import eapli.base.ticket.domain.EstadoTicket;
import eapli.base.ticket.domain.Ticket;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.UserSession;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SolicitarServicoUI extends AbstractUI {

    private final SolicitarServicoController lcp = new SolicitarServicoController();

    private final AuthorizationService authorizationService = AuthzRegistry.authorizationService();
    private final UserSession userSession = authorizationService.session().get();
    private final SystemUser systemUser = userSession.authenticatedUser();
    private final Colaborador colabPedido = lcp.colabPorUserName(systemUser.username());

    @Override
    protected boolean doShow() {

        List<Catalogo> catalogoList = lcp.listarCatalogosPorUser();

        for (int i = 0; i < catalogoList.size(); i++) {
            System.out.println(i + " - " + catalogoList.get(i).toString());
        }

        int indCatalogo = Console.readInteger("Escolha o catalogo a que pretende aceder (index)");

        Catalogo c = catalogoList.get(indCatalogo);

        List<Servico> servicoList = lcp.listarServicosPorCat(c); //TODO METER ISTO A RETORNAR SERVIÇOS COMPLETOS

        for (int i = 0; i < servicoList.size(); i++) {
            System.out.println(i + " - " + servicoList.get(i).toString());
        }

        int indServico = Console.readInteger("Escolha o servico que pretende requisitar (index)");

        Servico s = servicoList.get(indServico);

        System.out.println("\nTendo o serviço sido escolhido, vai agora ter de preencher os respetivos formulários\n");

        List<Formulario> formularioList = lcp.formulariosServico(s);

        String urgencia = Console.readLine("\nQual a urgência deste serviço?  (baixa | moderada | alta)");

        Set<FormularioPreenchido> fps = new HashSet<>();
        for (Formulario f : formularioList) {
            System.out.println("\nFormulario " + f.name() + "\n");

            Set<Resposta> respostas = new HashSet<>();
            Set<Atributo> a = f.atributos();

            for (Atributo atributo : a) {
                TipoDados td = atributo.tipoDados();
                String ajudaResposta = tipoDadosStr(td);
                String resposta = Console.readLine(atributo.nomeVar() + ": " + "    Responda conforme -> " + ajudaResposta);
                Resposta rAtr = new Resposta(resposta, atributo.nomeVar());
                respostas.add(rAtr);
            }

            FormularioPreenchido fp = new FormularioPreenchido(f, urgencia, respostas, s, colabPedido);
            fps.add(fp);

            lcp.saveFormPreenchido(fp);
        }

        Ticket ticket = new Ticket(colabPedido, s, s.nivelCriticidadeServico(), urgencia, EstadoTicket.POR_APROVAR);

        AtividadeRealizacao ar = s.fluxoDoServico().ativRealizacaoDoFluxo();
        AtividadeAprovacao at = s.fluxoDoServico().ativAprovacaoDoFluxo();

        if (at != null) {
            Set<ColaboradoresAprovacao> colabsApov = at.colabsDeAprovacao();
            TarefaManualAprovacao tarefaManualAprovacao = new TarefaManualAprovacao(ticket);
            if (colabsApov.contains(ColaboradoresAprovacao.RESPONSAVEL_HIERARQUICO)) {
                Colaborador respHierarquico = colabPedido.seuColabResponsavel();
                tarefaManualAprovacao.assignaColabAprovacao(respHierarquico);
            }
            if (colabsApov.contains(ColaboradoresAprovacao.RESPONSAVEL_PELO_SERVICO)) {
                Colaborador respServico = s.catalogo().colaboradorResponsavelDoCatalogo();
                tarefaManualAprovacao.assignaColabAprovacao(respServico);
            }
            at.adicionaTarefaAprov(tarefaManualAprovacao);
        }

        if (ar.tipoExecucao() == TipoExecucao.MANUAL) {
            if (ar.equipasExecucao() != null) {
                TarefaManualExecucao tme = new TarefaManualExecucao(ticket, s.fluxoDoServico().ativRealizacaoDoFluxo().equipasExecucao());
                for (Equipa equipa : ar.equipasExecucao()) {
                    tme.adicionaEquipaExecucao(equipa);
                }
                ar.adicionarTarefaExecucao(tme);
            } else if (ar.colabExec() != null) {
                TarefaManualExecucao tme = new TarefaManualExecucao(ticket, ar.colabExec(), EstadoRealizacao.POR_EXECUTAR);
                ar.adicionarTarefaExecucao(tme);
            }
        } else {
            TarefaAutomatica tarefaAutomatica = new TarefaAutomatica(ticket);
            ar.adicionarTarefaAutomatica(tarefaAutomatica);
        }

        s.fluxoDoServico().ativar();
        lcp.guardarFluxo(s.fluxoDoServico());

        return false;
    }

    @Override
    public String headline() {
        return "Solicitar um Serviço!";
    }

    private String tipoDadosStr(TipoDados a) {
        if (a == TipoDados.DATA) {
            return "Data";
        } else if (a == TipoDados.BOOLEANO) {
            return "Sim/Não";
        } else if (a == TipoDados.STRING) {
            return "Frase";
        } else if (a == TipoDados.FRACIONAL) {
            return "Numero fracional";
        } else if (a == TipoDados.INT) {
            return "Numero";
        } else
            return "";
    }
}
