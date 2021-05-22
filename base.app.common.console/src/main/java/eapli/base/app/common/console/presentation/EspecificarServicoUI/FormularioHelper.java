package eapli.base.app.common.console.presentation.EspecificarServicoUI;

import eapli.base.formulario.application.EspecificarFormularioController;
import eapli.base.formulario.domain.Formulario;
import eapli.base.formulario.domain.NomeFormulario;
import eapli.base.formulario.domain.TipoDados;
import eapli.framework.io.util.Console;

public class FormularioHelper {

    private final EspecificarFormularioController fc = new EspecificarFormularioController();



    public Formulario form(){
        boolean flag = true;
        String continuar;

        String nomeForm = Console.readLine("Nome do Formulario: ");
        NomeFormulario nomeFormulario = new NomeFormulario(nomeForm);
        Formulario f = fc.especificarFormulario(nomeFormulario);

        while(flag)
    {
        String nomeVar = Console.readLine("Nome de variável do atributo ");
        String lable = Console.readLine("Nome da label ");
        String descAjuda = Console.readLine("Curta descrição do atributo ");
        String tipoDados;
        TipoDados td = TipoDados.STRING;
        do {
            tipoDados = Console.readLine("Tipo de dados do atributo (Numero inteiro - 1 | Frase - 2 | Numero fracional - 3 | Data - 4");
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
            }
        } while (validaDadosEscolha(tipoDados));

        String expReg = Console.readLine("Expressão regular para validação do atributo: ");

        f.addAtributo(nomeVar,lable,descAjuda,td,expReg);
        fc.saveForm(f);
        continuar = Console.readLine("Deseja especificar mais atributos para o formulario? (sim|nao)");
        if (continuar.equalsIgnoreCase("nao")) {
            flag = false;
        }
    }
        return f;
    }

    private boolean validaDadosEscolha(String a) {
        return a.contains("1") || a.contains("2") || a.contains("3") || a.contains("4");
    }


}
