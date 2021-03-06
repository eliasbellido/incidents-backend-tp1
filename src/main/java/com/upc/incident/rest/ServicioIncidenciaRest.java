package com.upc.incident.rest;

import com.upc.incident.entidades.Incidencia;
import com.upc.incident.entidades.IncidenciaEntity;
import com.upc.incident.negocio.ServicioIncidenciaCore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api")
public class ServicioIncidenciaRest {
    @Autowired
    private ServicioIncidenciaCore servicioIncidenciaCore;

    @PostMapping("/incidencia")
    public Incidencia registrar(@RequestBody Incidencia incidencia){
        Incidencia i;
        i=servicioIncidenciaCore.registrarIncidencia(incidencia);
        return i;
    }

    @PutMapping("/incidencia/modificar")
    public Incidencia modificar(@RequestBody Incidencia incidencia){
        Incidencia i;
        i=servicioIncidenciaCore.modificarIncidencia(incidencia);
        return i;
    }

    @GetMapping("/incidencia/usuario/{idusuario}")
    public List<Incidencia> listarIncidenciaPorUsuario(@Param("idusuario") Long idusuario){
        return servicioIncidenciaCore.listarIncidenciasUsuario(idusuario);
    }

    @GetMapping("/incidencia/listar")
    public List<IncidenciaEntity> listarIncidencia(){
        return servicioIncidenciaCore.listarIncidencias();
    }

    @GetMapping("/incidencia/{id}")
    public IncidenciaEntity listarIncidencia(@PathVariable("id") Long id){
        return servicioIncidenciaCore.obtenerIncidenciaPorId(id);
    }

    @GetMapping("/incidencia/listarPorUbicacionYDistancia")
    public List<IncidenciaEntity> listarPorUbicacionYDistancia(Double latitud, Double longitud,int distancia){
        return servicioIncidenciaCore.listarIncidenciasPorUbicacionYDistancia(latitud,longitud,distancia);
    }

}
