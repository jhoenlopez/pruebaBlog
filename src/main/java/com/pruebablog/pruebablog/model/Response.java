/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pruebablog.pruebablog.model;

import com.idepro.appbackendnetbank.util.MethodUtil;
import java.util.Date;
import lombok.Data;

/**
 *
 * @author freddy.lopez
 */
@Data
public class Response<T> {
    private String mensaje;
    private String estado;
    private String fecha;
    private T data;

    public Response() {
        this.fecha = MethodUtil.dateDefault(new Date());
    }

    public Response(String mensaje, String estado, T data) {
        this.mensaje = mensaje;
        this.estado = estado;
        this.fecha = MethodUtil.dateDefault(new Date());
        this.data = data;
    }
}
