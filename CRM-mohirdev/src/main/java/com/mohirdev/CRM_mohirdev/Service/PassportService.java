package com.mohirdev.CRM_mohirdev.Service;

import com.mohirdev.CRM_mohirdev.Repository.PassportRepository;
import com.mohirdev.CRM_mohirdev.model.Passport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PassportService {
    @Autowired
    private PassportRepository passportRepository;


    public Passport create(Passport passport) {
        return passportRepository.save(passport);
    }


    public List<Passport> getAllPassports() {
        return passportRepository.findAll();
    }

    public Passport getPassport(Long id) {
        return passportRepository.findById(id).get();
    }

    public Passport update(Passport passport, Long id) {
        Passport result = passportRepository.findById(id).get();
        result.setId(passport.getId());
        result.setRace(passport.getRace());
        result.setNumbers(passport.getNumbers());
        result.setJSHSHIR(passport.getJSHSHIR());

        return passportRepository.save(passport);
    }

    public void delete(Passport passport) {
        passportRepository.delete(passport);
    }


}
