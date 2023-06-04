package org.spring.dao.impl;

import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.spring.dao.UserDao;
import org.spring.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public User loginUser(String email, String password) {
        Session session = null;
        try{
            session = sessionFactory.getObject().getCurrentSession();
        }catch (HibernateException e){
            session = sessionFactory.getObject().openSession();
        }

        String sql = "FROM User U where U.email=:email AND U.password=:password";
        Query query = session.createQuery(sql);
        query.setParameter("email",email);
        query.setParameter("password",password);
        User user =  (User) query.getSingleResult();
        return user;
    }

    @Override
    public void saveUser(User user) {
        Session session = null;
        try{
           session = sessionFactory.getObject().getCurrentSession();
        }catch (HibernateException e){
            session = sessionFactory.getObject().openSession();
        }
        session.save(user);
    }


    @Override
    public User getUserById(Long id) {
        Session session = null;
        try{
            session = sessionFactory.getObject().getCurrentSession();
        }catch (HibernateException e){
            session = sessionFactory.getObject().openSession();
        }
        User user = session.get(User.class, id);
        return user;
    }

    @Override
    public void deleteUserById(Long id) {
        Session session = null;
        try{
            session = sessionFactory.getObject().getCurrentSession();
        }catch (HibernateException e){
            session = sessionFactory.getObject().openSession();
        }
        User deleteUser = session.load(User.class,id);
        session.delete(deleteUser);
    }

    @Override
    public User updateUserById(Long id){
        Session session = null;
        try{
            session = sessionFactory.getObject().getCurrentSession();
        }catch (HibernateException e){
            session = sessionFactory.getObject().openSession();
        }
        User updateUser = session.get(User.class,id);
        session.persist(updateUser);
        return null;
    }

}
