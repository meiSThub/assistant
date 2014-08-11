package edu.zzuli.assistant.until;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {    
       public static final SessionFactory sessionFactory;    
       public static final ThreadLocal<Session> sessionThreadLocal = new ThreadLocal<Session>();    
       static {    
          try {    

         		Configuration cfg = new Configuration();
        		cfg.configure();
        		sessionFactory = cfg.buildSessionFactory();
           } catch (Throwable ex) {    
               throw new ExceptionInInitializerError(ex);    
           }    
      }    
       public static Session getCurrentSession() throws HibernateException {    
               Session s = sessionThreadLocal.get(); 
               if(s == null) {    
                     s = sessionFactory.openSession();    
                     sessionThreadLocal.set(s);    
               }    
               return s;    
       }    
      public static void closeSession() {    
                Session s = sessionThreadLocal.get();    
                if(s != null) {    
                     s.close();    
                }    
                sessionThreadLocal.set(null);    
       }    
} 


