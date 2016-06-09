# Importatint Topics on REST
1) HTTP Methods
----------------
2) HTTP Headers -Metadata
-------------------------
3) Response Status Code
------------------------
4) Parameters
-------------------------
5) Content Negotiation
------------------------
6) HATEOAS
------------------------
7) Security
------------------------
*Note: 1-4 topics covered in this example.

Important HTTP Methods:
------------------------
<b>GET</b><br>
<b>POST</b><br>
<b>PUT</b><br>
<b>DELETE</b><br>

<b>GET</b>: This is request to get the resource from server,we can easily see the get request url on browser,
since the GET request is read-only therefore this does not make any side effects or changes the resources on servers.
So GET request is called as Idmpotent, it means when we repeat the request it doesn't effects on server.

<b>POST</b>: This is request to insert or update the resources on server,we can not see the url of POST method on browser because data is passing through 
request body.Since the POST request is write-method therefore this makes side effects or changes the resources on server.
So POST request is called as Non-Idempotent, it means when we repeat the request it effects on server.

<b>PUT</b>: This is request to update the resources on server.However PUT request is write-method but it doesn't any side effects on server while it repeats the same request.
PUT method is Idempotent.So it is recommended that whenever we have to update the resources on server we should use PUT rather than POST.

<b>DELETE</b>:This is request to delete the resources on server.However DELETE request is write-method but it doesn't any side effects on server while it repeats the same request.
DELETE method is Idempotent.So it is recommended that whenever we have to delete the resources on server we should use DELETE rather than POST.


# RestJersySimpleExample

Download Jars from: https://jersey.java.net/download.html

How To Run (User Service):
----------------------------
POST Url:
http://localhost:8080/UserManagement/rest/UserService/saveUsers

GET Url:
http://localhost:8080/UserManagement/rest/UserService/users

How To Run (Order Service):
----------------------------
PUT Url:
http://localhost:8080/UserManagement/rest/orders/402?customer_name=JamesBond

GET Url:
http://localhost:8080/UserManagement/rest/orders/402

GET Url:
http://localhost:8080/UserManagement/rest/orders/list
