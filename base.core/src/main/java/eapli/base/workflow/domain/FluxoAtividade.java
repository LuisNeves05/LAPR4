package eapli.base.workflow.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public abstract class FluxoAtividade {

    @Id
    private Long id;

}
