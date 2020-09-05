package com.hokumus.schoolmanagement.dao.util;

import java.lang.reflect.Field;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class DBServices<T>  implements IDBServices<T>{

	private Session session;
	private Transaction transaction;

	public Session getSession() {
		return session;
	}

	public void getSessionAndTrans() {
		session = (Session) MyHibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
	}

	public void closeSesionAndCommit() {
		transaction.commit();
		session.close();
	}

	public void closeSesionAndRoolback() {
		transaction.rollback();
		session.close();
	}
	@Override
	public Boolean kaydet(T temp) {
		try {
			getSessionAndTrans();
			session.save(temp);
			closeSesionAndCommit();
		} catch (Exception e) {
			closeSesionAndRoolback();
			return false;
		}
		
		return true;
	}

	@Override
	public Boolean guncelle(T temp) {
		try {
			getSessionAndTrans();
			session.update(temp);
			closeSesionAndCommit();
		} catch (Exception e) {
			closeSesionAndRoolback();
		}
		return null;
	}

	@Override
	public Boolean sil(T temp) {
		try {
			getSessionAndTrans();
			session.delete(temp);
			closeSesionAndCommit();
		} catch (Exception e) {
			closeSesionAndRoolback();
			return false;
		}
		
		return true;
	}

	@Override
	public List<T> getir(T temp) {
		List<T> liste = null;
		try {
			getSessionAndTrans();
			Criteria cr = session.createCriteria(temp.getClass());
			liste = cr.list();
			closeSesionAndCommit();
		} catch (Exception e) {
			closeSesionAndRoolback();
			return null;
		}
		return liste;
	}

	@Override
	public T bul(Long id, T temp) {
		T result= null;
		try {
			getSessionAndTrans();
			Criteria cr = session.createCriteria(temp.getClass());
			cr.add(Restrictions.eq("id", id));
			result = (T)cr.uniqueResult();
			closeSesionAndCommit();
		} catch (Exception e) {
			closeSesionAndRoolback();
			return null;
		}
		return result;
	}

	@Override
	public T bul(T temp) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> getir(String kolonAdi, String deger, T temp) {
		List<T> liste = null;
		try {
			getSessionAndTrans();
			Criteria cr = session.createCriteria(temp.getClass());
			cr.add(Restrictions.eq(kolonAdi, deger));
			liste = cr.list();
			closeSesionAndCommit();
		} catch (Exception e) {
			closeSesionAndRoolback();
			return null;
		}
		return liste;
	}

	@Override
	public List<T> ara(T temp) {
		List<T> liste = null;
		Class cl = temp.getClass();
		Field[] fields =cl.getDeclaredFields();
		getSessionAndTrans();
		Criteria cr = session.createCriteria(cl);
		for (int i = 0; i < fields.length; i++) {
			fields[i].setAccessible(true);
			try {
				if(fields[i].get(temp) != null) {
					cr.add(Restrictions.ilike(fields[i].getName(), "%"+fields[i].get(temp)+"%"));
				}
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		liste = cr.list();
		return liste;
	}

}
