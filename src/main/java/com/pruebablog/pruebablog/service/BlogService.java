/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pruebablog.pruebablog.service;

import com.pruebablog.pruebablog.dto.BlogDto;
import java.util.List;


/**
 *
 * @author freddy.lopez
 */
public interface BlogService {
  
  public BlogDto create(BlogDto entity);
  
  public BlogDto update(BlogDto entity);
  
  public BlogDto get(Integer id);
  
  public void delete(Integer id);
  
  public List<BlogDto> listAll();
  
}
