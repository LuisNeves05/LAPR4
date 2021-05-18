package eapli.base.app.common.console.presentation.solicitarservicoUI;

import eapli.base.catalogo.domain.Catalogo;
import eapli.base.formulario.domain.Atributo;
import eapli.base.formulario.domain.Formulario;
import eapli.base.ticket.application.SolicitarServicoController;
import eapli.base.servico.domain.Servico;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.List;
import java.util.Set;

public class SolicitarServicoUI extends AbstractUI {

    private final SolicitarServicoController lcp = new SolicitarServicoController();

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

        for(Formulario f : formularioList){
            System.out.println("Formulario " +  f.name() + "\n");
            Set<Atributo> a =  f.atributos();

            for(Atributo atributo : a){

            }
        }


        return false;
    }

    @Override
    public String headline() {
        return "Solicitar um Serviço!";
    }
}
