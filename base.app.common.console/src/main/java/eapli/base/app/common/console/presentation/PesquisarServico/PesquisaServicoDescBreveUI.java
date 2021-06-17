package eapli.base.app.common.console.presentation.PesquisarServico;

import eapli.base.catalogo.domain.Catalogo;
import eapli.base.catalogo.persistencia.CatalogoRepositorio;
import eapli.base.colaborador.persistencia.ColaboradorRepositorio;
import eapli.base.equipa.domain.Equipa;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.servico.application.PesquisarServicoController;
import eapli.base.servico.domain.Servico;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.UserSession;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PesquisaServicoDescBreveUI extends AbstractUI {

    private final PesquisarServicoController psController = new PesquisarServicoController();

    public PesquisaServicoDescBreveUI(){}

    @Override
    protected boolean doShow() {

        final String descBreve = Console.readLine("Indique a Descrição Breve que quer pesquisar:");

        Iterable<Servico> servicos =  psController.todosServicos();

        if(servicos.iterator().hasNext()){
            for (Servico sv : servicos){
                if(psController.servicoContiverDescBreve(sv,descBreve)) {
                    if (sv.estado().equals("INCOMPLETO"))
                        System.out.println(sv.toString() + "   BREVEMENTE DISPONIVEL");
                    else
                        System.out.println(sv.toString());
                }
            }
            return true;
        }

        System.out.println("Não conseguimos encontrar esse Serviço");
        return false;
    }

    @Override
    public String headline() {
        return "Pesquisar pela Descrição Breve do Serviço";
    }
}
