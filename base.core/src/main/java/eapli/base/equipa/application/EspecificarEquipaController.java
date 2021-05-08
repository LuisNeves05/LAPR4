package eapli.base.equipa.application;

import eapli.base.colaborador.domain.Colaborador;
import eapli.base.equipa.domain.Acronimo;
import eapli.base.equipa.domain.Equipa;
import eapli.base.equipa.persistencia.EquipaRepositorio;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.framework.domain.repositories.IntegrityViolationException;

public class EspecificarEquipaController {

    private final EquipaRepositorio repoEquipa = PersistenceContext.repositories().equipaRepositorio();

    /**
     * Especificação de uma nova Equipa para a base de dados
     */

    public Equipa especificarEquipa(Long codigoEquipa, Acronimo acr, String designacao, Colaborador colab){

        try {
            return repoEquipa.save(new Equipa(codigoEquipa, acr, designacao, colab));
        }catch (IntegrityViolationException violation){
            System.out.println("Equipa com credenciais já usadas!");
        }
        return null;
    }

    public String listarAcronimos(String txt){
        repoEquipa.listarAcronimosEquipa(txt);
        return txt;
    }
}
