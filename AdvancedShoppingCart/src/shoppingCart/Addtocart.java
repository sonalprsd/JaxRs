package shoppingCart;
import shoppingCart.CartDao;
import shoppingCart.Cart;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebServlet(description = "A simple servlet" , urlPatterns = {"/Addtocartpath"})
public class Addtocart extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        Cart shoppingCart;
        int tp=0,quan=0,sign = 0,tp1=0;
        shoppingCart = (Cart) session.getAttribute("cart");
        if(shoppingCart == null){
        	quan = 1;
          shoppingCart = new Cart();
          session.setAttribute("cart", shoppingCart);
          String name = request.getParameter("name");
          // System.out.println(request.getParameter("price"));
           Integer price = Integer.parseInt(request.getParameter("price"));
           Integer totalprice = price;
           Integer quantity = Integer.parseInt("1");
           shoppingCart.addToCart(name, price, quantity, totalprice);
           Cart c = new Cart();
           c.itemId = name;
           c.price=price;
           c.totalPrice=totalprice;
           c.quantity=quantity;
           int i=CartDao.register(c);
           if(i>0) System.out.println("Successfully persisted");
        }
        else{
        	Vector<Cart> items = shoppingCart.getCartItems();
        	  Iterator i = items.iterator();
        	 int index=0;
        	 while (sign==0 && i.hasNext()) {
        		 index+=1;
        		 Cart it = (Cart)i.next();
        		 String str1=(String)request.getParameter("name");
        		 String str2 = it.itemId;
        		 if(str1.equals(str2)){
        			 
        			 String name = request.getParameter("name");
        			  tp1 = Integer.parseInt(request.getParameter("price")) ;
        			
        			  quan = 1 + it.quantity;
        				tp=tp1*quan;
        			  Integer price = Integer.parseInt(request.getParameter("price"));
      		          Integer totalprice = (Integer)tp;
      		          Integer quantity = (Integer)quan; 
        			  sign=1;
        			  shoppingCart.editCart(name, price, quantity, totalprice, index-1);
        			  
        			  int k=CartDao.updateQuant(quantity, name);
        	           if(k>0) System.out.println("Successfully persisted");
        			  
        			  break;
        		 }
        	 }
        		 if(sign==0){
        			 tp = Integer.parseInt(request.getParameter("price")) ;
        			 quan = 1;
        			 String name = request.getParameter("name");
        		       // System.out.println(request.getParameter("price"));
        		        Integer price = Integer.parseInt(request.getParameter("price"));
        		        Integer totalprice = (Integer)tp;
        		        Integer quantity = (Integer)quan;
        		        shoppingCart.addToCart(name, price,quantity,totalprice); 
        		        Cart c = new Cart();
        		           c.itemId = name;
        		           c.price=price;
        		           c.totalPrice=totalprice;
        		           c.quantity=quantity;
        		           int j=CartDao.register(c);
        		           if(j>0) System.out.println("Successfully persisted");
        		 }
               
        	
       /* String name = request.getParameter("name");
       // System.out.println(request.getParameter("price"));
        Integer price = Integer.parseInt(request.getParameter("price"));
        Integer totalprice = (Integer)tp;
        Integer quantity = (Integer)quan;
        shoppingCart.addToCart(name, price,quantity,totalprice);    */ 
      //  }
        }
        session.setAttribute("cart", shoppingCart);
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>result</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Pizza successfully added to cart </h1>");
            out.println("<form action='index.jsp'>Add more pizza item<input type='submit' value='go'></form>");
            out.println("<hr>");
            out.println("<h2>Cart</h2>");
            Vector<Cart> items1 = shoppingCart.getCartItems();
            out.println("<table border='1px'>");
             
            Iterator i1 = items1.iterator();
            while (i1.hasNext()) {
              //System.out.println(i.next());
            	Cart c=(Cart)i1.next();
            	out.println("<tr><td>"+c.itemId+" - </td><td>"+" "+c.quantity+"</td><td>"+"$"+c.totalPrice+"</td></tr>");
               // out.println("<tr><td>"+i.next()+" - </td><td>"+"$"+items.get(key)+"</td><td>"+"$"+items.get(key)+"</td></tr>");
            }
            out.println("<table>");
            out.println("</body>");
            out.println("</html>");
            out.close();
             
        }
    }
}
