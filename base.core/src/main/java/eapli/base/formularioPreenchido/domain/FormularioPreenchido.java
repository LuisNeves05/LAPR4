package eapli.base.formularioPreenchido.domain;

import eapli.base.formulario.domain.Formulario;

import javax.persistence.*;

@Entity
@Table
public class FormularioPreenchido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Formulario formulario;

    public FormularioPreenchido(){}

}
