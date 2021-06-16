package eapli.base.app.common.console.presentation.solicitarservicoUI;

import eapli.base.app.common.console.presentation.utils.HelpMethodsForUIs;
import eapli.base.catalogo.domain.Catalogo;
import eapli.base.formulario.domain.Atributo;
import eapli.base.formulario.domain.Formulario;
import eapli.base.formulario.domain.TipoDados;
import eapli.base.formulario.gramatica.Script;
import eapli.base.formularioPreenchido.domain.FormularioPreenchido;
import eapli.base.formularioPreenchido.domain.Resposta;
import eapli.base.servico.application.SolicitarServicoController;
import eapli.base.servico.domain.Servico;
import eapli.base.ticket.domain.Ticket;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SolicitarServicoUI extends AbstractUI {

    private final SolicitarServicoController lcp = new SolicitarServicoController();

    @Override
    protected boolean doShow() {


        List<Catalogo> catalogoList = lcp.listarCatalogosPorUser();

        if (catalogoList.isEmpty()) {
            System.out.println("Ainda não existem catálogos");
            return false;
        }

        for (int i = 0; i < catalogoList.size(); i++) {
            System.out.println(i + 1 + " - " + catalogoList.get(i).toString());
        }

        boolean flag = true;
        Catalogo c = null;

        while (flag) {
            int indCatalogo = Console.readInteger("Escolha o catalogo a que pretende aceder (index) (0 para sair)");
            if (indCatalogo == 0) {
                return false;
            } else if (indCatalogo > 0 && indCatalogo <= catalogoList.size()) {
                c = catalogoList.get(indCatalogo - 1);
                flag = false;
            } else {
                System.out.println("Indique um index válido");
            }
        }

        List<Servico> servicoList = lcp.listarServicosPorCat(c);

        if (servicoList.isEmpty()) {
            System.out.println("Não existem serviços completos neste catálogo");
            return false;
        }

        for (int i = 0; i < servicoList.size(); i++) {
            System.out.println(i + 1 + " - " + servicoList.get(i).toString());
        }

        flag = true;
        Servico s = null;
        while (flag) {

            int indServico = Console.readInteger("Escolha o servico que pretende requisitar (index) (0 para sair)");

            if (indServico == 0) {
                return false;
            } else if (indServico > 0 && indServico <= servicoList.size()) {
                s = servicoList.get(indServico - 1);
                flag = false;
            } else {
                System.out.println("Indique um index válido");
            }
        }

        System.out.println("\nTendo o serviço sido escolhido, vai agora ter de preencher os respetivos formulários\n");

        flag = true;
        String urgencia = null;
        while (flag) {
            urgencia = Console.readLine("\nQual a urgência deste serviço?  (baixa | moderada | alta)");
            if (lcp.validaUrgencia(urgencia))
                flag = false;
            else if (urgencia.equalsIgnoreCase("0"))
                return false;
            else {
                System.out.println("Coloque uma urgência válida");
            }
        }

        List<Formulario> formularioList = lcp.formulariosServico(s);

        Set<FormularioPreenchido> fps = new HashSet<>();
        Ticket ticket = lcp.criarTicket(s, urgencia);
        //TODO VALIDAR FORMULARIO LPROG
        for (Formulario f : formularioList) {
            System.out.println("\nFormulario " + f.name() + "\n");

            Set<Resposta> respostas = new HashSet<>();
            Set<Atributo> a = f.atributos();

            for (Atributo atributo : a) {
                TipoDados td = atributo.tipoDados();
                String ajudaResposta = atributo.tipoDadosStr(td);
                String resposta = Console.readLine(atributo.nomeVar() + " " + "    Responda conforme -> " + ajudaResposta);
                Resposta rAtr = new Resposta(resposta, atributo.nomeVar());
                respostas.add(rAtr);
            }

            Set<String> scriptsForm = f.scriptsValidacao();

            if (!scriptsForm.isEmpty()) {
                for (String scri : scriptsForm) {
                    Script.executaScript(scri);
                }
            }

            FormularioPreenchido fp = new FormularioPreenchido(f, urgencia, respostas, ticket, lcp.colaboradorLogado());
            fps.add(fp);

            lcp.saveFormPreenchido(fp);
        }

        boolean result = lcp.solicitarServico(s, ticket);

        /**
         * Algoritmo de atribuicao automatica
         */
        HelpMethodsForUIs.sendToServer();

        return result;
    }

    @Override
    public String headline() {
        return "Solicitar um Serviço!";
    }

}
