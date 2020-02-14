package com.registro.registroapp.repository;

import com.registro.registroapp.repository.model.Phone;

import java.util.List;

public interface PhoneDAO {

    Phone save(Phone phone);
    Phone update(Phone phone);
    Phone delete(Phone phone);
    Phone find(Long id);
    List<Phone> list();
}
