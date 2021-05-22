package eapli.base.tarefa.domain;

import eapli.base.servico.domain.Servico;

import javax.persistence.*;

@Entity
public class TipoTarefa implements Comparable<Long>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Servico servico;

    private String descricao;

    protected TipoTarefa(){}


    @Override
    public int compareTo(Long o) {
        return (int) (o-id);
    }
}
