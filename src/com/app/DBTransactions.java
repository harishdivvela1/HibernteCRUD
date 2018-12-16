package com.app;


import java.util.*;
import java.util.Iterator;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import antlr.collections.List;

public class DBTransactions {
	public static void insertData(Employee e1)
	{
try {
SessionFactory sf=DBConfig.GetConfiguration();
Session s1=sf.openSession();
s1.beginTransaction();
s1.persist(e1);
s1.getTransaction().commit();
s1.close();
}
catch(Exception ex)
{
	ex.printStackTrace();
}
}
	public static void GetRecord(int id)
	{
		SessionFactory sf=DBConfig.GetConfiguration();
		Session s1=sf.openSession();
		s1.beginTransaction();
		Employee e2=(Employee)s1.load(Employee.class,new Integer(id));
		System.out.println("name"+"     " +e2.getName());
	}
	public static void GetData()
	{
		SessionFactory sf=DBConfig.GetConfiguration();
		Session s1=sf.openSession();
		s1.beginTransaction();
		Criteria c1=s1.createCriteria(Employee.class);
		java.util.List emp=c1.list();
		Iterator itr = emp.iterator();
		while(itr.hasNext())
		{
			Employee e3=(Employee)itr.next();
			System.out.println(e3.getId()+" "+e3.getName()+"  "+e3.getMobile());
		}
		s1.close();
		
	}
	
public static void updateData(Employee e1)
{
	
SessionFactory sf=DBConfig.GetConfiguration();
Session s1=sf.openSession();
s1.beginTransaction();
Employee e4 =(Employee)s1.load(Employee.class,e1.getId());
e4.setName(e1.getName());
s1.getTransaction().commit();
s1.close();
}

public static void deleteData(int id)
	
{


	SessionFactory sf=DBConfig.GetConfiguration();
	Session s1=sf.openSession();
	s1.beginTransaction();
	Employee e5=(Employee)s1.load(Employee.class,new Integer(id));
	
	s1.delete(e5);
	s1.getTransaction().commit();
	s1.close();
	
	
}



}













