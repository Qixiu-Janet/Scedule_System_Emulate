package com.scehdulesystem.domain.repository;
import java.util.HashSet;
import java.util.Set;

import com.scehdulesystem.domain.Product;


public class InMemoryProductRepository {
   private Set<Product> listOfProducts = new HashSet<Product>();

   public InMemoryProductRepository() {
	   // the service time there is in munites
	   Product p1=new Product();
		p1.setPname("HairCut");
	    p1.setP_id(1); 
		p1.setService_time(30);
	    Product p2=new Product();
		p2.setPname("Shampoo & Haircut");
	    p2.setP_id(2); 
		p2.setService_time(60);
		listOfProducts.add(p1);
		listOfProducts.add(p2);	
	  }
public Set<Product> getAllProducts() {
	return listOfProducts;
}
 public Product getProductById(int productId) {
	 Product productById=null;
	for(Product product : listOfProducts) {
	 if(product!=null  &&
		product.getP_id()==productId){
		productById = product;
      break;
    } 
     }
	if(productById == null){
		System.out.println("No products found withtheproduct id: "+ productId);
		}
return productById;
}
public void addProduct(Product product) {
	listOfProducts.add(product);
}


}