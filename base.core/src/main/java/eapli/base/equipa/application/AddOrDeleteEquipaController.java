package eapli.base.equipa.application;

import eapli.base.colaborador.domain.Colaborador;
import eapli.base.equipa.domain.Equipa;
import eapli.base.equipa.persistencia.EquipaRepositorio;
import eapli.base.infrastructure.persistence.PersistenceContext;

import java.util.LinkedHashSet;
import java.util.Set;

public class AddOrDeleteEquipaController {

    private final EquipaRepositorio repoEquipa = PersistenceContext.repositories().equipaRepositorio();

    /*
    public String addColaboresToEquipa(Equipa equipa, Colaborador colab){
        Set<Equipa> equipas = new LinkedHashSet<>();
        colab.setEquipas(equipas);
        repoEquipa.save(colab);
        return null;
    }*/
}
