package com.pruebablog.pruebablog.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "blog")
public class BlogEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_blog")
    private Integer idBlog;
    
    @Basic
    @Column(name = "id_persona")
    private Integer idPersona;

    @Basic
    @Column(name = "titulo")
    private String titulo;

    @Basic
    @Column(name = "tema")
    private String tema;

    @Basic
    @Column(name = "contenido")
    private String contenido;
    
    @Basic
    @Column(name = "periodicidad")
    private String periodicidad;
    
    @Basic
    @Column(name = "sw_comentario")
    private String swComentario;
    
    
}
