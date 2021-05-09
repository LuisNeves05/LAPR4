package eapli.base.app.common.console.presentation.especificarcatalogoUI;

import eapli.base.catalogo.application.EspecificarCatalogoController;
import eapli.base.colaborador.application.ListarColaboradoresController;
import eapli.base.colaborador.domain.Colaborador;
import eapli.base.equipa.application.ListarEquipaController;
import eapli.base.equipa.domain.Equipa;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EspecificarCatalogoUI extends AbstractUI {

    final private EspecificarCatalogoController esc = new EspecificarCatalogoController();
    final private ListarColaboradoresController lc = new ListarColaboradoresController();
    final private ListarEquipaController lec = new ListarEquipaController();

    @Override
    protected boolean doShow() {
        String titulo = Console.readLine("Introduza o titulo do catalogo: ");
        String descBreve = Console.readLine("Introduza uma descricao breve: ");
        String descCompleta = Console.readLine("Introduza uma descricao mais completa: ");

        int imageBin = 0;
        final String caminho = Console.readLine("Indique o caminho (path) do ícone:");

        File file = new File(caminho);
        try {
            FileInputStream fis = new FileInputStream(file);
            imageBin = fis.available();
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Colaborador> list = lc.listaColaboradores();

        for(int i=0; i<list.size();i++){
            System.out.println(i + " - " + list.get(i).toString());
        }
        int choiceC = Console.readInteger("Por favor escolha um colaborador (index)");
        Colaborador c = list.get(choiceC);

        List<Equipa> equipaList = lec.listarEquipa();
        Set<Equipa> listAcesso = new HashSet<>();
        int choiceE;
        do {
            for (int i = 0; i < equipaList.size(); i++) {
                System.out.println(i + " - " + equipaList.get(i).toString());
            }
            choiceE = Console.readInteger("Por favor escolha uma equipa que tenha acesso ao catalogo (index) | -1 para sair");
            if(choiceE>equipaList.size() || choiceE == -1){
                break;
            }
            listAcesso.add(equipaList.get(choiceE));
        }while(choiceE!=-1);

        esc.especificarCatalogo(titulo,descBreve,descCompleta,imageBin,c,listAcesso);
        return false;
    }

    @Override
    public String headline() {
        return "Especificação de um catalogo!";
    }
}
