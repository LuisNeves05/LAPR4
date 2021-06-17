package eapli.base.app.common.console.presentation.finalizarEspecificacaoServicoUI;

import eapli.base.servico.application.FinalizarEspecificacaoServicoController;
import eapli.base.servico.domain.Servico;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;

import java.util.List;

public class TerminarEspecificacaoServicoPendenteUI extends AbstractUI {

    private final FinalizarEspecificacaoServicoController fesc = new FinalizarEspecificacaoServicoController();

    @Override
    protected boolean doShow() {
        List<Servico> listServicos = fesc.servicosIncompletos();
        if(listServicos.isEmpty()){
            System.out.println("Não existem serviços incompleto!");
        }else{
            final SelectWidget<Servico> selector = new SelectWidget<>("Serviços Incompletos:", listServicos,
                    new ServicoIncompletosPrinter());
            selector.show();
            final Servico servico = selector.selectedElement();
            if(servico == null)
                return true;

            if(fesc.completarServico(servico)){
                System.out.println("Serviço Completo.");
            }else{
                System.out.println("Este serviço ainda não tem todos os campos obrigatórios");
            }
        }
        return true;
    }

    @Override
    public String headline() {
        return "Terminar especificação de serviço incompleto";
    }
}
