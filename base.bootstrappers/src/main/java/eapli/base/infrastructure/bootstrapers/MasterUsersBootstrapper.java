
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
        TipoEquipa tipoEquipaAvariaTecnica = registarTipoEquipaController.tipoEquipaServico("Id123AT", "Equipa de Avarias t??cnicas", 6);
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
         * Gestor Servi??os Helpdesk
         */
        Colaborador joaoGestorSH = colaboradorController.especificarColaborador(new NomeCurto("Joao"), new NomeCompleto("Joao Alves"),
                new MecanographicNumber("1121624"), new Morada("Porto", "Marco de Canaveses"),
                new NrContacto(927206841), date, admin, rolessGSH, "Joao", "Password1", "joao@gmail.com");

        /**
         * Colaborador Sergio pertence ?? equipa de RRH
         */
        Set<Colaborador> colaboradoresRRHTeam = new HashSet<>();
        colaboradoresRRHTeam.add(sergio);

        /**
         * Colaborador Rui pertence ?? equipa de avarias Tecnicas
         */
        Set<Colaborador> colaboradoresTecnicaTeam = new HashSet<>();
        colaboradoresRRHTeam.add(rui);
        colaboradoresRRHTeam.add(tiago);

        //////////////////////////////////////////////////////////////////////////////////

        /**
         * Colaborador Sergio pertence ?? equipa de vendas
         */
        Set<Colaborador> colaboradoresVDTeam = new HashSet<>();
        colaboradoresVDTeam.add(rui);
        colaboradoresVDTeam.add(tiago);


        /**
         * Colaboradores s??o adicionados ??s respetivas equipas
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

        Catalogo catalogoRRH = catalogoController.especificarCatalogo("Recursos Humanos", "Pedidos aos recursos humanos", "Pedir f??rias/altera????o dados pessoais/ etcs", 12, admin, equipasSet);

        Catalogo catalogoAvariaTecnicas = catalogoController.especificarCatalogo("Avarias", "Avarias de equipamentos/comunica????o", "Contem tipos de avarias possiveis que possam ocorrer no edificio da empresa", 13, admin, equipasSet);

        Catalogo catalogoVendas = catalogoController.especificarCatalogo("Vendas", "Gest??o de assuntos relacionados com vendas", "Gest??o de promo????es, problemas de vendas", 14, admin, equipasSet);

        //////////////////////////////////////////////////////////////////////////////////

        /**
         * Keywords para servi??o relacionado com os recursos humanos
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
         * Keywords para servi??o relacionado com avarias
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
         * Keywords para servi??o relacionado com vendas
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
        NivelCriticidade nc3 = enc.especificarNivelCriticidade("m??dia",2,Color.yellow,objNC3,true);

        Objetivo objNC2 = new Objetivo(120,500,80,320);
        NivelCriticidade nc2 = enc.especificarNivelCriticidade("baixa",1,Color.green,objNC2,true);


        /////////////////////////////////////////////////////////////////////////////////

        /**
         * Servi??o 1
         Objetivo: Pedido de Aus??ncia Futura

         Disponibilidade: Todos os colaboradores da organiza????o

         Formul??rio Pedido:

         Dados: Per??odo de aus??ncia (data inicio e fim) + Tipo Aus??ncia + Justifica????o
         Valida????o 1: O per??odo ?? definido por duas datas em que a data fim ?? igual ou superior ?? data inicio.
         Valida????o 2: O tipo de aus??ncia assume apenas 3 valores poss??veis: F??rias, Justificada, N??o Justificada.
         Valida????o 3: Caso o tipo de aus??ncia seja "Justificada" ?? obrigat??rio preencher o campo "justifica????o".
         Formul??rio Aprova????o:

         Quem: pelo superior hier??rquico do colaborador
         Dados: Para al??m da decis??o apenas ?? necess??rio um texto fundamentando a decis??o.
         Valida????o: A fundamenta????o ?? obrigat??ria.
         Formul??rio Realiza????o:

         Quem: um colaborador da equipa da sec????o de Recursos Humanos
         Dados: A t??tulo informativo para o colaborador deve ser indicado a seguinte informa????o: Dias de f??rias j?? gozados no ano, Dias de f??rias gozados do per??odo solicitado, Dias de f??rias totais, Dias de falta justificadas j?? ocorridas no ano, Dias de faltas justificadas do per??odo solicitado, Dias de faltas justificadas totais,  Dias de falta n??o justificadas j?? ocorridas no ano, Dias de faltas n??o justificadas do per??odo solicitado, Dias de faltas n??o justificadas totais e uma coment??rio.
         Valida????o 1: Com exce????o do coment??rio, todos os dados s??o obrigat??rios.
         Valida????o 2: Os dias totais (e.g. f??rias totais) devem corresponder ?? soma dos dias j?? gozados/ocorridos e dos dias a gozar/ocorrer no per??odo solicitado.
         */


        CriaServicoService criarServico1 = new CriaServicoService();

        /**
         *         Cria Atividade de aprovaca????o de um servi??o
         */
        AtividadeAprovacao atividadeAprovacao1 = new AtividadeAprovacao();
        atividadeAprovacao1.adicionaColabAprov(ColaboradoresAprovacao.RESPONSAVEL_HIERARQUICO);


        /**
         * Criar e guardar formul??rio de Atividade de Aprova????o
         */
        Formulario f1Aprov = new Formulario(new NomeFormulario("Aprova????o"));
        f1Aprov.addAtributo("Decis??o", "Decis??o da Atividade de Aprova????o",
                "Decis??o (deferido/indeferido) sobre a aprova????o", TipoDados.DECISAO, "(Deferido|Indeferido)");
        f1Aprov.addAtributo("Fundamenta????o", "Coment??rio decis??o", "Fundamente a sua decis??o", TipoDados.STRING, "[a-zA-Z]+");
        f1Aprov.addScript("ATRIBUTO 1 NAOVAZIO");
        atividadeAprovacao1.adicionaFormulario(formRep.save(f1Aprov));
        atividadeAprovacao1 = ativAprovRepo.save(atividadeAprovacao1);

        /**
         *   Cria Atividade de realiza????o de um Servico
         */
        AtividadeRealizacao atividadeRealizacao1 = new AtividadeRealizacao();
        atividadeRealizacao1.adicionarEquipaExecucao(equipa_RRH);
        atividadeRealizacao1.adicionarEquipaExecucao(equipa_Tecnica);
        /**
         *         //Criar formul??rio de Atividade de Realiza????o
         */
        Formulario f1Exe = new Formulario(new NomeFormulario("Execu????o"));
        f1Exe.addAtributo("Dias Gozados : ", "F??rias", "Dias de F??rias j?? gozados no ano", TipoDados.INT, "[0-9]+");
        f1Exe.addAtributo("Dias Gozados Periodo : ", "F??rias per??odo", "Dias de F??rias j?? gozados no per??odo pedido", TipoDados.INT, "[0-9]+");
        f1Exe.addAtributo("Dias Totais : ", "F??rias", "Dias de F??rias totais no ano", TipoDados.INT, "[0-9]+");
        f1Exe.addAtributo("Faltas Justificadas : ", "Faltas", "Dias de faltas justificadas totais", TipoDados.INT, "[0-9]+");
        f1Exe.addAtributo("Faltas N??o Justificadas :", "Faltas", "Dias de faltas n??o justificadas totais", TipoDados.INT, "[0-9]+");
        f1Exe.addAtributo("Conclus??o : ", "Conclus??o da resolu????o de uma tarefa", "Conclus??o (Concluido/Inacabado)", TipoDados.CONCLUSAO, "(Concluido|Inacabado)");
        f1Exe.addAtributo("Fundamenta????o :", "Coment??rio decis??o", "Fundamente a sua decis??o", TipoDados.STRING, "[a-zA-Z]+");
        f1Exe.addScript("ATRIBUTO 5 NAOVAZIO");
        atividadeRealizacao1.adicionaFormulario(formRep.save(f1Exe));
        atividadeRealizacao1 = atividadeRealRepo.save(atividadeRealizacao1);

        /**
         guarda Fluxo de Atividade
         */
        FluxoAtividade fluxoAtividade1 = fluxoAtividadeRepositorio.save(new FluxoAtividade(atividadeAprovacao1, atividadeRealizacao1));
        Servico servico1 = especificarServicoController.especificarServico(new Servico(new ServicoIdentificador("123IDAusencia"), new Titulo("Pedido de Aus??ncia Futura"), new DescricaoBreve("Pedido de aus??ncia para F??rias, ou por um motivo justificado ou n??o justificado"),
                new DescricaoCompleta("Requisitar uma aus??ncia , elaborando a sua raz??o"), new byte[3], keywordsRRH, EstadoServico.COMPLETO, fluxoAtividade1, catalogoRRH, true, nc4));

        /**
         * Criar e guardar formul??rio para pedido de Servico
         */

        Formulario f1pedido = new Formulario(new NomeFormulario("Aus??ncia"));
        f1pedido.addAtributo("Data de Inicio de Aus??ncia", "Data", "Data de inicio da aus??ncia ", TipoDados.DATA, "^\\d{4}-\\d{2}-\\d{2}$");
        f1pedido.addAtributo("Data de Fim de Aus??ncia", "Data", "Data de inicio da aus??ncia ", TipoDados.DATA, "^\\d{4}-\\d{2}-\\d{2}$");
        f1pedido.addAtributo("Tipo de Aus??ncia", "Tipo de Aus??ncia", "Que tipo de aus??ncia deseja reportar", TipoDados.STRING, "Justificada|NaoJustificada|Ferias");
        f1pedido.addAtributo("Coment??rio", "Coment??rio de Aus??ncia", "Se aus??ncia for justificada, ?? obrigado a inserir um coment??rio", TipoDados.STRING, "[a-zA-Z]+");
            f1pedido.addScript("ATRIBUTO 0 MENORIGUAL ATRIBUTO 1 ");
        f1pedido = formRep.save(f1pedido);
        servico1.adicionaFormulario(f1pedido);
        especificarServicoController.especificarServico(servico1);


        /**
         * Servi??o 2
         Objetivo: Autoriza????o para Aplicac??a??o de Desconto

         Disponibilidade: Colaboradores do departamento de vendas

         Formul??rio Pedido:

         Dados: C??digo Interno Cliente, Nome, Tipo de Desconto, Recorr??ncia, Percentagem de Desconto, Valor de Desconto, Identifica????o da Fatura, Data Limite, Fundamenta????o do pedido
         Valida????o 1: C??digo cliente obedece a uma express??o regular (3 consoantes + 3 d??gitos)
         Valida????o 2: C??digo cliente, nome, tipo de desconto, recorr??ncia e fundamenta????o s??o obrigat??rios
         Valida????o 3: Apenas um dos campos entre percentagem de desconto e valor de desconto tem obrigatoriamente que estar preenchido (valor superior a zero). O outro campo deve ficar a zero.
         Valida????o 4: A recorr??ncia apenas assume 2 valores poss??veis: ??nica ou At?? Data Limite. Em caso de ser ??nica ?? obrigat??rio identificar a fatura em causa. Caso contr??rio ?? obrigat??rio indicar a data limite de aplica????o do desconto.
         Formul??rio Aprova????o:

         Quem: pelo respons??vel pelo servi??o
         Dados: Para al??m da decis??o ?? necess??rio indicar: um texto fundamentando a decis??o e confirmar a percentagem ou valor de desconto atribu??do e a data limite (caso fa??a sentido)
         Valida????o 1: A fundamenta????o ?? obrigat??ria.
         Valida????o 2: Apenas um dos campos entre percentagem de desconto e valor de desconto tem obrigatoriamente que estar preenchido (valor superior a zero). O outro campo deve ficar a zero.
         Realiza????o (Autom??tica): Consiste no envio de um email ao colaborador que efetuou o pedido com um texto pr??-definido onde ?? inserida alguma da informa????o recolhida anteriormente pelo preenchimento dos formul??rios (e.g. a decis??o e o desconto a aplicar).
         */

        CriaServicoService criarServico2 = new CriaServicoService();

        /**
         * Cria Atividade de aprovaca????o de 1 servi??o
         */
        AtividadeAprovacao atividadeAprovacao2 = new AtividadeAprovacao();
        atividadeAprovacao2.adicionaColabAprov(ColaboradoresAprovacao.RESPONSAVEL_PELO_SERVICO);


        /**
         * Criar e guardar formul??rio de Atividade de Aprova????o
         */

        Formulario f2Aprov = new Formulario(new NomeFormulario("Aprova????o"));
        f2Aprov.addAtributo("Decis??o", "Decis??o da Atividade de Aprova????o",
                "Decis??o (deferido/indeferido) sobre a aprova????o", TipoDados.DECISAO, "(Deferido|Indeferido)");
        f2Aprov.addAtributo("Fundamenta????o", "Coment??rio decis??o", "Fundamente a sua decis??o, e confirmar a percentagem ou valor de desconto atribu??do e a data limite", TipoDados.STRING, "[a-zA-Z]+");
        atividadeAprovacao2.adicionaFormulario(formRep.save(f2Aprov));
        f2Aprov.addScript("ATRIBUTO 1 NAOVAZIO");
        atividadeAprovacao2 =ativAprovRepo.save(atividadeAprovacao2);


        /**
         *   Cria Atividade de realiza????o de um servi??o
         */
        AtividadeRealizacao atividadeRealizacao2 = new AtividadeRealizacao("ENVIAR EMAIL COLABORADOR REQUERENTE teste");
        atividadeRealizacao2 = atividadeRealRepo.save(atividadeRealizacao2);

        /**
         guarda Fluxo de Atividade
         */
        FluxoAtividade fluxoAtividade2 = fluxoAtividadeRepositorio.save(new FluxoAtividade(atividadeAprovacao2, atividadeRealizacao2));
        Servico servico2 = especificarServicoController.especificarServico(new Servico(new ServicoIdentificador("123IDAVenda"), new Titulo("Aplicac??a??o de Desconto"), new DescricaoBreve("Autoriza????o para Aplicac??a??o de Desconto"),
                new DescricaoCompleta("Autoriza????o para Aplicac??a??o de Desconto, e especifica????o do mesmo."), new byte[3], keywordsVendas, EstadoServico.COMPLETO, fluxoAtividade2, catalogoVendas, false, nc3));


        /**
         * Criar e guardar formul??rio para pedido de Servico
         */
        Formulario f2pedido = new Formulario(new NomeFormulario("Autoriza????o para Aplicac??a??o de Desconto "));
        f2pedido.addAtributo(" C??digo Interno Cliente", "C??digo", "C??digo representativo do cliente no sistema", TipoDados.INT, "^[0-9]+");
        f2pedido.addAtributo("Nome", "Nome", "Nome do cliente ", TipoDados.STRING, "[a-zA-Z]+");
        f2pedido.addAtributo("Tipo de Desconto", "Desconto", "Tipo de Desconto a aplicar", TipoDados.STRING, "[a-zA-Z]+");
        f2pedido.addAtributo("Recorr??ncia", "Recorr??ncia", "Recorr??ncia do desconto aplicado", TipoDados.STRING, "[a-zA-Z]+"); // data se unica, ou ATE data limite se por periodo
        f2pedido.addAtributo("Percentagem Desconto", "PDesconto", "Percentagem de Desconto a aplicar", TipoDados.FRACIONAL, "^([0-9]{1,2}){1}(\\.[0-9]{1,2})?$"); // data se unica, ou ATE data limite se por periodo
        f2pedido.addAtributo("Valor Desconto", "VDesconto", "Valor de Desconto a aplicar", TipoDados.FRACIONAL, "^([0-9]{1,2}){1}(\\.[0-9]{1,2})?$ "); // data se unica, ou ATE data limite se por periodo
        f2pedido.addAtributo("Identifica????o Fatura", "FaturaID", "Identificador un??voco da fatura em quest??o", TipoDados.STRING, "^[a-zA-Z0-9_]*$"); // data se unica, ou ATE data limite se por periodo
        f2pedido.addAtributo("Data Limite", "Data", "Data Limite Desconto", TipoDados.DATA, "^\\d{4}-\\d{2}-\\d{2}$"); // data se unica, ou ATE data limite se por periodo
        f2pedido.addAtributo("Fundamenta????o Pedido", "Fundamenta????o", "Fundamenta????o do pedido de desconto a aplicar", TipoDados.STRING, "^[a-zA-Z0-9_]*$"); // data se unica, ou ATE data limite se por periodo
        f2pedido.addScript("ATRIBUTO 4 VAZIO ATRIBUTO 5 NAOVAZIO");
        f2pedido = formRep.save(f2pedido);
        servico2.adicionaFormulario(f2pedido);
        especificarServicoController.especificarServico(servico2);
        /**
         * Servi??o 3
         Objetivo: Comunica????o de Altera????o de Resid??ncia

         Disponibilidade: Colaboradores do departamento de vendas

         Formul??rio Pedido:

         Dados: Os correspondentes ?? estrutura de uma morada postal em Portugal
         Valida????o: Garantir que a informa????o introduzida ?? v??lida (e.g. C??digo postal com 4+3 digitos).
         (Sem Aprova????o)

         Formul??rio Realiza????o:

         Quem: um colaborador da equipa da sec????o de Recursos Humanos
         Dados: Apenas um texto de observa????es.
         Valida????o: O texto de observa????es ?? obrigat??rio.
         *
         */
        CriaServicoService criarServico3 = new CriaServicoService();


        /**
         *   Cria Atividade de realiza????o de 1 servi??o
         */
        AtividadeRealizacao atividadeRealizacao3 = new AtividadeRealizacao();
        atividadeRealizacao3.adicionarEquipaExecucao(equipa_RRH);
        /**
         *         Criar  formul??rio para atividade de realizacao
         */
        Formulario f3exe = new Formulario(new NomeFormulario("Altera????o de Resid??ncia"));
        f3exe.addAtributo(" Coment??rio", "Morada", "Coment??rio sobre pedido de mudan??a", TipoDados.STRING, "^[A-Z a-z 0-9]+ *$");
        f3exe.addScript("ATRIBUTO 0 NAOVAZIO");

        atividadeRealizacao3.adicionaFormulario(formRep.save(f3exe));
        atividadeRealizacao3 = atividadeRealRepo.save(atividadeRealizacao3);

        /**
         Cria Fluxo de Atividade
         */
        FluxoAtividade fluxoAtividade3 = fluxoAtividadeRepositorio.save(new FluxoAtividade(atividadeRealizacao3));
        Servico servico3 = especificarServicoController.especificarServico(new Servico(new ServicoIdentificador("124IDAVenda"), new Titulo("Altera????o de Resid??ncia"), new DescricaoBreve("Altera????o de Resid??ncia"),
                new DescricaoCompleta("Requisitar a altera????o de resid??ncia , fornecendo uma morada e um c??digo postal."), new byte[3], keywordsVendas, EstadoServico.COMPLETO, fluxoAtividade3, catalogoVendas, false, nc4));

        /**
         * Criar  formul??rio para pedido de Servico
         */

        Formulario f3pedido = new Formulario(new NomeFormulario("Pedido Altera????o de Resid??ncia  "));
        f3pedido.addAtributo(" Morada Postal : ", "Morada", "Morada seguida de c??digo postal", TipoDados.STRING, "^[A-Z a-z 0-9]+ ' ' [0-9]{4}-[0-9]{3}*$");
        f3pedido.addScript("ATRIBUTO 0 @[0-9]{4}-[0-9]{3}*$@");
        f3pedido = formRep.save(f3pedido);
        servico3.adicionaFormulario(f3pedido);
        especificarServicoController.especificarServico(servico3);

        /**
         * Servi??o 4
         Objetivo: Requerer cotac??a??o para venda por grosso

         Disponibilidade: Colaboradores do departamento de vendas

         Formul??rio Pedido:

         Dados: C??digo do Produto, Quantidade pretendida, Tipo de Cliente
         Valida????o 1: Tipo de cliente aceita apenas 3 valores: Nacional, Europeu, Resto do Mundo
         Valida????o 2: Todos os dados s??o obrigat??rios
         Valida????o 3: A quantidade s?? pode ter parte decimal significativa (diferente de zero) caso o c??digo do produto comece por "20" ou "21".
         (Sem Aprova????o)
         Quem: um colaborador da equipa da sec????o de Recursos Humanos
         Dados: Apenas um texto de observa????es.
         Valida????o: O texto de observa????es ?? obrigat??rio.
         *Realiza????o (Autom??tica): Consiste em: (1) consultar um ficheiro XML de produtos e com base no c??digo do produto obter o pre??o de venda unit??rio
         *  e a categoria do produto; (2) calcular o valor total (pre??o unit??rio X quantidade); (3) com base no valor total calculado determinar a percentagem
         *  base de desconto a aplicar (e.g. se valor > Z o desconto ?? 3% caso contr??rio ?? 1%); (4) para produtos com a categoria "ABC" atualizar a percentagem
         *  base de desconto em mais 0.5%; (5) calcular o valor de desconto e o valor total ap??s descontos; (5) enviar um email ao colaborador que efetuou o pedido
         *  cujo texto pr??-definido varia consoante o tipo de cliente e onde se apresentam alguns dos valores calculados.
         */

        CriaServicoService criarServico4 = new CriaServicoService();


        /**
         *   Cria Atividade de realiza????o de um servi??o
         */

        AtividadeRealizacao atividadeRealizacao4 = new AtividadeRealizacao("ATRIBUTO 0 ATRIBUTO 1 SE ATRIBUTO 2 MENOR 5 ENTAO 8 SE Software ENTAO 9 ENVIAR EMAIL COLABORADOR REQUERENTE OLA");
        atividadeRealizacao4 = atividadeRealRepo.save(atividadeRealizacao4);

        /**
         Cria Fluxo de Atividade
         */
        FluxoAtividade fluxoAtividade4 = fluxoAtividadeRepositorio.save(new FluxoAtividade(atividadeRealizacao4));
        Servico servico4 = especificarServicoController.especificarServico(new Servico(new ServicoIdentificador("125IDAVenda"), new Titulo("Cotac??a??o para venda por grosso"), new DescricaoBreve("Venda por grosso"),
                new DescricaoCompleta("Definir especifica????es de poss??veis vendas a grosso a clientes."), new byte[3], keywordsVendas, EstadoServico.COMPLETO, fluxoAtividade4, catalogoVendas, false, nc3));

        /**
         * Criar  formul??rio para pedido de Servico
          */
        Formulario f4pedido = new Formulario(new NomeFormulario("Requerer cotac??a??o para venda por grosso"));
        f4pedido.addAtributo(" Nome Ficheiro : ", "Ficheiro", "Ficheiro que pretendo consultar", TipoDados.FICHEIROXML, "^[A-Z a-z 0-9]+");
        f4pedido.addAtributo(" C??digo Produto : ", "Codigo", "C??digo do Produto", TipoDados.STRING, "^[A-Z a-z 0-9]+");
        f4pedido.addAtributo(" Quantidade Pretendida : ", "Quantidade pretendida", "Quantidade de unidades para venda em grosso", TipoDados.INT, "^([0-9]{1,3}){1}");
        f4pedido.addAtributo("Tipo de Cliente :", "Tipo de Cliente", "Tipo de Cliente(Nacional, Europeu, Resto do Mundo) ", TipoDados.STRING, "(Nacional|Europeu|Resto do Mundo)");
        f4pedido.addScript("ATRIBUTO 3 @(Nacional|Europeu|Resto do Mundo)@");

        f4pedido = formRep.save(f4pedido);
        servico4.adicionaFormulario(f4pedido);
        especificarServicoController.especificarServico(servico4);


        /**
         * Servi??o tem atividade de aprova????o, neste caso, ?? aprovado pelo responsavel hierarquico do colaborador requerente
         *
         * ?? assignado a uma equipa, logo ?? de resolu????o manual
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

        Servico servico = especificarServicoController.especificarServico(new Servico(new ServicoIdentificador("123IDAvaria"), new Titulo("Reportar anomalia de Comunica????o"), new DescricaoBreve("Anomalia em comunica????o da rede da empresa"),
                new DescricaoCompleta("Reportar anomalias/avarias em servi??os de comunica????o da empresa"), new byte[2], new HashSet<>(), EstadoServico.INCOMPLETO, fluxoAtividade, catalogoAvariaTecnicas, false, nc2));


        Formulario f = new Formulario(new NomeFormulario("Avaria"));
        f.addAtributo("Equipamento que avariou: ","C??digo do equipamento","C??digo na lateral do equipamento", TipoDados.INT,"[0-9]+");
        f.addAtributo("Edif??cio do equipamento: ","Nome do edificio do equipamento","Nome afixado na entrada do edificio",TipoDados.STRING,"[a-zA-Z]+");
        f.addAtributo("Coment??rio: ","Avaria concreta do equipamento","Avalia????o emp??rica da avaria",TipoDados.STRING,"[a-zA-Z]+");
        Formulario fSav = formRep.save(f);

        servico.adicionaFormulario(fSav);
        especificarServicoController.especificarServico(servico);

        System.out.println("\n\n#############################################  BOOTSTRAP GRUPO 4 2DL FEITO  #############################################");

        return "";
    }
}
