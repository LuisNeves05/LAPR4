package eapli.base.equipa.application;

import eapli.base.colaborador.domain.Colaborador;
import eapli.base.equipa.domain.Equipa;
import eapli.base.equipa.persistencia.EquipaRepositorio;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.tipoEquipa.domain.TipoEquipa;

import java.util.Set;

public class AddOrDeleteEquipaController {

    private final EquipaRepositorio repoEquipa = PersistenceContext.repositories().equipaRepositorio();
    private final Equipa equipa;

    public AddOrDeleteEquipaController(Equipa e){
        this.equipa = e;
    }

    public boolean adicionarResponsavel(Colaborador colab) {
        if(equipa.adicionarColaboradorResponsavel(colab)){
            repoEquipa.save(equipa);
            return true;
        }
        return false;
    }

    public boolean adicionarColaborador(Colaborador colab) {
        if(equipa.adicionarColaborador(colab)){
            repoEquipa.save(equipa);
            return true;
        }
        return false;
    }

    public void adicionarColaboradores(Set<Colaborador> colab) {
       for(Colaborador c : colab){
            equipa.adicionarColaborador(c);
       }
        repoEquipa.save(equipa);
    }

    public boolean removerColaborador(Colaborador colab){
        if(equipa.removerColab(colab)){
            repoEquipa.save(equipa);
            return true;
        }
        return false;
    }
    public boolean temColaborador(Colaborador colab) {
        return equipa.temColab(colab);
    }

    public boolean temResponsavel(Colaborador colab) {
        return equipa.temResponsavel(colab);
    }

    public boolean temTipoEquipa(TipoEquipa tipoEquipa) {
        return equipa.temTipoEquipa(tipoEquipa);
    }
}
