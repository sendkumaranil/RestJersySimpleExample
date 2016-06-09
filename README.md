# Important Topics on REST

<b>1) HTTP Methods</b><br>
<b>2) HTTP Headers -Metadata</b><br>
<b>3) Response Status Code</b><br>
<b>4) Parameters</b><br>
<b>5) Content Negotiation</b><br>
<b>6) HATEOAS</b><br>
<b>7) Security</b><br>

*Note: 1-4 topics covered in this example.

Important HTTP Methods:
------------------------
<ul>
<li>GET</li>
<li>POST</li>
<li>PUT</li>
<li>DELETE</li>
</ul>
<b>GET</b>: This is request to get the resource from server,we can easily see the get request url on browser,
since the GET request is read-only therefore this does not make any side effects or changes the resources on servers.
So GET request is called as Idempotent, it means when we repeat the request it doesn't effects on server.

<b>POST</b>: This is request to insert or update the resources on server,we can not see the url of POST method on browser because data is passing through 
request body.Since the POST request is write-method therefore this makes side effects or changes the resources on server.
So POST request is called as Non-Idempotent, it means when we repeat the request it effects on server.

<b>PUT</b>: This is request to update the resources on server.However PUT request is write-method but it doesn't any side effects on server while it repeats the same request.
PUT method is Idempotent.So it is recommended that whenever we have to update the resources on server we should use PUT rather than POST.

<b>DELETE</b>:This is request to delete the resources on server.However DELETE request is write-method but it doesn't any side effects on server while it repeats the same request.
DELETE method is Idempotent.So it is recommended that whenever we have to delete the resources on server we should use DELETE rather than POST.

Common HTTP General Headers
---------------------------
<ul>
	<li>cache-control</li>
	<li>date</li>
</ul>

<b>cache-control:</b>The Cache-Control general-header field is used to specify directives that MUST be obeyed by all the caching system. 
The syntax is as follows:

			Cache-Control : cache-request-directive|cache-response-directive
			Examples:Cache-control: no-cache
					Cache Request Directive and Description:
					
					1	no-cache:
					A cache must not use the response to satisfy a subsequent request without successful revalidation with the origin server.

					2	no-store:
					The cache should not store anything about the client request or server response.

					3	max-age = seconds:
					Indicates that the client is willing to accept a response whose age is not greater than the specified time in seconds.

					4	max-stale [ = seconds ]:
					Indicates that the client is willing to accept a response that has exceeded its expiration time. If seconds are given, it must not be expired by more than that time.

					5	min-fresh = seconds:
					Indicates that the client is willing to accept a response whose freshness lifetime is not less than its current age plus the specified time in seconds.

					6	no-transform:
					Does not convert the entity-body.
					
					7	only-if-cached:
					Does not retrieve new data. The cache can send a document only if it is in the cache, and should not contact the origin-server to see if a newer copy exists.
					


<b>Date:</b>All HTTP date/time stamps MUST be represented in Greenwich Mean Time (GMT), without exception. 
HTTP applications are allowed to use any of the following three representations of date/time stamps:

			Sun, 06 Nov 1994 08:49:37 GMT  ; RFC 822, updated by RFC 1123
			Sunday, 06-Nov-94 08:49:37 GMT ; RFC 850, obsoleted by RFC 1036
			Sun Nov  6 08:49:37 1994       ; ANSI C's asctime() format
			
Common HTTP Request Headers			
---------------------------
<ul>
	<li>accept</li>
	<li>accept-encoding</li>
	<li>accpet-language</li>
	<li>accept-charset</li>
	<li>user-agent</li>
	<li>authorization</li>
	<li>cookie</li>
</u>

<b>accept:</b>The Accept request-header field can be used to specify certain media types which are acceptable for the response. 
The general syntax is as follows:

			Accept: type/subtype [q=qvalue]
			Example: Accept: text/plain; q=0.5, text/html, text/x-dvi; q=0.8, text/x-c
			
<b>accept-encoding:</b>The Accept-Encoding request-header field is similar to Accept, but restricts the content-codings that are acceptable in the response. 
The general syntax is:

			Accept-Encoding: encoding types
			Examples:	Accept-Encoding: compress, gzip
						Accept-Encoding:
						Accept-Encoding: *
						Accept-Encoding: compress;q=0.5, gzip;q=1.0
						Accept-Encoding: gzip;q=1.0, identity; q=0.5, *;q=0
						
<b>accpet-language:</b>The Accept-Language request-header field is similar to Accept, but restricts the set of natural languages that are preferred as a response to the request. 
The general syntax is:

			Accept-Language: language [q=qvalue]
			Example:Accept-Language: da, en-gb;q=0.8, en;q=0.7
			
<b>accept-charset:</b>The Accept-Charset request-header field can be used to indicate what character sets are acceptable for the response. 
Following is the general syntax:

			Accept-Charset: character_set [q=qvalue]
			Example:Accept-Charset: iso-8859-5, unicode-1-1; q=0.8
			
<b>user-agent:</b>The User-Agent request-header field contains information about the user agent originating the request. 
Following is the general syntax:

			User-Agent : product | comment
			Example:User-Agent: Mozilla/4.0 (compatible; MSIE5.01; Windows NT)
			
<b>authorization:</b>The Authorization request-header field value consists of credentials containing the authentication information of the user agent for the realm of the resource being requested. 
The general syntax is:

			Authorization : credentials
			Example:Authorization: BASIC Z3Vlc3Q6Z3Vlc3QxMjM=
			Base64 encoding/decoding:The value decodes into is guest:guest123 where guest is user ID and guest123 is the password.
			
<b>cookie:</b>The Cookie request-header field value contains a name/value pair of information stored for that URL. 
Following is the general syntax:

			Cookie: name=value
			Example:Cookie: name1=value1;name2=value2;name3=value3
			
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
