package eapli.base.app.common.console.presentation.consultarPedidosUI;

import eapli.base.ticket.application.ConsultarTicketsController;
import eapli.base.ticket.domain.Ticket;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.List;

public class ConsultarPedidosUI extends AbstractUI {

    private final ConsultarTicketsController controller = new ConsultarTicketsController();



    @Override
    protected boolean doShow() {

        System.out.println("0 - Pedidos Por Concluir");
        System.out.println("1 - Pedidos Concluidos");

        int choice;

        do{
            choice = Console.readInteger("Escolha uma opcao");
        }while (choice != 0 && choice != 1);

        if(choice == 0){
            List<Ticket> ticketsPorConcluir = controller.returnAllTicketsPorConcluir();

            if(ticketsPorConcluir.isEmpty()){
                System.out.println("Nao existem de momento Pedidos Por Concluir!");
            }else{
                ticketsPorConcluir.forEach(System.out::println);
            }
        }

        if(choice == 1){
            List<Ticket> ticketsConcluidos = controller.returnAllTicketsConcluidos();

            if(ticketsConcluidos.isEmpty()){
                System.out.println("Nao existem de momento Pedidos Concluidos!");
            }else{
                ticketsConcluidos.forEach(System.out::println);
            }
        }

        return true;
    }

    @Override
    public String headline() {
        return "Consultar Meus Pedidos";
    }
}
