package com.registro.registroapp.service.impl;

import com.registro.registroapp.repository.UsuarioDAO;
import com.registro.registroapp.repository.model.Phone;
import com.registro.registroapp.repository.model.Usuario;
import com.registro.registroapp.service.UsuarioService;
import com.registro.registroapp.service.builder.UsuarioVOBuilder;
import com.registro.registroapp.service.builder.VOBuilderFactory;
import com.registro.registroapp.service.builder.model.UsuarioVO;
import com.registro.registroapp.service.exception.CustomException;
import com.registro.registroapp.service.exception.Message;
import com.registro.registroapp.service.util.DateCalendar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioDAO usuarioDAO;

    @Override
    public UsuarioVO save(UsuarioVO usuarioVO) {
        try {
            if (usuarioDAO.findByEmail(usuarioVO.getEmail()).getId() != null)
                throw new Exception(Message.EMAIL_ALREADY_EXISTS);
        } catch (Exception e) {
            throw new CustomException(e.getMessage());
        }
        return VOBuilderFactory.getUsuarioVOBuilder(usuarioDAO.save(copy(new Usuario(), usuarioVO))).build();
    }

    @Override
    public UsuarioVO update(UsuarioVO usuarioVO) {
        return VOBuilderFactory.getUsuarioVOBuilder(usuarioDAO.update(copy(new Usuario(), usuarioVO))).build();
    }

    @Override
    public UsuarioVO delete(UsuarioVO usuarioVO) {
        return VOBuilderFactory.getUsuarioVOBuilder(usuarioDAO.delete(copy(new Usuario(), usuarioVO))).build();
    }

    @Override
    public UsuarioVO find(Long id) {
        return VOBuilderFactory.getUsuarioVOBuilder(usuarioDAO.find(id)).build();
    }

    @Override
    public List<UsuarioVO> list() {
        return usuarioDAO.list().stream()
                .map(VOBuilderFactory::getUsuarioVOBuilder)
                .map(UsuarioVOBuilder::build)
                .collect(Collectors.toList());
    }

    private Usuario copy(Usuario usuario, UsuarioVO usuarioVO) {
        usuario.setId(usuarioVO.getId());
        usuario.setName(usuarioVO.getName());
        usuario.setEmail(usuarioVO.getEmail());
        usuario.setPassword(usuarioVO.getPassword());
        usuario.setCreated(DateCalendar.now());
        usuario.setModified(DateCalendar.now());
        usuario.setLastLogin(DateCalendar.now());
        if (usuarioVO.getPhones() != null) {
            usuario.setPhones(
                    usuarioVO.getPhones().stream()
                            .map(phoneVO -> {
                                Phone p = new Phone();
                                p.setId(phoneVO.getId());
                                p.setNumber(phoneVO.getNumber());
                                p.setCitycode(phoneVO.getCitycode());
                                p.setContrycode(phoneVO.getContrycode());
                                p.setUsuario(usuario);
                                return p;
                            })
                            .collect(Collectors.toList())
            );
        }
        if (usuarioVO.getActive() == null) {
            usuario.setActive(true);
        } else {
            usuario.setActive(usuarioVO.getActive());
        }
        return usuario;
    }
}
