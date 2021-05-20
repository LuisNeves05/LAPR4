package eapli.base.app.common.console.presentation.EspecificarServicoUI;

import eapli.base.catalogo.domain.Catalogo;
import eapli.base.servico.application.EspecificarServicoController;
import eapli.base.servico.domain.EstadoServico;
import eapli.base.servico.domain.Keyword;
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

            if(servicosIncompletos.isEmpty()){
                System.out.println("Não tem disponível serviços incompletos");
                return false;
            }

            boolean findServico = true;
            int index = 1;
            for(Servico svc : servicosIncompletos){
                System.out.println(index + " " + svc.toString());
                index++;
            }
            while (findServico) {
                index = Console.readInteger("Indique o serviço");
                if(index == 0){
                    return false;
                }
                if(index <= servicosIncompletos.size() && index > 0){
                    findServico = false;
                    servico = servicosIncompletos.get(index - 1);
                }
                if (findServico) {
                    System.out.println("Coloque um index válido");
                }
            }
        }

        return especificarServicoUI(servico);
    }

    private boolean especificarServicoUI(Servico serv) {

        List<Catalogo> listaCatalogos = (List<Catalogo>) controller.listaCatalogos();
        if (listaCatalogos.isEmpty()) {
            System.out.println("Não existem Catálogos. Crie um Catálogo primeiro.");
            return false;
        }

        ServiceBuilder serviceBuilder = new ServiceBuilder();

        if(serv == null) {
            final String identificador = Console.readLine("(Se quiser sair da especificação, digite -1) \n Identificador do Serviço:");
            if(identificador.equalsIgnoreCase("-1")){
                return false;
            }
            serviceBuilder.comIdentificador(identificador);
        }else{
            serviceBuilder.comIdentificador(serv.identity().toString());
        }


        if(serv == null) {
            final String titulo = Console.readLine("(Se quiser sair da especificação, digite -1) \n Título:");
            if(titulo.equalsIgnoreCase("-1")){
                return false;
            }
            serviceBuilder.comTitulo(titulo);
        }else{
            serviceBuilder.comTitulo(serv.tituloDoServico().toString());
        }

        serviceBuilder.comEstado(EstadoServico.INCOMPLETO);

        if(serv == null) {
            if(!inserirDescBreve(serviceBuilder))
                return false;
        }else{
            if(serv.descricaoBreveDoServico() != null) {
                System.out.println("Descrição Breve atual:   " + serv.descricaoBreveDoServico().toString());
                if(alterar().equalsIgnoreCase("sim")){
                    if(!inserirDescBreve(serviceBuilder))
                        return false;
                }else{
                    serviceBuilder.comDescBreve(serv.descricaoBreveDoServico().toString());
                }
            }else{
                if(!inserirDescBreve(serviceBuilder))
                    return false;
            }
        }

        if(serv == null) {
            if(!inserirDescComp(serviceBuilder))
                return false;
        }else{
            if(serv.descricaoCompletaDoServico() != null) {
                System.out.println("Descrição Completa atual:   " + serv.descricaoCompletaDoServico().toString());
                if(alterar().equalsIgnoreCase("sim")){
                    if(!inserirDescComp(serviceBuilder))
                        return false;
                }else{
                    serviceBuilder.comDescComp(serv.descricaoCompletaDoServico().toString());
                }
            }else{
                if(!inserirDescComp(serviceBuilder))
                    return false;
            }
        }

        if(serv == null) {
            if(!inserirCatalogo(serviceBuilder, listaCatalogos))
                return false;
        }else{
            if(serv.catalogo() != null) {
                System.out.println("Catalogo atual:   " + serv.catalogo().toString());
                if(alterar().equalsIgnoreCase("sim")){
                    if(!inserirCatalogo(serviceBuilder, listaCatalogos))
                        return false;
                }else{
                    serviceBuilder.comCatalogo(serv.catalogo());
                }
            }else{
                if(!inserirCatalogo(serviceBuilder, listaCatalogos))
                    return false;
            }
        }

        if(serv == null) {
            if(!inserirIcone(serviceBuilder))
                return false;
        }else{
            if(serv.iconDoServico() != null) {
                System.out.println("Já tem um ícon associado.");
                if(alterar().equalsIgnoreCase("sim")){
                    if(!inserirIcone(serviceBuilder))
                        return false;
                }else{
                    serviceBuilder.comIcon(serv.iconDoServico());
                }
            }else{
                if(!inserirIcone(serviceBuilder))
                    return false;
            }
        }

        if(serv == null) {
            if(!inserirAtAprovacao(serviceBuilder))
                return false;
        }else{
                System.out.println("Atividade de Aprovação atual:   " + serv.atividadeAprovacao());
                if(alterar().equalsIgnoreCase("sim")){
                    if(!inserirAtAprovacao(serviceBuilder))
                        return false;
                }else{
                    serviceBuilder.comAtAprov(serv.atividadeAprovacao());
                }
        }


        if(serv == null) {
            if(!inserirAtRealizacao(serviceBuilder))
                return false;
        }else{
            System.out.println("Atividade de Realização atual:   " + serv.atividadeRealizacao());
            if(alterar().equalsIgnoreCase("sim")){
                if(!inserirAtRealizacao(serviceBuilder))
                    return false;
            }else{
                serviceBuilder.comAtReal(serv.atividadeRealizacao());
            }
        }


        if(serv == null) {
            if(!inserirKeywords(serviceBuilder))
                return false;
        }else{
            if(serv.listaKewordsDoServico() != null && serv.listaKewordsDoServico().size() > 0) {
                System.out.println("Lista de Keywords atual:   " + serv.listaKewordsDoServico().toString());
                if(alterar().equalsIgnoreCase("sim")){
                    if(!inserirKeywords(serviceBuilder))
                        return false;
                }else{
                    for (Keyword k : serv.listaKewordsDoServico())
                    serviceBuilder.adicionarKeyword(k.toString());
                }
            }else{
                if(!inserirKeywords(serviceBuilder))
                    return false;
            }
        }

        if(serv == null) {
            if(!inserirRequerFeedback(serviceBuilder))
                return false;
        }else{
            System.out.println("Pedido de requerimento de Feedback atual:   " + serv.requerFeedbackDoServico());
            if(alterar().equalsIgnoreCase("sim")){
                if(!inserirRequerFeedback(serviceBuilder))
                    return false;
            }else{
                serviceBuilder.comRequerFeedback(serv.requerFeedbackDoServico());
            }
        }

        String strContinuar;
        do {
            strContinuar = Console.readLine("Deseja continuar com a especificação, passando agora ao formulário? (sim/nao):");
        } while (validaSimNao(strContinuar));

        if (strContinuar.equalsIgnoreCase("sim")) {
            Servico servico = controller.especificarServico(serviceBuilder.build());
            String novoForm;
            do {
                fh.form();
                novoForm = Console.readLine("Deseja especificar outro formulario?  (sim|não)");
            } while (novoForm.contains("sim"));
        }

        String completar;
        do {
            completar = Console.readLine("Deseja dar este Serviço como completo? (sim/nao)");
        } while (validaSimNao(strContinuar));
        if(completar.equalsIgnoreCase("sim")) {
            if (serv != null) {
                if (serv.estaCompleto())
                    serviceBuilder.comEstado(EstadoServico.COMPLETO);
                else
                    System.out.println("O serviço não ficou completo pois não tem todos os campos obrigatórios preenchidos");
            }else{
                System.out.println("Ocorreu um erro.");
            }
        }

        controller.especificarServico(serviceBuilder.build());
        return true;
    }

    private boolean inserirRequerFeedback(ServiceBuilder serviceBuilder) {
        boolean requerFeed = false;
        String strFeed;
        do {
            strFeed = Console.readLine("(Se quiser sair da especificação, digite -1) || (Se quiser avançar, digite 0)\nEste serviço requer feedback por parte do colaborador? (sim|nao)");
            if(strFeed.equalsIgnoreCase("-1")){
                controller.especificarServico(serviceBuilder.build());
                return false;
            }
            else if(strFeed.equalsIgnoreCase("0")){
                return true;
            }
        } while (validaSimNao(strFeed));
        if (strFeed.equalsIgnoreCase("sim")) {
            requerFeed = true;
        }
        serviceBuilder.comRequerFeedback(requerFeed);
        return true;
    }

    private boolean inserirKeywords(ServiceBuilder serviceBuilder) {
        boolean flag = true;
        while (flag) {
            String keyword = Console.readLine("Indique as palavras-chave \\n 0 para sair");
            if(keyword.equalsIgnoreCase("-1")){
                controller.especificarServico(serviceBuilder.build());
                return false;
            }
            if (keyword.equals("0"))
                flag = false;
            else
                serviceBuilder.adicionarKeyword(keyword);
        }
        return true;
    }

    private boolean inserirAtRealizacao(ServiceBuilder serviceBuilder) {
        boolean flag = true;
        boolean booleanReal = true;
        while (flag) {
            final String atReal = Console.readLine("(Se quiser sair da especificação, digite -1) || (Se quiser avançar, digite 0)\nRequer atividade de realização? (sim/nao):");
            if(atReal.equalsIgnoreCase("-1")){
                controller.especificarServico(serviceBuilder.build());
                return false;
            }
            else if(atReal.equalsIgnoreCase("0")){
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
        return true;
    }

    private boolean inserirAtAprovacao(ServiceBuilder serviceBuilder) {
        boolean flagAtAprov = true;
        boolean booleanAprov = true;
        while (flagAtAprov) {
            final String atAprov = Console.readLine("(Se quiser sair da especificação, digite -1) || (Se quiser avançar, digite 0)\nTem atividade de aprovação? (sim/nao):");
            if(atAprov.equalsIgnoreCase("-1")){
                controller.especificarServico(serviceBuilder.build());
                return false;
            }
            else if(atAprov.equalsIgnoreCase("0")){
                return true;
            }
            if (atAprov.equalsIgnoreCase("sim")) {
                flagAtAprov = false;
            }

            if (atAprov.equalsIgnoreCase("nao")) {
                booleanAprov = false;
                flagAtAprov = false;
            }
        }
        serviceBuilder.comAtAprov(booleanAprov);
        return true;
    }

    private boolean inserirIcone(ServiceBuilder serviceBuilder) {
        int imageBin = 0;
        final String caminho = Console.readLine("(Se quiser sair da especificação, digite -1) || (Se quiser avançar, digite 0)\nIndique o caminho (path) do ícone:");
        if(caminho.equalsIgnoreCase("-1")){
            controller.especificarServico(serviceBuilder.build());
            return false;
        }
        else if(caminho.equalsIgnoreCase("0")){
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
        return true;
    }

    private boolean inserirCatalogo(ServiceBuilder serviceBuilder, List<Catalogo> listaCatalogos) {
        boolean findCatalogo = true;
        for (Catalogo catalogo : listaCatalogos)
            System.out.println(catalogo.toString());

        Catalogo catalogo = null;
        int index;

        while (findCatalogo) {
            index = Console.readInteger("(Se quiser sair da especificação, digite -1) || (Se quiser avançar, digite 0)\nIndique o catálogo");
            if(index == -1){
                controller.especificarServico(serviceBuilder.build());
                return false;
            }
            else if(index == 0){
                return true;
            }
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
        return true;
    }

    private boolean inserirDescComp(ServiceBuilder serviceBuilder) {
        final String descComp = Console.readLine("(Se quiser sair da especificação, digite -1) || (Se quiser avançar, digite 0)\nDescrição Completa:");
        if(descComp.equalsIgnoreCase("-1")){
            controller.especificarServico(serviceBuilder.build());
            return false;
        }
        else if(descComp.equalsIgnoreCase("0")){
            return true;
        }
        serviceBuilder.comDescComp(descComp);
        return true;
    }

    private boolean inserirDescBreve(ServiceBuilder serviceBuilder) {
        final String descBreve = Console.readLine("(Se quiser sair da especificação, digite -1) || (Se quiser avançar, digite 0)\nDescrição Breve:");
        if(descBreve.equalsIgnoreCase("-1")){
            controller.especificarServico(serviceBuilder.build());
            return false;
        }
        else if(descBreve.equalsIgnoreCase("0")){
            return true;
        }
        serviceBuilder.comDescBreve(descBreve);
        return true;
    }

    private String alterar() {
        String alterar;
        do {
            alterar = Console.readLine("Deseja alterar? (sim/nao)");
        }while (validaSimNao(alterar));

        return alterar;
    }


    private boolean validaSimNao(String a) {
        return !a.equalsIgnoreCase("sim") && !a.equalsIgnoreCase("nao");
    }

    @Override
    public String headline() {
        return "Especificar Serviço";
    }
}
