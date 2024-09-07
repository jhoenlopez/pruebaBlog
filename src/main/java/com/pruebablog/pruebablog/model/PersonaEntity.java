package com.pruebablog.pruebablog.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "persona")
public class PersonaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_persona")
    private Integer idPersona;

    @Basic
    @Column(name = "tipo")
    private String tipo;

    @Basic
    @Column(name = "nombres")
    private String nombres;

    @Basic
    @Column(name = "ape_paterno")
    private String apePaterno;
    
    @Basic
    @Column(name = "ape_materno")
    private String apeMaterno;
    
    @Basic
    @Column(name = "fecha_nac")
    private String fechaNac;
    
    @Basic
    @Column(name = "pais_res")
    private String paisRes;

    @Basic
    @Column(name = "correo")
    private String correo;
}
