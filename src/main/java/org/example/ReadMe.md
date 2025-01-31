# @RestController & @Controller
## @Controller 
is used to return a view for frontend affairs such as JSPs

## @RestController
is used to return data in form of ** JSON ** or ** HTML * by default and
typically in Restful applications usually is commonly used.

### @RestController or @Controller marks the class a controller.

## Methods annotated with RequestMapping such as @GetMapping - @PostMapping - @PutMapping - @DeleteMapping - @PathMapping
All of these methods can have * URL path * as their attribute.
for example :
    @GetMapping("URL Path")
## PathPatterns
In general a Path could be associated by a pattern as PATH or value.
for example :
@PostMapping("/logging/{entry}")
- "/resources/ima?e.png" - match one character in a path segment
- "/resources/*.png" - match zero or more characters in a path segment
- "/resources/**" - match multiple path segments
- "/projects/{project}/versions" - match a path segment and capture it as a variable
- "/projects/{project:[a-z]+}/versions" - match and capture a variable with a regex
for more information refer to[path pathern](https://docs.spring.io/spring-framework/docs/6.2.2/javadoc-api/org/springframework/web/util/pattern/PathPattern.html)

### Captured URL variables can accessed by * @PathVariable *
- For Example 
```
@GetMapping("/path/{personName}/{personId}"")
private void getPersonInfos(String personName, long personId){
    //...
}
```

## @RequestParams
This annotation locate beside attributes through method and simply is used to extract queries or parameters
from request or even from files.
for more information [get this address](https://www.baeldung.com/spring-request-param)

```
@GetMapping("/path")
private Model analizeRequest(@RequestParams long id){
    return "ID : " + id;
  // here you dont need to declare pathVariable but if you dont declare id response meets with an error
  // for example : bad request ...
}

```


 
 
 
 



 