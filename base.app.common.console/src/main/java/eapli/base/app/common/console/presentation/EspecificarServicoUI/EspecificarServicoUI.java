package eapli.base.app.common.console.presentation.EspecificarServicoUI;

import eapli.base.formulario.application.EspecificarFormularioController;
import eapli.base.formulario.domain.Atributo;
import eapli.base.formulario.domain.NomeFormulario;
import eapli.base.formulario.domain.TipoDados;
import eapli.base.servico.application.EspecificarServicoController;
import eapli.base.servico.domain.Keyword;
import eapli.base.servico.domain.ServiceBuilder;
import eapli.base.servico.domain.Servico;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.HashSet;
import java.util.Set;

public class EspecificarServicoUI extends AbstractUI {

    private final EspecificarServicoController controller = new EspecificarServicoController();
    private final EspecificarFormularioController fc = new EspecificarFormularioController();


    @Override
    protected boolean doShow() {

        final String identificador = Console.readLine("Identificador do Serviço:");
        final String titulo = Console.readLine("Título:");

        final String descBreve = Console.readLine("Descrição Breve:");
        final String descComp = Console.readLine("Descrição Completa:");

        final int icon = Console.readInteger("Ícone:");

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
                //CRIAR KEYWORD NO BUILDER
                listaKeywords.add(new Keyword(keyword));

        }

        String estado = "COMPLETO"; //TODO MUDAR PARA FICAR implementado
        Set<Atributo> listaAtributo = new HashSet<>();
        flag = true;
        String continuar;
        NomeFormulario nf;
        String strContinuar;
        do {
            strContinuar = Console.readLine("Deseja continuar com a especificação do formulário? (sim/nao):");
        }while (!validaSimNao(strContinuar));

        if (strContinuar.equalsIgnoreCase("nao")) {
            estado = "INCOMPLETO";
            Servico servico = controller.especificarServico(identificador, titulo, descBreve, descComp, icon, booleanAprov, booleanReal, listaKeywords, estado);
        }
        else if(strContinuar.equalsIgnoreCase("sim"))
        {
            String nomeForm = Console.readLine("Nome do Formulario: ");
            nf = new NomeFormulario(nomeForm);
            while (flag) {
                String nomeVar = Console.readLine("Nome de variável do atributo \n");
                String lable = Console.readLine("Nome da lable \n");
                String descAjuda = Console.readLine("Curta descrição do atributo \n");
                String tipoDados;
                TipoDados a = new TipoDados();
                do{
                    tipoDados = Console.readLine("Tipo de dados do atributo (Numero inteiro - 1 | Frase - 2 | Numero fracional - 3 | Data - 4");
                    switch (tipoDados) {
                        case "1":
                            a = new TipoDados("INT");
                            break;
                        case "2":
                            a = new TipoDados("STRING");
                            break;
                        case "3":
                            a = new TipoDados("FLOAT");
                            break;
                        case "4":
                            a = new TipoDados("DATA");
                            break;
                    }
                }while(!validaDadosEscolha(tipoDados));

                Atributo at = new Atributo(nomeVar,lable,descAjuda,a,"Teste");
                listaAtributo.add(at);
                continuar = Console.readLine("Deseja especificar mais atributos para o formulario? (sim|nao)");
                if (continuar.equalsIgnoreCase("nao")) {
                    flag = false;
                }
            }
            try {
                Servico servico = controller.especificarServico(identificador, titulo, descBreve, descComp, icon, booleanAprov, booleanReal, listaKeywords, estado);
                fc.especificarFormulario(nf,servico,listaAtributo);
            } catch (ConcurrencyException e) {
                System.out.println("Ocorreu um erro > " + e.getLocalizedMessage());
                return false;
            }

        }
        return true;
    }

    @Override
    public String headline() {
        return "Especificar Serviço";
    }

    private boolean validaDadosEscolha(String a){
        return a.equals("1") || a.equals("2") || a.equals("3") || a.equals("4");
    }

    private boolean validaSimNao(String a){
        return a.equalsIgnoreCase("sim") || a.equalsIgnoreCase("nao");
    }
}
