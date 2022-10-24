package org.example.dao;

import org.example.entity.Task;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


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
}
