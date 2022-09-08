package com.BootCampAcademy.demo.service;
import com.BootCampAcademy.demo.model.AppUser;
import java.util.List;

public interface IAppUserService {
    AppUser findUserById(Long id);
    List<AppUser> findAllUsers();

    boolean deleteUser(long id);

    AppUser createUser(AppUser user);

    AppUser updateUser(AppUser user, long id);

    Long findUserByUsername(String username);
}
