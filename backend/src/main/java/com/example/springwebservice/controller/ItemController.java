package com.example.springwebservice.controller;

import com.example.springwebservice.model.Item;
import com.example.springwebservice.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParser;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RequestMapping("/item")
@RestController
public class ItemController {

    @Autowired
    private ItemRepository itemRepository;

    @PostMapping("")
    public Item addItem(@RequestBody Item item){
        return itemRepository.save(item);
    }


    @GetMapping("/list")
    public List<Item> list(Model model){
        List<Item> itemList = itemRepository.findAll();
        return itemList;
    }


}
