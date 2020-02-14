package com.registro.registroapp.service.builder;

import com.registro.registroapp.repository.model.Usuario;
import com.registro.registroapp.service.builder.model.UsuarioVO;
import java.util.stream.Collectors;

public class UsuarioVOBuilder {

    private Usuario usuario;

    public UsuarioVOBuilder fromUsuario(Usuario usuario){
        this.usuario = usuario;
        return this;
    }

    public UsuarioVO build(){
        if (usuario == null) return null;

        UsuarioVO usuarioVO = new UsuarioVO();
        usuarioVO.setId(usuario.getId());
        usuarioVO.setName(usuario.getName());
        usuarioVO.setEmail(usuario.getEmail());
        usuarioVO.setPassword(usuario.getPassword());
        usuarioVO.setCreated(usuario.getCreated());
        usuarioVO.setModified(usuario.getModified());
        usuarioVO.setLastLogin(usuario.getLastLogin());
        usuarioVO.setToken(usuario.getToken());
        usuarioVO.setActive(usuario.getActive());
        if (usuario.getPhones() != null){
            usuarioVO.setPhones(
                    usuario.getPhones().stream()
                    .map(VOBuilderFactory::getPhoneVOBuilder)
                    .map(PhoneVOBuilder::build)
                    .collect(Collectors.toList())
            );
        }
        return usuarioVO;
    }
}
