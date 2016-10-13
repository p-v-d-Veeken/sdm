package com.tudelft.sdm.persistence.dao;

import com.tudelft.sdm.persistence.Record;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RecordRepository extends CrudRepository<Record, Long> {
    Record findByIdAndClientId(Long id, Long clientId);
    List<Record> findByClientId(Long clientId);
}
