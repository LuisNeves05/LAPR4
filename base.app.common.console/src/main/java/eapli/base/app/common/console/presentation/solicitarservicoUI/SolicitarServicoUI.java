package eapli.base.app.common.console.presentation.solicitarservicoUI;

import eapli.base.catalogo.domain.Catalogo;
import eapli.base.formulario.domain.Atributo;
import eapli.base.formulario.domain.Formulario;
import eapli.base.formulario.domain.TipoDados;
import eapli.base.formularioPreenchido.domain.FormularioPreenchido;
import eapli.base.formularioPreenchido.domain.Resposta;
import eapli.base.formularioPreenchido.persistencia.FormularioPreenchidoRepositorio;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.ticket.application.SolicitarServicoController;
import eapli.base.servico.domain.Servico;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SolicitarServicoUI extends AbstractUI {

    private final SolicitarServicoController lcp = new SolicitarServicoController();
    private final FormularioPreenchidoRepositorio fpr = PersistenceContext.repositories().formularioPreenchidoRepositorio();

    @Override
    protected boolean doShow() {

        List<Catalogo>  catalogoList =  lcp.ListarCatalogosPorUser();

        for(int i = 0;i<catalogoList.size();i++){
            System.out.println(i + " - " +catalogoList.get(i).toString());
        }

        int indCatalogo = Console.readInteger("Escolha o catalogo a que pretende aceder (index)");

        Catalogo c = catalogoList.get(indCatalogo);

        List<Servico> servicoList = lcp.ListarServicosPorCat(c);

        for(int i = 0;i<servicoList.size();i++){
            System.out.println(i + " - " +servicoList.get(i).toString());
        }

        int indServico = Console.readInteger("Escolha o servico que pretende requisitar (index)");

        Servico s = servicoList.get(indServico);

        System.out.println("\nTendo o serviço sido escolhido, vai agora ter de preencher os respetivos formulários\n");

        List<Formulario> formularioList = lcp.formulariosServico(s);

        String urgencia = Console.readLine("\nQual a urgência deste serviço?  (baixa | moderada | alta)");

        for(Formulario f : formularioList){
            System.out.println("\nFormulario " +  f.name() + "\n");

            Set<Resposta> respostas = new HashSet<>();
            Set<Atributo> a =  f.atributos();

            for(Atributo atributo : a){
                TipoDados td = atributo.tipoDados();
                String ajudaResposta = tipoDadosStr(td);
                String resposta = Console.readLine(atributo.nomeVar() + ": " + "    Responda conforme -> " +ajudaResposta);
                Resposta rAtr = new Resposta(resposta, atributo.nomeVar());
                respostas.add(rAtr);
            }

            FormularioPreenchido fp = new FormularioPreenchido(f,urgencia,respostas,s);

            fpr.save(fp);
        }

        return false;
    }

    @Override
    public String headline() {
        return "Solicitar um Serviço!";
    }

    private String tipoDadosStr(TipoDados a){
        if(a == TipoDados.DATA){
            return "Data";
        }else if(a == TipoDados.BOOLEANO){
            return "Sim/Não";
        }else if(a == TipoDados.STRING){
            return "Frase";
        }else if(a == TipoDados.FRACIONAL){
            return "Numero fracional";
        }else if(a == TipoDados.INT){
            return "Numero";
        }else
            return "";
    }
}
