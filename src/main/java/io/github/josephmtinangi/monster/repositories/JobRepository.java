package io.github.josephmtinangi.monster.repositories;

import io.github.josephmtinangi.monster.models.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {
}
