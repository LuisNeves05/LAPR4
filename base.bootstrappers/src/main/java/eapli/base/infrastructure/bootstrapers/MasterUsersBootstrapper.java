/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates and open the template
 * in the editor.
 */
package eapli.base.infrastructure.bootstrapers;

import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;

import eapli.base.Application;
import eapli.base.catalogo.application.EspecificarCatalogoController;
import eapli.base.catalogo.domain.Catalogo;
import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.colaborador.application.EspecificarColaboradorController;
import eapli.base.colaborador.domain.*;
import eapli.base.criticidade.application.EspecificarNivelCriticidadeController;
import eapli.base.criticidade.domain.Objetivo;
import eapli.base.equipa.application.AddOrDeleteEquipaController;
import eapli.base.equipa.application.EspecificarEquipaController;
import eapli.base.equipa.domain.Acronimo;
import eapli.base.equipa.domain.Equipa;
import eapli.base.equipa.persistencia.EquipaRepositorioJPAimpl;
import eapli.base.formulario.application.EspecificarFormularioController;
import eapli.base.formulario.domain.NomeFormulario;
import eapli.base.servico.application.EspecificarServicoController;
import eapli.base.servico.domain.Keyword;
import eapli.base.servico.domain.Servico;
import eapli.base.tipoEquipa.application.RegistarTipoEquipaController;
import eapli.base.tipoEquipa.domain.TipoEquipa;
import eapli.base.usermanagement.application.AddUserController;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.actions.Action;
import eapli.framework.infrastructure.authz.domain.model.Role;

/**
 * @author Paulo Gandra Sousa
 */
public class MasterUsersBootstrapper extends UsersBootstrapperBase implements Action {

    private final EspecificarEquipaController controllerEquipa = new EspecificarEquipaController();
    private final EspecificarCatalogoController catalogoController = new EspecificarCatalogoController();
    private final EspecificarColaboradorController colaboradorController = new EspecificarColaboradorController();
    private final EspecificarServicoController especificarServicoController = new EspecificarServicoController();
    private final RegistarTipoEquipaController registarTipoEquipaController = new RegistarTipoEquipaController();
    private final AddUserController acd = new AddUserController();
    private final EspecificarFormularioController efc = new EspecificarFormularioController();
    private final EspecificarNivelCriticidadeController enc = new EspecificarNivelCriticidadeController();


    @Override
    public boolean execute() {
        registerAdmin("admin", TestDataConstants.PASSWORD1, "Jane", "Doe Admin",
                "jane.doe@email.local");
        return true;
    }

    private void registerAdmin(final String username, final String password, final String firstName,
            final String lastName, final String email) {
        final Set<Role> roles = new HashSet<>();
        roles.add(BaseRoles.ADMIN);
        masterBootStrap();
        registerUser(username, password, firstName, lastName, email, roles);
    }

    private String masterBootStrap(){


        /**
         * CRIAR TIPO EQUIPA
         */
        TipoEquipa te = registarTipoEquipaController.tipoEquipaServico("Id123","Equipa de Software", 5);

        String pattern = "05-12-2000";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Date date = null;
        try {
            date = simpleDateFormat.parse(pattern);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Colaborador c = colaboradorController.especificarColaborador(new NomeCurto("Luis"), new NomeCompleto("Luis Neves"),
                new MecanographicNumber("1191421"), new Morada("Porto", "Penafiel"),
                new NrContacto(910900398), date, null);
        Set<Role> roless = new HashSet<>();
        roless.add(BaseRoles.ADMIN);
        roless.add(BaseRoles.COLABORADOR);

        acd.addUser("Luis","Password1","Luis","Neves","luismanuelneves@gmail.com",roless);

        Colaborador rui = colaboradorController.especificarColaborador(new NomeCurto("Rui"), new NomeCompleto("Rui Alves"),
                new MecanographicNumber("1181597"), new Morada("Porto", "Marco de Canaveses"),
                new NrContacto(927206840), date, c);
        rui.becameSystemUser(acd.addUser("Rui","Password1","Rui","Alves","ruialves@gmail.com",roless));


        /**
         * CRIAR EQUIPA
         */
        Set<Colaborador> colaboradors = new HashSet<>();
        colaboradors.add(c);
        Acronimo acr = new Acronimo("LAPR");
        Equipa equipa = controllerEquipa.especificarEquipa("12367",acr,"Designação Equipa",colaboradors,te);


        /**
         * CRIAR COLABORADOR
         */
        List<Equipa> equipasList = new ArrayList<>();
        Set<Equipa> equipasSet = new HashSet<>();
        equipasList.add(equipa);
        equipasSet.add(equipa);
        Colaborador colab = colaboradorController.especificarColaborador(new NomeCurto("Joao"), new NomeCompleto("Joao Alves"),
                new MecanographicNumber("1181596"), new Morada("Porto", "Marco de Canaveses"),
                new NrContacto(927206841), date, c);
        acd.addUser("joao","Password1","Rui","Alves","asddasd@gmail.com",roless);

        Colaborador tiago = colaboradorController.especificarColaborador(new NomeCurto("Tiago"), new NomeCompleto("Tiago Alves"),
                new MecanographicNumber("1181212"), new Morada("Porto", "Marco de Canaveses"),
                new NrContacto(921587569), date, c);
        acd.addUser("tiago","Password1","Tiago","Alves","rtiagoasd@gmail.com",roless);


        AddOrDeleteEquipaController adod = new AddOrDeleteEquipaController(equipa);
        Set<Colaborador> lista = new HashSet<>();
        lista.add(colab);
        lista.add(tiago);
        lista.add(rui);
        adod.adicionarColaboradores(lista);

        /**
         * CRIAR CATALOGO
         */
        Catalogo catalogo = catalogoController.especificarCatalogo("Titulo Catalogo","Catalogo RH", "Catalogo de recursos humanos",12,c, equipasSet);

        /**
         * CRIAR Servico
         */
        Keyword k = new Keyword("Software");
        Keyword k2 = new Keyword("JAVA");
        Set<Keyword> keywords = new HashSet<>();
        keywords.add(k);
        keywords.add(k2);
        Servico servico = especificarServicoController.especificarServico("123IDSERV","Titulo Servico","Desc breve Serv","Desc comp Servico",2,true,true,keywords,"COMPLETO",false,catalogo);

        /**
         * CRIAR FORMULARIO
         */
        efc.addAtributo("Nome Variavel","Label do Form","Descricao Ajuda","INTEIRO","EXP regular");
        efc.especificarFormulario(new NomeFormulario("Nome Formulario"),servico);

        /**
         * CRIAR NIVEL CRITICIDADE
         */
        Objetivo obj = new Objetivo(12,50,0,0);
        enc.especificarNivelCriticidade("Etiqueta do nivel", 4, Color.RED,obj);


        return "#############################################  BOOTSTRAP GRUPO 4 2DL FEITO  #############################################";
    }
}
