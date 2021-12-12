package com.example.Synesis.Model;

import com.example.Synesis.Persistence.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class CurrencyService {
    @Autowired
    private CurrencyRepository repository;

    public void save(Currency currency) {
        currency.setUploadTime(LocalDateTime.now());
        repository.save(currency);
    }

    public List<Currency> findAll() {
        return repository.findAll();
    }

    public List<Currency> findCurrencyByDate(LocalDate date) {
        return repository.findAllByDate(date);
    }

    public List<Currency> findAllByCurrency(String currency) {
        return repository.findAllByCurrency(currency);
    }

    public List<Currency> findAllByCurrencyAndDate(String currency, LocalDate date) {
        return repository.findAllByCurrencyAndDate(currency, date);
    }

    public Page<Currency> getAllCurrency(int pageNo, int pageSize) {
        Pageable paging = PageRequest.of(pageNo, pageSize);
        return repository.findAllCurrency(paging);
    }


}
