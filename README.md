# FREE-AND-4-SALE-Services
A responsive web site and scalable web application based on the service-oriented architecture (SOA).

## Description
This is the WebService API for the website. 
Components are described as below:
1) Rest Service: 
•	The Rest Service is the one which interacts with the database and provides data to the web server. 
•	The Rest Service first checks in the cache and then if there is cache miss interacts with database for getting the data. 
•	The Rest Service are developed using Jersey Framework and deployed on Tomcat server. 

2) Cache: 
•	This stores the frequently used data and makes data available faster to the rest service preventing expensive database calls. 
•	Whenever there is cache miss, data will be populated from database. 
•	Whenever there is cache hit, data will be send from cache. 

3) Database: 
•	The database will be called in case of cache miss. 
•	Whenever there is cache miss, it will first save data in cache and then return data to the rest Service. 
•	We have used Hibernate ORM for connecting with MySQL database. 


## Technology Used:
Rest Service Framework: JAX-RS Jersey Rest framework.
Cache: MemCache Distributed Cache.
Database: MySQL v5.7.11
Development Environment: JDK 1.8(JSP/Servlet Framework)
ORM: Hibernate 4.3.6
Compression: GZip compression.

## Web Services:

### Module	    Service	                                Descripion	
Inventory	    /InventoryServices/InventoryForHomePage	  This service fetches the list of different products.	                                         /InventoryServices/SearchInventory	       The service returns the search results	
	            /InventoryServices/FetchMoreDetails	      The service returns details of individual product.	

User	        /loginservices/checkuservalidity	        The service validates the user.	
              /registrationservices/newregistration	    The service registers the user.		
              /profileservices/getprofile	              The service gets Profile information		  
              /profileservices/updateprofile	          The service updates the profile information.	

Cart	        /CartService/addToCart	                  The service adds the product to user cart.		
              /CartService/getCart	                    The service gets the cart details.	
	            /CartService/saveUpdateCart	              The service saves the carts.	
	            /CartService/purchaseCart	                The service purchase the products from the cart and sends the confirmation email	
History	      /TransactionService/getTransactionHistory	The service gets the transaction history of the user.	

Review	      /ReviewServices/getReviews	              The service gets the past review given by the user.		
              /ReviewServices/saveReviews	              The service  saves the review.	
              
ContactUS	    /ContatcUsService/SendEmail	              The service sends the email for the message received confirmation.	


