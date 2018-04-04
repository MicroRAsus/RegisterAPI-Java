package edu.uark.models.entities;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import edu.uark.dataaccess.entities.BaseEntity;
import edu.uark.dataaccess.repository.DatabaseTable;
import edu.uark.models.api.Product;
import edu.uark.models.entities.fieldnames.ProductFieldNames;

public class ProductEntity extends BaseEntity<ProductEntity> {
	@Override
	protected void fillFromRecord(ResultSet rs) throws SQLException {
		this.lookupCode = rs.getString(ProductFieldNames.LOOKUP_CODE);
		this.quantity = rs.getInt(ProductFieldNames.QUANTITY);
		this.price = rs.getDouble(ProductFieldNames.PRICE);
		this.active = rs.getString(ProductFieldNames.ACTIVE);
	}

	@Override
	protected Map<String, Object> fillRecord(Map<String, Object> record) { //put data into record to be updated
		record.put(ProductFieldNames.LOOKUP_CODE, this.lookupCode);
		record.put(ProductFieldNames.QUANTITY, this.quantity);
		record.put(ProductFieldNames.PRICE, this.price);
		record.put(ProductFieldNames.ACTIVE, this.active);
		
		return record;
	}

	private String lookupCode;
	public String getLookupCode() {
		return this.lookupCode;
	}
	public ProductEntity setLookupCode(String lookupCode) {
		if (!StringUtils.equals(this.lookupCode, lookupCode)) {
			this.lookupCode = lookupCode;
			this.propertyChanged(ProductFieldNames.LOOKUP_CODE);
		}
		
		return this;
	}

	private int quantity;
	public int getQuantity() {
		return this.quantity;
	}
	public ProductEntity setQuantity(int quantity) {
		if (this.quantity != quantity) {
			this.quantity = quantity;
			this.propertyChanged(ProductFieldNames.QUANTITY);
		}
		
		return this;
	}
	
	private double price;
	public double getPrice() {
		return this.price;
	}
	public ProductEntity setPrice(double price) {
		if (this.price != price) {
			this.price = price;
			this.propertyChanged(ProductFieldNames.PRICE);
		}
		
		return this;
	}
	
	private String active;
	public String getActive() {
		return this.active;
	}
	public ProductEntity setActive(String active) {
		if (this.active != active) {
			this.active = active;
			this.propertyChanged(ProductFieldNames.ACTIVE);
		}
		
		return this;
	}
	
	public Product synchronize(Product apiProduct) {
		this.setQuantity(apiProduct.getQuantity());
		this.setLookupCode(apiProduct.getLookupCode());
		this.setPrice(apiProduct.getPrice());
		this.setActive(apiProduct.getActive());
		
		apiProduct.setId(this.getId());
		apiProduct.setCreatedOn(this.getCreatedOn());
		
		return apiProduct;
	}
	
	public ProductEntity() {
		super(DatabaseTable.PRODUCT);
		
		this.quantity = -1;
		this.lookupCode = StringUtils.EMPTY;
		this.price = 1.00;
		this.active = "F";
	}
	
	public ProductEntity(Product apiProduct) {
		super(DatabaseTable.PRODUCT);
		
		this.quantity = apiProduct.getQuantity();
		this.lookupCode = apiProduct.getLookupCode();
		this.price = apiProduct.getPrice();
		this.active = apiProduct.getActive();
	}
}
