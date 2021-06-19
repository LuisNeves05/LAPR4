package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.atividadeAprovacao.persistence.AtividadeAprovacaoRepositorio;
import eapli.base.atividadeAprovacao.persistence.AtividadeAprovacaoRepositorioJPAimpl;
import eapli.base.atividadeRealizacao.persistence.AtividadeRealizacaoRepositorio;
import eapli.base.atividadeRealizacao.persistence.AtividadeRealizacaoRepositorioJPAimpl;
import eapli.base.catalogo.persistencia.CatalogoRepositorio;
import eapli.base.catalogo.persistencia.CatalogoRepositorioJPAimpl;
import eapli.base.clientusermanagement.repositories.SignupRequestRepository;
import eapli.base.colaborador.persistencia.ColaboradorRepositorio;
import eapli.base.colaborador.persistencia.ColaboradorRepositorioJPAImpl;
import eapli.base.criticidade.persistencia.NivelCriticidadeRepositorio;
import eapli.base.criticidade.persistencia.NivelCriticidadeRepositorioJPAimpl;
import eapli.base.equipa.persistencia.EquipaRepositorio;
import eapli.base.equipa.persistencia.EquipaRepositorioJPAimpl;
import eapli.base.fluxoAtividade.persistence.FluxoAtividadeRepositorio;
import eapli.base.fluxoAtividade.persistence.FluxoAtividadeRepositorioJPAimpl;
import eapli.base.formulario.persistencia.FormularioRepositorio;
import eapli.base.formulario.persistencia.FormularioRepositorioJPAimpl;
import eapli.base.formularioPreenchido.persistencia.FormularioPreenchidoRepositorio;
import eapli.base.formularioPreenchido.persistencia.FormularioPreenchidoRepositorioJPAimpl;
import eapli.base.infrastructure.persistence.RepositoryFactory;
import eapli.base.servico.persistencia.ServicoRepositorio;

import eapli.base.servico.persistencia.ServicoRepositorioJPAimpl;
import eapli.base.tarefaAutomatica.persistance.TarefaAutomaticaRepositorio;
import eapli.base.tarefaAutomatica.persistance.TarefaAutomaticaRepositorioJPAimpl;
import eapli.base.tarefaManualAprovacao.persistance.TarefaManualAprovacaoRepositorio;
import eapli.base.tarefaManualAprovacao.persistance.TarefaManualAprovacaoRepositorioJPAimpl;
import eapli.base.tarefaManualExecucao.persistance.TarefaManualExecucaoRepositorio;
import eapli.base.tarefaManualExecucao.persistance.TarefaManualExecucaoRepositorioJPAimpl;
import eapli.base.ticket.persistence.TicketRepositorio;
import eapli.base.ticket.persistence.TicketRepositorioJPAimpl;
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
	public ServicoRepositorio servicoRepositorio(final TransactionalContext autoTx) {
		return new ServicoRepositorioJPAimpl(autoTx);
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
	public FormularioRepositorio formularioRepositorio(final TransactionalContext autoTx){
		return new FormularioRepositorioJPAimpl(autoTx);
	}

	@Override
	public TipoEquipaRepositorio tipoEquipaRepositorio(){
		return new TipoEquipaRepositorioJPAimpl(Application.settings().getPersistenceUnitName());
	}

	@Override
	public EquipaRepositorio equipaRepositorio() {
		return new EquipaRepositorioJPAimpl(Application.settings().getPersistenceUnitName());
	}

	@Override
	public NivelCriticidadeRepositorio nivelCriticidadeRepositorio() {
		return new NivelCriticidadeRepositorioJPAimpl(Application.settings().getPersistenceUnitName());
	}

	@Override
	public ColaboradorRepositorio colaboradorRepositorio(){
		return new ColaboradorRepositorioJPAImpl(Application.settings().getPersistenceUnitName());
	}

	@Override
	public FormularioPreenchidoRepositorio formularioPreenchidoRepositorio(){
		return new FormularioPreenchidoRepositorioJPAimpl(Application.settings().getPersistenceUnitName());
	}

	@Override
	public FormularioPreenchidoRepositorio formularioPreenchidoRepositorio(final TransactionalContext autoTx){
		return new FormularioPreenchidoRepositorioJPAimpl(autoTx);
	}

	@Override
	public TicketRepositorio ticketRepositorio(){
		return new TicketRepositorioJPAimpl(Application.settings().getPersistenceUnitName());
	}

	@Override
	public TicketRepositorio ticketRepositorio(final TransactionalContext autoTx){
		return new TicketRepositorioJPAimpl(autoTx);
	}

	@Override
	public TarefaManualExecucaoRepositorio tarefaManualExecucaoRepositorio(){
		return new TarefaManualExecucaoRepositorioJPAimpl(Application.settings().getPersistenceUnitName());
	}

	@Override
	public TarefaManualExecucaoRepositorio tarefaManualExecucaoRepositorio(final TransactionalContext autoTx){
		return new TarefaManualExecucaoRepositorioJPAimpl(autoTx);
	}

	@Override
	public TarefaManualAprovacaoRepositorio tarefaManualAprovacaoRepositorio(){
		return new TarefaManualAprovacaoRepositorioJPAimpl(Application.settings().getPersistenceUnitName());
	}

	@Override
	public TarefaManualAprovacaoRepositorio tarefaManualAprovacaoRepositorio(final TransactionalContext autoTx){
		return new TarefaManualAprovacaoRepositorioJPAimpl(autoTx);
	}

	@Override
	public TarefaAutomaticaRepositorio tarefaAutomaticaRepositorio(){
		return new TarefaAutomaticaRepositorioJPAimpl(Application.settings().getPersistenceUnitName());
	}

	@Override
	public TarefaAutomaticaRepositorio tarefaAutomaticaRepositorio(final TransactionalContext autoTx){
		return new TarefaAutomaticaRepositorioJPAimpl(autoTx);
	}


	@Override
	public FluxoAtividadeRepositorio fluxoAtividadeRepositorio(){
		return new FluxoAtividadeRepositorioJPAimpl(Application.settings().getPersistenceUnitName());
	}

	@Override
	public FluxoAtividadeRepositorio fluxoAtividadeRepositorio(final TransactionalContext autoTx){
		return new FluxoAtividadeRepositorioJPAimpl(autoTx);
	}

	@Override
	public AtividadeRealizacaoRepositorio atividadeRealizacaoRepositorio(){
		return new AtividadeRealizacaoRepositorioJPAimpl(Application.settings().getPersistenceUnitName());
	}

	@Override
	public AtividadeRealizacaoRepositorio atividadeRealizacaoRepositorio(final TransactionalContext autoTx){
		return new AtividadeRealizacaoRepositorioJPAimpl(autoTx);
	}

	@Override
	public AtividadeAprovacaoRepositorio atividadeAprovacaoRepositorio(){
		return new AtividadeAprovacaoRepositorioJPAimpl(Application.settings().getPersistenceUnitName());
	}

	@Override
	public AtividadeAprovacaoRepositorio atividadeAprovacaoRepositorio(final TransactionalContext autoTx){
		return new AtividadeAprovacaoRepositorioJPAimpl(autoTx);
	}

	@Override
	public TransactionalContext newTransactionalContext() {
		return JpaAutoTxRepository.buildTransactionalContext(Application.settings().getPersistenceUnitName(),
				Application.settings().getExtendedPersistenceProperties());
	}
}
