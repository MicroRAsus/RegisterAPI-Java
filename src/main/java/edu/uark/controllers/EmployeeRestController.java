package edu.uark.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/*import edu.uark.commands.products.ProductByLookupCodeQuery;  //these needs to be modified after creating commands classes for employee table
import edu.uark.commands.products.ProductCreateCommand;
import edu.uark.commands.products.ProductDeleteCommand;
import edu.uark.commands.products.ProductQuery;
import edu.uark.commands.products.ProductUpdateCommand;
import edu.uark.commands.products.ProductsQuery;*/
import edu.uark.models.api.Employee;

@RestController
@RequestMapping(value = "/api/employee")
public class EmployeeRestController {
//	@RequestMapping(value = "/", method = RequestMethod.POST)
//	public Employee createEmployee(@RequestBody Employee employee) {
//		return (new ProductCreateCommand()).
//			setApiProduct(product).
//			execute();
//	}
	
	
/*	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Product> getProducts() {
		return (new ProductsQuery()).execute();
	}

	@RequestMapping(value = "/{productId}", method = RequestMethod.GET)
	public Product getProduct(@PathVariable UUID productId) {
		return (new ProductQuery()).
			setProductId(productId).
			execute();
	}

	@RequestMapping(value = "/byLookupCode/{productLookupCode}", method = RequestMethod.GET)
	public Product getProductByLookupCode(@PathVariable String productLookupCode) {
		return (new ProductByLookupCodeQuery()).
			setLookupCode(productLookupCode).
			execute();
	}
	
	@RequestMapping(value = "/{productId}", method = RequestMethod.PUT)
	public Product updateProduct(@PathVariable UUID productId, @RequestBody Product product) {
		return (new ProductUpdateCommand()).
			setProductId(productId).
			setApiProduct(product).
			execute();
	}
	
	@RequestMapping(value = "/{productId}", method = RequestMethod.DELETE)
	public void deleteProduct(@PathVariable UUID productId) {
		(new ProductDeleteCommand()).
			setProductId(productId).
			execute();
	}

	@ResponseBody
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test() {
		return "Successful test. (EmployeeRestController)";
	}*/
}