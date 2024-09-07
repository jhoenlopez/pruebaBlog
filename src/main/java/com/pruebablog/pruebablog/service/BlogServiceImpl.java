/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pruebablog.pruebablog.service;

import com.pruebablog.pruebablog.dto.BlogDto;
import com.pruebablog.pruebablog.mapper.BlogMapper;
import com.pruebablog.pruebablog.model.BlogEntity;
import com.pruebablog.pruebablog.repository.BlogRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author freddy.lopez
 */
@Service
public class BlogServiceImpl implements BlogService {

  @Autowired
  private BlogRepository blogRepository;

  @Override
  public List<BlogDto> listAll() {
    List<BlogDto> list = BlogMapper.mapperToListBlog(blogRepository.findAll());
    return list.isEmpty() ? null : list;
  }

  @Override
  public BlogDto create(BlogDto blog) {
    BlogEntity entity = BlogMapper.mapperToBlogEntity(blog);
    BlogDto blogDto = BlogMapper.mapperToBlog(blogRepository.save(entity));
    return blogDto;
  }

  @Override
  public BlogDto update(BlogDto blog) {
    Optional<BlogEntity> optionalEntity = blogRepository.findById(blog.getIdBlog());
    BlogDto blogDto;
    if (optionalEntity.isPresent()) {
      BlogEntity entity = BlogMapper.mapperToBlogEntity(blog);
      blogDto = BlogMapper.mapperToBlog(blogRepository.save(entity));
    } else {
      blogDto = null;
    }
    return blogDto;
  }

  @Override
  public BlogDto get(Integer id) {
    Optional<BlogEntity> optionalEntity = blogRepository.findById(id);
    BlogDto blogDto = optionalEntity.isPresent() ? BlogMapper.mapperToBlog(optionalEntity.get()) : null;
    return blogDto;
  }

  @Override
  public void delete(Integer id) {
    Optional<BlogEntity> optionalEntity = blogRepository.findById(id);
    if (optionalEntity.isPresent()) {
      blogRepository.delete(optionalEntity.get());
    }
  }

}
