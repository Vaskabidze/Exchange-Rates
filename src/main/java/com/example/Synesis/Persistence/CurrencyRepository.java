package com.example.Synesis.Persistence;

import com.example.Synesis.Model.Currency;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CurrencyRepository extends PagingAndSortingRepository<Currency, Long> {

    @Query(value = "select * from CURRENCY \n" +
            "where id in (select min(id) from CURRENCY where date = ?1 group by currency) order by currency",
            nativeQuery = true)
    public List<Currency> findAllByDate(LocalDate date);

    @Query(value = "select * from CURRENCY \n" +
            "where id in (select min(id) from CURRENCY where currency = ?1 group by date) order by date desc",
            nativeQuery = true)
    public List<Currency> findAllByCurrency(String currency);

    @Query(value = "select * from CURRENCY \n" +
            "where id in (select min(id) from CURRENCY where currency = ?1 and date = ?2 group by date)",
            nativeQuery = true)
    public List<Currency> findAllByCurrencyAndDate(String currency, LocalDate date);

    @Override
    @Query(value = "select * from CURRENCY \n" +
            "where id in (select min(id) from CURRENCY group by currency,date) order by date desc, currency",
            nativeQuery = true)
    public List<Currency> findAll();


    @Query(value = "select * from CURRENCY \n" +
            "where id in (select min(id) from CURRENCY group by currency,date) order by date desc, currency",
            nativeQuery = true)
    public Page<Currency> findAllCurrency(Pageable pageable);

}
