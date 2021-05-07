package eapli.base.app.common.console.presentation.EspecificarServicoUI;

import eapli.base.servico.application.EspecificarServicoController;
import eapli.base.servico.domain.Keyword;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.HashSet;
import java.util.Set;

public class EspecificarServicoUI extends AbstractUI {

    private final EspecificarServicoController controller = new EspecificarServicoController();

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

        //REMOVER DEPOIS
        final String estado = Console.readLine("Estado do serviço:");

        try {
            controller.especificarServico(identificador, titulo, descBreve, descComp, icon, booleanAprov, booleanReal, listaKeywords, estado);
        } catch (ConcurrencyException e) {
            System.out.println("Ocorreu um erro> " + e.getLocalizedMessage());
            return false;
        }

        return true;
    }

    @Override
    public String headline() {
        return "Especificar Serviço";
    }

}
