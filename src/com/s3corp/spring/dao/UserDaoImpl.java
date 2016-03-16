package com.s3corp.spring.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.s3corp.spring.model.User;

public class UserDaoImpl implements UserDao{

	private SessionFactory sessionFactory;

	public UserDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<User> listUser() {
		String hsql = "FROM User";
		Query query = sessionFactory.getCurrentSession().createQuery(hsql);
		return query.list();
		/*List<User> listUser = (List<User>) sessionFactory.getCurrentSession().createCriteria(User.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listUser;*/
	}

	@Override
	@Transactional
	public User findUser(long id) {
		String hql = "FROM User WHERE user_id = :id";
		Query  query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter("id", id);
		return (User) query.list().get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<User> findUser(String name) {
		String hql = "FROM User WHERE name LIKE :name";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.setParameter("name", name + "%").list();
	}

	@Override
	@Transactional
	public void createUser(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.save(user);
	}

	
}
