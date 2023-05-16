package com.yoprogramo.ddback.controllers;

import com.yoprogramo.ddback.dto.request.UpdateHabilidadesRequest;
import com.yoprogramo.ddback.dto.response.BaseResponse;
import com.yoprogramo.ddback.dto.response.GetHabilidadesResponse;
import com.yoprogramo.ddback.models.Habilidad;
import com.yoprogramo.ddback.repositories.HabilidadRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path="/habilidades") //ruta base del controlador
public class HabilidadesController {
    @Autowired
    private HabilidadRepo habilidadRepo;

    @CrossOrigin(origins = "*")
    @GetMapping
    public @ResponseBody GetHabilidadesResponse getHabilidades(){
        GetHabilidadesResponse response = new GetHabilidadesResponse();
        try {
            List<Habilidad> result = habilidadRepo.findAll(); // a traves del repo, trae todos los datos de la tabla
            response.setHabilidades(result); // los datos obtenidos se colocan en el objeto del response
            response.setStatusCode(200);
        }
        catch(Exception e){
            response.setStatusCode(500);
        }
        return response;
    }

    @CrossOrigin(origins = "*")
    @PutMapping(path="/{id}")
    public @ResponseBody BaseResponse updateHabilidades(@PathVariable("id") Long id, //parametro de id en la ruta
                                                         @RequestBody UpdateHabilidadesRequest request){ //el cuerpo del request con los datos a actualizar

        BaseResponse response = new BaseResponse();
        try {
            Habilidad habilidad = habilidadRepo.findById(id).get(); // obtener un unico registro por el id que es univoco
            // actualizar los datos existentes
            // "habilidad" tiene lo que esta en la base de datos
            // "request" tiene lo que estamos enviando para actualizar
            habilidad.setNombre(request.getNombre());
            habilidad.setCalificacion(request.getCalificacion());
            habilidadRepo.save(habilidad);
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
            Habilidad habilidad = habilidadRepo.findById(id).get();
            // eliminar
            habilidadRepo.delete(habilidad);
            response.setStatusCode(200);
        }
        catch (Exception e){
            response.setStatusCode(500);
        }
        return response;
    }
}

