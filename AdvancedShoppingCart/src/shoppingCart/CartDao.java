package shoppingCart;

import org.hibernate.Session;  
import org.hibernate.Transaction;  
import org.hibernate.cfg.Configuration;  
  
public class CartDao {  
  
public static int register(Cart c){  
 int i=0;  
 Session session=new Configuration().  
  configure().buildSessionFactory().openSession();  
          
  Transaction t=session.beginTransaction();  
  t.begin();
  //System.out.println(session.save(u).getClass().getName());
                  
  i=(Integer)session.save(c);  
                  
  t.commit();  
  session.close();  
    
  return i;  
 }  

public static int updateQuant(Integer quant,String name)
{
	int i=0;
	Session session=new Configuration().  
			  configure().buildSessionFactory().openSession();  
	 Transaction t=session.beginTransaction();  
	  t.begin();
	  String hqlUpdate = "update Cart set quantity = :quant where itemId = :name";
	   i = session.createQuery( hqlUpdate )
		        .setParameter( "quant", quant )
		        .setString("name",name )
		        .executeUpdate();
		t.commit();
		session.close();
	
	return i;
}
}  

