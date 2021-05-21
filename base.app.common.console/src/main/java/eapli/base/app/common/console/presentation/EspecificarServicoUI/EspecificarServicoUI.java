package eapli.base.app.common.console.presentation.EspecificarServicoUI;

import eapli.base.catalogo.domain.Catalogo;
import eapli.base.colaborador.domain.Colaborador;
import eapli.base.equipa.domain.Equipa;
import eapli.base.formulario.domain.Formulario;
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
        do {
            System.out.println("0. Sair");
            System.out.println("1 .Especificar um novo serviço");
            opcao = Console.readLine("2. Especificar/alterar um serviço incompleto");

            if (opcao.equals("0"))
                return false;
        } while (!opcao.equalsIgnoreCase("1") && !opcao.equalsIgnoreCase("2"));

        Servico servico = null;
        if (opcao.equals("2")) {
            List<Servico> servicosIncompletos = controller.servicosIncompletos();

            if (servicosIncompletos.isEmpty()) {
                System.out.println("Não tem disponível serviços incompletos");
                return false;
            }

            boolean findServico = true;
            int index = 1;
            for (Servico svc : servicosIncompletos) {
                System.out.println(index + " " + svc.toString());
                index++;
            }
            while (findServico) {
                index = Console.readInteger("Indique o serviço");
                if (index == 0) {
                    return false;
                }
                if (index <= servicosIncompletos.size() && index > 0) {
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

        if (serv == null) {
            final String identificador = Console.readLine("(Se quiser sair da especificação, digite -1) \n Identificador do Serviço:");
            if (identificador.equalsIgnoreCase("-1")) {
                return false;
            }
            serviceBuilder.comIdentificador(identificador);
        } else {
            serviceBuilder.comIdentificador(serv.identity().toString());
        }


        if (serv == null) {
            if (!inserirTitulo(serviceBuilder))
                return false;
        } else {
            System.out.println("Título Atual: " + serv.tituloDoServico().toString());
            if (alterar().equalsIgnoreCase("sim")) {
                if (!inserirTitulo(serviceBuilder))
                    return false;
            } else {
                serviceBuilder.comTitulo(serv.tituloDoServico().toString());
            }
        }
        Catalogo catalogo = null;
        List<Colaborador> colabsAprov = new ArrayList<>();
        List<Equipa> equipasExec = new ArrayList<>();
        serviceBuilder.comEstado(EstadoServico.INCOMPLETO);

        if (serv == null) {
            if (!inserirDescBreve(serviceBuilder, colabsAprov, equipasExec))
                return false;
        } else {
            if (serv.descricaoBreveDoServico() != null) {
                System.out.println("Descrição Breve atual:   " + serv.descricaoBreveDoServico().toString());
                if (alterar().equalsIgnoreCase("sim")) {
                    if (!inserirDescBreve(serviceBuilder, colabsAprov, equipasExec))
                        return false;
                } else {
                    serviceBuilder.comDescBreve(serv.descricaoBreveDoServico().toString());
                }
            } else {
                if (!inserirDescBreve(serviceBuilder, colabsAprov, equipasExec))
                    return false;
            }
        }

        if (serv == null) {
            if (!inserirDescComp(serviceBuilder, colabsAprov, equipasExec))
                return false;
        } else {
            if (serv.descricaoCompletaDoServico() != null) {
                System.out.println("Descrição Completa atual:   " + serv.descricaoCompletaDoServico().toString());
                if (alterar().equalsIgnoreCase("sim")) {
                    if (!inserirDescComp(serviceBuilder, colabsAprov, equipasExec))
                        return false;
                } else {
                    serviceBuilder.comDescComp(serv.descricaoCompletaDoServico().toString());
                }
            } else {
                if (!inserirDescComp(serviceBuilder, colabsAprov, equipasExec))
                    return false;
            }
        }

        if (serv == null) {
            if (!inserirCatalogo(serviceBuilder, listaCatalogos, colabsAprov, equipasExec, catalogo))
                return false;
        } else {
            if (serv.catalogo() != null) {
                System.out.println("Catalogo atual:   " + serv.catalogo().toString());
                if (alterar().equalsIgnoreCase("sim")) {
                    if (!inserirCatalogo(serviceBuilder, listaCatalogos, colabsAprov, equipasExec, catalogo))
                        return false;
                } else {
                    serviceBuilder.comCatalogo(serv.catalogo());
                }
            } else {
                if (!inserirCatalogo(serviceBuilder, listaCatalogos, colabsAprov, equipasExec, catalogo))
                    return false;
            }
        }

        if (serv == null) {
            if (!inserirIcone(serviceBuilder, colabsAprov, equipasExec))
                return false;
        } else {
            if (serv.iconDoServico() != null) {
                System.out.println("Já tem um ícon associado.");
                if (alterar().equalsIgnoreCase("sim")) {
                    if (!inserirIcone(serviceBuilder, colabsAprov, equipasExec))
                        return false;
                } else {
                    serviceBuilder.comIcon(serv.iconDoServico());
                }
            } else {
                if (!inserirIcone(serviceBuilder, colabsAprov, equipasExec))
                    return false;
            }
        }

        if (serv == null) {
            if (!inserirAtAprovacao(serviceBuilder, serv, colabsAprov, equipasExec))
                return false;
        } else {
            System.out.println("Atividade de Aprovação atual:   " + serv.atividadeAprovacao());
            if (alterar().equalsIgnoreCase("sim")) {
                if (!inserirAtAprovacao(serviceBuilder, serv, colabsAprov, equipasExec))
                    return false;
            } else {
                serviceBuilder.comAtAprov(serv.atividadeAprovacao());
            }
        }


        if (serv == null) {
            if (!inserirAtRealizacao(serviceBuilder, colabsAprov, equipasExec, catalogo))
                return false;
        } else {
            System.out.println("Atividade de Realização atual:   " + serv.atividadeRealizacao());
            if (alterar().equalsIgnoreCase("sim")) {
                if (!inserirAtRealizacao(serviceBuilder, colabsAprov, equipasExec, catalogo))
                    return false;
            } else {
                serviceBuilder.comAtReal(serv.atividadeRealizacao());
            }
        }


        if (serv == null) {
            if (!inserirKeywords(serviceBuilder, colabsAprov, equipasExec))
                return false;
        } else {
            if (serv.listaKewordsDoServico() != null && serv.listaKewordsDoServico().size() > 0) {
                System.out.println("Lista de Keywords atual:   " + serv.listaKewordsDoServico().toString());
                if (alterar().equalsIgnoreCase("sim")) {
                    if (!inserirKeywords(serviceBuilder, colabsAprov, equipasExec))
                        return false;
                } else {
                    for (Keyword k : serv.listaKewordsDoServico())
                        serviceBuilder.adicionarKeyword(k.toString());
                }
            } else {
                if (!inserirKeywords(serviceBuilder, colabsAprov, equipasExec))
                    return false;
            }
        }

        if (serv == null) {
            if (!inserirRequerFeedback(serviceBuilder, colabsAprov, equipasExec))
                return false;
        } else {
            System.out.println("Pedido de requerimento de Feedback atual:   " + serv.requerFeedbackDoServico());
            if (alterar().equalsIgnoreCase("sim")) {
                if (!inserirRequerFeedback(serviceBuilder, colabsAprov, equipasExec))
                    return false;
            } else {
                serviceBuilder.comRequerFeedback(serv.requerFeedbackDoServico());
            }
        }

        String strContinuar;
        do {
            strContinuar = Console.readLine("Deseja continuar com a especificação, passando agora ao formulário? (sim/nao):");
        } while (validaSimNao(strContinuar));

        if (strContinuar.equalsIgnoreCase("sim")) {
            serv = especificarServico(serviceBuilder, colabsAprov, equipasExec);
            String novoForm;
            do {
                Formulario f = fh.form();
                controller.adicionaFormulario(serv, f);
                novoForm = Console.readLine("Deseja especificar outro formulario?  (sim|não)");
            } while (novoForm.contains("sim"));
        }

        String completar;
        do {
            completar = Console.readLine("Deseja dar este Serviço como completo? (sim/nao)");
        } while (validaSimNao(strContinuar));
        if (completar.equalsIgnoreCase("sim")) {
            if (serv != null) {
                if (serv.estaCompleto()) {
                    serviceBuilder.comEstado(EstadoServico.COMPLETO);
                    especificarServico(serviceBuilder, colabsAprov, equipasExec);
                } else
                    System.out.println("O serviço não ficou completo pois não tem todos os campos obrigatórios preenchidos");
                especificarServico(serviceBuilder, colabsAprov, equipasExec);
            } else {
                System.out.println("Ocorreu um erro.");
            }
        }
        return true;
    }

    private boolean inserirTitulo(ServiceBuilder serviceBuilder) {
        final String titulo = Console.readLine("(Se quiser sair da especificação, digite -1)\nTítulo:");
        if (titulo.equalsIgnoreCase("-1")) {
            return false;
        }

        serviceBuilder.comTitulo(titulo);
        return true;
    }

    private boolean inserirRequerFeedback(ServiceBuilder serviceBuilder, List<Colaborador> colabsAprov, List<Equipa> equipasExec) {
        boolean requerFeed = false;
        String strFeed;
        do {
            strFeed = Console.readLine("(Se quiser sair da especificação, digite -1) || (Se quiser avançar, digite 0)\nEste serviço requer feedback por parte do colaborador? (sim|nao)");
            if (strFeed.equalsIgnoreCase("-1")) {
                especificarServico(serviceBuilder, colabsAprov, equipasExec);
                return false;
            } else if (strFeed.equalsIgnoreCase("0")) {
                return true;
            }
        } while (validaSimNao(strFeed));
        if (strFeed.equalsIgnoreCase("sim")) {
            requerFeed = true;
        }
        serviceBuilder.comRequerFeedback(requerFeed);
        return true;
    }

    private boolean inserirAtRealizacao(ServiceBuilder serviceBuilder, List<Colaborador> colabsAprov, List<Equipa> equipasExec, Catalogo catalogo) {
        boolean flag = true;
        boolean booleanReal = true;
        while (flag) {
            final String atReal = Console.readLine("(Se quiser sair da especificação, digite -1) || (Se quiser avançar, digite 0)\nRequer atividade de realização automática ou manual? (aut/man):");
            if (atReal.equalsIgnoreCase("-1")) {
                especificarServico(serviceBuilder, colabsAprov, equipasExec);
                return false;
            } else if (atReal.equalsIgnoreCase("0")) {
                return true;
            }
            if (atReal.equalsIgnoreCase("aut")) {
                flag = false;
            }
            if (atReal.equalsIgnoreCase("man")) {
                escolherResponsavelExecucao(serviceBuilder, colabsAprov,catalogo, equipasExec);
                booleanReal = false;
                flag = false;
            }
        }
        serviceBuilder.comAtReal(booleanReal);
        return true;
    }

    private boolean escolherResponsavelExecucao(ServiceBuilder serviceBuilder, List<Colaborador> colabsAprov, Catalogo catalogo, List<Equipa> equipasExec) {
        if(catalogo == null){
            System.out.println("Indique primeiramente um catálogo");
            return false;
        }
        while (true) {
            final String exec = Console.readLine("Que entidade vai executar o Serviço? (equipas/colab)");
            if (exec.equalsIgnoreCase("equipas")) {
                List<Equipa> equipasCatalogo = controller.equipasExecDoCatalogo(catalogo);
                if(equipasCatalogo.isEmpty()){
                    System.out.println("O Catálogo não tem equipas associadas");
                    return false;
                }
                int size = equipasCatalogo.size();
                boolean findEquipa = true;
                while (findEquipa) {
                    if (equipasCatalogo.isEmpty()) {
                        System.out.println("Não há mais Equipas para associar");
                        return true;
                    }
                    int i = 1;
                    for (Equipa eq : equipasCatalogo) {
                        System.out.println(i + ") " + eq.toString());
                        i++;
                    }

                    int index = Console.readInteger("(Se quiser sair da especificação, digite -1) || (Se quiser avançar, digite 0)\nIndique a Equipa");
                    if (index == -1) {
                        if (equipasCatalogo.size() == size)
                            System.out.println("Selecione pelo menos uma Equipa");
                        else
                            especificarServico(serviceBuilder, colabsAprov, equipasExec);
                        return false;
                    } else if (index == 0) {
                        if (equipasCatalogo.size() == size)
                            System.out.println("Selecione pelo menos uma Equipa");
                        else
                            findEquipa = false;
                    } else if (index > 0 && index <= equipasCatalogo.size()) {
                        equipasExec.add(equipasCatalogo.get(index - 1));
                        equipasCatalogo.remove(index - 1);
                    } else {
                        System.out.println("Coloque um index válido");
                    }
                }
            } else if (exec.equalsIgnoreCase("colab")) {
                List<Colaborador> colabsExec = controller.colabsExecCatalogo(catalogo);
                if(colabsExec.isEmpty()){
                    System.out.println("Não há colaboradores nas equipas do Catálogo");
                    return false;
                }

                int i = 1;
                for (Colaborador col : colabsExec) {
                    System.out.println(i + ") " + col.toString());
                    i++;
                }

                boolean findColab = true;
                while (findColab) {
                    if (colabsExec.isEmpty()) {
                        System.out.println("Não há Colaboradores para associar");
                        return true;
                    }

                    int index = Console.readInteger("\nIndique o Colaborador");
                     if (index > 0 && index <= colabsExec.size()) {
                        Colaborador colabExec = colabsExec.get(index -1);
                        serviceBuilder.comColabExec(colabExec);
                        findColab = false;
                    } else {
                        System.out.println("Coloque um index válido");
                    }
                }
            } else
                System.out.println("Escolha uma equipa ou um colaborador");
        }
    }

    private boolean inserirAtAprovacao(ServiceBuilder serviceBuilder, Servico serv, List<Colaborador> colabsAprov, List<Equipa> equipasExec) {
        boolean flagAtAprov = true;
        boolean booleanAprov = true;
        while (flagAtAprov) {
            final String atAprov = Console.readLine("(Se quiser sair da especificação, digite -1) || (Se quiser avançar, digite 0)\nTem atividade de aprovação? (sim/nao):");
            if (atAprov.equalsIgnoreCase("-1")) {
                especificarServico(serviceBuilder, colabsAprov, equipasExec);
                return false;
            } else if (atAprov.equalsIgnoreCase("0")) {
                return true;
            }
            if (atAprov.equalsIgnoreCase("sim")) {
                if (serv == null) {
                    inserirColabs(serviceBuilder, colabsAprov, equipasExec);
                } else {
                    if (serv.colabsAprov().size() == 0)
                        System.out.println("Ainda não tem colaboradores para aprovar");
                    else
                        System.out.println("Lista de colaboradores para Aprovar:" + serv.colabsAprov().toString());
                    if (alterar().equalsIgnoreCase("sim"))
                        inserirColabs(serviceBuilder, colabsAprov, equipasExec);
                }
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

    private boolean inserirColabs(ServiceBuilder serviceBuilder, List<Colaborador> colabsAprov, List<Equipa> equipasExec) {
        boolean findColab = true;
        List<Colaborador> colabs = controller.colabsAprov();
        int size = colabs.size();
        int index;

        while (findColab) {
            if (colabs.isEmpty()) {
                System.out.println("Não há mais colaboradores para Aprovar");
                return true;
            }
            int i = 1;
            for (Colaborador colab : colabs) {
                System.out.println(i + ") " + colab.toString());
                i++;
            }

            index = Console.readInteger("(Se quiser sair da especificação, digite -1) || (Se quiser avançar, digite 0)\nIndique o Colaborador");
            if (index == -1) {
                if (colabs.size() == size)
                    System.out.println("Selecione pelo menos um Colaborador");
                else
                    especificarServico(serviceBuilder, colabsAprov, equipasExec);
                return false;
            } else if (index == 0) {
                if (colabs.size() == size)
                    System.out.println("Selecione pelo menos um Colaborador");
                else
                    findColab = false;
            } else if (index > 0 && index <= colabs.size()) {
                colabsAprov.add(colabs.get(index - 1));
                colabs.remove(index - 1);
            } else {
                System.out.println("Coloque um index válido");
            }
        }
        return true;
    }

    private boolean inserirKeywords(ServiceBuilder serviceBuilder, List<Colaborador> colabsAprov, List<Equipa> equipasExec) {
        boolean flag = true;
        while (flag) {
            String keyword = Console.readLine("Indique as palavras-chave \\n 0 para sair");
            if (keyword.equalsIgnoreCase("-1")) {
                especificarServico(serviceBuilder, colabsAprov, equipasExec);
                return false;
            }
            if (keyword.equals("0"))
                flag = false;
            else
                serviceBuilder.adicionarKeyword(keyword);
        }
        return true;
    }

    private boolean inserirIcone(ServiceBuilder serviceBuilder, List<Colaborador> colabsAprov, List<Equipa> equipasExec) {
        int imageBin = 0;
        final String caminho = Console.readLine("(Se quiser sair da especificação, digite -1) || (Se quiser avançar, digite 0)\nIndique o caminho (path) do ícone:");
        if (caminho.equalsIgnoreCase("-1")) {
            especificarServico(serviceBuilder, colabsAprov, equipasExec);
            return false;
        } else if (caminho.equalsIgnoreCase("0")) {
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

    private boolean inserirCatalogo(ServiceBuilder serviceBuilder, List<Catalogo> listaCatalogos, List<Colaborador> colabsAprov, List<Equipa> equipasExec, Catalogo catalogo) {
        boolean findCatalogo = true;
        for (Catalogo cat : listaCatalogos)
            System.out.println(cat.toString());

        int index;

        while (findCatalogo) {
            index = Console.readInteger("(Se quiser sair da especificação, digite -1) || (Se quiser avançar, digite 0)\nIndique o catálogo");
            if (index == -1) {
                especificarServico(serviceBuilder, colabsAprov, equipasExec);
                return false;
            } else if (index == 0) {
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

    private boolean inserirDescComp(ServiceBuilder serviceBuilder, List<Colaborador> colabsAprov, List<Equipa> equipasExec) {
        final String descComp = Console.readLine("(Se quiser sair da especificação, digite -1) || (Se quiser avançar, digite 0)\nDescrição Completa:");
        if (descComp.equalsIgnoreCase("-1")) {
            especificarServico(serviceBuilder, colabsAprov, equipasExec);
            return false;
        } else if (descComp.equalsIgnoreCase("0")) {
            return true;
        }
        serviceBuilder.comDescComp(descComp);
        return true;
    }

    private boolean inserirDescBreve(ServiceBuilder serviceBuilder, List<Colaborador> colabsAprov, List<Equipa> equipasExec) {
        final String descBreve = Console.readLine("(Se quiser sair da especificação, digite -1) || (Se quiser avançar, digite 0)\nDescrição Breve:");
        if (descBreve.equalsIgnoreCase("-1")) {
            especificarServico(serviceBuilder, colabsAprov, equipasExec);
            return false;
        } else if (descBreve.equalsIgnoreCase("0")) {
            return true;
        }
        serviceBuilder.comDescBreve(descBreve);
        return true;
    }

    private String alterar() {
        String alterar;
        do {
            alterar = Console.readLine("Deseja alterar? (sim/nao)");
        } while (validaSimNao(alterar));

        return alterar;
    }

    public Servico especificarServico(ServiceBuilder serviceBuilder, List<Colaborador> colabsAprov, List<Equipa> equipasExec) {
        Servico serv = controller.especificarServico(serviceBuilder.build());
        for (Colaborador col : colabsAprov)
            controller.adicionaColabAprov(serv, col);
        for (Equipa eq : equipasExec)
            controller.adicionaEquipaExec(serv, eq);
        return serv;
    }

    private boolean validaSimNao(String a) {
        return !a.equalsIgnoreCase("sim") && !a.equalsIgnoreCase("nao");
    }

    @Override
    public String headline() {
        return "Especificar Serviço";
    }
}
