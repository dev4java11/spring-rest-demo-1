package pe.com.mycompany.restclient;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import pe.com.mycompany.rest.model.ProductModelView;
import pe.com.mycompany.rest.model.ResultStateMessage;

public class RestClient {
	
	private static final String urlGetAllProduct = "http://localhost:8080/springmvc/rest/product/list.json";
	private static final String urlGetOneProduct = "http://localhost:8080/springmvc/rest/product/{cod}.json";
	private static final String urlGetPageProduct = "http://localhost:8080/springmvc/rest/product/page.json?page={page}&&size={size}";
	private static final String urlCreateProduct = "http://localhost:8080/springmvc/rest/product/create.json";
	private static final String urlUpdateProduct = "http://localhost:8080/springmvc/rest/product/update.json";
	private static final String urlDeleteProduct = "http://localhost:8080/springmvc/rest/product/delete.json?idProduct={idProduct}";

	public static void main(String[] args) {
		RestTemplate restTemplate = new RestTemplate();
		
		
		HttpHeaders headers = new HttpHeaders();
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

//	    ProductModelView body = new ProductModelView(-1
//	    		, "CODE"
//	    		, "DESCRIPTION_"
//	    		, "Motorcycles"
//	    		, "1:1991"
//	    		, "SSSSSSSSSSSSS"
//	    		, "BBBBBBBBBBBBBBBBBBBBBBB."
//	    		, 1
//	    		, 1
//	    		, 1
//	    		, 1);
//	    HttpEntity<ProductModelView> requestEntity =  new HttpEntity<ProductModelView>(body, headers);
	    
	    //ProductModelView[] pmvVector = restTemplate.getForObject(urlGetAllProduct, ProductModelView[].class);
	    ResponseEntity<ProductModelView[]> response = restTemplate.getForEntity(urlGetAllProduct, ProductModelView[].class);
	    System.out.println(response.getHeaders());
	    System.out.println(response.getStatusCode());
	    List<ProductModelView> pmvList = Arrays.asList(response.getBody());
	    for(ProductModelView pmv : pmvList){
	    	System.out.println(pmv.toString());
	    }
	   
	
	}

}
