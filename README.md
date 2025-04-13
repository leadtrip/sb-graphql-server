### Spring boot graphQL server

Fetch a Book from the in memory collection:
```graphql
query bookDetails {
  bookById(id: "book-1") {
    id
    name
    pageCount
    author{
      id
      firstName
      lastName
    }
  }
}
```

Fetch a Person from the person service which needs to be up of course:
```graphql
query personDetails {
  personById(id: 1) {
    id
    firstName
    lastName
  }
}
```