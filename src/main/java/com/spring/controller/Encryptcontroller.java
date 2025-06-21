package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.entity.encrypt;
import com.spring.repo.Encryptrepo;
import com.spring.services.Secretmsg;

@RestController
@CrossOrigin(origins="https://lock-talk-rouge.vercel.app/")
public class Encryptcontroller {
	@Autowired
	private Encryptrepo er;
	@Autowired 
	private Secretmsg s;
     @PostMapping("/addencrypt")
     public String addmsg(String msg,String password) {
    	String s_msg= s.generatemsg();
    	 encrypt e=new encrypt();
    	 e.setMsg(msg);
    	 e.setPassword(password);
    	 e.setEncryptmsg(s_msg);
    	 er.save(e);
    	 return s_msg;
     }
     @PostMapping("/decrypt")
     public String decrypt(String secret,String password) {
    	List<encrypt> list= er.findByEncryptmsgAndPassword(secret, password);
    	 if(list.size()==1) {
    		 return list.get(0).getMsg();
    	 }
    	 else {
    		 return "Invalid message or password";
    	 }
     }
}

