package com.app;

import org.hibernate.*;
import org.hibernate.cfg.*;
import org.hibernate.service.*;

public class DBConfig {
	public static SessionFactory GetConfiguration()
	{
		Configuration cfg=new Configuration().configure();
		ServiceRegistryBuilder registry=new ServiceRegistryBuilder();
		
		registry.applySettings(cfg.getProperties());
		ServiceRegistry sr=registry.buildServiceRegistry();
		SessionFactory sf=cfg.buildSessionFactory(sr);
		
		return sf; 
	}

}
