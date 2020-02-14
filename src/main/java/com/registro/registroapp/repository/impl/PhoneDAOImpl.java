package com.registro.registroapp.repository.impl;

import com.registro.registroapp.repository.PhoneDAO;
import com.registro.registroapp.repository.model.Phone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class PhoneDAOImpl implements PhoneDAO {

    @Autowired
    private EntityManager em;

    @Override
    @Transactional
    public Phone save(Phone phone){
        em.persist(phone);
        return phone;
    }

    @Override
    public Phone update(Phone phone){
        em.merge(phone);
        return phone;
    }

    @Override
    public Phone delete(Phone phone){
        em.remove(phone);
        return phone;
    }

    @Override
    public Phone find(Long id){
        return em.find(Phone.class, id);
    }

    @Override
    public List<Phone> list(){
        return em.createQuery("from Phone", Phone.class).getResultList();
    }
}
