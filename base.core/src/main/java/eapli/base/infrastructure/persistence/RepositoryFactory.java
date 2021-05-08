package eapli.base.infrastructure.persistence;

import eapli.base.catalogo.persistencia.CatalogoRepositorio;
import eapli.base.clientusermanagement.repositories.ClientUserRepository;
import eapli.base.clientusermanagement.repositories.SignupRequestRepository;
import eapli.base.equipa.persistencia.EquipaRepositorio;
import eapli.base.formulario.persistence.FormularioRepositorio;
import eapli.base.servico.persistencia.ServicoRepositorio;
import eapli.base.tipoEquipa.persistencia.TipoEquipaRepositorio;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.domain.repositories.UserRepository;

/**
 * @author Paulo Gandra Sousa
 *
 */
public interface RepositoryFactory {

	/**catalogoRepositorio
	 * factory method to create a transactional context to use in the repositories
	 *
	 * @return
	 */
	TransactionalContext newTransactionalContext();

	/**
	 *
	 * @param autoTx the transactional context to enrol
	 * @return
	 */
	UserRepository users(TransactionalContext autoTx);

	/**
	 * repository will be created in auto transaction mode
	 *
	 * @return
	 */
	UserRepository users();

	/**
	 *
	 * @param autoTx the transactional context to enroll
	 * @return
	 */
	ClientUserRepository clientUsers(TransactionalContext autoTx);

	/**
	 * repository will be created in auto transaction mode
	 *
	 * @return
	 */
	ClientUserRepository clientUsers();

	/**
	 *
	 * @param autoTx the transactional context to enroll
	 * @return
	 */
	SignupRequestRepository signupRequests(TransactionalContext autoTx);

	/**
	 * repository will be created in auto transaction mode
	 *
	 * @return
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
	 * @return
	 */
	FormularioRepositorio formularioRepositorio();

	/**
	 * Repositorio vai ser criado em modo auto transacional
	 * @return
	 */
	TipoEquipaRepositorio tipoEquipaRepositorio();

	EquipaRepositorio equipaRepositorio();

}
