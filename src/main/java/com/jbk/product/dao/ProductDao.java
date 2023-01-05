package com.jbk.product.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

import com.jbk.product.config.HibernateUtility;
import com.jbk.product.entity.Product;

public class ProductDao {
	
	private SessionFactory sessionFactory;
	
	public ProductDao() {
	 sessionFactory = HibernateUtility.getSessionFactory();
	}

	
	public String saveProduct(Product product){
		Session session = null;
		boolean isAdded=false;
		
		try {
			
			session = sessionFactory.openSession();
			Transaction transaction=session.beginTransaction();
			
			session.save(product);
			
			transaction.commit();
			isAdded=true;
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			if (session != null) {
				
				session.close();
				
			}
		}
		
		if (isAdded) { 
			   return "Saved .";
			}else {
			
			return "Not saved";
		}
		
		}
	
	public Product getProductById(int productId) {
		Session session = null;
		Product product = null;
		try {
			session = sessionFactory.openSession();
			product = session.get(Product.class,productId);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
                if (session != null) {
				
				session.close();
				
			}
			
		}
		return product;
		
	}
	
	public String deleteProductById(int productId) {
		Session session = null;
		String msg=null;
		
		try {
			
		session = sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		Product product = session.get(Product.class,productId);
		
		if (product!=null) {
			session.delete(product);
			transaction.commit();
			msg="Deleted";
			}else {
				
				msg="Product not found for dalete . "+productId;
			}
		
		} catch (Exception e) {
			e.printStackTrace();
			
		}finally {
            if (session != null) {
				
			session.close();
			
		}
		
	}
		
		return msg;
		
		
	}
	
	    public String updatedProduct(Product product) {
	    	Session session=null;
	    	boolean  isUpdated = false;
	    	try {
	    		
	    		session =sessionFactory.openSession();
	    		Transaction transaction = session.beginTransaction();
				Product dbproduct = session.get(Product.class,product.getProductId());
				
				if(dbproduct !=null) {
					session.update(product);
					transaction.commit();
					isUpdated=true;
					
				}
			} catch (Exception e) {
			     e.printStackTrace();
			}finally {
				
				session.close();
				
				
			}
	    	if(isUpdated) {
	    		return "product updated";
	    		
	    	}else {
	    		return "product not exits.";
	    	}
	    	
	    	
	    }
	
        public List<Product> getAllProducts(){
        	
        	Session session = null;
        	List<Product> list = null;
        	
        	try {
        		
        	
        	session =sessionFactory.openSession();
        	
        	Criteria criteria = session.createCriteria(Product.class);
        	
            list = criteria.list();
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
	            if (session != null) {
					
	    			session.close();
	    			
	    		}
			}
		
		return list;
		
        }
        
        	
        	public List<Product> getAllProductsDesc(){
            	
            	Session session = null;
            	List<Product> list = null;
            	
            	try {
            		
            	
            	session =sessionFactory.openSession();
            	
            	Criteria criteria = session.createCriteria(Product.class);
            	
            	criteria.addOrder(Order.desc("productPrice"));
            	
                list = criteria.list();
    				
    			} catch (Exception e) {
    				e.printStackTrace();
    			}finally {
    	            if (session != null) {
    					
    	    			session.close();
    	    			
    	    		}
    			}
    		return list;
            }
        	
                public List<Product> getAllProductsAsc(){
            	
            	Session session = null;
            	List<Product> list = null;
            	
            	try {
            		
            	
            	session =sessionFactory.openSession();
            	
            	Criteria criteria = session.createCriteria(Product.class);
            	
            	criteria.addOrder(Order.asc("productPrice"));
            	
                list = criteria.list();
    				
    			} catch (Exception e) {
    				e.printStackTrace();
    			}finally {
    	            if (session != null) {
    					
    	    			session.close();
    	    			
    	    		}
    			}
    		return list;
            }
             
                public List<Product> getAllProductsBetween(){
                	
                	Session session = null;
                	List<Product> list = null;
                	
                	try {
                		
                	
                	session =sessionFactory.openSession();
                	
                	Criteria criteria = session.createCriteria(Product.class);
                	
                	criteria.setFirstResult(0);
                	criteria.setMaxResults(4);
                	
                    list = criteria.list();
        				
        			} catch (Exception e) {
        				e.printStackTrace();
        			}finally {
        	            if (session != null) {
        					
        	    			session.close();
        	    			
        	    		}
        			}
        		return list;
        
    }   
                
                    public List<Product> restrictionsEx(){
                	
                	Session session = null;
                	List<Product> list = null;
                	
                	try {
                		
                	
                	session =sessionFactory.openSession();
                	
                	Criteria criteria = session.createCriteria(Product.class);
                	
                	criteria.setFirstResult(0);
                	criteria.setMaxResults(3);
                	
                    list = criteria.list();
        				
        			} catch (Exception e) {
        				e.printStackTrace();
        			}finally {
        	            if (session != null) {
        					
        	    			session.close();
        	    			
        	    		}
        			}
        		return list;
        
    }   
        

}