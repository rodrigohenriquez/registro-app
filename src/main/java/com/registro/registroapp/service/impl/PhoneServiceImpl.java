package com.registro.registroapp.service.impl;

import com.registro.registroapp.repository.PhoneDAO;
import com.registro.registroapp.repository.model.Phone;
import com.registro.registroapp.service.PhoneService;
import com.registro.registroapp.service.builder.PhoneVOBuilder;
import com.registro.registroapp.service.builder.VOBuilderFactory;
import com.registro.registroapp.service.builder.model.PhoneVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PhoneServiceImpl implements PhoneService {

    @Autowired
    private PhoneDAO phoneDAO;

    @Override
    public PhoneVO save(PhoneVO phoneVO) {
        return VOBuilderFactory.getPhoneVOBuilder(phoneDAO.save(copy(new Phone(), phoneVO))).build();
    }

    @Override
    public PhoneVO update(PhoneVO phoneVO) {
        return VOBuilderFactory.getPhoneVOBuilder(phoneDAO.update(copy(new Phone(), phoneVO))).build();
    }

    @Override
    public PhoneVO delete(PhoneVO phoneVO) {
        return VOBuilderFactory.getPhoneVOBuilder(phoneDAO.delete(copy(new Phone(), phoneVO))).build();
    }

    @Override
    public PhoneVO find(Long id) {
        return VOBuilderFactory.getPhoneVOBuilder(phoneDAO.find(id)).build();
    }

    @Override
    public List<PhoneVO> list() {
        return phoneDAO.list().stream()
                .map(VOBuilderFactory::getPhoneVOBuilder)
                .map(PhoneVOBuilder::build)
                .collect(Collectors.toList());
    }

    private Phone copy(Phone phone, PhoneVO phoneVO) {
        return phone;
    }
}
