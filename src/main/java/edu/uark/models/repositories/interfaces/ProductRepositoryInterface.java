package edu.uark.models.repositories.interfaces;

import java.util.Collection;

import edu.uark.dataaccess.repository.BaseRepositoryInterface;
import edu.uark.models.entities.ProductEntity;
import edu.uark.models.api.Product;

public interface ProductRepositoryInterface extends BaseRepositoryInterface<ProductEntity> {
	ProductEntity byLookupCode(String lookupCode);
	Collection<ProductEntity> getAllActiveProductEntity();
}
