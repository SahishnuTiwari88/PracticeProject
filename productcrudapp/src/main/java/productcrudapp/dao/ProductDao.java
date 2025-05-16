package productcrudapp.dao;

import java.util.List;

import javax.transaction.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import productcrudapp.model.Product;

@Repository 
 //@Component
public class ProductDao {
	@Autowired
	private HibernateTemplate hibernateTemplate;

	// create
	@Transactional
	public void saveProduct(Product product) {
		this.hibernateTemplate.saveOrUpdate(product);

	}

	// get all product
	public List<Product> getProducts() {
		List<Product> product = this.hibernateTemplate.loadAll(Product.class);
		return product;
	}

	// get single data
	public Product getProduct(int id) {
		Product p = this.hibernateTemplate.get(Product.class, id);
		return p;
	}

	// delete data
	@Transactional
	public void deleteProduct(int id) {
		Product p = this.hibernateTemplate.get(Product.class, id);
		this.hibernateTemplate.delete(p);

	}

	// update data
	@Transactional
	public void updateProduct(Product product) {
		this.hibernateTemplate.update(product);
	}

}
