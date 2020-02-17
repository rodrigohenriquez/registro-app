package com.registro.registroapp.controller;

import com.registro.registroapp.service.UsuarioService;
import com.registro.registroapp.service.builder.model.UsuarioVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<UsuarioVO> save(@RequestBody UsuarioVO usuarioVO){

        return new ResponseEntity<>(usuarioService.save(usuarioVO), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioVO> find(@PathVariable("id") Long id){
        return new ResponseEntity<>(usuarioService.find(id), HttpStatus.OK);
    }

    @GetMapping
    public List<UsuarioVO> list(){
        return usuarioService.list();
    }

    @PutMapping
    public ResponseEntity<UsuarioVO> update(@RequestBody UsuarioVO usuarioVO){
        return new ResponseEntity<>(usuarioService.update(usuarioVO), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<UsuarioVO> delete(@RequestBody UsuarioVO usuarioVO){
        return new ResponseEntity<>(usuarioService.delete(usuarioVO), HttpStatus.ACCEPTED);
    }


}
