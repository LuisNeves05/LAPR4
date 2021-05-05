package eapli.base.especificarFormulario.repositories;

import eapli.base.especificarFormulario.domain.Formulario;

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
