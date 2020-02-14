package com.registro.registroapp.controller;

import com.registro.registroapp.service.UsuarioService;
import com.registro.registroapp.service.builder.model.UsuarioVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public UsuarioVO save(@RequestBody UsuarioVO usuarioVO){
        return usuarioService.save(usuarioVO);
    }

    @GetMapping("/{id}")
    public UsuarioVO find(@PathVariable("id") Long id){
        return usuarioService.find(id);
    }

    @GetMapping
    public List<UsuarioVO> list(){
        return usuarioService.list();
    }

    @PutMapping
    public UsuarioVO update(@RequestBody UsuarioVO usuarioVO){
        return usuarioService.update(usuarioVO);
    }

    @DeleteMapping
    public UsuarioVO delete(@RequestBody UsuarioVO usuarioVO){
        return usuarioService.delete(usuarioVO);
    }


}
