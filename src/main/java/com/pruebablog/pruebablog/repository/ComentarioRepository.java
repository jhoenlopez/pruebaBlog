/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pruebablog.pruebablog.repository;

import com.pruebablog.pruebablog.model.ComentarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author freddy.lopez
 */
@Repository
public interface ComentarioRepository extends JpaRepository<ComentarioEntity, Integer>{
  
}
