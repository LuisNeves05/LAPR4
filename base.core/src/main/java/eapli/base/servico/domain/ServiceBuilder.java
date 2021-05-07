package eapli.base.servico.domain;

import eapli.framework.domain.model.DomainFactory;
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
    private int icon; //TODO alterar para imagem
    /**
     * Modo de atividade de aprovação, podendo ser requerida ou não
     */
    private boolean atAprov;
    /**
     * Atividade de realização, podendo ser automática ou manual
     */
    private boolean atReal;
    /**
     * Conjunto de palavras chave de um serviço
     */
    private Set<Keyword> keywords;
    /**
     * Estado de conclusão do serviço, podendo estar completo ou incompleto
     */
    private String estado;

    public ServiceBuilder(){
    }

    public ServiceBuilder comIdentificador(final String identificador) {
        this.servicoIdentificador = identificador;
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

    public ServiceBuilder comIcon(final int icon) {
        this.icon = icon;
        return this;
    }

    public ServiceBuilder comAtAprov(final boolean atAprov) {
        this.atAprov = atAprov;
        return this;
    }

    public ServiceBuilder comAtReal(final boolean atReal) {
        this.atReal = atReal;
        return this;
    }

    public ServiceBuilder comKeywords(final Set<Keyword> keywords) {
        this.keywords = keywords;
        return this;
    }

    public ServiceBuilder comEstado(final String estado) {
        this.estado = estado;
        return this;
    }

    /**
     * Criação da instância Serviço
     */
    @Override
    public Servico build() {
        // since the factory knows that all the parts are needed it could throw
        // an exception. however, we will leave that to the constructor

        return new Servico(ServicoIdentificador.valueOf(servicoIdentificador), titulo, descBreve, descComp, icon, atAprov, atReal, keywords, estado);
    }
}
