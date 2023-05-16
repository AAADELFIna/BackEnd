package com.yoprogramo.ddback.controllers;

import com.yoprogramo.ddback.dto.request.UpdateExperienciasRequest;
import com.yoprogramo.ddback.dto.request.UpdateInfoBasicaRequest;
import com.yoprogramo.ddback.dto.response.BaseResponse;
import com.yoprogramo.ddback.dto.response.GetExperienciasResponse;
import com.yoprogramo.ddback.dto.response.GetInfoBasicaResponse;
import com.yoprogramo.ddback.models.Experiencia;
import com.yoprogramo.ddback.models.InfoBasica;
import com.yoprogramo.ddback.repositories.ExperienciaRepo;
import com.yoprogramo.ddback.repositories.InfoBasicaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path="/infobasica") //ruta base del controlador
public class InfoBasicaController {
    @Autowired
    private InfoBasicaRepo infoBasicaRepo;

    @CrossOrigin(origins = "*")
    @GetMapping
    public @ResponseBody GetInfoBasicaResponse getInfoBasica(){
        GetInfoBasicaResponse response = new GetInfoBasicaResponse();

        try {
            List<InfoBasica> result = infoBasicaRepo.findAll(); // a traves del repo, trae todos los datos de la tabla
            InfoBasica infoBasica;
            // Si hay datos, colocar el primer resultado
            if (result != null && !result.isEmpty()){
                infoBasica = result.get(0);
            }
            // Si no hay nada, colocar datos por defecto y guardarlos
            else {
                infoBasica = new InfoBasica("Delfina Dominguez", "Full-stack Developer Jr.", "");
                infoBasicaRepo.save(infoBasica);
            }
            response.setInfoBasica(infoBasica); // los datos obtenidos se colocan en el objeto del response
            response.setStatusCode(200);
        }
        catch(Exception e){
            response.setStatusCode(500);
        }
        return response;
    }

    @CrossOrigin(origins = "*")
    @PutMapping(path="/:id")
    public @ResponseBody BaseResponse updateInfoBasica(@RequestParam Long id, //parametro de id en la ruta
                                                         @RequestBody UpdateInfoBasicaRequest request){ //el cuerpo del request con los datos a actualizar

        BaseResponse response = new BaseResponse();
        try {
            InfoBasica infoBasica = infoBasicaRepo.findById(id).get(); // obtener un unico registro por el id que es univoco
            // actualizar los datos existentes
            // "infoBasica" tiene lo que esta en la base de datos
            // "request" tiene lo que estamos enviando para actualizar
            infoBasica.setAcerca(request.getAcerca());
            infoBasica.setNombre(request.getNombre());
            infoBasica.setCargo(request.getCargo());
            infoBasicaRepo.save(infoBasica);
            response.setStatusCode(200);
        }
        catch (Exception e){
            response.setStatusCode(500);
        }
        return response;
    }
}
