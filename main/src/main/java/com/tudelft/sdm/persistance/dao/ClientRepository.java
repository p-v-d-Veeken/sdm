package com.tudelft.sdm.persistance.dao;

import com.tudelft.sdm.persistance.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client, Long> {
}
