package com.spring.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.entity.encrypt;
@Repository
public interface Encryptrepo extends JpaRepository<encrypt,Long> {
	List<encrypt>findByEncryptmsgAndPassword(String encryptmsg,String password);

}
