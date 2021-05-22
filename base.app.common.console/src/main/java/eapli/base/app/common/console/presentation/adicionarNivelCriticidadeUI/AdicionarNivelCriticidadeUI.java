package eapli.base.app.common.console.presentation.adicionarNivelCriticidadeUI;

import eapli.base.catalogo.application.AdicionarNivelCriticidadeController;
import eapli.base.catalogo.domain.Catalogo;
import eapli.base.criticidade.application.EspecificarNivelCriticidadeController;
import eapli.base.criticidade.domain.NivelCriticidade;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.List;

public class AdicionarNivelCriticidadeUI extends AbstractUI {
    private final EspecificarNivelCriticidadeController controllerNivelCrit = new EspecificarNivelCriticidadeController();
    private final AdicionarNivelCriticidadeController controllerAddCrit = new AdicionarNivelCriticidadeController();
    @Override
    protected boolean doShow() {
        String opcao;
        Catalogo catalogo = null;

        do {
            System.out.println("0. Sair");
            opcao = Console.readLine("1 .Adicionar um nível de criticidade a um catálogo");

            if (opcao.equals("0"))
                return false;
        } while (!opcao.equalsIgnoreCase("1"));

        if (opcao.equals("1")) {
            List<NivelCriticidade> niveisCriticidade = (List<NivelCriticidade>) controllerNivelCrit.nivelCriticidades();
            List<Catalogo> catalogosSemNivelCrit =  controllerAddCrit.catalogosSemNivelCrit();

            if(catalogosSemNivelCrit.isEmpty()){
                System.out.println("Não existem catálogos sem nível de criticidade");
            }
            if (niveisCriticidade.isEmpty()) {
                System.out.println("Não existem  níveis de criticidade criados");
                return false;
            }
            boolean catalogoEscolha = true;
            int index = 1;
            for (Catalogo c : catalogosSemNivelCrit) {
                System.out.println(index + " " + c.toString());
                index++;
            }
            while (catalogoEscolha) {
                index = Console.readInteger("Indique o catálogo ao qual pretende associar um nível de criticidade :  \n");
                if (index == 0) {
                    return false;
                }
                if (index <= niveisCriticidade.size() && index > 0) {
                    catalogoEscolha = false;
                    catalogo = catalogosSemNivelCrit.get(index - 1);
                }
                if (catalogoEscolha) {
                    System.out.println("Coloque um index válido");
                }
            }
            NivelCriticidade nivelCriticidade = null;
            boolean nivelCrit = true;
            index = 1;
            for (NivelCriticidade nivel : niveisCriticidade) {
                System.out.println(index + " " + nivel.toString());
                index++;
            }
            while (nivelCrit) {
                index = Console.readInteger("Indique o nível de criticidade que pretende associar :  \n");
                if (index == 0) {
                    return false;
                }
                if (index <= niveisCriticidade.size() && index > 0) {
                    nivelCrit = false;
                    nivelCriticidade = niveisCriticidade.get(index - 1);
                }
                if (nivelCrit) {
                    System.out.println("Coloque um index válido");
                }
            }
            String objetivos;
            do {
                objetivos = Console.readLine("Pretende mudar os objetivos do nível de criticidade que está a associar ao catálogo:  (Não- 0 / Sim- 1) \n");
                if (objetivos.equals("0")){
                    controllerAddCrit.addNivelCriticidade(catalogo,nivelCriticidade);
                    return false;}
            } while (!(objetivos.equals("1")));


                //TODO perguntar aos bandalhos como é que saco os objetivos do nivel de criticidade que agora ja sao 6h da matina e o cerebro ta em papa


        }
        return true; ////TODO dummie  , devo retornar a persistencia de um catalogo com o novo nivel de criticidade
    }

    @Override
    public String headline() {
        return null;
    }
}