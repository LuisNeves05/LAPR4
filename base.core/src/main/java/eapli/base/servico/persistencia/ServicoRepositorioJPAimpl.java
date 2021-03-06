package eapli.base.servico.persistencia;

import eapli.base.Application;
import eapli.base.catalogo.domain.Catalogo;
import eapli.base.servico.domain.*;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.Query;
import java.util.List;


public class ServicoRepositorioJPAimpl extends JpaAutoTxRepository<Servico, Long, ServicoIdentificador>
        implements ServicoRepositorio {

    public ServicoRepositorioJPAimpl(final TransactionalContext autoTx) {
        super(autoTx,"eapli.base");
    }

    public ServicoRepositorioJPAimpl(String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "eapli.base");
    }

    @Override
    public Iterable<Servico> servicoPorIdentificador(final String ident){
        Query query = super.createQuery("SELECT s from Servico s where s.servicoIdent = :ident", Servico.class);
        query.setParameter("ident", new ServicoIdentificador(ident));
        return query.getResultList();
    }

    @Override
    public List<Servico> servicoPorTitulo(final String titulo, final Catalogo catalogo) {
        Query query = super.createQuery("SELECT s from Servico s where s.titulo = :titulo and :catalogo = s.catalogo", Servico.class);
        query.setParameter("titulo", new Titulo(titulo));
        query.setParameter("catalogo", catalogo);
        return query.getResultList();
    }

    @Override
    public List<Servico> servicoPorDescBreve(final String descBreve, final Catalogo catalogo) {
        Query query = super.createQuery("SELECT s from Servico s where s.descBreve = :descBreve and :catalogo = s.catalogo", Servico.class);
        query.setParameter("descBreve", new DescricaoBreve(descBreve));
        query.setParameter("catalogo", catalogo);
        return query.getResultList();
    }

    @Override
    public List<Servico> servicoPorKeyword(final String keyword, final Catalogo catalogo) {
        Query query = super.createQuery("SELECT s from Servico s where :keyword member of s.keywords and :catalogo = s.catalogo", Servico.class);
        query.setParameter("keyword", new Keyword(keyword));
        query.setParameter("catalogo", catalogo);
        return query.getResultList();
    }

    @Override
    public List<Servico> servicoPorCatalogo(final Catalogo catalogo) {
        Query query = super.createQuery("SELECT s from Servico s where :catalogo = s.catalogo and s.estado = :completo", Servico.class);
        query.setParameter("catalogo", catalogo);
        query.setParameter("completo", EstadoServico.COMPLETO);
        return query.getResultList();
    }

    @Override
    public List<Servico> findByEstado(final String estado) {
        Query query = super.createQuery("SELECT s FROM Servico s where estado = ' " + estado + "' ", Servico.class);
        return query.getResultList();
    }

    public List<Servico> servicosIncompletos(){
        Query query = super.createQuery("SELECT s from Servico s where s.estado = 'INCOMPLETO'", Servico.class);
        return query.getResultList();
    }
}
