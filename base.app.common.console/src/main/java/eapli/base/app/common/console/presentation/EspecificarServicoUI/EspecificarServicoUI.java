package eapli.base.app.common.console.presentation.EspecificarServicoUI;

import eapli.base.catalogo.domain.Catalogo;
import eapli.base.servico.application.EspecificarServicoController;
import eapli.base.servico.domain.Keyword;
import eapli.base.servico.domain.Servico;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class EspecificarServicoUI extends AbstractUI {

    private final EspecificarServicoController controller = new EspecificarServicoController();
    private final FormularioHelper fh = new FormularioHelper();

    @Override
    protected boolean doShow() {

        List<Catalogo> listaCatalogos = (List<Catalogo>) controller.listaCatalogos();

        if(listaCatalogos.isEmpty()){
            System.out.println("Não existem Catálogos. Crie um Catálogo primeiro.");
            return false;
        }

        final String identificador = Console.readLine("Identificador do Serviço:");
        final String titulo = Console.readLine("Título:");

        final String descBreve = Console.readLine("Descrição Breve:");
        final String descComp = Console.readLine("Descrição Completa:");

        int imageBin = 0;
        final String caminho = Console.readLine("Indique o caminho (path) do ícone:");

        File file = new File(caminho);
        try {
            FileInputStream fis = new FileInputStream(file);
            imageBin = fis.available();
        } catch (IOException e) {
            e.printStackTrace();
        }

        boolean findCatalogo = true;

        for (Catalogo catalogo : listaCatalogos)
            System.out.println(catalogo.toString());

        Catalogo catalogo = null;
        int index;

        while (findCatalogo) {
            index = Console.readInteger("Indique o catálogo");

            for(Catalogo cat : listaCatalogos){
                if (cat.identity() == index){
                    catalogo = cat;
                    findCatalogo = false;
                }
            }
            if(findCatalogo){
                System.out.println("Não existe um catálogo com esse identificador");
            }
        }

        boolean flag = true;
        boolean booleanAprov = true;
        boolean booleanReal = true;

        while (flag) {
            final String atAprov = Console.readLine("Tem atividade de aprovação? (sim/nao):");
            if (atAprov.equalsIgnoreCase("sim")) {
                flag = false;
            }

            if (atAprov.equalsIgnoreCase("nao")) {
                booleanAprov = false;
                flag = false;
            }
        }

        flag = true;
        while (flag) {
            final String atReal = Console.readLine("Requer atividade de realização? (sim/nao):");
            if (atReal.equalsIgnoreCase("sim")) {
                flag = false;
            }
            if (atReal.equalsIgnoreCase("nao")) {
                booleanReal = false;
                flag = false;
            }

        }

        Set<Keyword> listaKeywords = new HashSet<>();

        flag = true;
        while (flag) {
            String keyword = Console.readLine("Indique as palavras-chave \\n 0 para sair");

            if (keyword.equals("0"))
                flag = false;
            else
                listaKeywords.add(new Keyword(keyword));
        }

        boolean requerFeed = false;
        String strFeed = Console.readLine("Este serviço requer feedback por parte do colaborador? (sim|nao)");
        if (strFeed.equalsIgnoreCase("sim")) {
            requerFeed = true;
        }

        String estado = "COMPLETO"; //TODO MUDAR PARA FICAR implementado
        String strContinuar;
        do {
            strContinuar = Console.readLine("Deseja continuar com a especificação, passando agora ao formulário? (sim/nao):");
        } while (!validaSimNao(strContinuar));
        if (strContinuar.equalsIgnoreCase("nao")) {
            estado = "INCOMPLETO";
            controller.especificarServico(identificador, titulo, descBreve, descComp, imageBin, booleanAprov, booleanReal, listaKeywords, estado, requerFeed, catalogo);
        } else if (strContinuar.equalsIgnoreCase("sim")) {
            Servico servico = controller.especificarServico(identificador, titulo, descBreve, descComp, imageBin, booleanAprov, booleanReal, listaKeywords, estado, requerFeed, catalogo);
            fh.form(servico);
        }
        return true;
    }

    @Override
    public String headline() {
        return "Especificar Serviço";
    }

    private boolean validaSimNao(String a) {
        return a.equalsIgnoreCase("sim") || a.equalsIgnoreCase("nao");
    }


}
