package com.pruebablog.pruebablog.model;

import com.idepro.appbackendnetbank.util.MethodUtil;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * Created by Freddy Lopez Gomez.
 */
@Data
public class ResponseList<T> {
    private String mensaje;
    private String estado;
    private String fecha;
    private List<T> data;

    public ResponseList() {
        this.fecha = MethodUtil.dateDefault(new Date());
    }

    public ResponseList(String mensaje, String estado, List<T> data) {
        this.mensaje = mensaje;
        this.estado = estado;
        this.fecha = MethodUtil.dateDefault(new Date());
        this.data = data;
    }
}
