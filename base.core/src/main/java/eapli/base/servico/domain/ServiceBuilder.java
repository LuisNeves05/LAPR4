package eapli.base.servico.domain;

import eapli.base.catalogo.domain.Catalogo;
import eapli.base.colaborador.domain.Colaborador;
import eapli.base.criticidade.domain.NivelCriticidade;
import eapli.base.fluxoAtividade.domain.FluxoAtividade;
import eapli.framework.domain.model.DomainFactory;

import java.util.HashSet;
import java.util.Set;

public class ServiceBuilder implements DomainFactory<Servico> {

    /**
     * Identificador único do Serviço
     */
    private String servicoIdentificador;
    /**
     * Titulo do Servico
     */
    private String titulo;
    /**
     * Descrição brece do serviço
     */
    private String descBreve;
    /**
     * Descrição completa do serviço
     */
    private String descComp;
    /**
     * Ícone do serviço
     */
    private byte[] icon;
    /**
     * Conjunto de palavras chave de um serviço
     */
    private Set<Keyword> keywords = new HashSet<>();
    /**
     * Estado de conclusão do serviço, podendo estar completo ou incompleto
     */

    private EstadoServico estado;
    /**
     * Nivel de criticidade associado ao serviço
     */
    private NivelCriticidade nivelCriticidade;
    private Catalogo catalogo;

    private boolean requerFeedback;

    private FluxoAtividade fluxoAtividade;

    public ServiceBuilder(){
    }

    public ServiceBuilder comIdentificador(final String identificador) {
        this.servicoIdentificador = identificador;
        return this;
    }

    public ServiceBuilder comRequerFeedback(final boolean requerFeedback) {
        this.requerFeedback = requerFeedback;
        return this;
    }

    public ServiceBuilder comTitulo(final String titulo) {
        this.titulo = titulo;
        return this;
    }

    public ServiceBuilder comDescBreve(final String descBreve) {
        this.descBreve = descBreve;
        return this;
    }

    public ServiceBuilder comDescComp(final String descComp) {
        this.descComp = descComp;
        return this;
    }

    public ServiceBuilder comIcon(final byte[] icon) {
        this.icon = icon;
        return this;
    }

    public ServiceBuilder comEstado(final EstadoServico estado) {
        this.estado = estado;
        return this;
    }

    public ServiceBuilder comCatalogo(final Catalogo catalogo){
        this.catalogo = catalogo;
        return this;
    }

    public ServiceBuilder comNivelCrit(final NivelCriticidade nivelCriticidade){
        this.nivelCriticidade = nivelCriticidade;
        return this;
    }

    public void adicionarKeyword(String key){
        Keyword keyword = new Keyword(key);
        keywords.add(keyword);
    }

    public ServiceBuilder comFluxo(FluxoAtividade fluxoAtividade){
        this.fluxoAtividade = fluxoAtividade;
        return this;
    }

    public boolean estaCompleto() {
        return this.servicoIdentificador != null && this.titulo != null && this.descBreve != null && this.descComp != null && keywords.size() > 0 && this.catalogo != null;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ServiceBuilder)) {
            return false;
        }

        final ServiceBuilder that = (ServiceBuilder) other;
        return this.servicoIdentificador.equals(that.servicoIdentificador);
    }


    /**
     * Criação da instância Serviço
     */
    @Override
    public Servico build() {
        // since the factory knows that all the parts are needed it could throw
        // an exception. however, we will leave that to the constructor

        return new Servico(ServicoIdentificador.valueOf(servicoIdentificador), Titulo.valueOf(titulo), DescricaoBreve.valueOf(descBreve),
                DescricaoCompleta.valueOf(descComp), icon, keywords, estado, fluxoAtividade ,catalogo, requerFeedback,nivelCriticidade);
    }
}
