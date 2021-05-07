package eapli.base.colaborador.domain;

import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.framework.domain.model.DomainFactory;

import java.util.Date;


public class ColaboradorBuilder implements DomainFactory<Colaborador> {

    private String nomeCurto;

    private String nomeCompleto;

    private MecanographicNumber numMecanografico;

    private String localResidencia;

    private String email;

    private int nrContacto;

    private Date dataNascimento;

    private String password;

    private String funcao;

    private Colaborador colaboradorResponsavel;

    private ColaboradorBuilder(){}

    public ColaboradorBuilder comNomeCurto(final String nomeCurto){
        this.nomeCurto = nomeCurto;
        return this;
    }

    public ColaboradorBuilder comNomeCompleto(final String nomeCompleto){
        this.nomeCompleto = nomeCompleto;
        return this;
    }

    public ColaboradorBuilder comNumMecanografico(final MecanographicNumber numMecanografico){
        this.numMecanografico = numMecanografico;
        return this;
    }

    public ColaboradorBuilder comLocalResidencia(final String localResidencia){
        this.localResidencia = localResidencia;
        return this;
    }

    public ColaboradorBuilder comEmail(final String email){
        this.email = email;
        return this;
    }

    public ColaboradorBuilder comNrContacto(final int nrContacto){
        this.nrContacto = nrContacto;
        return this;
    }

    public ColaboradorBuilder comDataNascimento(final Date dataNascimento){
        this.dataNascimento = dataNascimento;
        return this;
    }

    public ColaboradorBuilder comPassword(final String password) {
        this.password = password;
        return this;
    }

    public ColaboradorBuilder comFuncao(final String funcao){
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

        return new Colaborador(nomeCurto, nomeCompleto, numMecanografico, localResidencia, email, nrContacto,
                dataNascimento, password, funcao, colaboradorResponsavel);
    }
}
