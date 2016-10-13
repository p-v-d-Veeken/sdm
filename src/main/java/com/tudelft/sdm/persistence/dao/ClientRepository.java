package com.tudelft.sdm.persistence.dao;

import com.tudelft.sdm.persistence.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client, Long> {
}
