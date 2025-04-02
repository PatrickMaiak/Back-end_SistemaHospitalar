//package com.patrickmaia.demo.controller;
//
//import com.patrickmaia.demo.service.JwtService;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/auth")
//public class AuthController {
//
//    private final JwtService jwtService;
//
//    public AuthController(JwtService jwtService) {
//        this.jwtService = jwtService;
//    }
//
//    @PostMapping("/login")
//    public String login(@RequestParam String username, @RequestParam String password) {
//        // Valide o usuário com seu banco de dados, se necessário.
//        // Se a validação for bem-sucedida, gere e retorne o JWT.
//
//        // Aqui, estamos apenas retornando o token com base no nome de usuário.
//        return jwtService.generateToken(username);
//    }
//}
