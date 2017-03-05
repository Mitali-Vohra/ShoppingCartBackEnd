package com.niit.shoppingcart.daoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.domain.User;

@Transactional
@Repository("userDAO")
public class UserDAOImpl implements UserDAO {

	@Autowired
	SessionFactory sessionFactory;

	public UserDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public List<User> getAllUsers() {
		return sessionFactory.getCurrentSession().createQuery("from User").list();
	}

	public User getUserById(String userId) {
		return (User) sessionFactory.getCurrentSession().createQuery("from User where userId='"+userId+"'").uniqueResult();
	}

	public User getUserByName(String name) {
		return (User) sessionFactory.getCurrentSession().createQuery("from User where name='"+name+"'").list().get(0);
	}

	public boolean updateUser(User user) {
		try{
			sessionFactory.getCurrentSession().update(user);
			return true;
		} catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteUserById(String userId) {
		try{
			sessionFactory.getCurrentSession().delete(getUserById(userId));
			return true;
		} catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteUser(User user) {
		try{
			sessionFactory.getCurrentSession().delete(user);
			return true;
		} catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	public boolean addUsers(User user) {
		try {
			sessionFactory.getCurrentSession().save(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
