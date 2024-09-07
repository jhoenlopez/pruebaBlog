package com.pruebablog.pruebablog.mapper;

import com.pruebablog.pruebablog.dto.BlogDto;
import com.pruebablog.pruebablog.model.BlogEntity;
import java.util.ArrayList;
import java.util.List;

public class BlogMapper {

  public static void mapperToBlog(BlogEntity from, BlogDto to) {
    to.setIdBlog(from.getIdBlog());
    to.setIdAutor(from.getIdPersona());
    to.setTitulo(from.getTitulo());
    to.setTema(from.getTema());
    to.setContenido(from.getContenido());
    to.setPeriodicidad(from.getPeriodicidad());
    to.setSwComentario(from.getSwComentario());
  }
  
  public static BlogDto mapperToBlog(BlogEntity from) {
    BlogDto to = new BlogDto();
    BlogMapper.mapperToBlog(from, to);
    return to;
  }
  
  public static List<BlogDto> mapperToListBlog(List<BlogEntity> from) {
    List<BlogDto> list = new ArrayList<>();
    from.forEach(personaEntity -> {
      list.add(mapperToBlog(personaEntity));
    });
    return list;
  }
  
  public static void mapperToBlogEntity(BlogDto from, BlogEntity to) {
    to.setIdBlog(from.getIdBlog());
    to.setIdPersona(from.getIdAutor());
    to.setTitulo(from.getTitulo());
    to.setTema(from.getTema());
    to.setContenido(from.getContenido());
    to.setPeriodicidad(from.getPeriodicidad());
    to.setSwComentario(from.getSwComentario());
  }
  
  public static BlogEntity mapperToBlogEntity(BlogDto from) {
    BlogEntity to = new BlogEntity();
    BlogMapper.mapperToBlogEntity(from, to);
    return to;
  }

}
