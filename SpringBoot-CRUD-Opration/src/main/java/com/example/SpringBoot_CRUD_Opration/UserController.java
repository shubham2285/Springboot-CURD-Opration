package com.example.SpringBoot_CRUD_Opration;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class UserController {

    private final UserRepository repo;

    public UserController(UserRepository repo) {
        this.repo = repo;
    }

    // Test endpoint
    @RequestMapping("/test")
    public String test() {
        return "this is test only";
    }

    // C - Create
    @PostMapping("/save")
    public User create(@RequestBody User user) {
    	return repo.save(user);
        
    }

    // R - Read All
    @GetMapping("/all")
    public List<User> alldata() {
        return repo.findAll();
    }

    // R - Read by Id
    @GetMapping("/{id}")
    public User getById(@PathVariable Long id) {
        return repo.findById(id).orElse(null);
    }

    // U - Update
    @PutMapping("/update/{id}")
    public User update(@PathVariable Long id, @RequestBody User user) {
        user.setId(id);
        return repo.save(user);
    }

    // D - Delete
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        repo.deleteById(id);
        return "User deleted with id " + id;
    }
}
