package eapli.base.app.common.console.presentation.RegistarTipoEquipaUI;

import eapli.base.tipoEquipa.application.RegistarTipoEquipaController;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class RegistarTipoEquipaUI extends AbstractUI {

    private final RegistarTipoEquipaController registarTipoEquipaController;
    private int number;

    public RegistarTipoEquipaUI(RegistarTipoEquipaController registarTipoEquipaController) {
        this.registarTipoEquipaController = registarTipoEquipaController;
    }

    @Override
    protected boolean doShow() {

        final String identificador = Console.readLine("Código de Identificação:");
        final String descricao = Console.readLine("Descrição do Tipo de Equipa:");
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
        try {
            registarTipoEquipaController.tipoEquipaServico(identificador, descricao, cor);
        } catch (ConcurrencyException e) {
            System.out.println("Ocorreu um erro > " + e.getLocalizedMessage());
            return false;
        }
        return true;
    }

    @Override
    public String headline() {
        return "Registar Tipo de Equipa";
    }
}
