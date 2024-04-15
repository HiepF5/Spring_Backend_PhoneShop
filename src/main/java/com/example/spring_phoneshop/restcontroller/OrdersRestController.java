package com.example.spring_phoneshop.restcontroller;

import com.example.spring_backend_ecommerce.entity.Orders;
import com.example.spring_backend_ecommerce.model.dto.OrdersDTO;
import com.example.spring_backend_ecommerce.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class OrdersRestController {
    @Autowired
    private OrdersService ordersService;
    @GetMapping("/orders")
    public List<OrdersDTO> getAllOrders(){
        return ordersService.getAllOrders();
    }
    @GetMapping("/orders/{id}")
    public Optional<OrdersDTO> getOrdersById(@PathVariable Integer id){return ordersService.getOrdersById(id);}
    @PostMapping("/orders")
    public void addOrders(@RequestBody Orders orders){ordersService.addOrders(orders);}
    @PutMapping ("/orders")
    public void updateOrders(@RequestBody Orders orders){ordersService.updateOrders(orders);}
    @DeleteMapping("/orders/{id}")
    public void deleteOrders(@PathVariable Integer id){ordersService.deleteOrders(id);}
}
