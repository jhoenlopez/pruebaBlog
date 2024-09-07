/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pruebablog.pruebablog.controller;

import com.idepro.appbackendnetbank.util.ConstantsUtil;
import com.pruebablog.pruebablog.dto.BlogDto;
import com.pruebablog.pruebablog.dto.PersonaDto;
import com.pruebablog.pruebablog.service.BlogService;
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
import com.pruebablog.pruebablog.service.PersonaService;

/**
 *
 * @author freddy.lopez
 */
@RestController
@RequestMapping("/blog")
public class BlogController {

  @Autowired
  private BlogService blogService;

  @Autowired
  private PersonaService personaService;

  @PostMapping(value = "/create")
  public ResponseEntity<Response> create(@RequestBody BlogDto request) {
    PersonaDto personaDto = personaService.get(request.getIdAutor());
    Response<BlogDto> response;
    if (personaDto != null) {
      BlogDto blogDto = blogService.create(request);
      response = new Response(ConstantsUtil.PARAM_MENSAJE_VACIO, ConstantsUtil.PARAM_ESTADO_OK, blogDto);
    } else {
      response = new Response(ConstantsUtil.PARAM_MENSAJE_SIN_REGISTROS_PERSONA, ConstantsUtil.PARAM_ESTADO_OK, null);
    }
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @PostMapping(value = "/update")
  public ResponseEntity<Response> update(@RequestBody BlogDto request) {
    PersonaDto personaDto = personaService.get(request.getIdAutor());
    Response<BlogDto> response;
    if (personaDto != null) {
      BlogDto blogDto = blogService.update(request);
      response = blogDto != null ? new Response(ConstantsUtil.PARAM_MENSAJE_VACIO, ConstantsUtil.PARAM_ESTADO_OK, blogDto) : new Response(ConstantsUtil.PARAM_MENSAJE_SIN_REGISTROS, ConstantsUtil.PARAM_ESTADO_NOK, null);
    } else {
      response = new Response(ConstantsUtil.PARAM_MENSAJE_SIN_REGISTROS_PERSONA, ConstantsUtil.PARAM_ESTADO_OK, null);
    }
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @PostMapping(value = "/get")
  public ResponseEntity<Response> get(@RequestBody Request request) {
    BlogDto blogDto = blogService.get(request.getIdBlog());
    Response<BlogDto> response = blogDto != null ? new Response(ConstantsUtil.PARAM_MENSAJE_VACIO, ConstantsUtil.PARAM_ESTADO_OK, blogDto) : new Response(ConstantsUtil.PARAM_MENSAJE_SIN_REGISTROS, ConstantsUtil.PARAM_ESTADO_NOK, null);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @PostMapping(value = "/delete")
  public ResponseEntity<Response> delete(@RequestBody Request request) {
    BlogDto blogDto = blogService.get(request.getIdBlog());
    Response<BlogDto> response;
    if (blogDto != null) {
      blogService.delete(request.getIdBlog());
      response = new Response(ConstantsUtil.PARAM_MENSAJE_VACIO, ConstantsUtil.PARAM_ESTADO_OK, null);
    } else {
      response = new Response(ConstantsUtil.PARAM_MENSAJE_SIN_REGISTROS, ConstantsUtil.PARAM_ESTADO_NOK, null);
    }
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @PostMapping(value = "/list")
  public ResponseEntity<ResponseList> listarBlogs() {
    List<BlogDto> list = blogService.listAll();
    ResponseList<BlogDto> response = list != null ? new ResponseList(ConstantsUtil.PARAM_MENSAJE_VACIO, ConstantsUtil.PARAM_ESTADO_OK, list) : new ResponseList(ConstantsUtil.PARAM_MENSAJE_SIN_REGISTROS, ConstantsUtil.PARAM_ESTADO_NOK, null);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

}
