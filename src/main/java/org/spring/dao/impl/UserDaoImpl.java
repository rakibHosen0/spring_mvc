package org.spring.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.spring.dao.UserDao;
import org.spring.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Primary;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Service;

import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import java.util.List;
import java.util.Objects;

@Service
public class UserDaoImpl implements UserDao {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<User> getAllUsers() {
        Session session = null;

        try {
            session = sessionFactory.getObject().getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.getObject().openSession();
        }
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class);
        Root<User> root = cq.from(User.class);
        cq.select(root);
        Query query = session.createQuery(cq);
        List<User>resultList = query.getResultList();
        return resultList;
    }

    @Override
    public void saveUser(User user) {

    }

    @Override
    public User getUser(Long id) {
        return null;
    }

    @Override
    public void deleteUser(User user) {

    }
}
