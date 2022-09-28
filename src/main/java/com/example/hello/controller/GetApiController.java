package com.example.hello.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/get") // ~/api/get은 고정임 >> 클래스가 RequestMapping으로 /get까지 가지고 있기 때문임
public class GetApiController {
    @GetMapping(path = "/hello") //http://localhost:8080/api/hello
    public String Hello(){
        return "get Hello";
    }

    //사용 할 필요 없음 >> GetMapping으로 개선됨
    @RequestMapping(path = "/hi", method = RequestMethod.GET) //get http://localhost:8080/api/get/hi
    public String hi(){
        return "hi";
    }

    // http://localhost:8080/api/get/path-variable/{spring-boot} >> 변수f
    @GetMapping("/path-variable/{name}")
    public String pathVariable(@PathVariable(name = "name") String pathName){
        System.out.println("PathVariable: " + pathName);
        return pathName;
    }

    //http://localhost:8080/api/get/query-param?user=steve&email=steve@gmail.com&age=30
    @GetMapping(path = "query-param")
    public String queryParam(@RequestParam Map<String, String> queryParam){

        StringBuilder sb = new StringBuilder();

        queryParam.entrySet().forEach(entry -> {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            System.out.println("\n");

            sb.append(entry.getKey() + " = " + entry.getValue() + "\n");
        });

        return sb.toString();
    }

}
