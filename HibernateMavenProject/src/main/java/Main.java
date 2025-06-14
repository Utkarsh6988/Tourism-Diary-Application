//////In Hibernate, the dialect refers to a specific SQL dialect used by a particular database. 
/////It's a way for Hibernate to understand and interact with different database systems, as each database has its own syntax and features.
//   


//For Students Table


//import org.hibernate.Session;
//
//import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
//import org.hibernate.cfg.Configuration;
//
//public class Main {
//	public static void main(String[] args) {
//         
//		students s1 = new students();
//		
////		students s2 = null;
//		
////		s1.setsName("Utkarsh");
////		s1.setRollNo(101);
////		s1.setsAge(20);
//		
////		s1.setsName("Kiran");
////		s1.setRollNo(102);
////		s1.setsAge(22);
//		
////		s1.setsName("Kapil");
////		s1.setRollNo(103);
////		s1.setsAge(22);
//		
////		s1.setsName("Mahi");
////		s1.setRollNo(104);
////		s1.setsAge(21);
//		
////		s1.setsName("Raunak");
////		s1.setRollNo(105);
////		s1.setsAge(19);
//		
////		s1.setsName("Avni");
////		s1.setRollNo(106);
////		s1.setsAge(21);
//		
////		s1.setsName("Avinash");
////		s1.setRollNo(107);
////		s1.setsAge(25);
//		
////		Configuration cfg= new Configuration(); //Configuration is a class
////		cfg.addAnnotatedClass(students.class);
////		cfg.configure();                                                     // now these three lines are combined and used in one single statement below.
//		
//		
//		SessionFactory sf = new Configuration()
//				.addAnnotatedClass(students.class)
//				.configure()
//				.buildSessionFactory();    //cfg.buildSessionFactory();             //SessionFactory is a interface 
//		
//		
//		Session session = sf.openSession();   //Session is a interface
//		
//		Transaction transaction = session.beginTransaction();  //Transaction is a interface , beginTransaction() returns object of transaction
//		
//		
//		
//		//session.save(s1);  //Save is a deprecated method , so lets use some other method , it will not give error but it is not a good practice for this and upcoming versions
////		session.persist(s1);
//		
////		transaction.commit();
//		
//		
//		
//		//Fetching Data
////		s2 = session.get(students.class, 102);
//		
////		session.merge(s1);  // for updating because update function is deprecated, it will also insert the data if the data is not present with same roll no.
//		
////		transaction.commit();  // without commit it will not update
//		
//		
//		//for deleting                           //First get the object then remove the object
//		s1=session.get(students.class, 107);
//		session.remove(s1);
//		transaction.commit();
//		
//		
//		session.close();
//		sf.close();
//		
//		
////		System.out.println(s1);
//		System.out.println(s2);
//	}
//}



//For Alien Table


//import java.util.Arrays;
//
//import org.hibernate.Session;
//
//import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
//import org.hibernate.cfg.Configuration;
//
//public class Main {
//	public static void main(String[] args) {
//		
//        Laptop l1 = new Laptop();
//        l1.setLid(1);
//        l1.setBrand("Asus");
//        l1.setModel("Rog");
//        l1.setRam(16);
//		
//        Laptop l2 = new Laptop();
//        l2.setLid(2);
//        l2.setBrand("Dell");
//        l2.setModel("XPS");
//        l2.setRam(32);
//        
//        Laptop l3 = new Laptop();
//        l3.setLid(3);
//        l3.setBrand("Apple");
//        l3.setModel("Macbook air");
//        l3.setRam(8);
//        
//		
//		Alien a1 = new Alien();
//		a1.setAid(101);
//		a1.setAname("Navin");
//		a1.setTech("Java");
////		a1.setLaptop(l1);
//		
//		Alien a2 = new Alien();
//		a2.setAid(102);
//		a2.setAname("Harsh");
//		a2.setTech("Python");
//		
////		Alien a3 = new Alien();
////		a3.setAid(103);
////		a3.setAname("Avni");
////		a3.setTech("AI");
//		
//		a1.setLaptops(Arrays.asList(l1,l2));
//		a2.setLaptops(Arrays.asList(l3));
////		a3.setLaptops(Arrays.asList(l1));
//		
////		l1.setAliens(Arrays.asList(a1,a3));
////		l2.setAliens(Arrays.asList(a1,a2));
////		l3.setAliens(Arrays.asList(a2));
//		
//		
////		l1.setAlien(a1);
////		l2.setAlien(a1);
//		
//		
//		SessionFactory sf = new Configuration()
//				.addAnnotatedClass(Alien.class)
//				.addAnnotatedClass(Laptop.class)
//				.configure()
//				.buildSessionFactory();    //cfg.buildSessionFactory();             //SessionFactory is a interface 
//		
//		
//		Session session = sf.openSession();   //Session is a interface
//		
//		Transaction transaction = session.beginTransaction();  //Transaction is a interface , beginTransaction() returns object of transaction
//		
//		session.persist(l1);  // we will persist l1 before a1 because here l1 is primary table and a1 is child table
//		session.persist(l2);
//		session.persist(l3);
//		
//		session.persist(a1);
//		session.persist(a2);
////		session.persist(a3);
//		
//		
//		transaction.commit();
//		
////	     Alien a5 = session.get(Alien.class, 101);
//////	     System.out.println(a5);
//		
//		session.close();
//		
//		
//		Session session1 = sf.openSession();
//		
//		Alien a5 = session1.get(Alien.class, 101);
////	     System.out.println(a5);                      //I am not using print statement still Because of eager fetching it is still firing query for everything
//		
//		session1.close();
//		
//		sf.close();
//		
//		
//	}
//}

