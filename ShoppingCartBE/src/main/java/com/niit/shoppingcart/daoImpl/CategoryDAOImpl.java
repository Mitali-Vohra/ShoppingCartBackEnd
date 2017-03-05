package com.niit.shoppingcart.daoImpl;

import javax.transaction.Transactional;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.domain.Category;

@Transactional
@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO
{
	@Autowired
	SessionFactory sessionFactory;
	
	public CategoryDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}
	
	
	
	@SuppressWarnings("unchecked")
	public List<Category> getAllCategories() {
		return sessionFactory.getCurrentSession().createQuery("from Category").list();
	}

	
	public boolean createCategory(Category category) {
		try
		{
			sessionFactory.getCurrentSession().save(category);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}


	public boolean updateCategory(Category category) {
		try
		{
			sessionFactory.getCurrentSession().update(category);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(Category category) {
		try
		{
			sessionFactory.getCurrentSession().delete(category);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(String id) {
		try
		{
			sessionFactory.getCurrentSession().delete(getCategoryById(id));
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	@SuppressWarnings("deprecation")
	public Category getCategoryById(String id) {
		return (Category) sessionFactory.getCurrentSession().createQuery("from Category where id='"+id+"'").uniqueResult();
	}

	@SuppressWarnings("deprecation")
	public Category getCategoryByName(String name) {
		return (Category) sessionFactory.getCurrentSession().createQuery("from Category where name='"+name+"'").list().get(0);
	}
	
}
