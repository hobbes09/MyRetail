package com.test.trgt.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.test.trgt.models.Error;
import com.test.trgt.models.Price;
import com.test.trgt.data.PricesRepository;
import com.test.trgt.exceptions.BaseException;
import com.test.trgt.models.Product;
import com.test.trgt.service.ProductService;

@Path("/api")
public class GatewayApi {
	
	ProductService productService;
	
	public GatewayApi() {
		super();
		productService = new ProductService();
	}

	@GET
	@Path("/")
	public Response resp(){
		
		return Response.status(200).entity("HOME PATH !").build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/products/{id}")
	public Product responseMsg(@PathParam("id") int productId) {
		
		Product product = new Product();
		try {
			product = productService.getProductDetailsById(productId);
		} catch (BaseException e) {
			product.setError(new Error(e.message, e.responseCode));
		}
				
		return product;
	}
}
