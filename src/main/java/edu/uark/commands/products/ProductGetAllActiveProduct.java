package edu.uark.commands.products;

import java.util.List;
import java.util.stream.Collectors;

import edu.uark.commands.ResultCommandInterface;
import edu.uark.models.api.Product;
import edu.uark.models.repositories.ProductRepository;
import edu.uark.models.repositories.interfaces.ProductRepositoryInterface;

public class ProductGetAllActiveProduct implements ResultCommandInterface<List<Product>> {
	@Override
	public List<Product> execute() {
		return this.productRepository.
			getAllActiveProductEntity().
			stream().
			map(mp -> (new Product(mp))).
			collect(Collectors.toList());
	}

	//Properties
	private ProductRepositoryInterface productRepository;
	public ProductRepositoryInterface getProductRepository() {
		return this.productRepository;
	}
	public ProductGetAllActiveProduct setProductRepository(ProductRepositoryInterface productRepository) {
		this.productRepository = productRepository;
		return this;
	}
	
	public ProductGetAllActiveProduct() {
		this.productRepository = new ProductRepository();
	}
}
