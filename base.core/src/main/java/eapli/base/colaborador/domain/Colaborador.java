package eapli.base.colaborador.domain;

import com.sun.nio.sctp.PeerAddressChangeNotification;
import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class Colaborador implements Comparable<Colaborador>, AggregateRoot<Colaborador> {

    @Column(name = "NOME_CURTO")
    private String nomeCurto;

    @Column(name = "NOME_COMPLETO")
    private String nomeCompleto;

    @Id
    @Column(name = "NUM_MECANOGRAFICO")
    private MecanographicNumber numMecanografico;

    @Column(name = "LOCAL_RESIDENCIA")
    private String localResidencia; //TODO CRIAR CLASSE ADDRESS

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "CONTACTO")
    private int nrContacto;

    @Column(name = "DATA_NASCIMENTO")
    private Date dataNascimento;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "FUNCAO")
    private String funcao;  //TODO CRIAR CLASSE FUNCAO @ONETOMANY

    @OneToOne
    private Colaborador colaboradorResponsavel;

    public Colaborador(String nomeCurto,String nomeCompleto, MecanographicNumber numMecanografico, String localResidencia, String email, int nrContacto,
                       Date dataNascimento, String password, String funcao, Colaborador colaboradorResponsavel){
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
    public int compareTo(Colaborador o){return 0;}

    @Override
    public Colaborador identity() {return null;}

    @Override
    public boolean hasIdentity(Colaborador otherNumMecanografico){return false;}

}