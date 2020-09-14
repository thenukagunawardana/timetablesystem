
package com.eea.timetablesystem.Service;


import com.eea.timetablesystem.DTO.UserRegistration;
import com.eea.timetablesystem.Model.Role;
import com.eea.timetablesystem.Model.User;
import com.eea.timetablesystem.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService
{
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository)
    {
        super();
        this.userRepository = userRepository;
    }

   @Override
    public User save(UserRegistration registration)
    {
        User user=new User(registration.getFirstName(),registration.getLastName()
        ,registration.getEmail(),passwordEncoder.encode(registration.getPassword()),Arrays.asList(new Role("ROLE_USER")));

        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        User user =userRepository.findByEmail(username);
        if (user==null)
        {
            throw new UsernameNotFoundException("Invalid Username or Password");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword()
                ,mapRolesToAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role>roles)
    {
        roles.stream().map(role-> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());


        return null;
    }
}

