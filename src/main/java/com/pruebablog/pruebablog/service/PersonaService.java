/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pruebablog.pruebablog.service;

import com.pruebablog.pruebablog.dto.PersonaDto;
import com.pruebablog.pruebablog.model.PersonaEntity;
import java.util.List;


/**
 *
 * @author freddy.lopez
 */
public interface PersonaService {
  
  public PersonaDto create(PersonaDto entity);
  
  public PersonaDto update(PersonaDto entity);
  
  public PersonaDto get(Integer id);
  
  public void delete(Integer id);
  
  public List<PersonaDto> listAll();
  
}
