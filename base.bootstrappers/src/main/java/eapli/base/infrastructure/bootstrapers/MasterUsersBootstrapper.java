/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates and open the template
 * in the editor.
 */
package eapli.base.infrastructure.bootstrapers;

import eapli.base.app.common.console.presentation.EspecificarServicoUI.FormularioHelper;
import eapli.base.atividadeAprovacao.domain.AtividadeAprovacao;
import eapli.base.atividadeAprovacao.domain.ColaboradoresAprovacao;
import eapli.base.atividadeAprovacao.persistence.AtividadeAprovacaoRepositorio;
import eapli.base.atividadeRealizacao.domain.AtividadeRealizacao;
import eapli.base.atividadeRealizacao.persistence.AtividadeRealizacaoRepositorio;
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
import eapli.base.fluxoAtividade.domain.FluxoAtividade;
import eapli.base.formulario.domain.Formulario;
import eapli.base.formulario.domain.NomeFormulario;
import eapli.base.formulario.domain.TipoDados;
import eapli.base.formulario.persistencia.FormularioRepositorio;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.servico.application.EspecificarServicoController;
import eapli.base.servico.domain.*;
import eapli.base.servico.service.CriaServicoService;
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
    private final EspecificarNivelCriticidadeController enc = new EspecificarNivelCriticidadeController();
    private final FormularioRepositorio formRep = PersistenceContext.repositories().formularioRepositorio();
    private final AtividadeAprovacaoRepositorio ativAprovRepo = PersistenceContext.repositories().atividadeAprovacaoRepositorio();
    private final AtividadeRealizacaoRepositorio atividadeRealRepo = PersistenceContext.repositories().atividadeRealizacaoRepositorio();


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

    private String masterBootStrap() {

        TipoEquipa tipoEquipaRRH = registarTipoEquipaController.tipoEquipaServico("Id123RH", "Equipa de RRH", 5);
        TipoEquipa tipoEquipaAvariaTecnica = registarTipoEquipaController.tipoEquipaServico("Id123AT", "Equipa de Avarias técnicas", 6);


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
        Equipa equipa_RRH = controllerEquipa.especificarEquipa("123SFT", acrRRH, "Equipa Software", colaboradoresRRHTeam, tipoEquipaRRH);
        Equipa equipa_Tecnica = controllerEquipa.especificarEquipa("123TCN", acrTCN, "Equipa Avaria Tecnica", colaboradoresTecnicaTeam, tipoEquipaAvariaTecnica);

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

        Catalogo catalogoRRH = catalogoController.especificarCatalogo("Recursos Humanos", "Pedidos aos recursos humanos", "Pedir férias/alteração dados pessoais/ etcs", 12, admin, equipasSet);

        Catalogo catalogoAvariaTecnicas = catalogoController.especificarCatalogo("Avarias", "Avarias de equipamentos/comunicação", "Contem tipos de avarias possiveis que possam ocorrer no edificio da empresa", 13, admin, equipasSet);

        //todo fazer catalogo de ferias
       // Catalogo catalogoFerias =  catalogoController.especificarCatalogo()

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

        Objetivo obj = new Objetivo(20, 250, 0, 0);
        NivelCriticidade nc = enc.especificarNivelCriticidade("elevada", 4, Color.RED, obj, true);

        /////////////////////////////////////////////////////////////////////////////////

        /**
         Objetivo: Pedido de Ausência Futura

         Disponibilidade: Todos os colaboradores da organização

         Formulário Pedido:

         Dados: Período de ausência (data inicio e fim) + Tipo Ausência + Justificação
         Validação 1: O período é definido por duas datas em que a data fim é igual ou superior à data inicio.
         Validação 2: O tipo de ausência assume apenas 3 valores possíveis: Férias, Justificada, Não Justificada.
         Validação 3: Caso o tipo de ausência seja "Justificada" é obrigatório preencher o campo "justificação".
         Formulário Aprovação:

         Quem: pelo superior hierárquico do colaborador
         Dados: Para além da decisão apenas é necessário um texto fundamentando a decisão.
         Validação: A fundamentação é obrigatória.
         Formulário Realização:

         Quem: um colaborador da equipa da secção de Recursos Humanos
         Dados: A título informativo para o colaborador deve ser indicado a seguinte informação: Dias de férias já gozados no ano, Dias de férias gozados do período solicitado, Dias de férias totais, Dias de falta justificadas já ocorridas no ano, Dias de faltas justificadas do período solicitado, Dias de faltas justificadas totais,  Dias de falta não justificadas já ocorridas no ano, Dias de faltas não justificadas do período solicitado, Dias de faltas não justificadas totais e uma comentário.
         Validação 1: Com exceção do comentário, todos os dados são obrigatórios.
         Validação 2: Os dias totais (e.g. férias totais) devem corresponder à soma dos dias já gozados/ocorridos e dos dias a gozar/ocorrer no período solicitado.
         */

        CriaServicoService criarServico1 = new CriaServicoService();
        //Cria Atividade de aprovacação de 1 serviço
        AtividadeAprovacao atividadeAprovacao1 = new AtividadeAprovacao();
        atividadeAprovacao1.adicionaColabAprov(ColaboradoresAprovacao.RESPONSAVEL_HIERARQUICO);
        atividadeAprovacao1 = criarServico1.guardaAtividadeAprovacao(atividadeAprovacao1);


        //Criar e guardar formulário de Atividade de Aprovação
        FormularioHelper fha1 = new FormularioHelper();
        Formulario f1Aprov= fha1.form(false,true,false);
        f1Aprov.addAtributo("Fundamentação","Comentário decisão","Fundamente a sua decisão",TipoDados.STRING,"[a-zA-Z]+");
        formRep.save(f1Aprov);

        // Guarda Atividade de aprovacação de 1 serviço
        atividadeAprovacao1.adicionaFormulario(f1Aprov);
        ativAprovRepo.save(atividadeAprovacao1);

        //Cria Atividade de realização de 1 serviço
        AtividadeRealizacao atividadeRealizacao1 = new AtividadeRealizacao();
        atividadeRealizacao1.adicionarEquipaExecucao(equipa_RRH);
        atividadeRealizacao1.adicionarEquipaExecucao(equipa_Tecnica);
        //Criar e guardar formulário de Atividade de Realização
        FormularioHelper fhe1 = new FormularioHelper();
        Formulario f1Exe= fhe1.form(false,false,true);
        f1Exe.addAtributo("Fundamentação","Comentário decisão","Fundamente a sua decisão",TipoDados.STRING,"[a-zA-Z]+");
        f1Exe.addAtributo("Dias Gozados","Férias","Dias de Férias já gozados no ano",TipoDados.INT,"[0-9]+");
        f1Exe.addAtributo("Dias Gozados Período","Férias período","Dias de Férias já gozados no período pedido",TipoDados.INT,"[0-9]+");
        f1Exe.addAtributo("Dias Totais","Férias","Dias de Férias totais no ano",TipoDados.INT,"[0-9]+");
        f1Exe.addAtributo("Faltas Justificadas","Faltas","Dias de faltas justificadas totais",TipoDados.INT,"[0-9]+");
        f1Exe.addAtributo("Faltas Não Justificadas","Faltas","Dias de faltas não justificadas totais",TipoDados.INT,"[0-9]+");

        formRep.save(f1Aprov);
        //guarda Fluxo de Atividade
        FluxoAtividade fluxoAtividade1 = criarServico1.guardaFluxo(new FluxoAtividade(atividadeAprovacao1,atividadeRealizacao1));
        //todo terminar especificacao de servico
        Servico servico1 = especificarServicoController.especificarServico(new Servico(new ServicoIdentificador("123IDAusencia"), new Titulo("Pedido de Ausência Futura"), new DescricaoBreve("Pedido de ausência para Férias, ou por um motivo justificado ou não justificado"),
                new DescricaoCompleta("Requisitar uma ausência , elaborando a sua razão"), new byte[3], new HashSet<>(), EstadoServico.INCOMPLETO, fluxoAtividade1, catalogoAvariaTecnicas, false, nc));


        /**
         * Serviço tem atividade de aprovação, neste caso, é aprovado pelo responsavel hierarquico do colaborador requerente
         *
         * É assignado a uma equipa, logo é de resolução manual
         *
         */
        CriaServicoService criarServicoService = new CriaServicoService();
        AtividadeAprovacao atividadeAprovacao = new AtividadeAprovacao();
        atividadeAprovacao.adicionaColabAprov(ColaboradoresAprovacao.RESPONSAVEL_HIERARQUICO);
        AtividadeAprovacao at = criarServicoService.guardaAtividadeAprovacao(atividadeAprovacao);

        AtividadeRealizacao ativReal = new AtividadeRealizacao();
        ativReal.adicionarEquipaExecucao(equipa_Tecnica);
        AtividadeRealizacao atividadeRealizacao = criarServicoService.guardaAtividadeRealizacao(ativReal);

        FluxoAtividade fluxoAtividade = criarServicoService.guardaFluxo(new FluxoAtividade(at,atividadeRealizacao));

        Servico servico = especificarServicoController.especificarServico(new Servico(new ServicoIdentificador("123IDAvaria"), new Titulo("Reportar anomalia de Comunicação"), new DescricaoBreve("Anomalia em comunicação da rede da empresa"),
                new DescricaoCompleta("Reportar anomalias/avarias em serviços de comunicação da empresa"), new byte[2], new HashSet<>(), EstadoServico.INCOMPLETO, fluxoAtividade, catalogoAvariaTecnicas, false, nc));


        Formulario f = new Formulario(new NomeFormulario("Avaria"));
        f.addAtributo("Equipamento que avariou: ","Código do equipamento","Código na lateral do equipamento", TipoDados.INT,"[0-9]+");
        f.addAtributo("Edifício do equipamento: ","Nome do edificio do equipamento","Nome afixado na entrada do edificio",TipoDados.STRING,"[a-zA-Z]+");
        f.addAtributo("Comentário: ","Avaria concreta do equipamento","Avaliação empírica da avaria",TipoDados.STRING,"[a-zA-Z]+");
        Formulario fSav = formRep.save(f);

        criarServicoService.adicionaFormulario(servico,fSav);
        especificarServicoController.especificarServico(servico);


        System.out.println("\n\n#############################################  BOOTSTRAP GRUPO 4 2DL FEITO  #############################################");

        return "";
    }
}
