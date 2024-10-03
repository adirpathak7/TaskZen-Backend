/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.it.taskzenapp.repositories;

import com.it.taskzenapp.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Aditya Pathak R
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    UserEntity findByEmail(String email);
}
