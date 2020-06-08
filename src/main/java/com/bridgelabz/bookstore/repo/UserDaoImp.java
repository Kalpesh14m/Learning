package com.bridgelabz.bookstore.repo;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bridgelabz.bookstore.model.User;

@Repository
public class UserDaoImp implements UserRepo {

	@Autowired
	private SessionFactory sessionFactory;

	public void addUser(User user) {
		sessionFactory.getCurrentSession().save(user);
	}

	public User findById(Long id) {
		return sessionFactory.getCurrentSession().get(User.class, id);
	}

	public List<User> getUser() {
		return sessionFactory.getCurrentSession().createQuery("FROM User").list();
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
		User user = findById(id);
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

}