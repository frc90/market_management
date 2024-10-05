package com.market_management.market_management.repositories;

import com.market_management.market_management.models.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocalRepository extends JpaRepository<Local, Long> {
//    public Local findByName(String name);

    @Query("select l from Local l where l.name = :name")
    List<Local> findLocalByNameWithJPQL(String name);
}
