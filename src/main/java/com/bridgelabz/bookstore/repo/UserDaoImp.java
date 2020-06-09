package com.bridgelabz.bookstore.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bridgelabz.bookstore.model.User;

@Repository
@Transactional
public class UserDaoImp implements UserRepo {

	@Autowired
	private SessionFactory sessionFactory;

	public void addUser(User user) {
		sessionFactory.getCurrentSession().save(user);
	}

	public User findByUserId(Long id) {
		return sessionFactory.getCurrentSession().get(User.class, id);
	}

	public List<User> getUser() {
		Session session = sessionFactory.getCurrentSession();
		String hql = "FROM User";
		Query query = session.createQuery(hql);
		List results = query.list();
		return results;
	}

	public User update(User val, Long id) {
		Session session = sessionFactory.getCurrentSession();
		User user = (User) session.get(User.class, id);
		user.setCity(val.getCity());
		user.setFirstName(val.getFirstName());
		session.update(user);
		return user;
	}

	public void delete(Long id) {
		Session session = sessionFactory.getCurrentSession();
		User user = findByUserId(id);
		session.delete(user);
	}

	@Override
	public List<User> findByEmail(String email) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "FROM User E WHERE E.email = :email";
		Query query = session.createQuery(hql);
		query.setParameter("email", email);
		List results = query.list();
		return results;
	}

	@Override
	public void verify(Long id) {
		Session session = sessionFactory.getCurrentSession();
		User user = (User) session.get(User.class, id);
		user.setVerify(true);
		session.update(user);
	}

}