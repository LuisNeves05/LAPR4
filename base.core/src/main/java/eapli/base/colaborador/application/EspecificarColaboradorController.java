package eapli.base.colaborador.application;

import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.colaborador.domain.*;
import eapli.base.colaborador.persistencia.ColaboradorRepositorio;
import eapli.base.equipa.domain.Equipa;
import eapli.base.infrastructure.persistence.PersistenceContext;

import java.util.Date;
import java.util.List;

public class EspecificarColaboradorController {

    private final ColaboradorRepositorio repoColaborador = PersistenceContext.repositories().colaboradorRepositorio();

    public Colaborador especificarColaborador(NomeCurto nomeCurto, NomeCompleto nomeCompleto, MecanographicNumber numMecanografico,
                                              Morada localResidencia, NrContacto nrContacto, Date dataNascimento, Colaborador colaboradorResponsavel){

        ColaboradorBuilder colaboradorBuilder = new ColaboradorBuilder();
        Colaborador c = colaboradorBuilder.comNomeCurto(nomeCurto).comNomeCompleto(nomeCompleto).comNumMecanografico(numMecanografico)
                .comLocalResidencia(localResidencia).comNrContacto(nrContacto).comDataNascimento(dataNascimento).comColaboradorResponsavel(colaboradorResponsavel).build();

        return repoColaborador.save(c);
    }

}
