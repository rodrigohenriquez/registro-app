package com.registro.registroapp.repository.impl;

import com.registro.registroapp.repository.UsuarioDAO;
import com.registro.registroapp.repository.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UsuarioDAOImpl implements UsuarioDAO {

    @Autowired
    private EntityManager em;

    @Override
    @Transactional
    public Usuario save(Usuario usuario) {
        em.persist(usuario);
        return usuario;
    }

    @Override
    @Transactional
    public Usuario update(Usuario usuario) {
        em.merge(usuario);
        return usuario;
    }

    @Override
    @Transactional
    public Usuario delete(Usuario usuario) {
        em.remove(usuario);
        return usuario;
    }

    @Override
    public Usuario find(Long id) {
        return em.find(Usuario.class, id);
    }

    @Override
    public Usuario findByEmail(String email) {
        TypedQuery<Usuario> query = em.createQuery("select u from Usuario u where u.email = :email", Usuario.class);
        query.setParameter("email", email);
        return query.getResultList().size() > 0 ? query.getSingleResult() : new Usuario();

    }

    @Override
    public List<Usuario> list() {
        return em.createQuery("from Usuario", Usuario.class).getResultList();
    }
}
