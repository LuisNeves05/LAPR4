package eapli.base.tipoEquipa.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.tipoEquipa.domain.TipoEquipa;
import eapli.base.tipoEquipa.domain.TipoEquipaBuilder;
import eapli.base.tipoEquipa.persistencia.TipoEquipaRepositorio;

import java.awt.*;

/**
 * Classe Controller da Especificação de um TipoEquipa
 */
public class RegistarTipoEquipaController {


    private final TipoEquipaRepositorio repoServ = PersistenceContext.repositories().tipoEquipaRepositorio();

    /**
     * Especificação de um novo TipoEquipa
     */
    public TipoEquipa tipoEquipaServico(String identificador, String descricao, Color cor) {

        TipoEquipaBuilder tipoEquipaBuilder = new TipoEquipaBuilder();
        tipoEquipaBuilder.comIdentificador(identificador).comDescricao(descricao).comCor(cor);
        return this.repoServ.save(tipoEquipaBuilder.build());
    }

}

