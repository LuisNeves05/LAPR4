package eapli.base.app.common.console.presentation.especificarNivelCriticidadeUI;

import eapli.base.criticidade.application.EspecificarNivelCriticidadeController;
import eapli.base.criticidade.domain.Objetivo;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class EspecificarNivelCriticidadeUI extends AbstractUI {

    private final EspecificarNivelCriticidadeController enc = new EspecificarNivelCriticidadeController();

    @Override
    protected boolean doShow() {

        String etiqueta = Console.readLine("Etiqueta: ");
        int valorEscala = Console.readInteger("Valor de escala (1 a 4)");
        int number;
        Map<Integer, Color> cores = new HashMap<>();

        cores.put(1, Color.white);
        cores.put(2, Color.lightGray);
        cores.put(3, Color.gray);
        cores.put(4, Color.darkGray);
        cores.put(5, Color.black);
        cores.put(6, Color.red);
        cores.put(7, Color.pink);
        cores.put(8, Color.orange);
        cores.put(9, Color.yellow);
        cores.put(10, Color.green);
        cores.put(11, Color.magenta);
        cores.put(12, Color.cyan);
        cores.put(13, Color.blue);
        do {
            number = Console.readInteger("Escolha o número da cor que pretende:\n " +
                    "Branco - 1 \nCinzento Claro - 2 \nCinzento - 3\n" +
                    "Cinzento Escuro - 4 \nPreto - 5 \nVermelho - 6 \nRosa - 7\nLaranja - 8\n" +
                    "Amarelo - 9 \nVerde - 10 \nMagenta - 11 \nCiano - 12 \nAzul - 13");
            if (number <= 0 | number > 13)
                System.out.println("Cor especificada não é valida ! \n");
        } while (number <= 0 | number > 13);
        final Color cor = cores.get(number);

        int aprovacaoMax = Console.readInteger("Tempo de aprovação máxima (min)");
        int resolucaoMax = Console.readInteger("Tempo de resolução máxima (min)");
        int aprovacaomed = 0;
        int resolucaomed = 0;
        Objetivo obj = new Objetivo(aprovacaoMax, resolucaoMax, aprovacaomed, resolucaomed);
        String defaultBo;
        boolean isDefault = false;
        do {
            defaultBo = Console.readLine("Pretende definir este nível de criticidade como default ?(sim/nao)\n ");
        }
        while (validaSimNao(defaultBo));
        if (defaultBo.equalsIgnoreCase("sim")) {
            isDefault = true;

        }
        enc.especificarNivelCriticidade(etiqueta, valorEscala, cor, obj, isDefault);

        return true;
    }

    @Override
    public String headline() {
        return "Especificação de um Nivel de Criticidade!";
    }

    private boolean validaSimNao(String a) {
        return !a.equalsIgnoreCase("sim") && !a.equalsIgnoreCase("nao");
    }
}
