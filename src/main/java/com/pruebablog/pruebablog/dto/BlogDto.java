package com.pruebablog.pruebablog.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class BlogDto {

    private Integer idBlog;
    private Integer idAutor;
    private String titulo;
    private String tema;
    private String contenido;
    private String periodicidad;
    private String swComentario;
}
