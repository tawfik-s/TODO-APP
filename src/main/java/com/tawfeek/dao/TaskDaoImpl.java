package com.tawfeek.dao;

import com.tawfeek.entity.Task;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class TaskDaoImpl implements TaskDao{
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    public List<Task> getTasks() {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // create a query
        Query<Task> theQuery =
                currentSession.createQuery("from Task", Task.class);

        // execute query and get result list
        List<Task> tasks = theQuery.getResultList();

        // return the results
        return tasks;
    }

    public void saveTask(Task task) {
        System.out.println(task);

        Session currentSession=sessionFactory.getCurrentSession();
        System.out.println(task);

        currentSession.saveOrUpdate(task);

    }

    public Task getTask(long theId) {
        Session currentSession = sessionFactory.getCurrentSession();

        // create a query
        Query<Task> theQuery =
                currentSession.createQuery("from Task where id="+theId, Task.class);

        // execute query and get result list
        Task task = theQuery.getSingleResult();

        return task;
    }

    public void deleteTask(long theId) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query theQuery =
                currentSession.createQuery("delete from Task where id=:theId");
        theQuery.setParameter("theId",theId);
        theQuery.executeUpdate();


    }
}
