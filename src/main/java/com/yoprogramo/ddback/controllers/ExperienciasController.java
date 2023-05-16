package com.yoprogramo.ddback.controllers;

import com.yoprogramo.ddback.dto.request.UpdateExperienciasRequest;
import com.yoprogramo.ddback.dto.response.BaseResponse;
import com.yoprogramo.ddback.dto.response.GetExperienciasResponse;
import com.yoprogramo.ddback.models.Experiencia;
import com.yoprogramo.ddback.repositories.ExperienciaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path="/experiencias") //ruta base del controlador
public class ExperienciasController {
    @Autowired
    private ExperienciaRepo experienciaRepo;

    @CrossOrigin(origins = "*")
    @GetMapping
    public @ResponseBody GetExperienciasResponse getExperiencias(){
        GetExperienciasResponse response = new GetExperienciasResponse();
        try {
            List<Experiencia> result = experienciaRepo.findAll(); // a traves del repo, trae todos los datos de la tabla
            response.setExperiencias(result); // los datos obtenidos se colocan en el objeto del response
            response.setStatusCode(200);
        }
        catch(Exception e){
            response.setStatusCode(500);
        }
        return response;
    }

    @CrossOrigin(origins = "*")
    @PutMapping(path="/{id}")
    public @ResponseBody BaseResponse updateExperiencias(@PathVariable("id") Long id, //parametro de id en la ruta
                                                         @RequestBody UpdateExperienciasRequest request){ //el cuerpo del request con los datos a actualizar

        BaseResponse response = new BaseResponse();
        try {
            Experiencia experiencia = experienciaRepo.findById(id).get(); // obtener un unico registro por el id que es univoco
            // actualizar los datos existentes
            // "experiencia" tiene lo que esta en la base de datos
            // "request" tiene lo que estamos enviando para actualizar
            experiencia.setTitulo(request.getTitulo());
            experiencia.setPeriodo(request.getPeriodo());
            experiencia.setOrganizacion(request.getOrganizacion());
            experiencia.setUrlImagen(request.getUrlImagen());
            experiencia.setEnlace(request.getEnlace());
            experiencia.setDescripcion(request.getDescripcion());
            experienciaRepo.save(experiencia);
            response.setStatusCode(200);
        }
        catch (Exception e){
            response.setStatusCode(500);
        }
        return response;
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping(path="/{id}")
    public @ResponseBody BaseResponse deleteExperiencia(@PathVariable("id") Long id){
        BaseResponse response = new BaseResponse();
        try {
            // obtener el registro de la base de datos a traves del id
            Experiencia experiencia = experienciaRepo.findById(id).get();
            // eliminar
            experienciaRepo.delete(experiencia);
            response.setStatusCode(200);
        }
        catch (Exception e){
            response.setStatusCode(500);
        }
        return response;
    }
}
