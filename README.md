# Miniproject3

To set up Kafka in docker, run the following command:
```
docker-compose up -d
```

#### Endpoints

LoanGateway - localhost:8020/loan

* RequestLoan[POST] - /request
Returns borrowerId

* List of loan quotes[GET] - /{borrowerId}
Returns list of LoanQuote objects 

Accept loan quote[POST] - /accept/{quoteId}/{bankId}
Returns String







