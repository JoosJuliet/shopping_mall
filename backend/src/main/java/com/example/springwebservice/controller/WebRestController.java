package com.example.springwebservice.controller;

//import com.example.springwebservice.model.Greeting;

import com.example.springwebservice.model.Item;
import com.example.springwebservice.model.PurchaseHistory;
import com.example.springwebservice.model.User;
import com.example.springwebservice.repository.ItemRepository;
import com.example.springwebservice.repository.PurchaseHistoryRepository;
import com.example.springwebservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@CrossOrigin("*")
@RestController
public class WebRestController {


    @GetMapping("/hello")
    public String hello(){
        return "HelloWorld!";
    }


}
