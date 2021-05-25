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
import eapli.base.tarefaAprovacao.persistance.TarefaAprovacaoRepositorio;
import eapli.base.tarefaExecucao.persistance.TarefaExecucaoRepositorio;
import eapli.base.ticket.persistence.TicketRepositorio;
import eapli.base.tipoEquipa.persistencia.TipoEquipaRepositorio;
import eapli.base.tipoTarefa.persistance.TipoTarefaRepositorio;
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
	public CatalogoRepositorio catalogoRepositorio() {
		return null;
	}

	@Override
	public FormularioRepositorio formularioRepositorio() {
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
	public TicketRepositorio ticketRepositorio() {
		return null;
	}

	@Override
	public TipoTarefaRepositorio tipoTarefaRepositorio() {
		return null;
	}

	@Override
	public TarefaExecucaoRepositorio tarefaExecucaoRepositorio() {
		return null;
	}

	@Override
	public TarefaAprovacaoRepositorio tarefaAprovacaoRepositorio() {
		return null;
	}

	@Override
	public FluxoAtividadeRepositorio fluxoAtividadeRepositorio() {
		return null;
	}

	@Override
	public AtividadeRealizacaoRepositorio atividadeRealizacaoRepositorio() {
		return null;
	}

	@Override
	public AtividadeAprovacaoRepositorio atividadeAprovacaoRepositorio() {
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
