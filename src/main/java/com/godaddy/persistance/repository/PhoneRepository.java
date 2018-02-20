package com.godaddy.persistance.repository;

import com.godaddy.persistance.entity.PhoneEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by sasha on 20.02.2018.
 */
@Repository
public interface PhoneRepository extends JpaRepository<PhoneEntity, String>{
}
