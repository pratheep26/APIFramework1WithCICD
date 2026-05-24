package resources;

public enum APIResources {
	
	Login ("/api/ecom/auth/login"),
	CreateProduct ("/api/ecom/product/add-product"),
	DeleteProduct ("/api/ecom/product/delete-product/{productId}");
	
	private String resource;
	
	APIResources (String resource){
		this.resource = resource;
	}
	
	public String getAPIResource() {
		return resource;
	}

}
