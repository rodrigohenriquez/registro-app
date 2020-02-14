package com.registro.registroapp.service;


import com.registro.registroapp.service.builder.model.PhoneVO;

import java.util.List;

public interface PhoneService {

    PhoneVO save(PhoneVO phoneVO);
    PhoneVO update(PhoneVO phoneVO);
    PhoneVO delete(PhoneVO phoneVO);
    PhoneVO find(Long id);
    List<PhoneVO> list();
}
