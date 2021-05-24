package eapli.base.criticidade.application;

import eapli.base.criticidade.domain.Etiqueta;
import eapli.base.criticidade.domain.NivelCriticidade;
import eapli.base.criticidade.domain.Objetivo;
import eapli.base.criticidade.domain.ValorEscala;
import eapli.base.criticidade.persistencia.NivelCriticidadeRepositorio;
import eapli.base.infrastructure.persistence.PersistenceContext;
import java.awt.*;

public class EspecificarNivelCriticidadeController {

    private final NivelCriticidadeRepositorio repoNivel = PersistenceContext.repositories().nivelCriticidadeRepositorio();

    public NivelCriticidade especificarNivelCriticidade(String etiqueta, int valorEscala, Color cor, Objetivo objetivo, boolean isDefault){
        Etiqueta e = new Etiqueta(etiqueta);
        ValorEscala ve = new ValorEscala(valorEscala);
        return repoNivel.save(new NivelCriticidade(e,ve,cor,objetivo,isDefault));

    }

    public NivelCriticidade especificarNivelCriticidade(NivelCriticidade nivelCriticidade){
        return repoNivel.save(nivelCriticidade);

    }

    public Iterable<NivelCriticidade> nivelCriticidades(){
        return repoNivel.findAll();
    }

    public Iterable<NivelCriticidade> niveisCriticidadeDefault(){
        return repoNivel.niveisCritDefault();
    }

}
