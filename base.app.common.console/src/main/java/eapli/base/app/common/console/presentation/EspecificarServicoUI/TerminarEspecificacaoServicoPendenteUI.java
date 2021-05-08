package eapli.base.app.common.console.presentation.EspecificarServicoUI;

import eapli.base.servico.application.ListarServicosController;
import eapli.base.servico.domain.Servico;
import eapli.framework.presentation.console.AbstractUI;

import java.util.List;

public class TerminarEspecificacaoServicoPendenteUI extends AbstractUI {

    private ListarServicosController lsc = new ListarServicosController();

    @Override
    protected boolean doShow() {
        List<Servico> listServicos = lsc.listarServico();
        if(listServicos.isEmpty()){
            System.out.println("Não existem serviços por especificar!");
        }else{
            System.out.println("Por favor, escolha um dos serviços ");
            for(Servico a : listServicos){
                System.out.println(a.toString() + "\n");
            }
        }

        return false;
    }

    @Override
    public String headline() {
        return "Terminar especificação de serviço pendente";
    }
}
