package com.antonov.projyh2.repository;

import com.antonov.projyh2.model.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestRepository extends
        CrudRepository<Request, Long>,
        JpaRepository<Request, Long> {

}
