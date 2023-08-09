package com.example.appSpring.controller;

import com.example.appSpring.DTO.Recebo;
import com.example.appSpring.entity.Mostrar;
import com.example.appSpring.service.ReceboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/api")
public class NumeroController {

    @Autowired
    private ReceboService receboService;

    private Mostrar mostrar;


    @PostMapping("/send")
    public ResponseEntity<?> mandar(@RequestBody Recebo recebo){
        try{
            mostrar = this.receboService.verify(recebo);
            System.out.println(recebo.getNumeroList());
            return ResponseEntity.ok(mostrar);
        }catch (Exception error){
            return ResponseEntity.badRequest().body("Error" + error.getMessage());
        }

    }
}
