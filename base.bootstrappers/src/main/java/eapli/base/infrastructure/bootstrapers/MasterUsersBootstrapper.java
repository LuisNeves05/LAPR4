/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates and open the template
 * in the editor.
 */
package eapli.base.infrastructure.bootstrapers;

import eapli.base.catalogo.application.EspecificarCatalogoController;
import eapli.base.catalogo.domain.Catalogo;
import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.colaborador.application.EspecificarColaboradorController;
import eapli.base.colaborador.domain.*;
import eapli.base.criticidade.application.EspecificarNivelCriticidadeController;
import eapli.base.criticidade.domain.NivelCriticidade;
import eapli.base.criticidade.domain.Objetivo;
import eapli.base.equipa.application.AddOrDeleteEquipaController;
import eapli.base.equipa.application.EspecificarEquipaController;
import eapli.base.equipa.domain.Acronimo;
import eapli.base.equipa.domain.Equipa;
import eapli.base.formulario.application.EspecificarFormularioController;
import eapli.base.formulario.domain.Formulario;
import eapli.base.formulario.domain.NomeFormulario;
import eapli.base.formulario.domain.TipoDados;
import eapli.base.servico.application.EspecificarServicoController;
import eapli.base.servico.domain.*;
import eapli.base.tipoEquipa.application.RegistarTipoEquipaController;
import eapli.base.tipoEquipa.domain.TipoEquipa;
import eapli.base.usermanagement.application.AddUserController;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.actions.Action;
import eapli.framework.infrastructure.authz.domain.model.Role;

import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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

        TipoEquipa te = registarTipoEquipaController.tipoEquipaServico("Id123","Equipa de Software", 5);

        String pattern = "05-12-2000";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Date date = null;
        try {
            date = simpleDateFormat.parse(pattern);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Set<Role> roless = new HashSet<>();
        roless.add(BaseRoles.ADMIN);
        roless.add(BaseRoles.COLABORADOR);

        Colaborador c = colaboradorController.especificarColaborador(new NomeCurto("Luis"), new NomeCompleto("Luis Neves"),
                new MecanographicNumber("1191421"), new Morada("Porto", "Penafiel"),
                new NrContacto(910900398), date, null, roless, "Luis", "Password1", "luismanuelneves@gmail.com");

        Colaborador rui = colaboradorController.especificarColaborador(new NomeCurto("Rui"), new NomeCompleto("Rui Alves"),
                new MecanographicNumber("1181597"), new Morada("Porto", "Marco de Canaveses"),
                new NrContacto(927206840), date, c, roless, "Rui", "Password1", "rui@gmail.com");



        Set<Colaborador> colaboradors = new HashSet<>();
        colaboradors.add(c);
        Acronimo acr = new Acronimo("LAPR");
        Equipa equipa = controllerEquipa.especificarEquipa("12367",acr,"Designação Equipa",colaboradors,te);


        Set<Equipa> equipasSet = new HashSet<>();
        equipasSet.add(equipa);
        Colaborador colab = colaboradorController.especificarColaborador(new NomeCurto("Joao"), new NomeCompleto("Joao Alves"),
                new MecanographicNumber("1181596"), new Morada("Porto", "Marco de Canaveses"),
                new NrContacto(927206841), date, c, roless, "Joao", "Password1", "joao@gmail.com");

        Colaborador tiago = colaboradorController.especificarColaborador(new NomeCurto("Tiago"), new NomeCompleto("Tiago Alves"),
                new MecanographicNumber("1181212"), new Morada("Porto", "Marco de Canaveses"),
                new NrContacto(921587569), date, c, roless, "Tiago", "Password1", "tiago@gmail.com");

        AddOrDeleteEquipaController adod = new AddOrDeleteEquipaController(equipa);
        Set<Colaborador> lista = new HashSet<>();
        lista.add(colab);
        lista.add(tiago);
        lista.add(rui);
        adod.adicionarColaboradores(lista);

        Catalogo catalogo = catalogoController.especificarCatalogo("Titulo Catalogo","Catalogo RH", "Catalogo de recursos humanos",12,c, equipasSet);

        Keyword k = new Keyword("Software");
        Keyword k2 = new Keyword("JAVA");
        Set<Keyword> keywords = new HashSet<>();
        keywords.add(k);
        keywords.add(k2);
        Objetivo obj = new Objetivo(12,50,0,0);
        NivelCriticidade nc  = enc.especificarNivelCriticidade("Etiqueta do nivel", 4, Color.RED,obj,true);
        Servico servico = especificarServicoController.especificarServico(new Servico(new ServicoIdentificador("123IDSERV"), new Titulo("Titulo Servico"), new DescricaoBreve("Desc breve Serv"),
                new DescricaoCompleta("Desc comp Servico"), new byte[2], TipoExecucao.AUTOMATICA, null, keywords, EstadoServico.COMPLETO, catalogo, false,nc));

        Formulario f = efc.especificarFormulario(new NomeFormulario("Nome Formulario"));
        f.addAtributo("Nome Variavel","Label do Form","Descricao Ajuda", TipoDados.INT,"EXP regular");
        f.addAtributo("Nome Variavel2","Label do Form","Descricao Ajuda",TipoDados.STRING,"EXP regular");
        f.addAtributo("Nome Variavel3","Label do Form","Descricao Ajuda",TipoDados.BOOLEANO,"EXP regular");
        efc.saveForm(f);
        Formulario f2 = efc.especificarFormulario(new NomeFormulario("Nome Formulario"));
        f2.addAtributo("Nome Variavel Teste","Label do Form","Descricao Ajuda",TipoDados.INT,"EXP regular");
        f2.addAtributo("Nome Variavel  Teste2","Label do Form","Descricao Ajuda",TipoDados.FRACIONAL,"EXP regular");
        f2.addAtributo("Nome Variavel  Teste3","Label do Form","Descricao Ajuda",TipoDados.INT,"EXP regular");
        efc.saveForm(f2);
        especificarServicoController.adicionaFormulario(servico,f);
        especificarServicoController.adicionaFormulario(servico,f2);





        System.out.println("#############################################  BOOTSTRAP GRUPO 4 2DL FEITO  #############################################");

        return "";
    }
}
