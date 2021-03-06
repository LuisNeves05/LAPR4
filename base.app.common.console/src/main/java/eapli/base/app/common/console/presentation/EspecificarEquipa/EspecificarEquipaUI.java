package eapli.base.app.common.console.presentation.EspecificarEquipa;

import eapli.base.colaborador.application.ListarColaboradoresController;
import eapli.base.colaborador.domain.Colaborador;
import eapli.base.equipa.application.EspecificarEquipaController;
import eapli.base.equipa.domain.Acronimo;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EspecificarEquipaUI extends AbstractUI {

    ListarColaboradoresController colabCntrl = new ListarColaboradoresController();
    EspecificarEquipaController espEquipa = new EspecificarEquipaController();

    @Override
    protected boolean doShow() {


        final String codigoEquipa = Console.readLine("Escreva o código de equipa:");
        final String acr = Console.readLine("Escreva o acrónimo para a equipa:");
        final String designacao = Console.readLine("Escreva a designação para a equipa");

        List<Colaborador> colabList = colabCntrl.listaColaboradores();
        Set<Colaborador> colabListReponsaveis = new HashSet<>();

        int option;
        do {
            System.out.println("COLABORADORES:");
            for(int i = 0; i < colabList.size(); i++){
                System.out.printf("%s - %s\n", i+1, colabList.get(i));
            }
            option = Console.readInteger("Escreva a opção:");
            colabListReponsaveis.add(colabList.get(option-1));

        }while (option < 0 || option > colabList.size());

        espEquipa.especificarEquipa(codigoEquipa, new Acronimo(acr), designacao, colabListReponsaveis,null);

        return false;
    }

    @Override
    public String headline() {
        return "Criar Equipas";
    }
}
