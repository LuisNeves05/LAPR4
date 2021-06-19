package eapli.base.app.common.console.presentation.assignarTarefaUI;

import ExecutorServer.ClientExecutorSSL;
import com.google.common.collect.Lists;
import eapli.base.Utils.SortValues;
import eapli.base.formulario.gramatica.ScriptTarefasAutomaticas;
import eapli.base.formularioPreenchido.domain.FormularioPreenchido;
import eapli.base.formularioPreenchido.persistencia.FormularioPreenchidoRepositorio;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.tarefaAutomatica.domain.TarefaAutomatica;
import eapli.base.tarefaAutomatica.persistance.TarefaAutomaticaRepositorio;
import eapli.base.tarefaManualExecucao.application.AssignarTarefaController;
import eapli.base.tarefaManualExecucao.domain.TarefaManualExecucao;
import eapli.base.ticket.persistence.TicketRepositorio;
import eapli.framework.presentation.console.AbstractUI;

import java.io.IOException;
import java.util.ArrayList;

import static eapli.base.Utils.HelpMethods.setToList;

public class AssignarTarefasUI extends AbstractUI {

    private final AssignarTarefaController controller = new AssignarTarefaController();
    private final FormularioPreenchidoRepositorio repo = PersistenceContext.repositories().formularioPreenchidoRepositorio();
    private final TarefaAutomaticaRepositorio repoT = PersistenceContext.repositories().tarefaAutomaticaRepositorio();
    private final TicketRepositorio repoTick = PersistenceContext.repositories().ticketRepositorio();

    @Override
    protected boolean doShow() {

        //TarefaManualExecucao tarefa = null;
        //List<TarefaManualExecucao> listaTarefasManualExecucao = controller.tarefasManualExecucao();

        ////////////////////////MY CHANGES /////////////////////////

        //AssignarTarefaAlgoritmoService algo = new AssignarTarefaAlgoritmoService();
        //algo.selecionarColabComMenosTarefas();

        //////////////////////////////////////////////////////////////

        /*
        if (!listaTarefasManualExecucao.isEmpty()) {
            int index = 1;
            for (TarefaManualExecucao t : listaTarefasManualExecucao) {
                System.out.println(index + " " + t.toString());
                index++;
            }

            boolean escolherTarefa = true;

            while (escolherTarefa) {
                int opcao = Console.readInteger("Escolha a tarefa que pretende realizar : (prima 0 para sair)");

                if (opcao == 0) {
                    return false;
                } else if (opcao <= listaTarefasManualExecucao.size() && opcao > 0) {
                    escolherTarefa = false;
                    tarefa = listaTarefasManualExecucao.get(opcao - 1);
                } else {
                    System.out.println("Coloque um index válido");
                }
            }

            assignarTarefaManualExecucao(tarefa);
            if (controller.assignarTarefaExecutante(tarefa) != null)
                System.out.println("Tarefa reivindicar com sucesso");
        } else {
            System.out.println("Nao existem tarefas por reevindicar");
        }


         */



        ClientExecutorSSL executorSSL = new ClientExecutorSSL();
        try {
            executorSSL.executarTarefaAutomatica();
        } catch (IOException e) {
            e.printStackTrace();
        }


        /*

        var tar = Lists.newArrayList(repoT.tarefasAutomaticasPendentes());

        System.out.println("SIZE DESTA MERDA : " + tar.size());

        for (TarefaAutomatica elems : tar) {
            for (FormularioPreenchido form : elems.ticketDaTarefa().formulariosPreenchidosDoTicket()) {
                var respotasDoForm = SortValues.sortByMaxPeriodTime(form.respostasDoFormulario()).keySet();
                var scriptTar = elems.scriptExecucao();
                var email = elems.ticketDaTarefa().colabQueRequisita().systemUserDoColab().email().toString();

                System.out.println("Resposta : " + respotasDoForm.toString());
                System.out.println("ScriptT : " + scriptTar);
                System.out.println("Email : " + email);

                // TODO MANDAR RESPOSTA + SCRIPT + EMAIL PARA O EXECUTOR

                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(respotasDoForm.toString().trim() + "!");
                stringBuilder.append(scriptTar.trim() + "!");
                stringBuilder.append(email.trim());


                System.out.println(stringBuilder);
                var result = ScriptTarefasAutomaticas.executaTarefaAutomatica(scriptTar, new ArrayList<>(respotasDoForm), email);


                // TODO LER DO CLIENTE A RESPOSTA
                if(result){
                    elems.ticketDaTarefa().completarTicket();
                    repoTick.save(elems.ticketDaTarefa());
                }
            }


        }
        */

        /*

        var x = setToList(repo.formularioRespostas());




        var formulario = x.get(0);

        var respostas = SortValues.sortByMaxPeriodTime(formulario.respostasDoFormulario());
        var script = tar.get(0).scriptExecucao();
        //var email = HelpMethods.getEmailWithColab(repoTick, formulario);

        System.out.println("Respostas: " + respostas);
        System.out.println("ScriptExec: " + script);



        //System.out.println("Email: " + email);


        //ScriptTarefasAutomaticas.executaTarefaAutomatica(script, new ArrayList<>(respostas.keySet()), email);


        // CLIENT

        */


        return true;
    }


    @Override
    public String headline() {
        return "Reivindicar Tarefa";
    }

    public void assignarTarefaManualExecucao(TarefaManualExecucao tarefa) {
        tarefa.retirarEquipa();
        tarefa.defineColaboradorExecutante(controller.responsavelTarefa());
    }
}
