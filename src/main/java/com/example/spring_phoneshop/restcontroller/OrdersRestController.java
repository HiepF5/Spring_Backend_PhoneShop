package com.example.spring_phoneshop.restcontroller;

import com.example.spring_phoneshop.dto.OrdersDTO;
import com.example.spring_phoneshop.dto.CheckoutOrder;
import com.example.spring_phoneshop.entity.Orders;
import com.example.spring_phoneshop.service.OrdersService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class OrdersRestController {
    @Autowired
    private OrdersService ordersService;
    @GetMapping("/orders")
    public ResponseEntity<List<OrdersDTO>> getAllOrders(){
        List<OrdersDTO> orderDTOS = ordersService.getAllOrders();
        return ResponseEntity.ok(orderDTOS);
    }
    @GetMapping("/orders/{id}")
    public ResponseEntity<OrdersDTO> getOrdersById(@PathVariable("id") Integer orderId){
        OrdersDTO ordersDTO = ordersService.getOrdersById(orderId);
        return ResponseEntity.ok(ordersDTO);
    }
    @PostMapping("/orders")
    public ResponseEntity<OrdersDTO> addOrders(@RequestBody OrdersDTO ordersDTO) {
        OrdersDTO saveOrders = ordersService.addOrders(ordersDTO);
        return new ResponseEntity<>(saveOrders, HttpStatus.CREATED);
    }
    @PutMapping("/orders/{id}")
    public ResponseEntity<OrdersDTO> updateOrders(@PathVariable("id") Integer orderId,
                                                      @RequestBody OrdersDTO updateOrders){
        OrdersDTO orderDTO = ordersService.updateOrders(orderId, updateOrders);
        return ResponseEntity.ok(orderDTO);
    }
    @DeleteMapping("/orders/{id}")
    public ResponseEntity<String> deleteOrders(@PathVariable("id") Integer orderId) {
        ordersService.deleteOrders(orderId);
        return ResponseEntity.ok("Product deleted successfully!");
    }
    @PostMapping("/orders/checkout")
    public void checkout(@RequestBody List<CheckoutOrder> checkoutOrder, @RequestParam("user_id") Integer userId) {
        ordersService.checkout(checkoutOrder, userId);
    }
    @GetMapping("/orders/byMonth")
    public List<Orders> getOrdersByMonth(@RequestParam("month") int month) {
        return ordersService.findOrdersByMonth(month);
    }
//    @GetMapping("/user/{userId}")
//    public List<Orders> getOrdersByUserId(@PathVariable Integer userId) {
//        return ordersService.findOrdersByUserId(userId);
//    }
    @GetMapping("orders/count")
    public ResponseEntity<Integer> countAllOrders() {
        int totalCount = ordersService.countAllOrders();
        return new ResponseEntity<>(totalCount, HttpStatus.OK);
    }
    @GetMapping("orders/totalAmount")
    public int getTotalOrderAmount() {
        return ordersService.getTotalOrderAmount();
    }
    @GetMapping("orders/month-with-most-orders")
    public int getMonthWithMostOrders() {
        return ordersService.getMonthWithMostOrders();
    }
}
