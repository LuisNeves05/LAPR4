package eapli.base.app.common.console.presentation.especificarcolaboradorUI;

import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.colaborador.application.EspecificarColaboradorController;
import eapli.base.colaborador.application.ListarColaboradoresController;
import eapli.base.colaborador.domain.*;
import eapli.base.equipa.application.ListarEquipaController;
import eapli.base.equipa.domain.Equipa;
import eapli.base.usermanagement.application.AddUserController;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.infrastructure.authz.domain.model.Role;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class EspecificarColaboradorUI extends AbstractUI {
    private final EspecificarColaboradorController controller = new EspecificarColaboradorController();
    private final ListarColaboradoresController listarColabsController = new ListarColaboradoresController();
    private final AddUserController addUserController = new AddUserController();
    private final ListarEquipaController listarEquipaController = new ListarEquipaController();

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

        final String username = Console.readLine("Username do colaborador: (Deve ser apenas uma palavra)");
        final String password = Console.readLine("Password do colaborador: (Deve conter uma letra maiuscula, um numero, e pelo menos 6 caracteres)");
        final String email = Console.readLine("Email do colaborador:");

        List<Colaborador> listaColabsResponsaveis = listarColabsController.listaColaboradores();
        List<Equipa> listaEquipas =listarEquipaController.listarEquipa();
        List<Equipa> listaEquipasColab = new ArrayList<>();

        if(listaEquipas.isEmpty()){
            System.out.println("Não existem equipas disponiveis! ");
        }else{
            String escolhaEquipa;
            do {
                for (int i = 0; i < listaEquipas.size(); i++) {
                    System.out.println(i + " " + listaEquipas.get(i).toString());
                }
                escolhaEquipa = Console.readLine("Escolha uma equipa (index)  | -1 para sair");
                if (Integer.parseInt(escolhaEquipa) > listaEquipas.size() || escolhaEquipa.equals("-1")) {
                    break;
                } else {
                    listaEquipasColab.add(listaEquipas.get(Integer.parseInt(escolhaEquipa)));
                }
            }while(!escolhaEquipa.equals("-1"));
        }

        if(listaColabsResponsaveis.isEmpty()){
            controller.especificarColaborador(nomeCurto, nomeCompleto, mecanographicNumber, localResidencia, nrContacto, data, null);
            System.out.println("Não existem outros colaboradores disponíveis para selecionar como responsáveis neste momento");
        }else {
            System.out.println("Por favor escolha um colaborador para ser o responsável pelo novo Colaborador: ");
            for (int i = 0; i < listaColabsResponsaveis.size(); i++) {
                System.out.println(i + " - " + listaColabsResponsaveis.get(i));
            }
            String escolhaColabResponsavel = Console.readLine("Escolha (index)");
            int escolha = Integer.parseInt(escolhaColabResponsavel);
            Colaborador colabResponsavel = listaColabsResponsaveis.get(escolha);

            controller.especificarColaborador(nomeCurto, nomeCompleto, mecanographicNumber, localResidencia, nrContacto
            , data, colabResponsavel);
        }

        String role;
        Set<Role> roleSet = new HashSet<>();
        do{
            System.out.println("\n"+1 + " " +BaseRoles.COLABORADOR);
            System.out.println(2 + " " +BaseRoles.RRH);
            System.out.println(3 + " " +BaseRoles.ADMIN +"\n");
            role = Console.readLine("Escolha uma funcao para o Colaborador (index) (0 para sair)");
            atribuiRole(role,roleSet);
        }while(!role.equals("0"));

        addUserController.addUser(username,password,nomeCurtostr,nomeCompletostr,email,roleSet);
        return true;
    }

    @Override
    public String headline() {
        return "Especificar um novo Colaborador";
    }

    private void atribuiRole(String role, Set<Role> roleSet){
        if(role.equalsIgnoreCase("1")){
            roleSet.add(BaseRoles.COLABORADOR);
        }else if(role.equalsIgnoreCase("2")){
            roleSet.add(BaseRoles.RRH);
        }else if(role.equalsIgnoreCase("3")){
            roleSet.add(BaseRoles.ADMIN);
        }
    }

}
