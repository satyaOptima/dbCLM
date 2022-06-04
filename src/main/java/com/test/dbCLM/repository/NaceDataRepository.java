package com.test.dbCLM.repository;

import com.test.dbCLM.entity.NaceData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NaceDataRepository extends JpaRepository<NaceData, Long> {

    public NaceData findByOrder(String order);
}
