package com.spring.services;

import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class Secretmsg {
	public String generatemsg(){
       String str="Java-Full-Stack*Hyderbad%Kbhp(NareshIt_-Technology";
       Random r=new Random();
        String Secret="";
        
        for(int i=1;i<=11;i++) {
        	int num=r.nextInt(30);
        	
        	Secret=Secret+str.charAt(num);
        }
        return Secret;
	}
}
