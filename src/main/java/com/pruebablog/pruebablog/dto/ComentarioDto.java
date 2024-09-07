package com.pruebablog.pruebablog.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ComentarioDto {

  private Integer idComentario;
  private Integer idBlog;
  private Integer idAutor;
  private Integer puntuacion;
}
