package com.yoprogramo.ddback.controllers;

import com.yoprogramo.ddback.dto.request.LoginRequest;
import com.yoprogramo.ddback.dto.request.LogoutRequest;
import com.yoprogramo.ddback.dto.response.BaseResponse;
import com.yoprogramo.ddback.dto.response.LoginResponse;
import com.yoprogramo.ddback.models.Usuario;
import com.yoprogramo.ddback.repositories.UsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/auth")
public class AuthController {
    @Autowired
    UsuarioRepo usuarioRepo;
    @CrossOrigin(origins = "*")
    @PostMapping(path="/login")
    public @ResponseBody LoginResponse login(@RequestBody LoginRequest request){
        LoginResponse response = new LoginResponse();
        try{
            Usuario usuario = usuarioRepo.login(request.getUsername(), request.getPassword());
            if (usuario != null){
                response.setAccessToken(usuario.getUsername());
                response.setStatusCode(200);
            }
            else {
                response.setStatusCode(401); // no autorizado
            }
        }
        catch (Exception e){
            response.setStatusCode(500);
        }
        return response;
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path="/logout")
    public @ResponseBody BaseResponse logout(@RequestBody LogoutRequest request) {
        BaseResponse response = new BaseResponse();
        try{
            Usuario usuario = usuarioRepo.logout(request.getAccessToken());
            if (usuario != null){
                response.setStatusCode(200);
            }
            else {
                response.setStatusCode(401);
            }
        }
        catch (Exception e){
            response.setStatusCode(500);
        }
        return response;
    }
}
