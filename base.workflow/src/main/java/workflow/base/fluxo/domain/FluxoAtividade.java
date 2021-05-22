package workflow.base.fluxo.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class FluxoAtividade {

    @Id
    private Long id;

    @OneToOne
    private AtividadeRealizacao ativReal = new AtividadeRealizacao();
    @OneToOne
    private AtividadeAprovacao ativAprov = new AtividadeAprovacao();


}
