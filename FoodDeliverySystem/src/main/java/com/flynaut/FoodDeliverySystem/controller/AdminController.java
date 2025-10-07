package com.flynaut.FoodDeliverySystem.controller;

import com.flynaut.FoodDeliverySystem.entity.CakeShop;
import com.flynaut.FoodDeliverySystem.repository.OrderRepository;
import com.flynaut.FoodDeliverySystem.repository.UserRepository;
import com.flynaut.FoodDeliverySystem.service.CakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "*")
public class AdminController {

    @Autowired
    private CakeService service;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @PostMapping("/upload")
    public ResponseEntity<CakeShop> uploadCake(
            @RequestParam("name") String name,
            @RequestParam("price") double price,
            @RequestParam("description") String description,
            @RequestParam("image") MultipartFile imageFile) {

        try {
            // Absolute path to uploads folder in project directory
            String uploadDir = System.getProperty("user.dir") + "/uploads/";

            String imageName = System.currentTimeMillis() + "_" + imageFile.getOriginalFilename();
            java.nio.file.Path path = java.nio.file.Paths.get(uploadDir + imageName);
            java.nio.file.Files.createDirectories(path.getParent());
            imageFile.transferTo(path);

            CakeShop cake = new CakeShop();
            cake.setName(name);
            cake.setPrice(price);
            cake.setDescription(description);
            cake.setImage(imageName);

            return ResponseEntity.ok(service.addCake(cake));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("/counts")
    public ResponseEntity<Map<String, Long>> getCounts() {
        Map<String, Long> counts = new HashMap<>();
        counts.put("cakes", (long) service.getAllCake().size());
        counts.put("users", userRepository.count());
        counts.put("orders", orderRepository.count());
//        counts.put("loggedInUsers", userRepository.countByIsLoggedInTrue());
        return ResponseEntity.ok(counts);
    }

    @GetMapping("/getAll")
    public List<CakeShop> getAllCake() {
        return service.getAllCake();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<CakeShop> getCakeById(@PathVariable long id) {
        return service.getCakeById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<CakeShop> updateCakeById(@PathVariable long id, @RequestBody CakeShop cakeShop) {
        try {
            return ResponseEntity.ok(service.updateCakeById(id, cakeShop));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCakeById(@PathVariable long id) {
        service.deleteCakeById(id);
        return ResponseEntity.ok("Cake Successfully Deleted");
    }
}
