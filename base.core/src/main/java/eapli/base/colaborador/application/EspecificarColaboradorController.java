package eapli.base.colaborador.application;

import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.colaborador.domain.*;
import eapli.base.colaborador.persistencia.ColaboradorRepositorio;
import eapli.base.equipa.domain.Equipa;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.application.AddUserController;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.infrastructure.authz.domain.model.Role;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EspecificarColaboradorController {

    private final ColaboradorRepositorio repoColaborador = PersistenceContext.repositories().colaboradorRepositorio();
    private final AddUserController adc = new AddUserController();

    public void becameSystemUser(Colaborador colab, String username, String password, String firstname, String lastname, String email, Set<Role> roless){
        colab.becameSystemUser(adc.addUser(username,password,firstname,lastname,email, roless));
    }
    public Colaborador especificarColaborador(NomeCurto nomeCurto, NomeCompleto nomeCompleto, MecanographicNumber numMecanografico,
                                              Morada localResidencia, NrContacto nrContacto, Date dataNascimento,
                                              Colaborador colaboradorResponsavel, Set<Role> roless, String username, String password, String email){

        ColaboradorBuilder colaboradorBuilder = new ColaboradorBuilder();
        Colaborador c = colaboradorBuilder.comNomeCurto(nomeCurto).comNomeCompleto(nomeCompleto).comNumMecanografico(numMecanografico)
                .comLocalResidencia(localResidencia).comNrContacto(nrContacto).comDataNascimento(dataNascimento).comColaboradorResponsavel(colaboradorResponsavel).build();

        becameSystemUser(c, username, password, nomeCurto.toString(), nomeCompleto.toString(), email, roless);
        return repoColaborador.save(c);
    }

}
