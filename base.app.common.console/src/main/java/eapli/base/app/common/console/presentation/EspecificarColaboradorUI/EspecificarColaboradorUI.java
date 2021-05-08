package eapli.base.app.common.console.presentation.EspecificarColaboradorUI;

import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.colaborador.application.EspecificarColaboradorController;
import eapli.base.colaborador.domain.*;
import eapli.framework.io.util.Console;

import java.util.Date;
import java.util.Set;

public class EspecificarColaboradorUI {
    private final EspecificarColaboradorController controller = new EspecificarColaboradorController();

    /*
    @Override
    protected boolean doShow(){

        final String nomeCurto = Console.readLine("Nome Curto do Colaborador:");
        NomeCurto nomeCurto1 = new NomeCurto(nomeCurto);

        final String nomeCompleto = Console.readLine("Nome completo:");
        NomeCompleto nomeCompleto1 = new NomeCompleto(nomeCompleto);

        final String numMecanografico = Console.readLine("Número mecanográfico:");
        MecanographicNumber numero = new MecanographicNumber(numMecanografico);

        final String distrito = Console.readLine("Distrito:");
        final String concelho = Console.readLine("Concelho:");
        Morada localResidencia = new Morada (distrito, concelho);


        final int nrContacto = Console.readInteger("Número de contacto:");
        NrContacto nrContacto1 = new NrContacto(nrContacto);

        final Date dataNascimento = Console.readDate("Data de Nascimento:");
        Date data = new Date(String.valueOf(dataNascimento));

        final String listaFuncao = Console.readLine("Função do colaborador:");
        Funcao funcao = new Funcao(listaFuncao);


        try{
            Colaborador colaborador = controller.especificarColaborador(nomeCurto1, nomeCompleto1, numero, localResidencia,
                    nrContacto1, data, listaFuncao);
        }



    }
    */

}
