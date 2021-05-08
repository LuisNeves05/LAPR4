package eapli.base.app.common.console.presentation.EspecificarEquipa;

import eapli.base.colaborador.application.ListarColaboradoresController;
import eapli.base.colaborador.domain.Colaborador;
import eapli.base.equipa.application.EspecificarEquipaController;
import eapli.base.equipa.domain.Acronimo;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.List;

public class EspecificarEquipaUI extends AbstractUI {

    ListarColaboradoresController colabCntrl = new ListarColaboradoresController();
    EspecificarEquipaController espEquipa = new EspecificarEquipaController();

    @Override
    protected boolean doShow() {


        final long codigoEquipa = Console.readInteger("Escreva o código de equipa:");
        final String acr = Console.readLine("Escreva o acrónimo para a equipa:");
        final String designacao = Console.readLine("Escreva a designação para a equipa");

        //TODO LISTAR COLABS
        List<Colaborador> colabList = colabCntrl.listaColaboradores();

        int option;
        do {
            System.out.println("COLABORADORES:");
            for(int i = 0; i < colabList.size(); i++){
                System.out.printf("%s - %s", i+1, colabList.get(i));
            }
            option = Console.readInteger("Escreva a opção:");

        }while (option < 0 || option > colabList.size());

        espEquipa.especificarEquipa(codigoEquipa, new Acronimo(acr), designacao, colabList.get(option-1));
        //espEquipa.especificarEquipa()






        return false;
    }

    @Override
    public String headline() {
        return "Criar Equipas";
    }
}
