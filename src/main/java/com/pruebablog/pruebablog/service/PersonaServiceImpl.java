/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pruebablog.pruebablog.service;

import com.pruebablog.pruebablog.dto.PersonaDto;
import com.pruebablog.pruebablog.mapper.PersonaMapper;
import com.pruebablog.pruebablog.model.PersonaEntity;
import com.pruebablog.pruebablog.repository.PersonaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author freddy.lopez
 */
@Service
public class PersonaServiceImpl implements PersonaService {

  @Autowired
  private PersonaRepository personaRepository;

  @Override
  public List<PersonaDto> listAll() {
    List<PersonaDto> list = PersonaMapper.mapperToListPersona(personaRepository.findAll());
    return list.isEmpty() ? null : list;
  }

  @Override
  public PersonaDto create(PersonaDto persona) {
    PersonaEntity entity = PersonaMapper.mapperToPersonaEntity(persona);
    PersonaDto personaDto = PersonaMapper.mapperToPersona(personaRepository.save(entity));
    return personaDto;
  }

  @Override
  public PersonaDto update(PersonaDto persona) {
    Optional<PersonaEntity> optionalEntity = personaRepository.findById(persona.getIdPersona());
    PersonaDto personaDto;
    if(optionalEntity.isPresent()){
      PersonaEntity entity = PersonaMapper.mapperToPersonaEntity(persona);
      personaDto =  PersonaMapper.mapperToPersona(personaRepository.save(entity));
    }else{
      personaDto = null;
    }
    return personaDto;
  }

  @Override
  public PersonaDto get(Integer id) {
    Optional<PersonaEntity> optionalEntity = personaRepository.findById(id);
    PersonaDto personaDto = optionalEntity.isPresent() ? PersonaMapper.mapperToPersona(optionalEntity.get()) : null;
    return personaDto;
  }

  @Override
  public void delete(Integer id) {
    Optional<PersonaEntity> optionalEntity = personaRepository.findById(id);
    if (optionalEntity.isPresent()) {
      personaRepository.delete(optionalEntity.get());
    }
  }

}
