package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.catalogo.persistencia.CatalogoRepositorio;
import eapli.base.catalogo.persistencia.CatalogoRepositorioJPAimpl;
import eapli.base.clientusermanagement.repositories.SignupRequestRepository;
import eapli.base.formulario.persistence.FormularioRepositorio;
import eapli.base.formulario.persistence.FormularioRepositorioJPAimpl;
import eapli.base.infrastructure.persistence.RepositoryFactory;
import eapli.base.servico.persistencia.ServicoRepositorio;

import eapli.base.servico.persistencia.ServicoRepositorioJPAimpl;
import eapli.base.tipoEquipa.persistencia.TipoEquipaRepositorio;
import eapli.base.tipoEquipa.persistencia.TipoEquipaRepositorioJPAimpl;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.domain.repositories.UserRepository;
import eapli.framework.infrastructure.authz.repositories.impl.JpaAutoTxUserRepository;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

/**
 *
 * Created by nuno on 21/03/16.
 */
public class JpaRepositoryFactory implements RepositoryFactory {

	@Override
	public UserRepository users(final TransactionalContext autoTx) {
		return new JpaAutoTxUserRepository(autoTx);
	}

	@Override
	public UserRepository users() {
		return new JpaAutoTxUserRepository(Application.settings().getPersistenceUnitName(),
				Application.settings().getExtendedPersistenceProperties());
	}

	@Override
	public JpaClientUserRepository clientUsers(final TransactionalContext autoTx) {
		return new JpaClientUserRepository(autoTx);
	}

	@Override
	public JpaClientUserRepository clientUsers() {
		return new JpaClientUserRepository(Application.settings().getPersistenceUnitName());
	}

	@Override
	public SignupRequestRepository signupRequests(final TransactionalContext autoTx) {
		return new JpaSignupRequestRepository(autoTx);
	}

	@Override
	public SignupRequestRepository signupRequests() {
		return new JpaSignupRequestRepository(Application.settings().getPersistenceUnitName());
	}

	@Override
	public ServicoRepositorio servicoRepositorio() {
		return new ServicoRepositorioJPAimpl(Application.settings().getPersistenceUnitName());
	}

	@Override
	public CatalogoRepositorio catalogoRepositorio() {
		return new CatalogoRepositorioJPAimpl(Application.settings().getPersistenceUnitName());
	}

	@Override
	public FormularioRepositorio formularioRepositorio(){
		return new FormularioRepositorioJPAimpl(Application.settings().getPersistenceUnitName());
	}

	@Override
	public TipoEquipaRepositorio tipoEquipaRepositorio(){
		return new TipoEquipaRepositorioJPAimpl(Application.settings().getPersistenceUnitName());
	}

	@Override
	public TransactionalContext newTransactionalContext() {
		return JpaAutoTxRepository.buildTransactionalContext(Application.settings().getPersistenceUnitName(),
				Application.settings().getExtendedPersistenceProperties());
	}
}
