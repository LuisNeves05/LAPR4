package eapli.base.app.common.console.presentation.EspecificarColaboradorUI;

import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.colaborador.application.EspecificarColaboradorController;
import eapli.base.colaborador.application.ListarColaboradoresController;
import eapli.base.colaborador.domain.*;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EspecificarColaboradorUI extends AbstractUI {
    private final EspecificarColaboradorController controller = new EspecificarColaboradorController();
    private final ListarColaboradoresController listarColabsController = new ListarColaboradoresController();

    @Override
    protected boolean doShow(){

        final String nomeCurtostr = Console.readLine("Nome Curto do Colaborador:");
        NomeCurto nomeCurto = new NomeCurto(nomeCurtostr);

        final String nomeCompletostr = Console.readLine("Nome completo:");
        NomeCompleto nomeCompleto = new NomeCompleto(nomeCompletostr);

        final String numMecanograficostr = Console.readLine("Número mecanográfico:");
        MecanographicNumber mecanographicNumber = new MecanographicNumber(numMecanograficostr);

        final String distritostr = Console.readLine("Distrito:");
        final String concelhostr = Console.readLine("Concelho:");
        Morada localResidencia = new Morada (distritostr, concelhostr);


        final int nrContactonum = Console.readInteger("Número de contacto:");
        NrContacto nrContacto = new NrContacto(nrContactonum);

        String dataNascimento = Console.readLine("Data de Nascimento: (dia-mes-ano)");
        String pattern = "MM-dd-yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Date data = null;
        try {
            data = simpleDateFormat.parse(dataNascimento);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        final String listaFuncao = Console.readLine("Função do colaborador:");
        Funcao funcao = new Funcao(listaFuncao);
        Set<Funcao> listaFunc = new HashSet<>();
        listaFunc.add(funcao);

        List<Colaborador> listaColabsResponsaveis = listarColabsController.listaColaboradores();

        if(listaColabsResponsaveis.isEmpty()){
            Colaborador colaborador = controller.especificarColaborador(nomeCurto, nomeCompleto, mecanographicNumber, localResidencia, nrContacto
                    , data, listaFunc, null);
            System.out.println("Não existem outros colaboradores disponíveis para selecionar como responsáveis neste momento");
        }else {

            System.out.println("Por favor escolha um colaborador para ser o responsável pelo novo Colaborador: ");

            for (int i = 0; i < listaColabsResponsaveis.size(); i++) {
                System.out.println(i + " - " + listaColabsResponsaveis.get(i));
            }

            String escolhaColabResponsavel = Console.readLine("Escolha (index)");
            int escolha = Integer.parseInt(escolhaColabResponsavel);
            Colaborador colabResponsavel = listaColabsResponsaveis.get(escolha);

            Colaborador colaborador = controller.especificarColaborador(nomeCurto, nomeCompleto, mecanographicNumber, localResidencia, nrContacto
                    , data, listaFunc, colabResponsavel);
        }
        return true;
    }

    @Override
    public String headline() {
        return "Especificar um novo Colaborador";
    }

}
