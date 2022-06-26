package com.gjun.service;

import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/api")
public class MyApplication extends Application{

	public MyApplication() {
		System.out.println("REST Service已經啟動了...");
	}
	@Override
	public Set<Class<?>> getClasses() {
		// TODO Auto-generated method stub
		return super.getClasses();
	}
	
}
