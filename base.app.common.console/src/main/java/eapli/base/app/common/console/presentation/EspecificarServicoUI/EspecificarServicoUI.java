package eapli.base.app.common.console.presentation.EspecificarServicoUI;

import eapli.base.catalogo.domain.Catalogo;
import eapli.base.servico.application.EspecificarServicoController;
import eapli.base.servico.domain.EstadoServico;
import eapli.base.servico.domain.ServiceBuilder;
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

        String opcao;
        do{
        System.out.println("0. Sair");
        System.out.println("1 .Especificar um novo serviço");
        opcao = Console.readLine("2. Especificar/alterar um serviço incompleto");

        if(opcao.equals("0"))
            return false;
        }while (!opcao.equalsIgnoreCase("1") && !opcao.equalsIgnoreCase("2"));

        Servico servico = null;
        if(opcao.equals("2")) {
            List<Servico> servicosIncompletos = controller.servicosIncompletos();

            boolean findServico = true;
            int index;

            while (findServico) {
                index = Console.readInteger("Indique o serviço");
                if(index == 0){
                    return false;
                }
                for (Servico sv: servicosIncompletos) {
                    if (sv.identity() == servicosIncompletos.get(index).identity()) {
                        servico = sv;
                        findServico = false;
                    }
                }
                if (findServico) {
                    System.out.println("Não existe um serviço com esse identificador");
                }
            }
        }

        return especificarServicoUI(servico);
    }

    private boolean especificarServicoUI(Servico serv) {
        /*int tamanhoListaKeyword = 0;


        List<Catalogo> listaCatalogos = (List<Catalogo>) controller.listaCatalogos();
        if (listaCatalogos.isEmpty()) {
            System.out.println("Não existem Catálogos. Crie um Catálogo primeiro.");
            return false;
        }

        ServiceBuilder serviceBuilder = new ServiceBuilder();
        final String identificador = Console.readLine("Identificador do Serviço:");
        serviceBuilder.comIdentificador(identificador);

        Iterable<Servico> servs = controller.servivoExistente(identificador, catalogo);

        for (Servico sv : servs){
            serv = sv;
        }

        if(serv != null){
            tamanhoListaKeyword = serv.tamanhoListaKewords();
            System.out.println("\n\nEste serviço já existe");
            System.out.println(serv.toString() + "\n\n");
            serviceBuilder.comEstado(serv.estado());
            String alterar;
            do {
                alterar = Console.readLine("Deseja alerar este Serviço? (sim/nao)");
            } while (validaSimNao(alterar));
            if (alterar.equals("nao")){
                return false;
            }
        }else{
            serviceBuilder.comEstado(EstadoServico.INCOMPLETO);
        }


        final String titulo = Console.readLine("(Se quiser sair da especificação, digite -1) Título:");
        if(titulo.equalsIgnoreCase("-1")){
            controller.especificarServico(serviceBuilder.build());
            return true;
        }
        serviceBuilder.comTitulo(titulo);



        final String descBreve = Console.readLine("Descrição Breve:");
        if(descBreve.equalsIgnoreCase("-1")){
            controller.especificarServico(serviceBuilder.build());
            return true;
        }
        serviceBuilder.comDescBreve(descBreve);



        final String descComp = Console.readLine("Descrição Completa:");
        if(descComp.equalsIgnoreCase("-1")){
            controller.especificarServico(serviceBuilder.build());
            return true;
        }
        serviceBuilder.comDescComp(descComp);


        boolean findCatalogo = true;
        for (Catalogo catalogo : listaCatalogos)
            System.out.println(catalogo.toString());

        Catalogo catalogo = null;
        int index;

        while (findCatalogo) {
            index = Console.readInteger("Indique o catálogo");

            for (Catalogo cat : listaCatalogos) {
                if (cat.identity() == index) {
                    catalogo = cat;
                    findCatalogo = false;
                }
            }
            if (findCatalogo) {
                System.out.println("Não existe um catálogo com esse identificador");
            }
        }
        serviceBuilder.comCatalogo(catalogo);

        int imageBin = 0;
        final String caminho = Console.readLine("Indique o caminho (path) do ícone:");
        if(caminho.equalsIgnoreCase("-1")){
            controller.especificarServico(serviceBuilder.build());
            return true;
        }
        File file = new File(caminho);
        try {
            FileInputStream fis = new FileInputStream(file);
            imageBin = fis.available();
        } catch (IOException e) {
            e.printStackTrace();
        }
        serviceBuilder.comIcon(new byte[imageBin]);




        boolean flag = true;
        boolean booleanAprov = true;
        while (flag) {
            final String atAprov = Console.readLine("Tem atividade de aprovação? (sim/nao):");
            if(atAprov.equalsIgnoreCase("-1")){
                controller.especificarServico(serviceBuilder.build());
                return true;
            }
            if (atAprov.equalsIgnoreCase("sim")) {
                flag = false;
            }

            if (atAprov.equalsIgnoreCase("nao")) {
                booleanAprov = false;
                flag = false;
            }
        }
        serviceBuilder.comAtAprov(booleanAprov);



        flag = true;
        boolean booleanReal = true;
        while (flag) {
            final String atReal = Console.readLine("Requer atividade de realização? (sim/nao):");
            if(atReal.equalsIgnoreCase("-1")){
                controller.especificarServico(serviceBuilder.build());
                return true;
            }
            if (atReal.equalsIgnoreCase("sim")) {
                flag = false;
            }
            if (atReal.equalsIgnoreCase("nao")) {
                booleanReal = false;
                flag = false;
            }
        }
        serviceBuilder.comAtReal(booleanReal);



        flag = true;
        while (flag) {
            String keyword = Console.readLine("Indique as palavras-chave \\n 0 para sair");
            if(keyword.equalsIgnoreCase("-1")){
                controller.especificarServico(serviceBuilder.build());
                return true;
            }
            if (keyword.equals("0"))
                flag = false;
            else
                serviceBuilder.adicionarKeyword(keyword);
        }
        serviceBuilder.comAtReal(booleanReal);



        boolean requerFeed = false;
        String strFeed;
        do {
            strFeed = Console.readLine("Este serviço requer feedback por parte do colaborador? (sim|nao)");
            if(strFeed.equalsIgnoreCase("-1")){
                controller.especificarServico(serviceBuilder.build());
                return true;
            }
        } while (validaSimNao(strFeed));
        if (strFeed.equalsIgnoreCase("sim")) {
            requerFeed = true;
        }
        serviceBuilder.comRequerFeedback(requerFeed);



        String strContinuar;
        do {
            strContinuar = Console.readLine("Deseja continuar com a especificação, passando agora ao formulário? (sim/nao):");
        } while (validaSimNao(strContinuar));

        if (strContinuar.equalsIgnoreCase("sim")) {
            Servico servico1 = controller.especificarServico(serviceBuilder.build());
            String novoForm;
            do {
                fh.form(servico);
                novoForm = Console.readLine("Deseja especificar outro formulario?  (sim|não)");
            } while (novoForm.contains("sim"));
        }



        String completar;
        do {
            completar = Console.readLine("Deseja dar este Serviço como completo? (sim/nao)");
        } while (validaSimNao(strContinuar));
        if(completar.equalsIgnoreCase("sim")) {
            if (tamanhoListaKeyword > 0)
                serviceBuilder.comEstado(EstadoServico.COMPLETO);
            else
                System.out.println("O serviço não ficou completo pois não tem pelo menos uma palavra-chave (keyword)");
        }

        controller.especificarServico(serviceBuilder.build());

         */
        return true;
    }



    private boolean validaSimNao(String a) {
        return !a.equalsIgnoreCase("sim") && !a.equalsIgnoreCase("nao");
    }

    @Override
    public String headline() {
        return "Especificar Serviço";
    }
}
