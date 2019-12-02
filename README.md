# Microservices in Java

[Microservices Overview](https://www.nginx.com/blog/introduction-to-microservices/)

## Prerequesites

- `docker` and `docker-compose`
- mysql client like `workbench` or `dbeaver`
- Java 8 SDK setup

## Build services

Services can be built simply by running below command
```
$ ./build-all-projects.sh
```

## Running the services

`docker-compose up`

## One time SQL setup

- Create the mysql tables in database using script in `data/WebStoreSchema.sql`.
- Import `data/pincode.csv` to `address_suggest` table.

## Troubleshooting

- Check for prerequisites
- Make sure no port conflicts
- Check for error logs when running `docker-compose up`
- Try restarting with `docker-compose down` followed by `docker-compose up`

## TODO

- Swagger documentation for microservices

