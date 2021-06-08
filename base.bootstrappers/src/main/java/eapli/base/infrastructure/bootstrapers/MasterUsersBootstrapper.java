/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates and open the template
 * in the editor.
 */
package eapli.base.infrastructure.bootstrapers;

import eapli.base.atividadeAprovacao.domain.AtividadeAprovacao;
import eapli.base.atividadeAprovacao.domain.ColaboradoresAprovacao;
import eapli.base.atividadeRealizacao.domain.AtividadeRealizacao;
import eapli.base.atividadeRealizacao.domain.TipoExecucao;
import eapli.base.catalogo.application.EspecificarCatalogoController;
import eapli.base.catalogo.domain.Catalogo;
import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.colaborador.application.EspecificarColaboradorController;
import eapli.base.colaborador.domain.*;
import eapli.base.criticidade.application.EspecificarNivelCriticidadeController;
import eapli.base.criticidade.domain.Etiqueta;
import eapli.base.criticidade.domain.NivelCriticidade;
import eapli.base.criticidade.domain.Objetivo;
import eapli.base.equipa.application.AddOrDeleteEquipaController;
import eapli.base.equipa.application.EspecificarEquipaController;
import eapli.base.equipa.domain.Acronimo;
import eapli.base.equipa.domain.Equipa;
import eapli.base.fluxoAtividade.domain.FluxoAtividade;
import eapli.base.formulario.application.EspecificarFormularioController;
import eapli.base.formulario.domain.Formulario;
import eapli.base.formulario.domain.NomeFormulario;
import eapli.base.formulario.domain.TipoDados;
import eapli.base.formulario.persistencia.FormularioRepositorio;
import eapli.base.infrastructure.persistence.PersistenceContext;
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
    private final FormularioRepositorio formRep = PersistenceContext.repositories().formularioRepositorio();


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

        TipoEquipa tipoEquipaRRH = registarTipoEquipaController.tipoEquipaServico("Id123RH","Equipa de RRH", 5);
        TipoEquipa tipoEquipaAvariaTecnica = registarTipoEquipaController.tipoEquipaServico("Id123AT","Equipa de Avarias técnicas", 6);


        String pattern = "05-12-2000";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Date date = null;
        try {
            date = simpleDateFormat.parse(pattern);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Set<Role> rolessAdmin = new HashSet<>();
        Set<Role> rolessGSH = new HashSet<>();
        Set<Role> rolessCOLAB = new HashSet<>();
        rolessAdmin.add(BaseRoles.ADMIN);
        rolessCOLAB.add(BaseRoles.COLABORADOR);
        rolessGSH.add(BaseRoles.RRH);


        /**
         * Administrador
         */
        Colaborador admin = colaboradorController.especificarColaborador(new NomeCurto("Luis"), new NomeCompleto("Luis Neves"),
                new MecanographicNumber("1191421"), new Morada("Porto", "Penafiel"),
                new NrContacto(910900398), date, null, rolessAdmin, "Luis", "Password1", "luismanuelneves@gmail.com");

        /**
         * Colaborador normal
         */
        Colaborador rui = colaboradorController.especificarColaborador(new NomeCurto("Rui"), new NomeCompleto("Rui Alves"),
                new MecanographicNumber("1181597"), new Morada("Porto", "Marco de Canaveses"),
                new NrContacto(927206840), date, admin, rolessCOLAB, "Rui", "Password1", "rui@gmail.com");

        /**
         * Colaborador normal
         */
        Colaborador tiago = colaboradorController.especificarColaborador(new NomeCurto("Tiago"), new NomeCompleto("Tiago Marante"),
                new MecanographicNumber("1181235"), new Morada("Porto", "Marco de Canaveses"),
                new NrContacto(927206840), date, admin, rolessCOLAB, "Tiago", "Password1", "tiago@gmail.com");


        /**
         * Colaborador normal
         */
        Colaborador sergio = colaboradorController.especificarColaborador(new NomeCurto("Sergio"), new NomeCompleto("Sergio Neves"),
                new MecanographicNumber("1200625"), new Morada("Porto", "Marco de Canaveses"),
                new NrContacto(927296840), date, admin, rolessCOLAB, "Sergio", "Password1", "sergio@gmail.com");

        /**
         * Gestor Serviços Helpdesk
         */
        Colaborador joaoGestorSH = colaboradorController.especificarColaborador(new NomeCurto("Joao"), new NomeCompleto("Joao Alves"),
                new MecanographicNumber("1121624"), new Morada("Porto", "Marco de Canaveses"),
                new NrContacto(927206841), date, admin, rolessGSH, "Joao", "Password1", "joao@gmail.com");

        /**
         * Colaborador Sergio pertence à equipa de rrh
         */
        Set<Colaborador> colaboradoresRRHTeam = new HashSet<>();
        colaboradoresRRHTeam.add(sergio);

        /**
         * Colaborador Rui pertence à equipa de avarias Tecnicas
         */
        Set<Colaborador> colaboradoresTecnicaTeam = new HashSet<>();
        colaboradoresRRHTeam.add(rui);
        colaboradoresRRHTeam.add(tiago);

        //////////////////////////////////////////////////////////////////////////////////

        /**
         * Colaboradores são adicionados às respetivas equipas
         */
        Acronimo acrRRH = new Acronimo("RRH");
        Acronimo acrTCN = new Acronimo("TCN");
        Equipa equipa_RRH = controllerEquipa.especificarEquipa("123SFT",acrRRH,"Equipa Software",colaboradoresRRHTeam,tipoEquipaRRH);
        Equipa equipa_Tecnica = controllerEquipa.especificarEquipa("123TCN",acrTCN,"Equipa Avaria Tecnica",colaboradoresTecnicaTeam,tipoEquipaAvariaTecnica);

        Set<Equipa> equipasSet = new HashSet<>();
        equipasSet.add(equipa_RRH);
        equipasSet.add(equipa_Tecnica);

        //////////////////////////////////////////////////////////////////////////////////


        AddOrDeleteEquipaController adod = new AddOrDeleteEquipaController(equipa_Tecnica);
        Set<Colaborador> lista = new HashSet<>();
        lista.add(rui);
        lista.add(tiago);
        adod.adicionarColaboradores(lista);

        //////////////////////////////////////////////////////////////////////////////////

        Catalogo catalogoRRH = catalogoController.especificarCatalogo("Recursos Humanos","Pedidos aos recursos humanos", "Pedir férias/alteração dados pessoais/ etcs",12,admin, equipasSet);

        Catalogo catalogoAvariaTecnicas = catalogoController.especificarCatalogo("Avarias","Avarias de equipamentos/comunicação", "Contem tipos de avarias possiveis que possam ocorrer no edificio da empresa",13,admin, equipasSet);

        //////////////////////////////////////////////////////////////////////////////////

        /**
         * Keywords para serviço relacionado com os recursos humanos
         */
        Keyword k = new Keyword("Ferias");
        Keyword k2 = new Keyword("NIB");
        Keyword k3 = new Keyword("IBAN");
        Keyword k4 = new Keyword("Salario");
        Keyword k5 = new Keyword("Horas");
        Set<Keyword> keywordsRRH = new HashSet<>();
        keywordsRRH.add(k);
        keywordsRRH.add(k2);
        keywordsRRH.add(k3);
        keywordsRRH.add(k4);
        keywordsRRH.add(k5);

        //////////////////////////////////////////////////////////////////////////////////

        /**
         * Keywords para serviço relacionado com avarias
         */
        Keyword k6 = new Keyword("Avariou");
        Keyword k7 = new Keyword("Queimou");
        Keyword k8 = new Keyword("Estragou");
        Keyword k9 = new Keyword("Caiu");
        Keyword k10 = new Keyword("Partiu");
        Set<Keyword> keywordsAvariaTecnica = new HashSet<>();
        keywordsAvariaTecnica.add(k6);
        keywordsAvariaTecnica.add(k7);
        keywordsAvariaTecnica.add(k8);
        keywordsAvariaTecnica.add(k9);
        keywordsAvariaTecnica.add(k10);

        //////////////////////////////////////////////////////////////////////////////////

        Objetivo obj = new Objetivo(20,250,0,0);
        NivelCriticidade nc  = enc.especificarNivelCriticidade("elevada", 4, Color.RED,obj,true);

        /////////////////////////////////////////////////////////////////////////////////

        /**
         * Serviço tem atividade de aprovação, neste caso, é aprovado pelo responsavel hierarquico do colaborador requerente
         *
         * É assignado a uma equipa, logo é de resolução manual
         *
         */

        AtividadeAprovacao atividadeAprovacao = new AtividadeAprovacao();
        atividadeAprovacao.adicionaColabAprov(ColaboradoresAprovacao.RESPONSAVEL_HIERARQUICO);
        AtividadeAprovacao at = especificarServicoController.guardaAtividadeAprovacao(atividadeAprovacao);

        AtividadeRealizacao ativReal = new AtividadeRealizacao(TipoExecucao.MANUAL,null);
        ativReal.adicionarEquipaExecucao(equipa_Tecnica);
        AtividadeRealizacao atividadeRealizacao = especificarServicoController.guardaAtividadeRealizacao(ativReal);

        FluxoAtividade fluxoAtividade = especificarServicoController.guardaFluxo(new FluxoAtividade(at,atividadeRealizacao));

        Servico servico = especificarServicoController.especificarServico(new Servico(new ServicoIdentificador("123IDAvaria"), new Titulo("Reportar anomalia de Comunicação"), new DescricaoBreve("Anomalia em comunicação da rede da empresa"),
                new DescricaoCompleta("Reportar anomalias/avarias em serviços de comunicação da empresa"), new byte[2], new HashSet<>(), EstadoServico.INCOMPLETO, fluxoAtividade, catalogoAvariaTecnicas, false, nc));


        Formulario f = new Formulario(new NomeFormulario("Avaria"), new HashSet<>());
        f.addAtributo("Equipamento que avariou: ","Código do equipamento","Código na lateral do equipamento", TipoDados.INT,"[0-9]+");
        f.addAtributo("Edifício do equipamento: ","Nome do edificio do equipamento","Nome afixado na entrada do edificio",TipoDados.STRING,"[a-zA-Z]+");
        f.addAtributo("Comentário: ","Avaria concreta do equipamento","Avaliação empírica da avaria",TipoDados.STRING,"[a-zA-Z]+");
        Formulario fSav = formRep.save(f);

        especificarServicoController.adicionaFormulario(servico,fSav);
        especificarServicoController.especificarServico(servico);


        System.out.println("\n\n#############################################  BOOTSTRAP GRUPO 4 2DL FEITO  #############################################");

        return "";
    }
}
