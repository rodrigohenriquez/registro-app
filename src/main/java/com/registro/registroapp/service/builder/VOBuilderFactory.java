package com.registro.registroapp.service.builder;

import com.registro.registroapp.repository.model.Phone;
import com.registro.registroapp.repository.model.Usuario;

public class VOBuilderFactory {

    private VOBuilderFactory(){}

    public static UsuarioVOBuilder getUsuarioVOBuilder() {
        return new UsuarioVOBuilder();
    }

    public static UsuarioVOBuilder getUsuarioVOBuilder(Usuario usuario) {
        return new UsuarioVOBuilder().fromUsuario(usuario);
    }

    public static PhoneVOBuilder getPhoneVOBuilder() {
        return new PhoneVOBuilder();
    }

    public static PhoneVOBuilder getPhoneVOBuilder(Phone phone) {
        return new PhoneVOBuilder().fromPhone(phone);
    }
}
