package com.sumup.jobko.repositories;

import com.sumup.jobko.models.Task;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TaskRepositoryImpl implements TaskRepository {
    private final SessionFactory sessionFactory;

    @Autowired
    public TaskRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Task> process() {
        String query = "select distinct task from Task task " +
                "join Task tq on tq.id = task.id " +
                "order by tq.requires.size";
        Session session = sessionFactory.openSession();
        Query<Task> finalQuery = session.createQuery(query, Task.class);
        return finalQuery.list();
    }

    @Override
    public void create(Task task) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(task);
            session.getTransaction().commit();
        }
    }

    @Override
    public void update(Task task) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.update(task);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(int id) {
        Task task = getById(id);
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.delete(task);
            session.getTransaction().commit();
        }
    }

    @Override
    public List<Task> getAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from Task", Task.class).list();
        }
    }

    @Override
    public Task getById(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Task.class, id);
        }
    }

    @Override
    public Task getByName(String name) {
        try (Session session = sessionFactory.openSession()) {
            Query<Task> query = session.createQuery("from Task where name = :name", Task.class);
            query.setParameter("name", name);
            return query.list().get(0);
        }
    }
}