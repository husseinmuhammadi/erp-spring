package com.digiboy.erp.service;

import com.digiboy.erp.repository.UserRepository;
import com.digiboy.erp.to.User;
import com.digiboy.erp.type.Principal;
import com.digiboy.erp.utils.JsonUtil;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.transaction.Transactional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserDetailServiceImpl implements UserDetailsService {

    private final Logger logger;

    @Autowired
    UserRepository repository;

    public UserDetailServiceImpl(Logger logger) {
        this.logger = logger;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("Get user {} from database", username);
        User user = repository.findByUsername(username);
        if (user == null)
            throw new UsernameNotFoundException(username);
        logger.info(JsonUtil.jsonString(user));
        Set<GrantedAuthority> grantedAuthorities = user.getRoles()
                .stream()
                .map(role -> {
                    Assert.isTrue(!role.getName().startsWith("ROLE_"), () -> role + " cannot start with ROLE_ (it is automatically added)");
                    return new SimpleGrantedAuthority("ROLE_" + role.getName());
                }).collect(Collectors.toSet());
        logger.info(JsonUtil.jsonString(grantedAuthorities));
        Principal principal = new Principal(user.getUsername(), user.getPassword(), grantedAuthorities);
        principal.setEmail(user.getEmail());
        return principal;
    }
}

