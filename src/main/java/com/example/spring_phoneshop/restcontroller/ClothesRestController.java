package com.example.spring_phoneshop.restcontroller;

import com.example.spring_backend_ecommerce.entity.Clothes;
import com.example.spring_backend_ecommerce.model.dto.ClothesDTO;
import com.example.spring_backend_ecommerce.service.ClothesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ClothesRestController {
    @Autowired
    private ClothesService clothesService;
    @GetMapping("/clothes")
    public List<ClothesDTO> getAllClothes(){
        return clothesService.getAllClothes();
    }
    @GetMapping("/clothes/{id}")
    public Optional<ClothesDTO> getClothesById(@PathVariable Integer id){return clothesService.getClothesById(id);}
    @PostMapping("/clothes")
    public void addClothes(@RequestBody Clothes clothes){clothesService.addClothes(clothes);}
    @PutMapping ("/clothes")
    public void updateClothes(@RequestBody Clothes clothes){clothesService.updateClothes(clothes);}
    @DeleteMapping("/clothes/{id}")
    public void deleteClothes(@PathVariable Integer id){clothesService.deleteClothes(id);}
}
