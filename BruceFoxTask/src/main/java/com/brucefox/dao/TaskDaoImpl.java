package com.brucefox.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.brucefox.model.Task;;

public class TaskDaoImpl implements TaskDao {


	SessionFactory sessionFactory = new AnnotationConfiguration().configure().
			// addPackage("com.xyz") //add package if used.
			addAnnotatedClass(com.brucefox.model.Task.class).buildSessionFactory();;

	Session ses = null;

	@Override
	public boolean addEntity(Task task) throws Exception {
		ses = sessionFactory.openSession();
		ses.beginTransaction();
		ses.save(task);
		ses.getTransaction().commit();
		ses.close();
		System.out.println("Add Task");
		return false;
	}

	@Override
	public Task getEntityById(long id) throws Exception {
		ses = sessionFactory.openSession();
		Task task = (Task) ses.load(Task.class,
				new Long(id));
		ses.beginTransaction();
		return task;
	}

	@SuppressWarnings("unchecked")
	public List<Task> getEntityList() throws Exception {
		ses = sessionFactory.openSession();
		List<Task> TaskList = ses.createCriteria(Task.class).list();
		ses.close();
		System.out.println("Task List");
		return TaskList;
	}
	
	@Override
	public Task updateTask(Task task) {
		// TODO Auto-generated method stub
		ses = sessionFactory.openSession();
		ses.beginTransaction();
		Task updatedTask = (Task) ses.merge(task);
		ses.getTransaction().commit();
		ses.close();
		System.out.println("update Task");
		return updatedTask;
	}


/*	@Override
	public boolean deleteEntity(long id) throws Exception {
		ses = sessionFactory.openSession();
		Object o = ses.load(Task.class, id);
		ses.beginTransaction();
		ses.delete(o);
		ses.flush();
		return false;
	}*/

}
