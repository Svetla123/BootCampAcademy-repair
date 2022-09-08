package com.BootCampAcademy.demo.repository;
import com.BootCampAcademy.demo.model.AppUser;
import com.BootCampAcademy.demo.model.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    UserProfile findByUsername(String username);
}
