package com.registro.registroapp.repository;

import com.registro.registroapp.repository.model.Usuario;

import java.util.List;

public interface UsuarioDAO {

    Usuario save(Usuario usuario);
    Usuario update(Usuario usuario);
    Usuario delete(Usuario usuario);
    Usuario find(Long id);
    Usuario findByEmail(String email);
    List<Usuario> list();

}
