package com.example.spring_phoneshop.restcontroller;

import com.example.spring_phoneshop.entity.OrderDetail;
import com.example.spring_phoneshop.dto.OrderDetailDTO;
import com.example.spring_phoneshop.service.OrderDetailService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class OrderDetailRestController {
    @Autowired
    private OrderDetailService orderDetailService;
    @GetMapping("/orderDetail")
    public List<OrderDetailDTO> getAllOrderDetail(){
        return orderDetailService.getAllOrderDetail();
    }
    @GetMapping("/orderDetail/{id}")
    public Optional<OrderDetailDTO> getOrderDetailById(@PathVariable Integer id){return orderDetailService.getOrderDetailById(id);}
    @PostMapping("/orderDetail")
    public void addOrderDetail(@RequestBody OrderDetail orderDetail){orderDetailService.addOrderDetail(orderDetail);}
    @PutMapping ("/orderDetail")
    public void updateOrderDetail(@RequestBody OrderDetail orderDetail){orderDetailService.updateOrderDetail(orderDetail);}
    @DeleteMapping("/orderDetail/{id}")
    public void deleteOrderDetailDTO(@PathVariable Integer id){orderDetailService.deleteOrderDetailDTO(id);}
    @GetMapping("/total-quantity")
    public ResponseEntity<List<Object[]>> getTotalQuantityForEachProduct() {
        List<Object[]> totalQuantities = orderDetailService.getTotalQuantityForEachProduct();
        return ResponseEntity.ok(totalQuantities);
    }
}
