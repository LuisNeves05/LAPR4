
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates and open the template
 * in the editor.
 */
package eapli.base.infrastructure.bootstrapers;

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
import eapli.base.fluxoAtividade.persistence.FluxoAtividadeRepositorio;
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
import eapli.framework.domain.repositories.TransactionalContext;
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
    private final EspecificarNivelCriticidadeController enc = new EspecificarNivelCriticidadeController();
    private final FormularioRepositorio formRep = PersistenceContext.repositories().formularioRepositorio();
    private final AtividadeAprovacaoRepositorio ativAprovRepo = PersistenceContext.repositories().atividadeAprovacaoRepositorio();
    private final AtividadeRealizacaoRepositorio atividadeRealRepo = PersistenceContext.repositories().atividadeRealizacaoRepositorio();
    private final FluxoAtividadeRepositorio fluxoAtividadeRepositorio = PersistenceContext.repositories().fluxoAtividadeRepositorio();

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
        TipoEquipa tipoEquipaVendas = registarTipoEquipaController.tipoEquipaServico("Id123VD", "Equipa de Vendas", 7);


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
         * Colaborador Sergio pertence à equipa de RRH
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
         * Colaborador Sergio pertence à equipa de vendas
         */
        Set<Colaborador> colaboradoresVDTeam = new HashSet<>();
        colaboradoresVDTeam.add(rui);
        colaboradoresVDTeam.add(tiago);


        /**
         * Colaboradores são adicionados às respetivas equipas
         */
        Acronimo acrRRH = new Acronimo("RRH");
        Acronimo acrTCN = new Acronimo("TCN");
        Acronimo acrVD = new Acronimo("VD");

        Equipa equipa_RRH = controllerEquipa.especificarEquipa("123SFT", acrRRH, "Equipa Software", colaboradoresRRHTeam, tipoEquipaRRH);
        Equipa equipa_Tecnica = controllerEquipa.especificarEquipa("123TCN", acrTCN, "Equipa Avaria Tecnica", colaboradoresTecnicaTeam, tipoEquipaAvariaTecnica);
        Equipa equipa_vendas = controllerEquipa.especificarEquipa("123VD", acrVD, "Equipa Vendas", colaboradoresVDTeam, tipoEquipaVendas);

        Set<Equipa> equipasSet = new HashSet<>();
        equipasSet.add(equipa_RRH);
        equipasSet.add(equipa_Tecnica);
        equipasSet.add(equipa_vendas);

        //////////////////////////////////////////////////////////////////////////////////


        AddOrDeleteEquipaController equipaTecnica = new AddOrDeleteEquipaController(equipa_Tecnica);
        Set<Colaborador> lista = new HashSet<>();
        lista.add(rui);
        lista.add(tiago);
        equipaTecnica.adicionarColaboradores(lista);

        AddOrDeleteEquipaController equipaRH = new AddOrDeleteEquipaController(equipa_RRH);
         lista = new HashSet<>();
        lista.add(rui);
        lista.add(tiago);
        equipaRH.adicionarColaboradores(lista);

        AddOrDeleteEquipaController equipaVendas = new AddOrDeleteEquipaController(equipa_vendas);
        lista = new HashSet<>();
        lista.add(rui);
        lista.add(tiago);
        equipaVendas.adicionarColaboradores(lista);

        //////////////////////////////////////////////////////////////////////////////////

        Catalogo catalogoRRH = catalogoController.especificarCatalogo("Recursos Humanos", "Pedidos aos recursos humanos", "Pedir férias/alteração dados pessoais/ etcs", 12, admin, equipasSet);

        Catalogo catalogoAvariaTecnicas = catalogoController.especificarCatalogo("Avarias", "Avarias de equipamentos/comunicação", "Contem tipos de avarias possiveis que possam ocorrer no edificio da empresa", 13, admin, equipasSet);

        Catalogo catalogoVendas = catalogoController.especificarCatalogo("Vendas", "Gestão de assuntos relacionados com vendas", "Gestão de promoções, problemas de vendas", 14, admin, equipasSet);

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

        /**
         * Keywords para serviço relacionado com vendas
         */
        Set<Keyword> keywordsVendas = new HashSet<>();

        Keyword k11 = new Keyword("Percentagem");
        Keyword k12 = new Keyword("Lucro");
        Keyword k13 = new Keyword("Desconto");
        Keyword k14 = new Keyword("Fatura");
        keywordsVendas.add(k11);
        keywordsVendas.add(k12);
        keywordsVendas.add(k13);
        keywordsVendas.add(k14);


        //////////////////////////////////////////////////////////////////////////////////
        Objetivo objNC5 = new Objetivo(2, 2, 1, 1);
        NivelCriticidade nc5 = enc.especificarNivelCriticidade("elevada", 4, Color.red, objNC5, true);

        Objetivo objNC4 = new Objetivo(30, 240, 18, 150);
        NivelCriticidade nc4 = enc.especificarNivelCriticidade("elevada", 3, Color.orange, objNC4, true);

        Objetivo objNC3 = new Objetivo(0,360,0,240);
        NivelCriticidade nc3 = enc.especificarNivelCriticidade("média",2,Color.yellow,objNC3,true);

        Objetivo objNC2 = new Objetivo(120,500,80,320);
        NivelCriticidade nc2 = enc.especificarNivelCriticidade("baixa",1,Color.green,objNC2,true);


        /////////////////////////////////////////////////////////////////////////////////

        /**
         * Serviço 1
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

        /**
         *         Cria Atividade de aprovacação de um serviço
         */
        AtividadeAprovacao atividadeAprovacao1 = new AtividadeAprovacao();
        atividadeAprovacao1.adicionaColabAprov(ColaboradoresAprovacao.RESPONSAVEL_HIERARQUICO);


        /**
         * Criar e guardar formulário de Atividade de Aprovação
         */
        Formulario f1Aprov = new Formulario(new NomeFormulario("Aprovação"));
        f1Aprov.addAtributo("Decisão", "Decisão da Atividade de Aprovação",
                "Decisão (deferido/indeferido) sobre a aprovação", TipoDados.DECISAO, "(Deferido|Indeferido)");
        f1Aprov.addAtributo("Fundamentação", "Comentário decisão", "Fundamente a sua decisão", TipoDados.STRING, "[a-zA-Z]+");
        f1Aprov.addScript("ATRIBUTO 1 NAOVAZIO");
        atividadeAprovacao1.adicionaFormulario(formRep.save(f1Aprov));
        atividadeAprovacao1 = ativAprovRepo.save(atividadeAprovacao1);

        /**
         *   Cria Atividade de realização de um Servico
         */
        AtividadeRealizacao atividadeRealizacao1 = new AtividadeRealizacao();
        atividadeRealizacao1.adicionarEquipaExecucao(equipa_RRH);
        atividadeRealizacao1.adicionarEquipaExecucao(equipa_Tecnica);
        /**
         *         //Criar formulário de Atividade de Realização
         */
        Formulario f1Exe = new Formulario(new NomeFormulario("Execução"));
        f1Exe.addAtributo("Dias Gozados : ", "Férias", "Dias de Férias já gozados no ano", TipoDados.INT, "[0-9]+");
        f1Exe.addAtributo("Dias Gozados Periodo : ", "Férias período", "Dias de Férias já gozados no período pedido", TipoDados.INT, "[0-9]+");
        f1Exe.addAtributo("Dias Totais : ", "Férias", "Dias de Férias totais no ano", TipoDados.INT, "[0-9]+");
        f1Exe.addAtributo("Faltas Justificadas : ", "Faltas", "Dias de faltas justificadas totais", TipoDados.INT, "[0-9]+");
        f1Exe.addAtributo("Faltas Não Justificadas :", "Faltas", "Dias de faltas não justificadas totais", TipoDados.INT, "[0-9]+");
        f1Exe.addAtributo("Conclusão : ", "Conclusão da resolução de uma tarefa", "Conclusão (Concluido/Inacabado)", TipoDados.CONCLUSAO, "(Concluido|Inacabado)");
        f1Exe.addAtributo("Fundamentação :", "Comentário decisão", "Fundamente a sua decisão", TipoDados.STRING, "[a-zA-Z]+");
        f1Exe.addScript("ATRIBUTO 5 NAOVAZIO");
        atividadeRealizacao1.adicionaFormulario(formRep.save(f1Exe));
        atividadeRealizacao1 = atividadeRealRepo.save(atividadeRealizacao1);

        /**
         guarda Fluxo de Atividade
         */
        FluxoAtividade fluxoAtividade1 = fluxoAtividadeRepositorio.save(new FluxoAtividade(atividadeAprovacao1, atividadeRealizacao1));
        Servico servico1 = especificarServicoController.especificarServico(new Servico(new ServicoIdentificador("123IDAusencia"), new Titulo("Pedido de Ausência Futura"), new DescricaoBreve("Pedido de ausência para Férias, ou por um motivo justificado ou não justificado"),
                new DescricaoCompleta("Requisitar uma ausência , elaborando a sua razão"), new byte[3], keywordsRRH, EstadoServico.COMPLETO, fluxoAtividade1, catalogoRRH, true, nc4));

        /**
         * Criar e guardar formulário para pedido de Servico
         */

        Formulario f1pedido = new Formulario(new NomeFormulario("Ausência"));
        f1pedido.addAtributo("Data de Inicio de Ausência", "Data", "Data de inicio da ausência ", TipoDados.DATA, "^\\d{4}-\\d{2}-\\d{2}$");
        f1pedido.addAtributo("Data de Fim de Ausência", "Data", "Data de inicio da ausência ", TipoDados.DATA, "^\\d{4}-\\d{2}-\\d{2}$");
        f1pedido.addAtributo("Tipo de Ausência", "Tipo de Ausência", "Que tipo de ausência deseja reportar", TipoDados.STRING, "Justificada|NaoJustificada|Ferias");
        f1pedido.addAtributo("Comentário", "Comentário de Ausência", "Se ausência for justificada, é obrigado a inserir um comentário", TipoDados.STRING, "[a-zA-Z]+");
            f1pedido.addScript("ATRIBUTO 0 MENORIGUAL ATRIBUTO 1 ");
        f1pedido = formRep.save(f1pedido);
        servico1.adicionaFormulario(f1pedido);
        especificarServicoController.especificarServico(servico1);


        /**
         * Serviço 2
         Objetivo: Autorização para Aplicação de Desconto

         Disponibilidade: Colaboradores do departamento de vendas

         Formulário Pedido:

         Dados: Código Interno Cliente, Nome, Tipo de Desconto, Recorrência, Percentagem de Desconto, Valor de Desconto, Identificação da Fatura, Data Limite, Fundamentação do pedido
         Validação 1: Código cliente obedece a uma expressão regular (3 consoantes + 3 dígitos)
         Validação 2: Código cliente, nome, tipo de desconto, recorrência e fundamentação são obrigatórios
         Validação 3: Apenas um dos campos entre percentagem de desconto e valor de desconto tem obrigatoriamente que estar preenchido (valor superior a zero). O outro campo deve ficar a zero.
         Validação 4: A recorrência apenas assume 2 valores possíveis: Única ou Até Data Limite. Em caso de ser única é obrigatório identificar a fatura em causa. Caso contrário é obrigatório indicar a data limite de aplicação do desconto.
         Formulário Aprovação:

         Quem: pelo responsável pelo serviço
         Dados: Para além da decisão é necessário indicar: um texto fundamentando a decisão e confirmar a percentagem ou valor de desconto atribuído e a data limite (caso faça sentido)
         Validação 1: A fundamentação é obrigatória.
         Validação 2: Apenas um dos campos entre percentagem de desconto e valor de desconto tem obrigatoriamente que estar preenchido (valor superior a zero). O outro campo deve ficar a zero.
         Realização (Automática): Consiste no envio de um email ao colaborador que efetuou o pedido com um texto pré-definido onde é inserida alguma da informação recolhida anteriormente pelo preenchimento dos formulários (e.g. a decisão e o desconto a aplicar).
         */

        CriaServicoService criarServico2 = new CriaServicoService();

        /**
         * Cria Atividade de aprovacação de 1 serviço
         */
        AtividadeAprovacao atividadeAprovacao2 = new AtividadeAprovacao();
        atividadeAprovacao2.adicionaColabAprov(ColaboradoresAprovacao.RESPONSAVEL_PELO_SERVICO);


        /**
         * Criar e guardar formulário de Atividade de Aprovação
         */

        Formulario f2Aprov = new Formulario(new NomeFormulario("Aprovação"));
        f2Aprov.addAtributo("Decisão", "Decisão da Atividade de Aprovação",
                "Decisão (deferido/indeferido) sobre a aprovação", TipoDados.DECISAO, "(Deferido|Indeferido)");
        f2Aprov.addAtributo("Fundamentação", "Comentário decisão", "Fundamente a sua decisão, e confirmar a percentagem ou valor de desconto atribuído e a data limite", TipoDados.STRING, "[a-zA-Z]+");
        atividadeAprovacao2.adicionaFormulario(formRep.save(f2Aprov));
        f2Aprov.addScript("ATRIBUTO 1 NAOVAZIO");
        atividadeAprovacao2 =ativAprovRepo.save(atividadeAprovacao2);


        /**
         *   Cria Atividade de realização de um serviço
         */
        AtividadeRealizacao atividadeRealizacao2 = new AtividadeRealizacao("ENVIAR EMAIL COLABORADOR REQUERENTE teste");//todo verificar script para realizaÇão automática ???
        atividadeRealizacao2 = atividadeRealRepo.save(atividadeRealizacao2);

        /**
         guarda Fluxo de Atividade
         */
        FluxoAtividade fluxoAtividade2 = fluxoAtividadeRepositorio.save(new FluxoAtividade(atividadeAprovacao2, atividadeRealizacao2));
        Servico servico2 = especificarServicoController.especificarServico(new Servico(new ServicoIdentificador("123IDAVenda"), new Titulo("Aplicação de Desconto"), new DescricaoBreve("Autorização para Aplicação de Desconto"),
                new DescricaoCompleta("Autorização para Aplicação de Desconto, e especificação do mesmo."), new byte[3], keywordsVendas, EstadoServico.COMPLETO, fluxoAtividade2, catalogoVendas, false, nc3));


        /**
         * Criar e guardar formulário para pedido de Servico
         */
        Formulario f2pedido = new Formulario(new NomeFormulario("Autorização para Aplicação de Desconto "));
        f2pedido.addAtributo(" Código Interno Cliente", "Código", "Código representativo do cliente no sistema", TipoDados.INT, "^[0-9]+");
        f2pedido.addAtributo("Nome", "Nome", "Nome do cliente ", TipoDados.STRING, "[a-zA-Z]+");
        f2pedido.addAtributo("Tipo de Desconto", "Desconto", "Tipo de Desconto a aplicar", TipoDados.STRING, "[a-zA-Z]+");
        f2pedido.addAtributo("Recorrência", "Recorrência", "Recorrência do desconto aplicado", TipoDados.STRING, "[a-zA-Z]+"); // data se unica, ou ATE data limite se por periodo
        f2pedido.addAtributo("Percentagem Desconto", "PDesconto", "Percentagem de Desconto a aplicar", TipoDados.FRACIONAL, "^([0-9]{1,2}){1}(\\.[0-9]{1,2})?$"); // data se unica, ou ATE data limite se por periodo
        f2pedido.addAtributo("Valor Desconto", "VDesconto", "Valor de Desconto a aplicar", TipoDados.FRACIONAL, "^([0-9]{1,2}){1}(\\.[0-9]{1,2})?$ "); // data se unica, ou ATE data limite se por periodo
        f2pedido.addAtributo("Identificação Fatura", "FaturaID", "Identificador unívoco da fatura em questão", TipoDados.STRING, "^[a-zA-Z0-9_]*$"); // data se unica, ou ATE data limite se por periodo
        f2pedido.addAtributo("Data Limite", "Data", "Data Limite Desconto", TipoDados.DATA, "^\\d{4}-\\d{2}-\\d{2}$"); // data se unica, ou ATE data limite se por periodo
        f2pedido.addAtributo("Fundamentação Pedido", "Fundamentação", "Fundamentação do pedido de desconto a aplicar", TipoDados.STRING, "^[a-zA-Z0-9_]*$"); // data se unica, ou ATE data limite se por periodo
        f2pedido.addScript("ATRIBUTO 4 VAZIO ATRIBUTO 5 NAOVAZIO");
        f2pedido = formRep.save(f2pedido);
        servico2.adicionaFormulario(f2pedido);
        especificarServicoController.especificarServico(servico2);
        /**
         * Serviço 3
         Objetivo: Comunicação de Alteração de Residência

         Disponibilidade: Colaboradores do departamento de vendas

         Formulário Pedido:

         Dados: Os correspondentes à estrutura de uma morada postal em Portugal
         Validação: Garantir que a informação introduzida é válida (e.g. Código postal com 4+3 digitos).
         (Sem Aprovação)

         Formulário Realização:

         Quem: um colaborador da equipa da secção de Recursos Humanos
         Dados: Apenas um texto de observações.
         Validação: O texto de observações é obrigatório.
         *
         */
        CriaServicoService criarServico3 = new CriaServicoService();


        /**
         *   Cria Atividade de realização de 1 serviço
         */
        AtividadeRealizacao atividadeRealizacao3 = new AtividadeRealizacao();
        atividadeRealizacao3.adicionarEquipaExecucao(equipa_RRH);
        /**
         *         Criar  formulário para atividade de realizacao
         */
        Formulario f3exe = new Formulario(new NomeFormulario("Alteração de Residência"));
        f3exe.addAtributo(" Comentário", "Morada", "Comentário sobre pedido de mudança", TipoDados.STRING, "^[A-Z a-z 0-9]+ *$");
        f3exe.addScript("ATRIBUTO 0 NAOVAZIO");

        atividadeRealizacao3.adicionaFormulario(formRep.save(f3exe));
        atividadeRealizacao3 = atividadeRealRepo.save(atividadeRealizacao3);

        /**
         Cria Fluxo de Atividade
         */
        FluxoAtividade fluxoAtividade3 = fluxoAtividadeRepositorio.save(new FluxoAtividade(atividadeRealizacao3));
        Servico servico3 = especificarServicoController.especificarServico(new Servico(new ServicoIdentificador("124IDAVenda"), new Titulo("Alteração de Residência"), new DescricaoBreve("Alteração de Residência"),
                new DescricaoCompleta("Requisitar a alteração de residência , fornecendo uma morada e um código postal."), new byte[3], keywordsVendas, EstadoServico.COMPLETO, fluxoAtividade3, catalogoVendas, false, nc4));

        /**
         * Criar  formulário para pedido de Servico
         */

        Formulario f3pedido = new Formulario(new NomeFormulario("Pedido Alteração de Residência  "));
        f3pedido.addAtributo(" Morada Postal : ", "Morada", "Morada seguida de código postal", TipoDados.STRING, "^[A-Z a-z 0-9]+ ' ' [0-9]{4}-[0-9]{3}*$");
        f3pedido.addScript("ATRIBUTO 0 @[0-9]{4}-[0-9]{3}*$@");
        f3pedido = formRep.save(f3pedido);
        servico3.adicionaFormulario(f3pedido);
        especificarServicoController.especificarServico(servico3);

        /**
         * Serviço 4
         Objetivo: Requerer cotação para venda por grosso

         Disponibilidade: Colaboradores do departamento de vendas

         Formulário Pedido:

         Dados: Código do Produto, Quantidade pretendida, Tipo de Cliente
         Validação 1: Tipo de cliente aceita apenas 3 valores: Nacional, Europeu, Resto do Mundo
         Validação 2: Todos os dados são obrigatórios
         Validação 3: A quantidade só pode ter parte decimal significativa (diferente de zero) caso o código do produto comece por "20" ou "21".
         (Sem Aprovação)
         Quem: um colaborador da equipa da secção de Recursos Humanos
         Dados: Apenas um texto de observações.
         Validação: O texto de observações é obrigatório.
         *Realização (Automática): Consiste em: (1) consultar um ficheiro XML de produtos e com base no código do produto obter o preço de venda unitário
         *  e a categoria do produto; (2) calcular o valor total (preço unitário X quantidade); (3) com base no valor total calculado determinar a percentagem
         *  base de desconto a aplicar (e.g. se valor > Z o desconto é 3% caso contrário é 1%); (4) para produtos com a categoria "ABC" atualizar a percentagem
         *  base de desconto em mais 0.5%; (5) calcular o valor de desconto e o valor total após descontos; (5) enviar um email ao colaborador que efetuou o pedido
         *  cujo texto pré-definido varia consoante o tipo de cliente e onde se apresentam alguns dos valores calculados.
         */

        CriaServicoService criarServico4 = new CriaServicoService();


        /**
         *   Cria Atividade de realização de um serviço
         */

        AtividadeRealizacao atividadeRealizacao4 = new AtividadeRealizacao("ATRIBUTO 0 ATRIBUTO 1 SE ATRIBUTO 2 MENOR 5 ENTAO 8 SE Software ENTAO 9 ENVIAR EMAIL COLABORADOR REQUERENTE OLA");
        atividadeRealizacao4 = atividadeRealRepo.save(atividadeRealizacao4);

        /**
         Cria Fluxo de Atividade
         */
        FluxoAtividade fluxoAtividade4 = fluxoAtividadeRepositorio.save(new FluxoAtividade(atividadeRealizacao4));
        Servico servico4 = especificarServicoController.especificarServico(new Servico(new ServicoIdentificador("125IDAVenda"), new Titulo("Cotação para venda por grosso"), new DescricaoBreve("Venda por grosso"),
                new DescricaoCompleta("Definir especificações de possíveis vendas a grosso a clientes."), new byte[3], keywordsVendas, EstadoServico.COMPLETO, fluxoAtividade4, catalogoVendas, false, nc3));

        /**
         * Criar  formulário para pedido de Servico
          */
        Formulario f4pedido = new Formulario(new NomeFormulario("Requerer cotação para venda por grosso"));
        f4pedido.addAtributo(" Nome Ficheiro : ", "Ficheiro", "Ficheiro que pretendo consultar", TipoDados.FICHEIROXML, "^[A-Z a-z 0-9]+");
        f4pedido.addAtributo(" Código Produto : ", "Codigo", "Código do Produto", TipoDados.STRING, "^[A-Z a-z 0-9]+");
        f4pedido.addAtributo(" Quantidade Pretendida : ", "Quantidade pretendida", "Quantidade de unidades para venda em grosso", TipoDados.INT, "^([0-9]{1,3}){1}");
        f4pedido.addAtributo("Tipo de Cliente :", "Tipo de Cliente", "Tipo de Cliente(Nacional, Europeu, Resto do Mundo) ", TipoDados.STRING, "(Nacional|Europeu|Resto do Mundo)");
        f4pedido.addScript("ATRIBUTO 3 @(Nacional|Europeu|Resto do Mundo)@");

        f4pedido = formRep.save(f4pedido);
        servico4.adicionaFormulario(f4pedido);
        especificarServicoController.especificarServico(servico4);


        /**
         * Serviço tem atividade de aprovação, neste caso, é aprovado pelo responsavel hierarquico do colaborador requerente
         *
         * É assignado a uma equipa, logo é de resolução manual
         *
         */
        CriaServicoService criarServicoService = new CriaServicoService();
        AtividadeAprovacao atividadeAprovacao = new AtividadeAprovacao();
        atividadeAprovacao.adicionaColabAprov(ColaboradoresAprovacao.RESPONSAVEL_HIERARQUICO);
        AtividadeAprovacao at = ativAprovRepo.save(atividadeAprovacao);

        AtividadeRealizacao ativReal = new AtividadeRealizacao();
        ativReal.adicionarEquipaExecucao(equipa_Tecnica);
        AtividadeRealizacao atividadeRealizacao = atividadeRealRepo.save(ativReal);

        FluxoAtividade fluxoAtividade = fluxoAtividadeRepositorio.save(new FluxoAtividade(at,atividadeRealizacao));

        Servico servico = especificarServicoController.especificarServico(new Servico(new ServicoIdentificador("123IDAvaria"), new Titulo("Reportar anomalia de Comunicação"), new DescricaoBreve("Anomalia em comunicação da rede da empresa"),
                new DescricaoCompleta("Reportar anomalias/avarias em serviços de comunicação da empresa"), new byte[2], new HashSet<>(), EstadoServico.INCOMPLETO, fluxoAtividade, catalogoAvariaTecnicas, false, nc2));


        Formulario f = new Formulario(new NomeFormulario("Avaria"));
        f.addAtributo("Equipamento que avariou: ","Código do equipamento","Código na lateral do equipamento", TipoDados.INT,"[0-9]+");
        f.addAtributo("Edifício do equipamento: ","Nome do edificio do equipamento","Nome afixado na entrada do edificio",TipoDados.STRING,"[a-zA-Z]+");
        f.addAtributo("Comentário: ","Avaria concreta do equipamento","Avaliação empírica da avaria",TipoDados.STRING,"[a-zA-Z]+");
        Formulario fSav = formRep.save(f);

        servico.adicionaFormulario(fSav);
        especificarServicoController.especificarServico(servico);

        System.out.println("\n\n#############################################  BOOTSTRAP GRUPO 4 2DL FEITO  #############################################");

        return "";
    }
}
