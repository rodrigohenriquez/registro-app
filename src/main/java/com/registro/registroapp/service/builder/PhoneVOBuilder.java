package com.registro.registroapp.service.builder;

import com.registro.registroapp.repository.model.Phone;
import com.registro.registroapp.service.builder.model.PhoneVO;

public class PhoneVOBuilder {

    private Phone phone;

    public PhoneVOBuilder fromPhone(Phone phone) {
        this.phone = phone;
        return this;
    }

    public PhoneVO build() {
        if (phone == null) return null;

        PhoneVO phoneVO = new PhoneVO();
        phoneVO.setId(phone.getId());
        phoneVO.setNumber(phone.getNumber());
        phoneVO.setCitycode(phone.getCitycode());
        phoneVO.setContrycode(phone.getContrycode());
        return phoneVO;
    }

}
