package eapli.base.app.common.console.presentation.SLA_UI;

import eapli.base.ticket.application.SLAController;
import eapli.base.ticket.domain.SLA_ENUM;
import eapli.base.ticket.domain.Ticket;
import eapli.base.ticket.service.SLATable;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.time.util.Calendars;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ConsultaSLA_UI extends AbstractUI {

    private final SLAController slaController = new SLAController();

    public ConsultaSLA_UI() {
    }

    @Override
    protected boolean doShow() {
        long minutes = 0;
        int meses = Console.readInteger("Escolha o período que pretende incluir no SLA(em meses)");
        Calendar date = Calendars.now();
        date.add(Calendar.MONTH, -meses);
        final List<Ticket> ticketsConcluidos = slaController.ticketsConcluidos(date);
        String[] tickets = new String[ticketsConcluidos.size() + 1];
        tickets[0] = "Pedido,Servico,Criticidade,Tempo Max. Aprov ,Média Aprov ,Tempo Decorrido Aprov, Tempo Max. Res, Média Res, Tempo Decorrido Res,Comentário/Conclusão";
        int i = 1;
        for (Ticket t : ticketsConcluidos) {

            Calendar dataAprovacaoC = t.dataAprovacaoTicket();
            long dataResolucao = t.datafinalizacaoTicket().getTimeInMillis();
            long dataCriacao = t.criacaoTicket().getTimeInMillis();

            if (dataAprovacaoC == null) {
                dataAprovacaoC = t.criacaoTicket();
            }

            long dataAprovacao = dataAprovacaoC.getTimeInMillis();

            long tempoAprov = TimeUnit.MILLISECONDS.toMinutes(dataAprovacao - dataCriacao);

            long tempoRes = TimeUnit.MILLISECONDS.toMinutes(dataResolucao - dataAprovacao);

            String comentario = "";
            if (tempoRes <= t.servicoDoTicket().nivelCriticidadeServico().objetivos().tempoMaximoResolucao() && tempoAprov <= t.servicoDoTicket().nivelCriticidadeServico().objetivos().tempoMaximoAprovacao()) {
                if (tempoAprov < t.servicoDoTicket().nivelCriticidadeServico().objetivos().tempoMedioAprovacao() && tempoRes < t.servicoDoTicket().nivelCriticidadeServico().objetivos().tempoMedioResolucao()) {
                    comentario = SLA_ENUM.CUMPRE_TUDO_E_FAVORECE_TMAR.toString();
                } else if (tempoRes < t.servicoDoTicket().nivelCriticidadeServico().objetivos().tempoMedioResolucao()) {
                    comentario = SLA_ENUM.CUMPRE_TUDO_E_FAVORECE_TMR.toString();
                } else if (tempoAprov < t.servicoDoTicket().nivelCriticidadeServico().objetivos().tempoMaximoAprovacao()) {
                    comentario = SLA_ENUM.CUMPRE_TUDO_E_FAVORECE_TMA.toString();
                }
            } else if (tempoRes > t.servicoDoTicket().nivelCriticidadeServico().objetivos().tempoMaximoResolucao()) {
                comentario = SLA_ENUM.FALHA_REALIZACAO.toString();
            } else if (tempoAprov > t.servicoDoTicket().nivelCriticidadeServico().objetivos().tempoMaximoAprovacao()) {
                comentario = SLA_ENUM.FALHA_APROVACAO.toString();
            } else {
                comentario = SLA_ENUM.FALHA_TUDO.toString();
            }

            tickets[i] = String.valueOf("Ticket : " + t.identity() + "," + t.servicoDoTicket().tituloDoServico() + "," + t.servicoDoTicket().nivelCriticidadeServico().getValorDeEscala() + "," + t.servicoDoTicket().nivelCriticidadeServico().objetivos().tempoMaximoAprovacao() + "," + t.servicoDoTicket().nivelCriticidadeServico().objetivos().tempoMedioAprovacao() + "," + tempoAprov + "," + t.servicoDoTicket().nivelCriticidadeServico().objetivos().tempoMaximoResolucao() + "," + t.servicoDoTicket().nivelCriticidadeServico().objetivos().tempoMedioResolucao() + "," + tempoRes + "," + comentario);


            i++;

            long diff = t.datafinalizacaoTicket().getTimeInMillis() - t.criacaoTicket().getTimeInMillis();
            minutes += TimeUnit.MILLISECONDS.toMinutes(diff);
        }
        System.out.println("\n########################################################\n");
        final Long totalTickets = slaController.totalTickets();
        System.out.println("Número total de tickets : " + totalTickets);
        System.out.println("\n########################################################\n");

        DateTimeFormatter dateTimeFormatter  =DateTimeFormatter.ofPattern(("MM/dd/yyyy"));
        LocalDateTime dataAnterior = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
        LocalDateTime data= LocalDateTime.now();
        final int ticketsConclu = ticketsConcluidos.size();
        System.out.println(" Número tickets concluídos desde " +dataAnterior.format(dateTimeFormatter)+" até "+ data.format(dateTimeFormatter)+" : " + ticketsConclu);

        System.out.println("\n########################################################\n");

        SLATable.printResult(tickets);

        System.out.println("########################################################\n");
        System.out.println("Tempo de execução médio : " + minutes / i);

        System.out.println("\n########################################################\n");
        return true;
    }

    @Override
    public String headline() {
        return "SLA";
    }
}
