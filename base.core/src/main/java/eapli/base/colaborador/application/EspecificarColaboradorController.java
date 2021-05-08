package eapli.base.colaborador.application;

import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.colaborador.domain.*;
import eapli.base.colaborador.persistencia.ColaboradorRepositorio;
import eapli.base.equipa.domain.Equipa;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.application.AddUserController;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.domain.model.Password;
import eapli.framework.infrastructure.authz.domain.model.Role;

import javax.persistence.Embedded;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class EspecificarColaboradorController {

    private final ColaboradorRepositorio repoColaborador = PersistenceContext.repositories().colaboradorRepositorio();

    public Colaborador especificarColaborador(NomeCurto nomeCurto, NomeCompleto nomeCompleto, MecanographicNumber numMecanografico,
                                              Morada localResidencia, NrContacto nrContacto, Date dataNascimento, Colaborador colaboradorResponsavel){

        ColaboradorBuilder colaboradorBuilder = new ColaboradorBuilder();
        Colaborador c = colaboradorBuilder.comNomeCurto(nomeCurto).comNomeCompleto(nomeCompleto).comNumMecanografico(numMecanografico)
                .comLocalResidencia(localResidencia).comNrContacto(nrContacto).comDataNascimento(dataNascimento).comColaboradorResponsavel(colaboradorResponsavel).build();

        return repoColaborador.save(c);
    }


    public String addColaboresToEquipa(Equipa equipa, Colaborador colab){
        colab.setEquipa(equipa);
        repoColaborador.save(colab);
        return null;
    }

}
