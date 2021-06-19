package eapli.base.colaborador.domain;

import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.equipa.domain.Equipa;
import eapli.base.tipoEquipa.domain.TipoEquipa;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table
public class Colaborador implements Comparable<MecanographicNumber>, AggregateRoot<MecanographicNumber> {

    @Column(name = "NOME_CURTO")
    @Embedded
    private NomeCurto nomeCurto;

    @Column(name = "NOME_COMPLETO")
    @Embedded
    private NomeCompleto nomeCompleto;

    @EmbeddedId
    @Column(name = "NUM_MECANOGRAFICO")
    private MecanographicNumber numMecanografico;

    @Column(name = "LOCAL_RESIDENCIA") //nao obrigatoria
    @Embedded
    private Morada localResidencia = null;

    @Column(name = "CONTACTO")
    @Embedded
    private NrContacto nrContacto;

    @Column(name = "DATA_NASCIMENTO")
    private Date dataNascimento;

    @OneToOne
    private Colaborador colaboradorResponsavel;

    @OneToOne
    private SystemUser systemUser;

    @ManyToMany(mappedBy = "listaColabs",cascade = CascadeType.ALL)
    private List<Equipa> equipas;


    public Colaborador(NomeCurto nomeCurto,NomeCompleto nomeCompleto, MecanographicNumber numMecanografico,
                       Morada localResidencia, NrContacto nrContacto, Date dataNascimento, Colaborador colaboradorResponsavel){
        this.nomeCurto = nomeCurto;
        this.nomeCompleto = nomeCompleto;
        this.numMecanografico = numMecanografico;
        this.localResidencia = localResidencia;
        this.nrContacto = nrContacto;
        this.dataNascimento = dataNascimento;
        this.colaboradorResponsavel = colaboradorResponsavel;
        this.equipas = new ArrayList<>();
    }


    public Colaborador(){}

    public void becameSystemUser(SystemUser sysUser){
        this.systemUser = sysUser;
    }

    public Colaborador seuColabResponsavel(){
        return this.colaboradorResponsavel;
    }

    public boolean pertenceTipoEquipa(TipoEquipa tipoEquipa) {
        if(!this.equipas.isEmpty()){
            for(Equipa equipa : equipas){
                if (equipa.temTipoEquipa(tipoEquipa))
                    return true;
            }
        }
        return false;
    }


    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public int compareTo(MecanographicNumber o){return this.numMecanografico.compareTo(o);}

    @Override
    public MecanographicNumber identity() {return this.numMecanografico;}

    @Override
    public String toString() {
        return "Colaborador{" +
                "nomeCurto=" + nomeCurto +
                ", numMecanografico=" + numMecanografico +
                ", nrContacto=" + nrContacto +
                '}';
    }

    public List<Equipa> obterEquipasColaborador() {
        return equipas;
    }

    public String nomeToString(){
        return nomeCurto.toString();
    }

    public MecanographicNumber numMecanografico() {
        return numMecanografico;
    }

    public void setNumMecanografico(MecanographicNumber numMecanografico) {
        this.numMecanografico = numMecanografico;
    }

    public SystemUser systemUserDoColab() {
        return systemUser;
    }
}