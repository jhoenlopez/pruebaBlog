/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pruebablog.pruebablog.controller;

import com.idepro.appbackendnetbank.util.ConstantsUtil;
import com.pruebablog.pruebablog.dto.PersonaDto;
import com.pruebablog.pruebablog.service.PersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pruebablog.pruebablog.model.Request;
import com.pruebablog.pruebablog.model.Response;
import com.pruebablog.pruebablog.model.ResponseList;

/**
 *
 * @author freddy.lopez
 */
@RestController
@RequestMapping("/persona")
public class PersonaController {

  @Autowired
  private PersonaService personaService;

  @PostMapping(value = "/create")
  public ResponseEntity<Response> create(@RequestBody PersonaDto request) {
    PersonaDto personaDto = personaService.create(request);
    Response<PersonaDto> response = new Response(ConstantsUtil.PARAM_MENSAJE_VACIO, ConstantsUtil.PARAM_ESTADO_OK, personaDto);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @PostMapping(value = "/update")
  public ResponseEntity<Response> update(@RequestBody PersonaDto request) {
    PersonaDto personaDto = personaService.update(request);
    Response<PersonaDto> response = personaDto != null ? new Response(ConstantsUtil.PARAM_MENSAJE_VACIO, ConstantsUtil.PARAM_ESTADO_OK, personaDto) : new Response(ConstantsUtil.PARAM_MENSAJE_SIN_REGISTROS, ConstantsUtil.PARAM_ESTADO_NOK, null);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @PostMapping(value = "/get")
  public ResponseEntity<Response> get(@RequestBody Request request) {
    PersonaDto personaDto = personaService.get(request.getIdPersona());
    Response<PersonaDto> response = personaDto != null ? new Response(ConstantsUtil.PARAM_MENSAJE_VACIO, ConstantsUtil.PARAM_ESTADO_OK, personaDto) : new Response(ConstantsUtil.PARAM_MENSAJE_SIN_REGISTROS, ConstantsUtil.PARAM_ESTADO_NOK, null);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @PostMapping(value = "/delete")
  public ResponseEntity<Response> delete(@RequestBody Request request) {
    PersonaDto personaDto = personaService.get(request.getIdPersona());
    Response<PersonaDto> response;
    if (personaDto != null) {
      personaService.delete(request.getIdPersona());
      response = new Response(ConstantsUtil.PARAM_MENSAJE_VACIO, ConstantsUtil.PARAM_ESTADO_OK, null);
    } else {
      response = new Response(ConstantsUtil.PARAM_MENSAJE_SIN_REGISTROS, ConstantsUtil.PARAM_ESTADO_NOK, null);
    }
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @PostMapping(value = "/list")
  public ResponseEntity<ResponseList> listarPersonas() {
    List<PersonaDto> list = personaService.listAll();
    ResponseList<PersonaDto> response = list != null ? new ResponseList(ConstantsUtil.PARAM_MENSAJE_VACIO, ConstantsUtil.PARAM_ESTADO_OK, list) : new ResponseList(ConstantsUtil.PARAM_MENSAJE_SIN_REGISTROS, ConstantsUtil.PARAM_ESTADO_NOK, null);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

}
