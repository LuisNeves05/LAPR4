package eapli.base.app.common.console.presentation.darFeedbackUI;

import eapli.base.ticket.application.ConsultarTicketsController;
import eapli.base.ticket.application.DarFeedbackController;
import eapli.base.ticket.domain.Ticket;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.List;

public class DarFeedbackUI extends AbstractUI {

        private final DarFeedbackController controller = new DarFeedbackController();

        @Override
        protected boolean doShow() {

            List<Ticket> ticketsComFeedbackDoColab = controller.ticketsComFeedbackDoColab();

            if(ticketsComFeedbackDoColab.isEmpty()){
                System.out.println("Ainda não tem tickets que possa dar feedback");
                return false;
            }

            int index = 0;
            for (Ticket t : ticketsComFeedbackDoColab) {
                System.out.println(index++ + ") " + t.toString());
            }

            boolean flag = true;
            while (flag) {
                int opcao = Console.readInteger("Indique o index do ticket que pretende dar feedback");
                if(opcao > 0 && opcao < ticketsComFeedbackDoColab.size()) {
                    String respostaFeedback = Console.readLine("Dê o seu feedback");
                    try {
                        controller.feedbackDoColaborador(respostaFeedback, ticketsComFeedbackDoColab.get(opcao -1));
                    }catch (Exception x){
                        System.out.println("Erro ao atribuir feedback ao ticket");
                        return true;
                    }
                    flag = false;
                }
                else{
                    System.out.println("Introduza um índice válido");
                }
            }
            System.out.println("Feedback Recebido");
            return true;
        }

        @Override
        public String headline() {
            return "Dar o meu feedback";
        }
    }
