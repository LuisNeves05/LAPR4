package eapli.base.app.common.console.presentation.EspecificarServicoUI;

import eapli.base.formulario.application.EspecificarFormularioController;
import eapli.base.formulario.domain.NomeFormulario;
import eapli.base.servico.application.EspecificarServicoController;
import eapli.base.servico.domain.Servico;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.io.util.Console;

public class FormularioHelper {

    private final EspecificarFormularioController fc = new EspecificarFormularioController();

    boolean flag = true;
    String continuar;
    String nomeForm = Console.readLine("Nome do Formulario: ");
    NomeFormulario nomeFormulario = new NomeFormulario(nomeForm);

    public boolean form(Servico servico){
            while(flag)
    {
        String nomeVar = Console.readLine("Nome de variável do atributo ");
        String lable = Console.readLine("Nome da label ");
        String descAjuda = Console.readLine("Curta descrição do atributo ");
        String tipoDados;
        do {
            tipoDados = Console.readLine("Tipo de dados do atributo (Numero inteiro - 1 | Frase - 2 | Numero fracional - 3 | Data - 4");
            switch (tipoDados) {
                case "1":
                    tipoDados = "INT";
                    break;
                case "2":
                    tipoDados = "STRING";
                    break;
                case "3":
                    tipoDados = "FLOAT";
                    break;
                case "4":
                    tipoDados = "DATA";
                    break;
            }
        } while (validaDadosEscolha(tipoDados));

        fc.addAtributo(nomeVar, lable, descAjuda, tipoDados, "Teste");
        continuar = Console.readLine("Deseja especificar mais atributos para o formulario? (sim|nao)");
        if (continuar.equalsIgnoreCase("nao")) {
            flag = false;
        }
    }
        fc.especificarFormulario(nomeFormulario,servico);
        return false;
    }

    private boolean validaDadosEscolha(String a) {
        return a.contains("1") || a.contains("2") || a.contains("3") || a.contains("4");
    }


}
