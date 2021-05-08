package eapli.base.colaborador.domain;

import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.framework.domain.model.DomainFactory;

import java.util.Date;
import java.util.Set;


public class ColaboradorBuilder implements DomainFactory<Colaborador> {

    private NomeCurto nomeCurto;

    private NomeCompleto nomeCompleto;

    private MecanographicNumber numMecanografico;

    private Morada localResidencia;

    private NrContacto nrContacto;

    private Date dataNascimento;

    private Set<Funcao> funcao;

    private Colaborador colaboradorResponsavel;

    public ColaboradorBuilder(){}

    public ColaboradorBuilder comNomeCurto(final NomeCurto nomeCurto){
        this.nomeCurto = nomeCurto;
        return this;
    }

    public ColaboradorBuilder comNomeCompleto(final NomeCompleto nomeCompleto){
        this.nomeCompleto = nomeCompleto;
        return this;
    }

    public ColaboradorBuilder comNumMecanografico(final MecanographicNumber numMecanografico){
        this.numMecanografico = numMecanografico;
        return this;
    }

    public ColaboradorBuilder comLocalResidencia(final Morada localResidencia){
        this.localResidencia = localResidencia;
        return this;
    }

    public ColaboradorBuilder comNrContacto(final NrContacto nrContacto){
        this.nrContacto = nrContacto;
        return this;
    }

    public ColaboradorBuilder comDataNascimento(final Date dataNascimento){
        this.dataNascimento = dataNascimento;
        return this;
    }

    public ColaboradorBuilder comFuncao(final Set<Funcao> funcao){
        this.funcao = funcao;
        return this;
    }

    public ColaboradorBuilder comColaboradorResponsavel(final Colaborador colaboradorResponsavel){
        this.colaboradorResponsavel = colaboradorResponsavel;
        return this;
    }


    @Override
    public Colaborador build(){
        // since the factory knows that all the parts are needed it could throw
        // an exception. however, we will leave that to the constructor

        return new Colaborador(nomeCurto, nomeCompleto, numMecanografico, localResidencia, nrContacto,
                dataNascimento, colaboradorResponsavel);
    }
}