//import java.util.Arrays;
//import java.util.List;
//
//import org.hibernate.Session;
//
//import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
//import org.hibernate.cfg.Configuration;
//import org.hibernate.query.Query;
//
//public class Main {
//	public static void main(String[] args) {
//		
//		
//		
//		//inserting data 
//		
////        Laptop l1 = new Laptop();
////        l1.setLid(4);
////        l1.setBrand("Asus");
////        l1.setModel("Strix");
////        l1.setRam(32);
////		
////       
////		
////		SessionFactory sf = new Configuration()
////				.addAnnotatedClass(Laptop.class)
////				.configure()
////				.buildSessionFactory();    //cfg.buildSessionFactory();             //SessionFactory is a interface 
////		
////		
////		Session session = sf.openSession();   //Session is a interface
////		
////		Transaction transaction = session.beginTransaction();  //Transaction is a interface , beginTransaction() returns object of transaction
////		
////		session.persist(l1);  // we will persist l1 before a1 because here l1 is primary table and a1 is child table
////		
////		transaction.commit();
//		
//		
//		// Fetching data  , for fetching transaction making is not required 
//		
//		SessionFactory sf = new Configuration()
//		.addAnnotatedClass(Laptop.class)
//		.configure()
//		.buildSessionFactory();   
//		
//		Session session = sf.openSession();
//		
//		//select * from laptop where ram=32 ->SQL
//		//from laptop where ram=32 ->HQL
//		
//		String brand="Asus";
//		
////		Query query = session.createQuery("from Laptop where ram=32");
////		Query query = session.createQuery("from Laptop where brand like 'Asus'");	
////		Query query = session.createQuery("from Laptop where brand like ?1");
////		Query query = session.createQuery("select model from Laptop where brand like ?1");
//		Query query = session.createQuery("select brand,model from Laptop where brand like ?1");
//		query.setParameter(1, brand);
////		List<Laptop> laptops = query.getResultList();
////		List<String> laptops = query.getResultList();   //String data type is more appropriate when you are fetching one  
//		
//		List<Object[]> laptops = query.getResultList();   //Object type because we are fetching two different columns 
//		
//		for(Object[] data: laptops) {
//			System.out.println((String)data[0] + " " + (String)data[1]);
//		}
//		
////		Laptop l1 = session.get(Laptop.class, 3);
//		
//		System.out.println(laptops);
//		
//
//
//		session.close();
//				
//
//		
//		sf.close();
//		
//		
//	}
//}




import java.rmi.server.LoaderHandler;

import javax.swing.plaf.basic.BasicScrollPaneUI.VSBChangeListener;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
	public static void main(String[] args) {
		
		
		
		
		SessionFactory sf = new Configuration()
		.addAnnotatedClass(Laptop.class)
		.configure()
		.buildSessionFactory();   
		
		Session session = sf.openSession();
		
	
//		load() VS get() or  Eager vs Lazy loading
		
//		Laptop laptop = session.get(Laptop.class, 2);  //It will fire a select query.
//		System.out.println(laptop);
		
//		Laptop laptop = session.load(Laptop.class, 2);  //It will not fire a select query until you add a print statement after a load function, this is difference between load and get,load method is deprecated but gives same result as get()
//		System.out.println(laptop);
		
         //As load is deprecated so alternative is :
//		Laptop laptop = session.byId(Laptop.class).getReference(2);  //It will not fire a select query until you add a print statement after a load function, this is difference between load and get,load method is deprecated but gives same result as get()
//		System.out.println(laptop);
		
		
		
		
		Laptop l1 = session.get(Laptop.class, 2);
		System.out.println(l1);
		
		//If I will make one more laptop object here with same parameters and print the l1 then it will give output two times but will be fired once because session is same , for this we need to make different session.
		

		session.close();
		
		Session session1 = sf.openSession();  // now it will fire two different select queries, because level2 cache is not implementing
		Laptop l2 = session1.get(Laptop.class, 2);
		System.out.println(l2);
		session1.close();
				
		
		// For using level2 cache you need to add dependency of it in pom.xml file and also of jcache dependency
	    //and also add jaxb-runtime dependency in dependency management otherwise maven repositories are blocked in further versions 
		//and then you need to specify annotation in laptop.java file (@Cacheable) then it will fire one query only with multiple sessions and same data.
	
		//Then if facing any problems then add the properties of second_level_cache, JCacheFactory, EhcacheCachingProvider in hibernate.cfg.xml file.

		
		sf.close();
		
		
	}
}

