package eapli.base.app.common.console.presentation.especificarServicoUI;

import eapli.base.formulario.application.EspecificarFormularioController;
import eapli.base.formulario.domain.Formulario;
import eapli.base.formulario.domain.NomeFormulario;
import eapli.base.formulario.domain.TipoDados;
import eapli.base.formulario.gramatica.ScriptFormularios;
import eapli.base.formulario.gramatica.ScriptTarefasAutomaticas;
import eapli.framework.io.util.Console;

public class FormularioHelper {

    private final EspecificarFormularioController fc = new EspecificarFormularioController();


    public Formulario form(boolean decisaoAprovacao, boolean conclusaoRealizacao) {
        boolean flag = true;
        String continuar;
        String nomeForm;
        NomeFormulario nomeFormulario;

        if (decisaoAprovacao) {
            nomeForm = "Formulário de Aprovação";
        } else if (conclusaoRealizacao) {
            nomeForm = "Formulario de Realização";
        } else {
            nomeForm = Console.readLine("Nome do Formulario: ");
        }
        nomeFormulario = new NomeFormulario(nomeForm);

        Formulario f = fc.especificarFormulario(nomeFormulario);

        if (decisaoAprovacao) {
            f.addAtributo("Decisão", "Decisão da Atividade de Aprovação",
                    "Decisão (deferido/indeferido) sobre a aprovação", TipoDados.DECISAO, "(Deferido|Indeferido)");
            continuar = Console.readLine("Deseja especificar atributos para o Formulário de Aprovação? (sim|nao)");
            if (continuar.equalsIgnoreCase("nao")) {
                return f;
            }
        } else if (conclusaoRealizacao) {
            continuar = Console.readLine("Deseja especificar atributos para o Formulário de Realização? (sim|nao)");
            if (continuar.equalsIgnoreCase("nao")) {
                return f;
            }
        }

        while (flag) {
            String nomeVar = Console.readLine("Nome de variável do atributo ");
            String lable = Console.readLine("Nome da label ");
            String descAjuda = Console.readLine("Curta descrição do atributo ");
            String tipoDados;
            TipoDados td = TipoDados.STRING;
            do {
                tipoDados = Console.readLine("Tipo de dados do atributo (Numero inteiro - 1 | Frase - 2 | Numero fracional - 3 | Data - 4| Booleano - 5| ");
                switch (tipoDados) {
                    case "1":
                        tipoDados = "INT";
                        td = TipoDados.INT;
                        break;
                    case "2":
                        tipoDados = "STRING";
                        td = TipoDados.STRING;
                        break;
                    case "3":
                        tipoDados = "FLOAT";
                        td = TipoDados.FRACIONAL;
                        break;
                    case "4":
                        tipoDados = "DATA";
                        td = TipoDados.DATA;
                        break;
                    case "5":
                        tipoDados = "BOOLEANO";
                        td = TipoDados.BOOLEANO;
                        break;
                    default:
                        System.out.println("Introduza um tipo de dados");
                }
            } while (validaDadosEscolha(tipoDados));

            String expReg = Console.readLine("Expressão regular para validação do atributo: ");

            f.addAtributo(nomeVar, lable, descAjuda, td, expReg);

            continuar = Console.readLine("Deseja especificar mais atributos para o formulario? (sim|nao)");
            if (continuar.equalsIgnoreCase("nao")) {
                flag = false;
            }
        }
        String script;
        do {
            script = Console.readLine("Introduza um script de validação para o formulario por favor: ");
        } while (!ScriptFormularios.validadeGrammarFromString(script));
        f.addScript(script);

        return f;
    }

    private boolean validaDadosEscolha(String a) {
        return a.contains("1") || a.contains("2") || a.contains("3") || a.contains("4");
    }


}
