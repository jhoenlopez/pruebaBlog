package com.pruebablog.pruebablog.mapper;

import com.pruebablog.pruebablog.dto.PersonaDto;
import com.pruebablog.pruebablog.model.PersonaEntity;
import java.util.ArrayList;
import java.util.List;

public class PersonaMapper {

  public static void mapperToPersona(PersonaEntity from, PersonaDto to) {
    to.setIdPersona(from.getIdPersona());
    to.setTipo(from.getTipo());
    to.setNombres(from.getNombres());
    to.setApePaterno(from.getApePaterno());
    to.setApeMaterno(from.getApeMaterno());
    to.setFechaNac(from.getFechaNac());
    to.setPaisRes(from.getPaisRes());
    to.setCorreo(from.getCorreo());
  }
  
  public static PersonaDto mapperToPersona(PersonaEntity from) {
    PersonaDto to = new PersonaDto();
    PersonaMapper.mapperToPersona(from, to);
    return to;
  }
  
  public static List<PersonaDto> mapperToListPersona(List<PersonaEntity> from) {
    List<PersonaDto> list = new ArrayList<>();
    from.forEach(personaEntity -> {
      list.add(mapperToPersona(personaEntity));
    });
    return list;
  }
  
  public static void mapperToPersonaEntity(PersonaDto from, PersonaEntity to) {
    to.setIdPersona(from.getIdPersona());
    to.setTipo(from.getTipo());
    to.setNombres(from.getNombres());
    to.setApePaterno(from.getApePaterno());
    to.setApeMaterno(from.getApeMaterno());
    to.setFechaNac(from.getFechaNac());
    to.setPaisRes(from.getPaisRes());
    to.setCorreo(from.getCorreo());
  }
  
  public static PersonaEntity mapperToPersonaEntity(PersonaDto from) {
    PersonaEntity to = new PersonaEntity();
    PersonaMapper.mapperToPersonaEntity(from, to);
    return to;
  }

}
