package eapli.base.servico.application;

import eapli.base.atividadeAprovacao.service.CriarAtividadeAprovacaoService;
import eapli.base.atividadeAprovacao.domain.ColaboradoresAprovacao;
import eapli.base.atividadeRealizacao.domain.TipoExecucao;
import eapli.base.atividadeRealizacao.service.CriarAtividadeRealizacaoService;
import eapli.base.catalogo.domain.Catalogo;
import eapli.base.catalogo.persistencia.CatalogoRepositorio;
import eapli.base.colaborador.domain.Colaborador;
import eapli.base.colaborador.persistencia.ColaboradorRepositorio;
import eapli.base.criticidade.domain.NivelCriticidade;
import eapli.base.equipa.domain.Equipa;
import eapli.base.equipa.persistencia.EquipaRepositorio;
import eapli.base.fluxoAtividade.builder.FluxoAtividadeBuilder;
import eapli.base.formulario.domain.Formulario;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.servico.builder.ServiceBuilder;
import eapli.base.servico.domain.Servico;
import eapli.base.servico.persistencia.ServicoRepositorio;
import eapli.base.servico.service.CriaServicoService;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Classe Controller da Especificação de um Serviço
 */
public class EspecificarServicoController {

    /**
     * Repositório do Serviço
     */
    private final ServicoRepositorio repoServ = PersistenceContext.repositories().servicoRepositorio();
    private final CatalogoRepositorio repoCat = PersistenceContext.repositories().catalogoRepositorio();
    private final ColaboradorRepositorio colabRep = PersistenceContext.repositories().colaboradorRepositorio();
    private final EquipaRepositorio eqRep = PersistenceContext.repositories().equipaRepositorio();
    private final CriaServicoService criarServicoService = new CriaServicoService();
    private final CriarAtividadeAprovacaoService criarAtividadeAprovacaoService = new CriarAtividadeAprovacaoService();
    private final CriarAtividadeRealizacaoService criarAtividadeRealizacaoService = new CriarAtividadeRealizacaoService();


    public EspecificarServicoController(){}

    /**
     * Especificação de um novo Serviço
     */
    public Servico especificarServico(Servico servico) {
        return this.repoServ.save(servico);
    }

    /**
     * Listar todas os Catalogos da base de dados
     */
    public Iterable<Catalogo> listaCatalogos() {
        return repoCat.findAll();
    }

    public List<Servico> servicosIncompletos() {
        return repoServ.servicosIncompletos();
    }

    public List<Equipa> equipasExecDoCatalogo(Catalogo catalogo) {
        return (List<Equipa>) eqRep.equipasDoCatalogo(catalogo);
    }

    public List<Colaborador> colabsExecCatalogo(Catalogo catalogo) {
        List<Equipa> equipasCatalogo = (List<Equipa>) eqRep.equipasDoCatalogo(catalogo);
        Set<Colaborador> colabsExec = new HashSet<>();
        for(Equipa eq : equipasCatalogo){
            Iterable<Colaborador> colaboradores = colabRep.colabsDoCatalogo(eq);
            for(Colaborador c : colaboradores){
                colabsExec.add(c);
            }
        }
        return new ArrayList<>(colabsExec);
    }

    public void adicionarNivelCritServ(Servico s, NivelCriticidade nC){
        s.adicionarNivelCriticidade(nC);
        repoServ.save(s);
    }



    public Servico criarServico(ServiceBuilder serviceBuilder, List<Formulario> formularios, FluxoAtividadeBuilder fluxoAtividadeBuilder) {
        return criarServicoService.especificarServico(serviceBuilder,formularios,fluxoAtividadeBuilder);
    }

    public Iterable<Servico> servicoPeloIdentificador(String identificador) {
        return repoServ.servicoPorIdentificador(identificador);
    }

    public void fluxoComAtividadeAprovacao(FluxoAtividadeBuilder fluxoAtivBuilder, List<ColaboradoresAprovacao> colabsAprov, Formulario form) {
        criarAtividadeAprovacaoService.fluxoComAtividadeAprovacao(fluxoAtivBuilder, colabsAprov, form);
    }

    public void fluxoComAtividadeRealizacaoEquipas(FluxoAtividadeBuilder fluxoAtivBuilder, List<Equipa> equipasExec, Formulario form) {
        criarAtividadeRealizacaoService.fluxoComAtividadeRealizacaoEquipas(fluxoAtivBuilder, equipasExec, form);
    }

    public void fluxoComAtividadeRealizacaoColab(FluxoAtividadeBuilder fluxoAtivBuilder, Colaborador colab, TipoExecucao tipoExec, Formulario form){
        criarAtividadeRealizacaoService.fluxoComAtividadeRealizacaoColaborador(fluxoAtivBuilder, colab, tipoExec, form);
    }

    public void fluxoComAtividadeRealizacaoAutomatica(FluxoAtividadeBuilder fluxoAtivBuilder,String scriptAutomatico) {
        criarAtividadeRealizacaoService.fluxoComAtividadeRealizacaoAutomatica(fluxoAtivBuilder, scriptAutomatico);
    }
}
