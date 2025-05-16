package prodinfo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		//Product pr = (Product)context.getBean("");
		//System.out.println(pr.getProdid()+" "+pr.getProdname());
		Customer cus = (Customer)context.getBean("customer");
		Product prd1 = cus.getProduct();
		Product prd2 = cus.getProduct();
		System.out.println(cus.getCustname());
		System.out.println("Product id "+prd2.getProdid());
		System.out.println("Product name "+prd2.getProdname());
		//System.out.println("Customer name is :"+cus.getCustname());

	}

}
