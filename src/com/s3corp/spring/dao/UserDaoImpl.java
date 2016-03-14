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
	
	public Session getSession(){
		return this.sessionFactory.getCurrentSession();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<User> listUser() {
		String hsql = "FROM User";
		Query query = getSession().createQuery(hsql);
		return query.list();
		/*List<User> listUser = (List<User>) sessionFactory.getCurrentSession().createCriteria(User.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listUser;*/
	}

	@Override
	public User findUser(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
