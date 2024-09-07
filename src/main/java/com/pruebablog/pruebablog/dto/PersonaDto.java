package com.pruebablog.pruebablog.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class PersonaDto {

    private Integer idPersona;
    private String tipo;
    private String nombres;
    private String apePaterno;
    private String apeMaterno;
    private String fechaNac;
    private String paisRes;
    private String correo;
}
