package eapli.base.app.common.console.presentation.EspecificarServicoUI;

import eapli.base.atividadeRealizacao.domain.TipoExecucao;
import eapli.base.catalogo.domain.Catalogo;
import eapli.base.colaborador.domain.Colaborador;
import eapli.base.criticidade.application.EspecificarNivelCriticidadeController;
import eapli.base.criticidade.domain.NivelCriticidade;
import eapli.base.criticidade.domain.Objetivo;
import eapli.base.equipa.domain.Equipa;
import eapli.base.atividadeAprovacao.domain.AtividadeAprovacao;
import eapli.base.atividadeRealizacao.domain.AtividadeRealizacao;
import eapli.base.atividadeAprovacao.domain.ColaboradoresAprovacao;
import eapli.base.fluxoAtividade.domain.FluxoAtividade;
import eapli.base.fluxoAtividade.builder.FluxoAtividadeBuilder;
import eapli.base.formulario.domain.Formulario;
import eapli.base.formulario.gramatica.ValidaScript;
import eapli.base.servico.application.EspecificarServicoController;
import eapli.base.servico.builder.ServiceBuilder;
import eapli.base.servico.domain.*;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class EspecificarServicoUI extends AbstractUI {

    private final EspecificarServicoController controller = new EspecificarServicoController();
    private final EspecificarNivelCriticidadeController controllerNivelCrit = new EspecificarNivelCriticidadeController();
    List<NivelCriticidade> niveisCriticidade = (List<NivelCriticidade>) controllerNivelCrit.niveisCriticidadeDefault();
    private final FormularioHelper fh = new FormularioHelper();
    private Catalogo catalogo = null;
    private Colaborador colab = null;
    private TipoExecucao tipoExec;
    private String scriptAutomatico;

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

        if (servico == null) {
            return especificarNovoServico();
        } else {
            return especificarServicoUI(servico);
        }
    }

    private boolean especificarNovoServico() {
        List<Catalogo> listaCatalogos = (List<Catalogo>) controller.listaCatalogos();
        ServiceBuilder serviceBuilder = new ServiceBuilder();

        final String identificador = Console.readLine("(Se quiser sair da especificação, digite -1) \n Identificador do Serviço:");

        Iterable<Servico> listaServicos = controller.listaServicos();

        for (Servico serv : listaServicos) {
            if (serv.identity().toString().equalsIgnoreCase(identificador)) {
                System.out.println("Já existe um Serviço com esse identificador.");
                return false;
            }
        }


        if (identificador.equalsIgnoreCase("-1")) {
            return false;
        }
        serviceBuilder.comIdentificador(identificador);

        if (!inserirTitulo(serviceBuilder))
            return false;

        FluxoAtividadeBuilder fluxoAtivBuilder = new FluxoAtividadeBuilder();
        serviceBuilder.comEstado(EstadoServico.INCOMPLETO);
        List<ColaboradoresAprovacao> colabsAprov = new ArrayList<>();
        List<Equipa> equipasExec = new ArrayList<>();
        List<Formulario> formularios = new ArrayList<>();

        if (!inserirDescBreve(serviceBuilder, formularios, fluxoAtivBuilder)) {
            controller.especificarServico(serviceBuilder.build());
            return false;
        }

        if (!inserirDescComp(serviceBuilder, formularios, fluxoAtivBuilder)) {
            controller.especificarServico(serviceBuilder.build());
            return false;
        }

        if (!inserirCatalogo(serviceBuilder, listaCatalogos, formularios, fluxoAtivBuilder)) {
            controller.especificarServico(serviceBuilder.build());
            return false;
        }
        if (!inserirIcone(serviceBuilder, formularios, fluxoAtivBuilder)) {
            controller.especificarServico(serviceBuilder.build());
            return false;
        }


        if (inserirAtAprovacao(serviceBuilder, null, colabsAprov, formularios, fluxoAtivBuilder)) {
            if (!colabsAprov.isEmpty())
                fluxoComAtividadeAprovacao(fluxoAtivBuilder, colabsAprov);
        } else {
            controller.especificarServico(serviceBuilder.build());
            return false;
        }

        if (inserirAtRealizacao(serviceBuilder, equipasExec, catalogo, formularios, fluxoAtivBuilder)) {
            if (colab != null) {
                AtividadeRealizacao ativRealizacao = new AtividadeRealizacao(colab, tipoExec, scriptAutomatico);
                fluxoAtivBuilder.comAtividadeRealizacao(ativRealizacao);
            } else if (!equipasExec.isEmpty()) {
                fluxoComAtividadeRealizacao(fluxoAtivBuilder, equipasExec);
            }
        } else {
            controller.especificarServico(serviceBuilder.build());
            return false;
        }

        if (!inserirKeywords(serviceBuilder, formularios, fluxoAtivBuilder)) {
            controller.especificarServico(serviceBuilder.build());
            return false;
        }

        if (!inserirRequerFeedback(serviceBuilder, formularios, fluxoAtivBuilder)) {
            controller.especificarServico(serviceBuilder.build());
            return false;
        }

        formularios = especificarFormulario();

        associarNivelCrit(serviceBuilder);

        finalizarServico(serviceBuilder, formularios, fluxoAtivBuilder);

        return true;
    }

    private boolean especificarServicoUI(Servico serv) {

        ServiceBuilder serviceBuilder = new ServiceBuilder();

        serviceBuilder.comIdentificador(serv.identity().toString());

        System.out.println("Título Atual: " + serv.tituloDoServico().toString());
        if (alterar().equalsIgnoreCase("sim")) {
            if (!inserirTitulo(serviceBuilder))
                return false;
        } else {
            serviceBuilder.comTitulo(serv.tituloDoServico().toString());
        }

        serviceBuilder.comEstado(EstadoServico.INCOMPLETO);
        List<ColaboradoresAprovacao> colabsAprov = new ArrayList<>();
        if (serv.fluxoDoServico() != null) {
            if (serv.fluxoDoServico().ativAprovacaoDoFluxo() != null) {
                colabsAprov = new ArrayList<>(serv.fluxoDoServico().ativAprovacaoDoFluxo().colabsDeAprovacao());
            }
        }
        List<Equipa> equipasExec = new ArrayList<>();
        if (serv.fluxoDoServico() != null) {
            if (serv.fluxoDoServico().ativRealizacaoDoFluxo() != null) {
                equipasExec = new ArrayList<>(serv.fluxoDoServico().ativRealizacaoDoFluxo().equipasExecucao());
            }
        }

        List<Formulario> formularios = new ArrayList<>(serv.formulariosDoServico());

        if(serv.descricaoBreveDoServico() != null){
            serviceBuilder.comDescBreve(serv.descricaoBreveDoServico().toString());
        }
        if(serv.descricaoCompletaDoServico() != null){
            serviceBuilder.comDescComp(serv.descricaoCompletaDoServico().toString());
        }

        serviceBuilder.comIcon(serv.iconDoServico())
                .comEstado(serv.estado()).comCatalogo(serv.catalogo()).comFluxo(serv.fluxoDoServico())
                .comRequerFeedback(serv.requerFeedbackDoServico()).comNivelCrit(serv.nivelCriticidadeServico()).comKeywords(serv.listaKewordsDoServico());

        FluxoAtividadeBuilder fluxoAtivBuilder = new FluxoAtividadeBuilder();

        if (serv.fluxoDoServico() != null) {
            fluxoAtivBuilder.comAtividadeRealizacao(serv.fluxoDoServico().ativRealizacaoDoFluxo());
            fluxoAtivBuilder.comAtividadeAprovacao(serv.fluxoDoServico().ativAprovacaoDoFluxo());
        }

        if (serv.descricaoBreveDoServico() != null) {
            System.out.println("Descrição Breve atual:   " + serv.descricaoBreveDoServico().toString());
            if (alterar().equalsIgnoreCase("sim")) {
                if (!inserirDescBreve(serviceBuilder, formularios, fluxoAtivBuilder))
                    return false;
            } else {
                serviceBuilder.comDescBreve(serv.descricaoBreveDoServico().toString());
            }
        } else {
            if (!inserirDescBreve(serviceBuilder, formularios, fluxoAtivBuilder))
                return false;
        }


        if (serv.descricaoCompletaDoServico() != null) {
            System.out.println("Descrição Completa atual:   " + serv.descricaoCompletaDoServico().toString());
            if (alterar().equalsIgnoreCase("sim")) {
                if (!inserirDescComp(serviceBuilder, formularios, fluxoAtivBuilder))
                    return false;
            } else {
                serviceBuilder.comDescComp(serv.descricaoCompletaDoServico().toString());
            }
        } else {
            if (!inserirDescComp(serviceBuilder, formularios, fluxoAtivBuilder))
                return false;
        }

        List<Catalogo> listaCatalogos = (List<Catalogo>) controller.listaCatalogos();

        if (serv.catalogo() != null) {
            System.out.println("Catalogo atual:   " + serv.catalogo().toString());
            if (alterar().equalsIgnoreCase("sim")) {
                if (!inserirCatalogo(serviceBuilder, listaCatalogos, formularios, fluxoAtivBuilder))
                    return false;
            } else {
                catalogo = serv.catalogo();
                serviceBuilder.comCatalogo(serv.catalogo());
            }
        } else {
            if (!inserirCatalogo(serviceBuilder, listaCatalogos, formularios, fluxoAtivBuilder))
                return false;
        }


        if (serv.iconDoServico() != null) {
            System.out.println("Já tem um ícon associado.");
            if (alterar().equalsIgnoreCase("sim")) {
                if (!inserirIcone(serviceBuilder, formularios, fluxoAtivBuilder))
                    return false;
            } else {
                serviceBuilder.comIcon(serv.iconDoServico());
            }
        } else {
            if (!inserirIcone(serviceBuilder, formularios, fluxoAtivBuilder))
                return false;
        }


        if (!colabsAprov.isEmpty())
            System.out.println("Colaboradores de Aprovação atuais:   " + serv.fluxoDoServico().ativAprovacaoDoFluxo().colabsDeAprovacao());
        else
            System.out.println("Não tem atividade de aprovação");
        if (alterar().equalsIgnoreCase("sim")) {
            if (inserirAtAprovacao(serviceBuilder, serv, colabsAprov, formularios, fluxoAtivBuilder)) {
                if (!colabsAprov.isEmpty())
                    fluxoComAtividadeAprovacao(fluxoAtivBuilder, colabsAprov);
            } else {
                return false;
            }
        }

        if (serv.fluxoDoServico() != null) {
            if (serv.fluxoDoServico().ativRealizacaoDoFluxo() != null)
                System.out.println("Atividade de Realização atual:   " + serv.fluxoDoServico().ativRealizacaoDoFluxo().toString());
            else
                System.out.println("Não tem tipo de atividade de Realização");
            if (alterar().equalsIgnoreCase("sim")) {
                if (!comAtividadeRealizacao(serviceBuilder, equipasExec, formularios, fluxoAtivBuilder))
                    return false;
            }
        } else {
            if (!comAtividadeRealizacao(serviceBuilder, equipasExec, formularios, fluxoAtivBuilder))
                return false;
        }


        if (serv.listaKewordsDoServico() != null && serv.listaKewordsDoServico().size() > 0) {
            System.out.println("Lista de Keywords atual:   " + serv.listaKewordsDoServico().toString());
            if (alterar().equalsIgnoreCase("sim")) {
                if (!inserirKeywords(serviceBuilder, formularios, fluxoAtivBuilder))
                    return false;
            } else {
                for (Keyword k : serv.listaKewordsDoServico())
                    serviceBuilder.adicionarKeyword(k.toString());
            }
        } else {
            if (!inserirKeywords(serviceBuilder, formularios, fluxoAtivBuilder))
                return false;
        }


        System.out.println("Pedido de requerimento de Feedback atual:   " + serv.requerFeedbackDoServico());
        if (alterar().equalsIgnoreCase("sim")) {
            if (!inserirRequerFeedback(serviceBuilder, formularios, fluxoAtivBuilder)) {
                especificarServico(serviceBuilder, formularios, fluxoAtivBuilder);
                return false;
            }
        } else {
            serviceBuilder.comRequerFeedback(serv.requerFeedbackDoServico());
        }

        List<Formulario> formsServ = especificarFormulario();
        if(formsServ != null)
        formularios.addAll(formsServ);
        associarNivelCrit(serviceBuilder);

        finalizarServico(serviceBuilder, formularios, fluxoAtivBuilder);

        return true;
    }


    private void finalizarServico(ServiceBuilder serviceBuilder, List<Formulario> formularios, FluxoAtividadeBuilder fluxoAtivBuilder) {
        String completar;
        do {
            completar = Console.readLine("Deseja dar este Serviço como completo? (sim/nao)");
        } while (validaSimNao(completar));
        Servico serv = especificarServico(serviceBuilder, formularios, fluxoAtivBuilder);
        if (completar.equalsIgnoreCase("sim")) {
            if (serv.estaCompleto()) {
                serv.completar();
                controller.especificarServico(serv);
                System.out.println("Serviço Completo especificado\n");
            } else {
                System.out.println("O serviço não ficou completo pois não tem todos os campos obrigatórios preenchidos");
                controller.especificarServico(serv);
            }
        } else {
            System.out.println("O Serviço Incompleto ficou registado\n");
            controller.especificarServico(serv);
        }
    }

    private List<Formulario> especificarFormulario() {
        List<Formulario> listaFormularios = new ArrayList<>();
        String strContinuar;
        do {
            strContinuar = Console.readLine("Deseja continuar com a especificação, passando agora ao formulário? (sim/nao):");
        } while (validaSimNao(strContinuar));

        if (strContinuar.equalsIgnoreCase("sim")) {
            String novoForm;
            do {
                Formulario f = fh.form();
                listaFormularios.add(f);
                novoForm = Console.readLine("Deseja especificar outro formulario?  (sim|não)");
            } while (novoForm.contains("sim"));
        } else
            return null;
        return listaFormularios;
    }


    private void fluxoComAtividadeAprovacao(FluxoAtividadeBuilder fluxoAtivBuilder, List<ColaboradoresAprovacao> colabsAprov) {
        AtividadeAprovacao atividadeAprovacao = new AtividadeAprovacao();
        List<Formulario> formsAprovacao = especificarFormulario();
        if (formsAprovacao != null)
            for (Formulario f : formsAprovacao)
                atividadeAprovacao.adicionaFormulario(f);
        for (ColaboradoresAprovacao ca : colabsAprov)
            atividadeAprovacao.adicionaColabAprov(ca);
        fluxoAtivBuilder.comAtividadeAprovacao(atividadeAprovacao);
    }

    private void fluxoComAtividadeRealizacao(FluxoAtividadeBuilder fluxoAtivBuilder, List<Equipa> equipasExec) {
        AtividadeRealizacao ativRealizacao = new AtividadeRealizacao(tipoExec, scriptAutomatico);
        List<Formulario> formsRealizacao = especificarFormulario();
        if (formsRealizacao != null)
            for (Formulario f : formsRealizacao)
                ativRealizacao.adicionaFormulario(f);
        for (Equipa eq : equipasExec)
            ativRealizacao.adicionarEquipaExecucao(eq);
        fluxoAtivBuilder.comAtividadeRealizacao(ativRealizacao);
    }

    private boolean inserirTitulo(ServiceBuilder serviceBuilder) {
        final String titulo = Console.readLine("(Se quiser sair da especificação, digite -1)\nTítulo:");
        if (titulo.equalsIgnoreCase("-1")) {
            return false;
        }

        serviceBuilder.comTitulo(titulo);
        return true;
    }

    private boolean comAtividadeRealizacao(ServiceBuilder serviceBuilder, List<Equipa> equipasExec, List<Formulario> formularios, FluxoAtividadeBuilder fluxoAtivBuilder) {

        if (inserirAtRealizacao(serviceBuilder, equipasExec, catalogo, formularios, fluxoAtivBuilder)) {
            if (colab != null) {
                AtividadeRealizacao ativRealizacao = new AtividadeRealizacao(colab, tipoExec, scriptAutomatico);
                List<Formulario> formsRealizacao = especificarFormulario();
                if (formsRealizacao != null)
                    for (Formulario f : formsRealizacao)
                        ativRealizacao.adicionaFormulario(f);

                fluxoAtivBuilder.comAtividadeRealizacao(ativRealizacao);
            } else if (!equipasExec.isEmpty()) {
                fluxoComAtividadeRealizacao(fluxoAtivBuilder, equipasExec);
            }
        } else {
            return false;
        }
        return true;
    }

    private boolean inserirRequerFeedback(ServiceBuilder serviceBuilder, List<Formulario> formularios, FluxoAtividadeBuilder fluxoAtivBuilder) {
        boolean requerFeed = false;
        String strFeed;
        do {
            strFeed = Console.readLine("(Se quiser sair da especificação, digite -1) || (Se quiser avançar, digite 0)\nEste serviço requer feedback por parte do colaborador? (sim|nao)");
            if (strFeed.equalsIgnoreCase("-1")) {
                especificarServico(serviceBuilder, formularios, fluxoAtivBuilder);
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

    private boolean inserirAtRealizacao(ServiceBuilder serviceBuilder, List<Equipa> equipasExec, Catalogo catalogo, List<Formulario> formularios, FluxoAtividadeBuilder fluxoAtivBuilder) {
        boolean flag = true;
        while (flag) {
            final String atReal = Console.readLine("(Se quiser sair da especificação, digite -1) || (Se quiser avançar, digite 0)\nRequer atividade de realização automática ou manual? (aut/man):");
            if (atReal.equalsIgnoreCase("-1")) {
                fluxoAtivBuilder.comAtividadeRealizacao(null);
                especificarServico(serviceBuilder, formularios, fluxoAtivBuilder);
                return false;
            } else if (atReal.equalsIgnoreCase("0")) {
                fluxoAtivBuilder.comAtividadeRealizacao(null);
                colab = null;
                equipasExec.clear();
                return true;
            } else if (atReal.equalsIgnoreCase("aut")) {
                equipasExec.clear();
                colab = null;
                tipoExec = TipoExecucao.AUTOMATICA;
                if (inserirScriptValidacaoTarefaAutomatica())
                    fluxoAtivBuilder.comAtividadeRealizacao(new AtividadeRealizacao(colab, tipoExec, scriptAutomatico));
                flag = false;
            } else if (atReal.equalsIgnoreCase("man")) {
                tipoExec = TipoExecucao.MANUAL;
                return escolherResponsavelExecucao(serviceBuilder, catalogo, equipasExec, formularios, fluxoAtivBuilder);
            } else {
                System.out.println("Dado incorreto \n");
            }
        }
        return true;
    }

    private boolean inserirScriptValidacaoTarefaAutomatica() {
        boolean flag = true;

        while (flag) {
            scriptAutomatico = Console.readLine("(0 para avançar) Insira o script de validação da Tarefa automática:");

            if (scriptAutomatico.equalsIgnoreCase("0")) {
                scriptAutomatico = null;
                return false;
            }

            if (ValidaScript.validadeGrammarFromString(scriptAutomatico))
                flag = false;
            else
                System.out.println("Script inválido");

        }

        return true;
    }

    private boolean escolherResponsavelExecucao(ServiceBuilder serviceBuilder, Catalogo catalogo, List<Equipa> equipasExec, List<Formulario> formularios, FluxoAtividadeBuilder fluxoAtivBuilder) {
        if (catalogo == null) {
            System.out.println("Indique primeiramente um catálogo");
            return false;
        }
        boolean flag = true;
        while (flag) {
            final String exec = Console.readLine("Que entidade vai executar o Serviço? (equipas/colab)");
            if (exec.equalsIgnoreCase("equipas")) {
                List<Equipa> equipasCatalogo = controller.equipasExecDoCatalogo(catalogo);
                if (equipasCatalogo.isEmpty()) {
                    System.out.println("O Catálogo não tem equipas associadas");
                    return true;
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
                            especificarServico(serviceBuilder, formularios, fluxoAtivBuilder);
                        return false;
                    } else if (index == 0) {
                        if (equipasCatalogo.size() == size)
                            System.out.println("Selecione pelo menos uma Equipa");
                        else
                            findEquipa = false;
                        flag = false;
                    } else if (index > 0 && index <= equipasCatalogo.size()) {
                        equipasExec.add(equipasCatalogo.get(index - 1));
                        equipasCatalogo.remove(index - 1);
                    } else {
                        System.out.println("Coloque um index válido");
                    }
                }
            } else if (exec.equalsIgnoreCase("colab")) {
                List<Colaborador> colabsExec = controller.colabsExecCatalogo(catalogo);
                if (colabsExec.isEmpty()) {
                    System.out.println("Não há colaboradores nas equipas do Catálogo");
                    return true;
                }

                int i = 1;
                for (Colaborador col : colabsExec) {
                    System.out.println(i + ") " + col.toString());
                    i++;
                }

                equipasExec = new ArrayList<>();

                boolean findColab = true;
                while (findColab) {
                    if (colabsExec.isEmpty()) {
                        System.out.println("Não há Colaboradores para associar");
                        return false;
                    }

                    int index = Console.readInteger("\nIndique o Colaborador");
                    if (index > 0 && index <= colabsExec.size()) {
                        this.colab = colabsExec.get(index - 1);
                        findColab = false;
                        flag = false;
                    } else {
                        System.out.println("Coloque um index válido");
                    }
                }
            } else
                System.out.println("Escolha uma equipa ou um colaborador");
        }
        return true;
    }

    private boolean inserirAtAprovacao(ServiceBuilder serviceBuilder, Servico serv, List<ColaboradoresAprovacao> colabsAprov, List<Formulario> formularios, FluxoAtividadeBuilder fluxoAtivBuilder) {
        if (catalogo == null) {
            System.out.println("Indique primeiramente um catálogo para poder escolher Colaboradores de Aprovação");
            return true;
        }
        boolean flagAtAprov = true;
        while (flagAtAprov) {
            final String atAprov = Console.readLine("(Se quiser sair da especificação, digite -1) || (Se quiser avançar, digite 0)\nTem atividade de aprovação? (sim/nao):");
            if (atAprov.equalsIgnoreCase("-1")) {
                especificarServico(serviceBuilder, formularios, fluxoAtivBuilder);
                return false;
            } else if (atAprov.equalsIgnoreCase("0")) {
                return true;
            }
            if (atAprov.equalsIgnoreCase("sim")) {
                if (serv == null) {
                    inserirColabs(colabsAprov);
                } else {
                    if (colabsAprov.size() == 0)
                        System.out.println("Ainda não tem colaboradores para aprovar");
                    else
                        System.out.println("Lista de colaboradores para Aprovar:" + colabsAprov);
                    if (alterar().equalsIgnoreCase("sim"))
                        return inserirColabs(colabsAprov);
                }
                flagAtAprov = false;
            }

            if (atAprov.equalsIgnoreCase("nao")) {
                flagAtAprov = false;
                colabsAprov.clear();
                fluxoAtivBuilder.comAtividadeAprovacao(null);
            }
        }
        return true;
    }


    private boolean inserirColabs(List<ColaboradoresAprovacao> colabsAprov) {
        boolean findColab = true;
        int index;

        Set<ColaboradoresAprovacao> aux = new HashSet<>();

        colabsAprov.clear();

        while (findColab) {

            System.out.println("1) Colaborador Do Serviço \n2) Responsável hierárquico");

            index = Console.readInteger("Indique o(s) Colaborador(es) (0 para sair)");

            if (index == 0) {
                if (aux.size() == 0)
                    System.out.println("Selecione pelo menos um Colaborador");
                else {
                    findColab = false;
                    colabsAprov.addAll(aux);

                }
            } else if (index == 1) {
                aux.add(ColaboradoresAprovacao.RESPONSAVEL_PELO_SERVICO);
            } else if (index == 2) {
                aux.add(ColaboradoresAprovacao.RESPONSAVEL_HIERARQUICO);
            } else {
                System.out.println("Coloque um index válido");
            }
        }

        return true;
    }

    private boolean inserirKeywords(ServiceBuilder serviceBuilder, List<Formulario> formularios, FluxoAtividadeBuilder fluxoAtivBuilder) {
        boolean flag = true;
        while (flag) {
            String keyword = Console.readLine("Indique as palavras-chave \\n 0 para sair");
            if (keyword.equalsIgnoreCase("-1")) {
                especificarServico(serviceBuilder, formularios, fluxoAtivBuilder);
                return false;
            }
            if (keyword.equals("0"))
                flag = false;
            else
                serviceBuilder.adicionarKeyword(keyword);
        }
        return true;
    }

    private boolean inserirIcone(ServiceBuilder serviceBuilder, List<Formulario> formularios, FluxoAtividadeBuilder fluxoAtivBuilder) {
        int imageBin = 0;
        final String caminho = Console.readLine("(Se quiser sair da especificação, digite -1) || (Se quiser avançar, digite 0)\nIndique o caminho (path) do ícone:");
        if (caminho.equalsIgnoreCase("-1")) {
            especificarServico(serviceBuilder, formularios, fluxoAtivBuilder);
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

    private boolean inserirCatalogo(ServiceBuilder serviceBuilder, List<Catalogo> listaCatalogos, List<Formulario> formularios, FluxoAtividadeBuilder fluxoAtivBuilder) {
        boolean findCatalogo = true;
        for (Catalogo cat : listaCatalogos)
            System.out.println(cat.toString());

        int index;

        while (findCatalogo) {
            index = Console.readInteger("(Se quiser sair da especificação, digite -1) || (Se quiser avançar, digite 0)\nIndique o catálogo");
            if (index == -1) {
                especificarServico(serviceBuilder, formularios, fluxoAtivBuilder);
                return false;
            } else if (index == 0) {
                return true;
            }
            for (Catalogo cat : listaCatalogos) {
                if (cat.identity() == index) {
                    this.catalogo = cat;
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

    private boolean inserirDescComp(ServiceBuilder serviceBuilder, List<Formulario> formularios, FluxoAtividadeBuilder fluxoAtivBuilder) {
        final String descComp = Console.readLine("(Se quiser sair da especificação, digite -1) || (Se quiser avançar, digite 0)\nDescrição Completa:");
        if (descComp.equalsIgnoreCase("-1")) {
            especificarServico(serviceBuilder, formularios, fluxoAtivBuilder);
            return false;
        } else if (descComp.equalsIgnoreCase("0")) {
            return true;
        }
        serviceBuilder.comDescComp(descComp);
        return true;
    }

    private boolean inserirDescBreve(ServiceBuilder serviceBuilder, List<Formulario> formularios, FluxoAtividadeBuilder fluxoAtivBuilder) {
        final String descBreve = Console.readLine("(Se quiser sair da especificação, digite -1) || (Se quiser avançar, digite 0)\nDescrição Breve:");
        if (descBreve.equalsIgnoreCase("-1")) {
            especificarServico(serviceBuilder, formularios, fluxoAtivBuilder);
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

    public Servico especificarServico(ServiceBuilder serviceBuilder, List<Formulario> formularios, FluxoAtividadeBuilder fluxoAtividadeBuilder) {

        FluxoAtividade fluxoAtividade = fluxoAtividadeBuilder.build();
        Servico serv = serviceBuilder.build();
        if (serv.fluxoDoServico() != null) {
            FluxoAtividade fluxoExistente = serv.fluxoDoServico();
            if (fluxoAtividade.ativAprovacaoDoFluxo() == null) {
                fluxoExistente.definirAtividadeAprovacao(null);
            } else {
                fluxoExistente.definirAtividadeAprovacao(controller.guardaAtividadeAprovacao(fluxoAtividade.ativAprovacaoDoFluxo()));
            }
            if (fluxoAtividade.ativRealizacaoDoFluxo() == null) {
                fluxoExistente.definirAtividadeRealizacao(null);
            } else {
                fluxoExistente.definirAtividadeRealizacao(controller.guardaAtividadeRealizacao(fluxoAtividade.ativRealizacaoDoFluxo()));
            }

            serviceBuilder.comFluxo(controller.guardaFluxo(fluxoExistente));

            if (fluxoAtividade.ativAprovacaoDoFluxo() == null && fluxoExistente.ativAprovacaoDoFluxo() != null) {
                controller.removerAtividadeAprovacao(fluxoExistente.ativAprovacaoDoFluxo());
            }
            if (fluxoAtividade.ativRealizacaoDoFluxo() == null && fluxoExistente.ativRealizacaoDoFluxo() != null) {
                controller.removerAtividadeRealizacao(fluxoExistente.ativRealizacaoDoFluxo());
            }
        } else {
            AtividadeRealizacao atReal = null;
            AtividadeAprovacao atAprov = null;
            if (fluxoAtividade.ativRealizacaoDoFluxo() != null) {
                atReal = controller.guardaAtividadeRealizacao(fluxoAtividade.ativRealizacaoDoFluxo());
            }
            if (fluxoAtividade.ativAprovacaoDoFluxo() != null) {
                atAprov = controller.guardaAtividadeAprovacao(fluxoAtividade.ativAprovacaoDoFluxo());
            }
            if(fluxoAtividade.ativRealizacaoDoFluxo() != null || fluxoAtividade.ativRealizacaoDoFluxo() != null)
                serviceBuilder.comFluxo(controller.guardaFluxo(new FluxoAtividade(atAprov, atReal)));
        }
        Servico servv = serviceBuilder.build();

        for (Formulario formulario : formularios) {
            controller.adicionaFormulario(servv, controller.guardaFormulario(formulario));
        }

        return servv;
    }

    private boolean validaSimNao(String a) {
        return !a.equalsIgnoreCase("sim") && !a.equalsIgnoreCase("nao");
    }

    private NivelCriticidade escolherNivelCrit() {
        NivelCriticidade nivelCriticidade = null;
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
        }
        return nivelCriticidade;
    }

    private Objetivo novoObjetivo() {
        boolean flag = true;
        int aprovacaoMax = -1;
        int resolucaoMax = -1;

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
        return new Objetivo(aprovacaoMax, resolucaoMax, 0, 0);
    }

    private NivelCriticidade criarNivelCriticidade(NivelCriticidade nivelCriticidade, Objetivo objetivo) {
        return new NivelCriticidade(nivelCriticidade.getEtiqueta(), nivelCriticidade.getValorDeEscala(), nivelCriticidade.getCor(), objetivo, nivelCriticidade.isDefault());
    }

    private boolean associarNivelCrit(ServiceBuilder serviceBuilder) {
        String nivelCrit;
        NivelCriticidade novoNivelCriticidade;
        boolean flag;

        if (this.catalogo.nivelCritToService() != null) {
            do {
                nivelCrit = Console.readLine("Deseja associar o nível de criticidade associada" +
                        "ao catalogo deste Serviço? (sim/nao)");
            } while (validaSimNao(nivelCrit));
            if (nivelCrit.equalsIgnoreCase("sim")) {
                serviceBuilder.comNivelCrit(catalogo.nivelCritToService());
                System.out.println("Nível de criticidade do catálogo associado ao Serviço \n");
            }
        }
        novoNivelCriticidade = escolherNivelCrit();
        String objetivos;
        do {
            objetivos = Console.readLine("Pretende mudar os objetivos do nível de criticidade que está a associar ao Serviço:? (sim/nao)\n");
        } while (validaSimNao(objetivos));
        if (objetivos.equals("nao")) {
            serviceBuilder.comNivelCrit(novoNivelCriticidade);
            flag = true;
            System.out.println("O nível de criticidade foi adicionado ao serviço");
        } else {
            Objetivo novoObjetivo = novoObjetivo();
            novoNivelCriticidade = criarNivelCriticidade(novoNivelCriticidade, novoObjetivo);
            serviceBuilder.comNivelCrit(novoNivelCriticidade);
            System.out.println("O nível de criticidade personalizado foi adicionado ao serviço");
            flag = true;
        }

        return flag;
    }

    @Override
    public String headline() {
        return "Especificar Serviço";
    }
}
