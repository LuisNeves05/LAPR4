package eapli.base.clientusermanagement.repositories;

import eapli.base.clientusermanagement.domain.Servico;

import java.util.List;

public interface RepositorioServico {
        /**
         * inserts an entity and commits
         *
         * @param entity
         * @return the persisted entity
         */
        public Servico add(Servico entity);

        /**
         * reads an entity given its ID
         *
         * @param id
         * @return
         */
        public Servico findById(Long id);

        /**
         * Returns the List of all entities in the persistence store
         *
         * @return
         */
        public List<Servico> findAll();
    }