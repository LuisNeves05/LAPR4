package eapli.base.formularioPreenchido.domain;

import javax.persistence.*;

@Entity
@Table
public class FormularioPreenchido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


}
