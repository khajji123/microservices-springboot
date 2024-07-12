package com.khalil.siteservice.service;

import com.khalil.siteservice.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private RestTemplate restTemplate;

    public List<User> findBySiteId(Long siteId) {
        String url = "http://user-service/site/" + siteId;
        User[] users = restTemplate.getForObject(url, User[].class);
        return Arrays.asList(users);
    }
}
