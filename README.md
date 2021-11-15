Made by Sofie Amalie Landt, Amanda Juhl Hansen & Benjamin Aizen Kongshaug

# Miniproject3

To set up Kafka in docker, run the following command:
```
docker-compose up -d
```

#### Endpoints

LoanGateway - localhost:8020/loan

* RequestLoan[POST] - /request (<i>Returns borrowerId</i>)

@RequestBody int amount

##### Example: 300000

* List of loan quotes[GET] - /{borrowerId} (<i>Returns list of LoanQuote objects with quoteId and bankId</i>)

* Accept loan quote[POST] - /accept/{quoteId}/{bankId} (<i>Returns String</i>)

@RequestBody BorrowerDTO borrowerDTO

##### Example: 
BorrowerDTO {
"id": UUID
"firstname": String
"lastname": String
"cpr": String
"email": String
"phonenumber": Integer
"address": {
  "street": String
  "city": String
  "country": String
  "zipcode": Integer
  "number": Integer
}
}
 
We have started implemented Camel in ContractService to send the generated email with attached files. Unfortunately we didn't have time to finish it. 








