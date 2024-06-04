package com.example.demo.service;

import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;


    //----------------------- Сервисы ролей ----------------------------

    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    public Role getRoleById(Long id){
        return roleRepository.findById(id).orElse(null);
    }
    public Role getRoleByName(String name){
        return roleRepository.findByName(name);
    }

    public void createRole(Role role){
        roleRepository.save(role);
    }

    public void deleteRole(Long id){
        roleRepository.deleteById(id);
    }

    public void updateRole(Role role){
        Role role1 = getRoleById(role.getId());
        role1.setName(role.getName());
        roleRepository.save(role1);
    }

    //-------------------- Сервисы пользователей -------------------------

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUserById(Long id){
        return userRepository.findById(id).orElse(null);
    }

    public  User getUserByUsername(String username){
        return userRepository.findByUsername(username);
    }

    public void createUser(User user){
        userRepository.save(user);
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }

    public void updateUser(User user){
        User user1 = getUserById(user.getId());
        Role role = roleRepository.getById(user.getRole().getId());
        user1.setUsername(user.getUsername());
        user1.setPassword(user.getPassword());
        user1.setEmail(user.getEmail());
        user1.setRole(role);
        userRepository.save(user1);
    }

}
