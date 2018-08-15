package com.Web.BankPayment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Web.BankPayment.models.User;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	public User findByusername(String username);
	public User findByid(Integer id);
}
