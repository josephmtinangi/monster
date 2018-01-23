package io.github.josephmtinangi.monster.services;

import io.github.josephmtinangi.monster.models.Job;
import io.github.josephmtinangi.monster.repositories.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;

    @PersistenceContext
    private EntityManager em;

    public List<Job> whereTitleStartsWith(String l) {

        String letter = l.toUpperCase();

        String sql = "SELECT j FROM Job j WHERE UPPER(j.title) LIKE '" + letter + "%'";
        TypedQuery<Job> query = em.createQuery(sql, Job.class);

        return query.getResultList();
    }
}
