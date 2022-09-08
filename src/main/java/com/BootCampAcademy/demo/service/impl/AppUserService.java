package com.BootCampAcademy.demo.service.impl;

import com.BootCampAcademy.demo.model.AppUser;
import com.BootCampAcademy.demo.repository.AppUserRepository;
import com.BootCampAcademy.demo.service.IAppUserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppUserService implements IAppUserService {
    private AppUserRepository users;
    private AppUserService(AppUserRepository users) {
        super();
        this.users = users;
    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        return new org.springframework.security.core.userdetails.User("admin", "password",new ArrayList<>());
//    }
    @Override
    public AppUser findUserById(Long id) {
        try{
            return this.users.findById(id).get();

        } catch (Exception e) {
            return null;
        }
    }
    @Override
    public List<AppUser> findAllUsers() {
        return this.users.findAll();
    }

    @Override
    public boolean deleteUser(long id) {
        AppUser user = this.findUserById(id);

        try {
            this.users.delete(user);
        }
        catch (Exception e){
            return false;
        }
        finally {
            return true;
        }
    }

    @Override
    public AppUser createUser(AppUser user) {
        return this.users.save(user);
    }

    @Override
    public AppUser updateUser(AppUser user, long id) {
        AppUser oldUser = this.findUserById(id);

        if (oldUser == null) {
            return null;
        } else {
            if (user.getEmail() != null) {
                oldUser.setEmail(user.getEmail());
            }
            if (user.getPassword() != null) {
                oldUser.setPassword(user.getPassword());
            }
            if (user.getArrivalSum() != 0) {
                oldUser.setArrivalSum(user.getArrivalSum());
            }
            if (user.getSumPoints() != 0.0) {
                oldUser.setSumPoints(user.getSumPoints());
            }
            if (user.getUsername() != null) {
                oldUser.setUsername(user.getUsername());
            }
            if (user.getUserProfile() != null) {
                oldUser.setUserProfile(user.getUserProfile());
            }
            if (user.getRole() != null) {
                oldUser.setRole(user.getRole());
            }
            return this.users.save(oldUser);
        }
    }

    public Long findUserByUsername(String username) {
        return this.users.findByUsername(username).getId();
    }
}
