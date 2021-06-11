package eapli.base.tarefaManualExecucao.services;

import eapli.base.colaborador.domain.Colaborador;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.tarefaManualAprovacao.domain.TarefaManualAprovacao;
import eapli.base.tarefaManualAprovacao.persistance.TarefaManualAprovacaoRepositorio;
import eapli.base.tarefaManualExecucao.domain.TarefaManualExecucao;
import eapli.base.tarefaManualExecucao.persistance.TarefaManualExecucaoRepositorio;

import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.List;

public class TarefasPendentesService {
    private final TarefaManualExecucaoRepositorio repoTarefasExec = PersistenceContext.repositories().tarefaManualExecucaoRepositorio();
    private final TarefaManualAprovacaoRepositorio repoTarefasAprov = PersistenceContext.repositories().tarefaManualAprovacaoRepositorio();

    private int hardcodedTime = 2;

    public String dashboardData(Colaborador colab){
        int tarefasAExp = 0,tarefasPen = 0, tarefasExp = 0;

        List<TarefaManualExecucao> tarefasManLis = repoTarefasExec.tarefasManuaisExecucaoPendentes(colab);


        for(TarefaManualExecucao elems : tarefasManLis){
            Calendar ticketTime = elems.procurarTicket().criacaoTicket();

            int periodoApr = elems.procurarTicket().periodoMaxApr();
            int periodoRes = elems.procurarTicket().periodoMaxRes();

            int minutes = (int) ChronoUnit.MINUTES.between(ticketTime.toInstant(), Calendar.getInstance().toInstant());

            if(minutes <= periodoApr && minutes <= periodoRes){
                tarefasPen++;
            }

            if(minutes <= hardcodedTime && minutes <= hardcodedTime){
                tarefasAExp += 1;
            }

            if(minutes >= periodoApr && minutes >= periodoRes){
                tarefasExp += 1;
            }
        }

        List<TarefaManualAprovacao> tarefasManAprList = (List<TarefaManualAprovacao>) repoTarefasAprov.tarefasManuaisAprovacaoNA(colab);

        for(TarefaManualAprovacao elems : tarefasManAprList){
            Calendar ticketTime = elems.procurarTicket().criacaoTicket();

            int periodoApr = elems.procurarTicket().periodoMaxApr();
            int periodoRes = elems.procurarTicket().periodoMaxRes();

            int minutes = (int) ChronoUnit.MINUTES.between(ticketTime.toInstant(), Calendar.getInstance().toInstant());

            if(minutes <= periodoApr && minutes <= periodoRes){
                tarefasPen++;
            }

            if(minutes <= hardcodedTime && minutes <= hardcodedTime){
                tarefasAExp += 1;
            }

            if(minutes >= periodoApr && minutes >= periodoRes){
                tarefasExp += 1;
            }
        }

        return String.format("%s,%s,%s", tarefasAExp, tarefasPen, tarefasExp);
    }
}
