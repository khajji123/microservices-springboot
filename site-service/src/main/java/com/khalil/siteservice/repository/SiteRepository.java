package com.khalil.siteservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.khalil.siteservice.model.Site;

/**
 * Site Repository
 * 
 * @author khalil
 *
 */
@Repository
public interface SiteRepository extends JpaRepository<Site, Long> {

	List<Site> findByOrganizationId(Long organizationId);

}
