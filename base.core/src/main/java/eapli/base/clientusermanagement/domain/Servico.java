package eapli.base.clientusermanagement.domain;

import javax.persistence.*;

@Entity
@Table(name = "Servico")
public class Servico {

    @Column
    private String titulo;
    @Column
    private String descBreve;
    @Column
    private String descComp;
    @Column
    int icon; //TODO alterar para imagem
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Servico(String titulo, String descBreve, String descComp, int icon){
        this.titulo = titulo;
        this.descBreve = descBreve;
        this.descComp = descComp;
        this.icon = icon;
    }

    public Servico(){}
}
