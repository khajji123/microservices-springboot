package com.khalil.userservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.khalil.userservice.model.User;

/**
 * User Repository
 * 
 * @author SayedBaladoh
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	List<User> findBySiteId(Long siteId);

	List<User> findByOrganizationId(Long organizationId);
}
