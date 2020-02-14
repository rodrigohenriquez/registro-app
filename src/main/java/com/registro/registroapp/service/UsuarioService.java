package com.registro.registroapp.service;

import com.registro.registroapp.service.builder.model.UsuarioVO;

import java.util.List;

public interface UsuarioService {

    UsuarioVO save(UsuarioVO usuarioVO);
    UsuarioVO update(UsuarioVO usuarioVO);
    UsuarioVO delete(UsuarioVO usuarioVO);
    UsuarioVO find(Long id);
    List<UsuarioVO> list();
}
