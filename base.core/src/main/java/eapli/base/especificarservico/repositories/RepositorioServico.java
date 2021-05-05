package eapli.base.especificarservico.repositories;

import eapli.base.especificarservico.domain.Servico;

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