package eapli.base.app.common.console.presentation.servicoUI;

import eapli.base.Utils.QueryMaker;
import eapli.base.servico.application.ListarServicosController;
import eapli.base.servico.domain.Servico;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import javax.management.Query;
import java.util.List;

import static java.lang.Thread.sleep;

public class TerminarEspecificacaoServicoPendenteUI extends AbstractUI {

    private QueryMaker qm = new QueryMaker();
    private FormularioHelper fh = new FormularioHelper();

    @Override
    protected boolean doShow() {
        List<Servico> listServicos = qm.queryToDB();
        if(listServicos.isEmpty()){
            System.out.println("Não existem serviços por especificar!");
        }else{
            for(int i=0; i<listServicos.size();i++){
                System.out.println(i + " TESTETESTS" +listServicos.get(i).toString() + "\n");
            }

            int choice = Console.readInteger("Escolha um dos servicos (index)");
            Servico servico = listServicos.get(choice);
            fh.form(servico);
        }
        return false;
    }

    @Override
    public String headline() {
        return "Terminar especificação de serviço pendente";
    }
}
