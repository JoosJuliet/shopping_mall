package com.example.springwebservice.controller;


import com.example.springwebservice.Payload.AuthenticatePayload;
import com.example.springwebservice.Payload.BuyPayload;
import com.example.springwebservice.model.Item;
import com.example.springwebservice.model.PurchaseHistory;
import com.example.springwebservice.model.User;
import com.example.springwebservice.repository.ItemRepository;
import com.example.springwebservice.repository.PurchaseHistoryRepository;
import com.example.springwebservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@CrossOrigin("*")
@RequestMapping("/user")
@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PurchaseHistoryRepository purchaseHistoryRepository;

    @Autowired
    private ItemRepository itemRepository;
    @PostMapping("/register")
    public User userRegister(@RequestBody User user){
        Integer intNum = (int)(Math.random() * 10000);
        user.setJsonWebToken(intNum.toString());
        return userRepository.save(user);
    }

    @PostMapping("/authenticate")
    public User authenticate(@RequestBody AuthenticatePayload user){

        Boolean check = userRepository.existsByuserName(user.getUserName());

        if (check){
            List<User> userList = userRepository.findByuserName(user.getUserName());
            User real_user = userList.get(0);

            if (real_user.getPassword().equals(user.getPassword()) ){
                return real_user;
            }else{
                return null;
            }

        }else{
            return null;
        }



    }


    @PostMapping("/buy")
    public User checkHistory(@RequestHeader (value="Authorization") String jwt, @RequestBody BuyPayload item){
        List<User> userList = userRepository.findByJsonWebToken(jwt);
        User user2 = userList.get(0);
        int item_id = item.getItemId();
        int user_id = user2.getId();
        PurchaseHistory purchaseHistory = new PurchaseHistory(user_id, item_id);
        purchaseHistoryRepository.save(purchaseHistory);
        User user0 = userRepository.findOne(purchaseHistory.getUserId());

        return userRepository.save(user0);
    }

    @GetMapping("/purchase/history")
    public ArrayList<Item> buyItem(@RequestHeader (value="Authorization") String jwt){
        List<User> userList = userRepository.findByJsonWebToken(jwt);
        User user2 = userList.get(0);
        Iterator<PurchaseHistory> iterator = user2.getPurchaseHistory().iterator();
//        이건  유저의 구매목록
        ArrayList<Item> item_list = new ArrayList<>();

        while((iterator).hasNext()){
//            구매목록의 아이템의 id를 빼기 위한 노력
            PurchaseHistory ph = (PurchaseHistory)iterator.next();
            item_list.add( itemRepository.findOne(ph.getItemId()));
        }

        return item_list;
    }
}
