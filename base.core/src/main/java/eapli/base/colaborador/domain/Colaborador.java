package eapli.base.colaborador.domain;

import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;

@Entity
@Table
public class Colaborador implements Comparable<Colaborador>, AggregateRoot<Colaborador> {

    private String nomeCurto;

    private String nomeCompleto;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private MecanographicNumber numMecanografico;

    private String localResidencia;

    private String email;

    int nrContacto;

    private String dataNascimento;

    private String password;

    String funcao;

    String colaboradorResponsavel;


    public Colaborador(String nomeCurto,String nomeCompleto, MecanographicNumber numMecanografico, String localResidencia, String email, int nrContacto,
                       String dataNascimento, String password, String funcao, String colaboradorResponsavel){
        this.nomeCurto = nomeCurto;
        this.nomeCompleto = nomeCompleto;
        this.numMecanografico = numMecanografico;
        this.localResidencia = localResidencia;
        this.email = email;
        this.nrContacto = nrContacto;
        this.dataNascimento = dataNascimento;
        this.password = password;
        this.funcao = funcao;
        this.colaboradorResponsavel = colaboradorResponsavel;

    }

    protected Colaborador(){}


    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public Colaborador identity() {
        return null;
    }
}