# Exchange-Rates
Application for monitoring the exchange rate of the European Central Bank.

### Technology stack: ###

1) Spring Boot, Data, MVC
2) Hibernate, H2 Database
3) Apache Tomcat
4) Rest API
6) JSON
7) Project Lombok

The app connects to the API of the European Central Bank. Every 30 minutes it reads information about the current exchange rate and saves it to the database.
The application provides access to data through an API. Application work on http://localhost:8889  

### The following endpoints exist: ###

### Currency controller ###

**GET /api/currency**  
Response JSON witn the List of Currency Rate from database. Can take currency or date as filtering parameters.   
For example:  
http://localhost:8889/api/currency - Returns all exchange rate   
http://localhost:8889/api/currency?currency=USD - Returns the exchange rate with filter by currency (USD)   
http://localhost:8889/api/currency?date=10.12.2021 - Returns the exchange rate with filter by date  
http://localhost:8889/api/currency?currency=USD&date=10.12.2021 - Returns the exchange rate with filter by currency and date  

Sample response:  
```json
[
    {
        "currency": "USD",
        "rate": 1.1273,
        "date": "2021-12-10"
    }
]
```

**GET /api/currency/page**  
Response JSON with all Currency from database paginated.
The default number of Currency on the page is 1.  
The page number can be set using the parameter "page".  
The number of Currency per page can be set using the parameter "pageSize".  
For example:  
http://localhost:8889/api/currency/page?page=1&pageSize=2
