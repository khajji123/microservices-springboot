package com.khalil.siteservice.controller;

import com.khalil.siteservice.model.Site;
import com.khalil.siteservice.service.SiteService;
import com.khalil.siteservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class SiteController {

	@Autowired
	private SiteService siteService;

	@Autowired
	private UserService userService;

	@PostMapping
	public Site add(@RequestBody Site site) {
		return siteService.save(site);
	}

	@GetMapping
	public List<Site> findAll() {
		return siteService.getAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable("id") Long id) {
		Optional<Site> site = siteService.get(id);
		if (site.isPresent())
			return new ResponseEntity<>(site.get(), HttpStatus.OK);
		else
			return new ResponseEntity<>("Site not found with id: " + id, HttpStatus.NOT_FOUND);
	}

	@GetMapping("/organization/{organizationId}")
	public List<Site> findByOrganization(@PathVariable("organizationId") Long organizationId) {
		return siteService.getByOrganizationId(organizationId);
	}

	@GetMapping("/organization/{organizationId}/with-users")
	public List<Site> findByOrganizationWithUsers(@PathVariable("organizationId") Long organizationId) {
		List<Site> sites = siteService.getByOrganizationId(organizationId);
		sites.forEach(s -> s.setUsers(userService.findBySiteId(s.getId())));
		return sites;
	}
}
