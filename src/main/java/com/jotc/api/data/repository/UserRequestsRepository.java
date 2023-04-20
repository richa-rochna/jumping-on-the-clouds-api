package com.jotc.api.data.repository;

import com.jotc.api.data.model.UserRequests;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface UserRequestsRepository extends CrudRepository<UserRequests, Long> {

    @Transactional
    void deleteByEmail(String email);
}
