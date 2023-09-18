# ReadJourney
is a simple clone of Goodreads application for tracking reading progress of users.

I implemented this project for practice and getting into web app development using spring boot and java.


- [ReadJourney API - Swagger UI Link](http://localhost:8000/swagger-ui/index.html#/)

## Technologies in this project
- Spring Boot
- MySQL
- Spring Data


## New things i have learned from this project

#### 1- Builder Design Patter

I used builder design patter in creating the response object that returned with each request.
this help me to make it simple to create and fill response object fileds. it's helpful for many reasons:
- Optional parameters
- Easy creation and initialization of objects
- Parameter validation
- Better readability

```java

	public Response getBookById(Long id){
		Book book = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book", "id", id));
        Response response = new Response.ResponseBuilder()
                .data(mapToDto(book))
                .message("Book retrieved successfully")
                .status(HttpStatus.FOUND)
                .build();
        return response;
	}

	public Response getAllBooks(int pageNo, int pageSize, String sortBy, String order){
        Sort sort = order.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending(): Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        Page<Book> books = repository.findAll(pageable);
        List<Book> listOfBooks = books.getContent();
        List<BookDto> result = listOfBooks.stream().map(book -> mapToDto(book)).collect(Collectors.toList());
        ResponseMetadata metadata = new ResponseMetadata();
        metadata.setIsLast(books.isLast());
        metadata.setPageNo(books.getNumber());
        metadata.setPageSize(books.getSize());
        metadata.setTotalPages(books.getTotalPages());
        metadata.setTotalRecords(books.getTotalElements());
        Response response = new Response.ResponseBuilder()
                .status(HttpStatus.OK)
                .message("books retrieved successfully")
                .data(result)
                .metadata(metadata)
                .build();
        System.out.println(result);
		return response;
	}
```

I write post about this topic [here](https://0xghazy.github.io/design%20patterns/Builder-design-pattern/)

#### 2- regex in java

I need to check if the passed date in the `YYYY-MM-DD` format is valid. so I used my secret superpower (search and copy & paste) 😁. chatGPT helped me to get the regex string that valid date in the needed format and it was 
`^(?:\d{4}-(?:0[1-9]|1[0-2])-(?:0[1-9]|[1-2]\d|3[0-1]))$`

I used this resource to learn how to use regex in Java [javatpoint - Java Regex](https://www.javatpoint.com/java-regex)

```java
import java.util.regex.*;  

// -- code snippet
Pattern pattern = Pattern.compile("PUT_YOUR_REGEX_HERE");//. represents single character  
Matcher matcher = pattern.matcher("INPUT");  
boolean isMatched = matcher.matches();  
// -- code snippet
```









