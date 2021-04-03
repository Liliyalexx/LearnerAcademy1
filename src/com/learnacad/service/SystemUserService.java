package com.learnacad.service;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.learnacad.model.SystemUser;
import com.learnacad.util.HibernateUtil;

public class SystemUserService {
	public List<SystemUser> getSystemUserList() {
		SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

        session.beginTransaction();
        
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<SystemUser> criteria = builder.createQuery(SystemUser.class);
        criteria.from(SystemUser.class);
        List<SystemUser> systemUserList = session.createQuery(criteria).getResultList();
        
        session.getTransaction().commit();
        
        session.close();
        
        return systemUserList;
	}
}

