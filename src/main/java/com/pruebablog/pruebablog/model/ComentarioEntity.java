package com.pruebablog.pruebablog.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "comentario")
public class ComentarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_comentario")
    private Integer idComentario;

    @Basic
    @Column(name = "id_blog")
    private Integer idBlog;

    @Basic
    @Column(name = "id_persona")
    private Integer idPersona;

    @Basic
    @Column(name = "puntuacion")
    private Integer puntuacion;
    
    
}
