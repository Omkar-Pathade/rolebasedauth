# rolebasedauth:
Created a role-based autharization model to demonstrate how we can restrict and allow role based access in spring boot.

# Steps to run:
1. Build the project using mvn clean install
2. Run using mvn spring-boot:run
3. The application is accessible via localhost:8080
# Description:
1. /products/adduser: {post}: Used to add the user- you need to pass user details in body of post request:
2. /products/allproducts: {get}: Returns list of products present
3. /products/{id}: {get}: Returns products with specific ID
4. /products/addproduct: {post}: Adds product in your database
5. /products/productbyuserid/{id} {get}: returns list of product by user id
6. /products/authenticate {post}: returns a token generated for your user.
# Public API:
"/products/adduser","/products/authenticate"
# ADMIN Accessible:
/products/allproducts, /products/addproduct, /products/productbyuserid/{id}
# USER Accessible:
/products/allproducts, /products/{id}, /products/addproduct, /products/productbyuserid/{id}
# Steps:
1. Add a user
2. Generate a token
3. Pass token to all your request as a bearer
4. Add a product to your catalog
5. Get the product and users details based on requirement: get all products, get product by id, get product by user id, etc.
# Payload for requests:
1. Add user:
   {
   "username":"",
   "password":"",
   "firstname":"",
   "lastname":"",
   "email":"",
   "role":""
   }
2. Authenticate:
{
   "username":"",
   "password":""
}
3. Add Product:
   {
   "name":"",
   "quantity":"",
   "price":"",
   "userId":
   }