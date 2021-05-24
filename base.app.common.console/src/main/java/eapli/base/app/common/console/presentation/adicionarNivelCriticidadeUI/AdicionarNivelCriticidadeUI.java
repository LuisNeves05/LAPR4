package eapli.base.app.common.console.presentation.adicionarNivelCriticidadeUI;

import eapli.base.catalogo.application.AdicionarNivelCriticidadeController;
import eapli.base.catalogo.domain.Catalogo;
import eapli.base.criticidade.application.EspecificarNivelCriticidadeController;
import eapli.base.criticidade.domain.NivelCriticidade;
import eapli.base.criticidade.domain.Objetivo;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import java.util.List;

public class AdicionarNivelCriticidadeUI extends AbstractUI {
    private final EspecificarNivelCriticidadeController controllerNivelCrit = new EspecificarNivelCriticidadeController();
    private final AdicionarNivelCriticidadeController controllerAddCrit = new AdicionarNivelCriticidadeController();
    List<NivelCriticidade> niveisCriticidade = (List<NivelCriticidade>) controllerNivelCrit.niveisCriticidadeDefault();
    List<Catalogo> catalogosSemNivelCrit = controllerAddCrit.catalogosSemNivelCrit();
    @Override
    protected boolean doShow() {
        Catalogo catalogo = null;
        NivelCriticidade nivelCriticidade = null;




            if (catalogosSemNivelCrit.isEmpty()) {
                System.out.println("Não existem catálogos sem nível de criticidade");
                return false;
            }
            if (niveisCriticidade.isEmpty()) {
                System.out.println("Não existem  níveis de criticidade criados. Por favor solicite a criação de um nível de criticidade. ");
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

            nivelCriticidade = escolherNivelCrit();

            String objetivos;
            do {
                objetivos = Console.readLine("Pretende mudar os objetivos do nível de criticidade que está a associar ao catálogo:  (Não- 0 / Sim- 1) \n");
                if (objetivos.equals("0")) {
                    controllerAddCrit.addNivelCriticidadeCatalogo(catalogo, nivelCriticidade);
                    System.out.println("O nível de criticidade foi adicionado ao catálogo");
                    return false;
                }
            } while (!(objetivos.equals("1")));

        Objetivo novoObjetivo =novoObjetivo();
        nivelCriticidade= criarNivelCriticidade(nivelCriticidade,novoObjetivo);
       // controllerNivelCrit.especificarNivelCriticidade(nivelCriticidade);
         controllerAddCrit.addNivelCriticidadeCatalogo(catalogo,nivelCriticidade);
        System.out.println("O nível de criticidade personalizado foi adicionado ao catálogo");
        return true;
    }

    @Override
    public String headline() {
        return "Adicionar Nível de Criticidade";
    }

    private Objetivo novoObjetivo() {
        boolean flag = true;
        int aprovacaoMax = -1;
        int resolucaoMax = -1;
        int aprovacaoMedia = -1;
        int resolucaoMedia = -1;

        while (flag) {
            aprovacaoMax = Console.readInteger("Defina o período de aprovação máximo deste  nível de criticidade personalizado (em minutos)\n");

            if (aprovacaoMax > 0) {
                flag = false;
            }
            if (flag) {
                System.out.println("Insira um período de aprovação válido\n");
            }
        }
        flag = true;
        while (flag) {
            resolucaoMax = Console.readInteger("Defina o período de resolução máximo deste  nível de criticidade personalizado (em minutos)\n");

            if (resolucaoMax > 0) {
                flag = false;
            }
            if (flag) {
                System.out.println("Insira um período de resolução máximo válido\n");
            }
        }
        flag = true;
        while (flag) {
            aprovacaoMedia = Console.readInteger("Defina o período de aprovação médio deste  nível de criticidade personalizado (em minutos)\n");

            if (aprovacaoMedia > 0) {
                flag = false;
            }
            if (flag) {
                System.out.println("Insira um período de aprovação média válido\n");
            }
        }
        flag = true;
        while (flag) {
            resolucaoMedia = Console.readInteger("Defina o período de resolução médio deste  nível de criticidade personalizado (em minutos)\n");

            if (resolucaoMedia > 0) {
                flag = false;
            }
            if (flag) {
                System.out.println("Insira um período de resolução média válido\n");
            }
        }
        return new Objetivo(aprovacaoMax, resolucaoMax, aprovacaoMedia, resolucaoMedia);
    }

    private NivelCriticidade criarNivelCriticidade(NivelCriticidade nivelCriticidade,Objetivo objetivo){
        return new NivelCriticidade(nivelCriticidade.getEtiqueta(),nivelCriticidade.getValorDeEscala(),nivelCriticidade.getCor(),objetivo,nivelCriticidade.isDefault());
    }

    private NivelCriticidade escolherNivelCrit(){
        NivelCriticidade nivelCriticidade= null;
        boolean nivelCrit = true;
        int index = 1;
        for (NivelCriticidade nivel : niveisCriticidade) {
            System.out.println(index + " " + nivel.toString());
            index++;
        }
        while (nivelCrit) {
            index = Console.readInteger("Indique o nível de criticidade que pretende associar :  \n");
            if (index <= niveisCriticidade.size() && index > 0) {
                nivelCrit = false;
                nivelCriticidade = niveisCriticidade.get(index - 1);
            }
            if (nivelCrit) {
                System.out.println("Coloque um index válido");
            }
        }return nivelCriticidade;}
}

