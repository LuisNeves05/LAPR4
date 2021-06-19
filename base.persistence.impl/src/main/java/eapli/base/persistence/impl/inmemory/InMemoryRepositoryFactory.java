package eapli.base.persistence.impl.inmemory;

import eapli.base.atividadeAprovacao.persistence.AtividadeAprovacaoRepositorio;
import eapli.base.atividadeRealizacao.persistence.AtividadeRealizacaoRepositorio;
import eapli.base.catalogo.persistencia.CatalogoRepositorio;
import eapli.base.clientusermanagement.repositories.ClientUserRepository;
import eapli.base.clientusermanagement.repositories.SignupRequestRepository;
import eapli.base.colaborador.persistencia.ColaboradorRepositorio;
import eapli.base.criticidade.persistencia.NivelCriticidadeRepositorio;
import eapli.base.equipa.persistencia.EquipaRepositorio;
import eapli.base.fluxoAtividade.persistence.FluxoAtividadeRepositorio;
import eapli.base.formulario.persistencia.FormularioRepositorio;
import eapli.base.formularioPreenchido.persistencia.FormularioPreenchidoRepositorio;
import eapli.base.infrastructure.bootstrapers.BaseBootstrapper;
import eapli.base.infrastructure.persistence.RepositoryFactory;
import eapli.base.servico.persistencia.ServicoRepositorio;
import eapli.base.tarefaAutomatica.persistance.TarefaAutomaticaRepositorio;
import eapli.base.tarefaManualAprovacao.persistance.TarefaManualAprovacaoRepositorio;
import eapli.base.tarefaManualExecucao.persistance.TarefaManualExecucaoRepositorio;
import eapli.base.ticket.persistence.TicketRepositorio;
import eapli.base.tipoEquipa.persistencia.TipoEquipaRepositorio;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.domain.repositories.UserRepository;
import eapli.framework.infrastructure.authz.repositories.impl.InMemoryUserRepository;

/**
 *
 * Created by nuno on 20/03/16.
 */
public class InMemoryRepositoryFactory implements RepositoryFactory {

	static {
		new BaseBootstrapper().execute();
	}

	@Override
	public UserRepository users(final TransactionalContext tx) {
		return new InMemoryUserRepository();
	}

	@Override
	public UserRepository users() {
		return users(null);
	}

	@Override
	public ClientUserRepository clientUsers(final TransactionalContext tx) {
		return new InMemoryClientUserRepository();
	}

	@Override
	public ClientUserRepository clientUsers() {
		return clientUsers(null);
	}

	@Override
	public SignupRequestRepository signupRequests() {
		return signupRequests(null);
	}

	@Override
	public ServicoRepositorio servicoRepositorio() {
		return null;
	}

	@Override
	public ServicoRepositorio servicoRepositorio(TransactionalContext autoTx) {
		return null;
	}

	@Override
	public CatalogoRepositorio catalogoRepositorio() {
		return null;
	}

	@Override
	public FormularioRepositorio formularioRepositorio() {
		return null;
	}

	@Override
	public FormularioRepositorio formularioRepositorio(TransactionalContext autoTx) {
		return null;
	}

	@Override
	public TipoEquipaRepositorio tipoEquipaRepositorio(){
		return null;
	}

	@Override
	public EquipaRepositorio equipaRepositorio() {return null;}

	@Override
	public NivelCriticidadeRepositorio nivelCriticidadeRepositorio() {
		return null;
	}

	@Override
	public ColaboradorRepositorio colaboradorRepositorio() {
		return null;
	}

	@Override
	public FormularioPreenchidoRepositorio formularioPreenchidoRepositorio() {
		return null;
	}

	@Override
	public FormularioPreenchidoRepositorio formularioPreenchidoRepositorio(TransactionalContext autoTx) {
		return null;
	}

	@Override
	public TicketRepositorio ticketRepositorio() {
		return null;
	}

	@Override
	public TicketRepositorio ticketRepositorio(TransactionalContext autoTx) {
		return null;
	}

	@Override
	public TarefaManualExecucaoRepositorio tarefaManualExecucaoRepositorio() {
		return null;
	}

	@Override
	public TarefaManualExecucaoRepositorio tarefaManualExecucaoRepositorio(TransactionalContext autoTx) {
		return null;
	}

	@Override
	public TarefaManualAprovacaoRepositorio tarefaManualAprovacaoRepositorio() {
		return null;
	}

	@Override
	public TarefaManualAprovacaoRepositorio tarefaManualAprovacaoRepositorio(TransactionalContext autoTx) {
		return null;
	}

	@Override
	public TarefaAutomaticaRepositorio tarefaAutomaticaRepositorio() {
		return null;
	}

	@Override
	public TarefaAutomaticaRepositorio tarefaAutomaticaRepositorio(TransactionalContext autoTx) {
		return null;
	}


	@Override
	public FluxoAtividadeRepositorio fluxoAtividadeRepositorio() {
		return null;
	}

	@Override
	public FluxoAtividadeRepositorio fluxoAtividadeRepositorio(TransactionalContext txCtx) {
		return null;
	}

	@Override
	public AtividadeRealizacaoRepositorio atividadeRealizacaoRepositorio() {
		return null;
	}

	@Override
	public AtividadeRealizacaoRepositorio atividadeRealizacaoRepositorio(TransactionalContext autoTx) {
		return null;
	}

	@Override
	public AtividadeAprovacaoRepositorio atividadeAprovacaoRepositorio() {
		return null;
	}

	@Override
	public AtividadeAprovacaoRepositorio atividadeAprovacaoRepositorio(TransactionalContext autoTx) {
		return null;
	}


	@Override
	public SignupRequestRepository signupRequests(final TransactionalContext tx) {
		return new InMemorySignupRequestRepository();
	}


	@Override
	public TransactionalContext newTransactionalContext() {
		// in memory does not support transactions...
		return null;
	}

}
