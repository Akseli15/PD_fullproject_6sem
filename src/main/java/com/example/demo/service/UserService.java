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
        Role existingRole = getRoleById(role.getId());
        if (existingRole != null) {
            existingRole.setName(role.getName());
            roleRepository.save(existingRole);
        }
    }

    //-------------------- Сервисы пользователей -------------------------

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUserById(Long id){
        return userRepository.findById(id).orElse(null);
    }

    public User getUserByUsername(String username){
        return userRepository.findByUsername(username);
    }

    public void createUser(User user){
        Role role = roleRepository.findById(user.getRole().getId()).orElse(null);
        if (role != null) {
            user.setRole(role);
            userRepository.save(user);
        } else {
            throw new IllegalArgumentException("Role not found");
        }
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }

    public void updateUser(User user){
        User existingUser = getUserById(user.getId());
        if (existingUser != null) {
            Role role = roleRepository.findById(user.getRole().getId()).orElse(null);
            if (role != null) {
                existingUser.setUsername(user.getUsername());
                existingUser.setPassword(user.getPassword());
                existingUser.setEmail(user.getEmail());
                existingUser.setRole(role);
                userRepository.save(existingUser);
            } else {
                throw new IllegalArgumentException("Role not found");
            }
        }
    }
}
