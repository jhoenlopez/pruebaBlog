/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pruebablog.pruebablog.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 *
 * @author freddy.lopez
 */
@Data
public class Request {
  
  private Integer idPersona;
  private Integer idBlog;
  
}
