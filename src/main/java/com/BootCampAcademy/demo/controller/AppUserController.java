package com.BootCampAcademy.demo.controller;
import com.BootCampAcademy.demo.model.AppUser;
import com.BootCampAcademy.demo.service.IAppUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AppUserController {
    private IAppUserService usersService;

    public AppUserController(IAppUserService usersService) {
        super();
        this.usersService = usersService;
    }

    @GetMapping("/api/users")
    public List<AppUser> findAll() {
        List<AppUser> users = this.usersService.findAllUsers();
        return users;
    }

    @GetMapping("/api/users/{id}")
    public ResponseEntity<?> findById (@PathVariable Long id) {
        AppUser user = this.usersService.findUserById(id);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User with id " + id + " not found");
        }
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/api/users/{id}")
    public ResponseEntity<?> delete (@PathVariable Long id) {
        boolean result  = this.usersService.deleteUser(id);

        if (result) {
            return ResponseEntity.ok("User with id " + id + " deleted");
        } else
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User with id " + id + " not found");
        }
    }

    @PostMapping("/api/users")
    public ResponseEntity<?> create (@RequestBody AppUser user) {
        AppUser newUser = this.usersService.createUser(user);
        return ResponseEntity.ok(newUser);
    }

    @PutMapping ("/api/users/{id}")
    public ResponseEntity<?> update (@RequestBody AppUser user, @PathVariable Long id) {
        AppUser updatedUser = this.usersService.updateUser(user, id);
        if (updatedUser == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User with id " + id + " not found");
        }
        return ResponseEntity.ok(updatedUser);
    }
}
