package eapli.base.app.common.console.presentation.EspecificarServicoUI;

import eapli.base.servico.application.FinalizarEspecificacaoServicoController;
import eapli.base.servico.domain.Servico;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.List;

import static java.lang.Thread.sleep;

public class TerminarEspecificacaoServicoPendenteUI extends AbstractUI {

    private final FinalizarEspecificacaoServicoController fesc = new FinalizarEspecificacaoServicoController();

    @Override
    protected boolean doShow() {
        List<Servico> listServicos = fesc.servicosIncompletos();
        if(listServicos.isEmpty()){
            System.out.println("Não existem serviços incompleto!");
        }else{
            for(int i=0; i<listServicos.size();i++){
                System.out.println(i + 1 + " " +listServicos.get(i).toString() + "\n");
            }

            boolean flag = true;
            while (flag) {
                int choice = Console.readInteger("(0 para sair) Escolha um dos servicos (index)");
                if(choice == 0){
                    return false;
                }
                else if(choice > 0 && choice <= listServicos.size()) {
                    Servico servico = listServicos.get(choice - 1);
                    if(servico.estaCompleto()){
                        servico.completar();
                        fesc.guardarServico(servico);
                        System.out.println("Serviço Completo.");
                    }else{
                        System.out.println("Este serviço ainda não tem todos os campos obrigatórios");
                    }
                    flag = false;
                }else{
                    System.out.println("Coloque um index válido.");
                }
            }
        }
        return true;
    }

    @Override
    public String headline() {
        return "Terminar especificação de serviço incompleto";
    }
}
