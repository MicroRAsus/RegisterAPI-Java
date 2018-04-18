package edu.uark.commands.products;

import org.apache.commons.lang3.StringUtils;

import edu.uark.commands.ResultCommandInterface;
import edu.uark.models.api.Product;
import edu.uark.models.api.ProductQuantityUpdateStatus;
import edu.uark.models.entities.ProductEntity;
import edu.uark.models.repositories.ProductRepository;
import edu.uark.models.repositories.interfaces.ProductRepositoryInterface;

public class ProductQuantityUpdateCommand implements ResultCommandInterface<ProductQuantityUpdateStatus> {
	@Override
	public ProductQuantityUpdateStatus execute() {
		//Validations
		if (StringUtils.isBlank(this.apiProduct.getLookupCode())) {
			return new ProductQuantityUpdateStatus();
		}

		ProductEntity productEntity = this.productRepository.byLookupCode(this.apiProduct.getLookupCode());
		if (productEntity == null) { //No record with the associated record ID exists in the database.
			return new ProductQuantityUpdateStatus();
		}
		
		productEntity.setQuantity(this.apiProduct.getQuantity()); //Synchronize incoming quantity changes for UPDATE to the database.
		
		productEntity.save(); //Write, via an UPDATE, any changes to the database.
		
		return new ProductQuantityUpdateStatus(true);
	}
	
	private Product apiProduct;
	public Product getApiProduct() {
		return this.apiProduct;
	}
	public ProductQuantityUpdateCommand setApiProduct(Product apiProduct) {
		this.apiProduct = apiProduct;
		return this;
	}
	
	private ProductRepositoryInterface productRepository;
	public ProductRepositoryInterface getProductRepository() {
		return this.productRepository;
	}
	public ProductQuantityUpdateCommand setProductRepository(ProductRepositoryInterface productRepository) {
		this.productRepository = productRepository;
		return this;
	}
	
	public ProductQuantityUpdateCommand() {
		this.productRepository = new ProductRepository();
	}
}
