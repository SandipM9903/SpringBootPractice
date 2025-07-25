package com.sandip.rest.webservices.rest_web_services.controller;

import com.sandip.rest.webservices.rest_web_services.model.HelloWorld;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping(path = "/hello-world")
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping(path = "/hello-world-bean")
    public HelloWorld helloWorldBean() {
        return new HelloWorld("Hello World!");
    }

    @GetMapping(path="/hello-world/{name}")
    public HelloWorld helloWorldPathVariable(@PathVariable String name){
        return new HelloWorld("Hello " + name + "!");
    }
}
