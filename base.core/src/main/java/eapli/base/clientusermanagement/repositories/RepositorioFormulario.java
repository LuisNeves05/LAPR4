package eapli.base.clientusermanagement.repositories;

import eapli.base.clientusermanagement.domain.Formulario;
import eapli.base.clientusermanagement.domain.Servico;

import java.util.List;

public interface RepositorioFormulario {
    /**
     * inserts an entity and commits
     *
     * @param entity
     * @return the persisted entity
     */
    public Formulario add(Formulario entity);

    /**
     * reads an entity given its ID
     *
     * @param id
     * @return
     */
    public Formulario findById(Long id);

    /**
     * Returns the List of all entities in the persistence store
     *
     * @return
     */
    public List<Formulario> findAll();
}
