package eapli.base.infrastructure.persistence;

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
import eapli.base.servico.persistencia.ServicoRepositorio;
import eapli.base.tarefa.persistance.TarefaExecucaoRepositorio;
import eapli.base.ticket.persistence.TicketRepositorio;
import eapli.base.tipoEquipa.persistencia.TipoEquipaRepositorio;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.domain.repositories.UserRepository;

/**
 * @author Paulo Gandra Sousa
 *
 */
public interface RepositoryFactory {

	/**
	 * factory method to create a transactional context to use in the repositories
	 *
	 * @return TransactionalContext
	 */
	TransactionalContext newTransactionalContext();

	/**
	 *
	 * @param autoTx the transactional context to enrol
	 * @return UserRepository
	 */
	UserRepository users(TransactionalContext autoTx);

	/**
	 * repository will be created in auto transaction mode
	 *
	 * @return UserRepository
	 */
	UserRepository users();

	/**
	 *
	 * @param autoTx the transactional context to enroll
	 * @return ClientUserRepository
	 */
	ClientUserRepository clientUsers(TransactionalContext autoTx);

	/**
	 * repository will be created in auto transaction mode
	 *
	 * @return ClientUserRepository
	 */
	ClientUserRepository clientUsers();

	/**
	 *
	 * @param autoTx the transactional context to enroll
	 * @return SignupRequestRepository
	 */
	SignupRequestRepository signupRequests(TransactionalContext autoTx);

	/**
	 * repository will be created in auto transaction mode
	 *
	 * @return SignupRequestRepository
	 */
	SignupRequestRepository signupRequests();

	/**
	 * Repositorio vai ser criado em modo auto transacional
	 *
	 */
	ServicoRepositorio servicoRepositorio();

	/**
	 * Repositorio vai ser criado em modo auto transacional
	 *
	 */
	CatalogoRepositorio catalogoRepositorio();

	/**
	 * Repositorio vai ser criado em modo auto transacional
	 * @return FormularioRepositorio
	 */
	FormularioRepositorio formularioRepositorio();

	/**
	 * Repositorio vai ser criado em modo auto transacional
	 * @return TipoEquipaRepositorio
	 */
	TipoEquipaRepositorio tipoEquipaRepositorio();

	ColaboradorRepositorio colaboradorRepositorio();

	EquipaRepositorio equipaRepositorio();

	NivelCriticidadeRepositorio nivelCriticidadeRepositorio();

	FormularioPreenchidoRepositorio formularioPreenchidoRepositorio();

	TicketRepositorio ticketRepositorio();

	TarefaExecucaoRepositorio tarefaExecucaoRepositorio();

	FluxoAtividadeRepositorio fluxoAtividadeRepositorio();

	AtividadeRealizacaoRepositorio atividadeRealizacaoRepositorio();

	AtividadeAprovacaoRepositorio atividadeAprovacaoRepositorio();
}
