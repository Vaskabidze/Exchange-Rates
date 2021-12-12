package com.example.Synesis.Controller;

import com.example.Synesis.Model.Currency;
import com.example.Synesis.Model.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
public class Controller {
    @Autowired
    CurrencyService service;

    @GetMapping(value = "/api/currency", params = "currency")
    public List<Currency> getCurrency(@RequestParam(name = "currency") String currency) {
        System.out.println(currency);
        return service.findAllByCurrency(currency);
    }

    @GetMapping(value = "/api/currency", params = {"currency", "date"})
    public List<Currency> getCurrency(@RequestParam(name = "currency") String currency,
                                      @RequestParam(name = "date") LocalDate date) {
        return service.findAllByCurrencyAndDate(currency, date);
    }

    @GetMapping(value = "/api/currency", params = "date")
    public List<Currency> getCurrency(@RequestParam(name = "date") LocalDate date) {
        return service.findCurrencyByDate(date);
    }

    @GetMapping(value = "/api/currency")
    public List<Currency> getCurrency() {
        return service.findAll();
    }


    @GetMapping(value = "/api/currency/page")
    public Page<Currency> getCurrency(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "1") int pageSize) {
        return service.getAllCurrency(page, pageSize);
    }


}
