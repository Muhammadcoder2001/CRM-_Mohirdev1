package com.mohirdev.CRM_mohirdev.Controller;

import com.mohirdev.CRM_mohirdev.Service.PassportService;
import com.mohirdev.CRM_mohirdev.model.Passport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class PassportController {

    @Autowired
    private PassportService service;

    @PostMapping("/passports")
    public ResponseEntity<?> register(@RequestBody Passport passport) {
        Passport result = service.create(passport);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/passports")
    public ResponseEntity<List<Passport>> getAllPassports() {
        List<Passport> result = service.getAllPassports();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/passports/{id}")
    public ResponseEntity<?> getPassportById(@PathVariable Long id) {
        Passport result = service.getPassport(id);
            return ResponseEntity.ok(result);
    }

    @PutMapping("/passports")
    public ResponseEntity<?> updatePassport(@RequestBody Passport passport, @PathVariable Long id) {
        if(passport.getId() == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Passport id is null");
        }else
            service.update(passport, id);
        return ResponseEntity.ok(passport);
    }

    @DeleteMapping("/passports/{id}")
    public ResponseEntity<?> deletePassport(@PathVariable Long id) {
        Passport result = service.getPassport(id);
     try{
         service.delete(result);
         return ResponseEntity.ok("Passport is deleted successfully");
     }catch(Exception e){
         return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
     }

    }
}
