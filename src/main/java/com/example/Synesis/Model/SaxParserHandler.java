package com.example.Synesis.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class SaxParserHandler extends DefaultHandler {
    @Autowired
    CurrencyService service;
    private LocalDate date;
    private final List<String> currencyList = List.of("USD", "JPY", "RUB");

    private final Map<String, Double> map = new HashMap<>();

    public void Print() {
        map.forEach((key, value) -> System.out.println(key + ":" + value));
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if (qName.equals("Cube")) {
            if (attributes.getValue("time") != null) {
                date = LocalDate.parse(attributes.getValue("time"));
                System.out.println("Current date " + attributes.getValue("time"));
            }
            if (attributes.getValue("currency") != null &&
                    currencyList.contains(attributes.getValue("currency"))) {
                Currency currency = new Currency();
                currency.setCurrency(attributes.getValue("currency"));
                currency.setRate(Double.parseDouble(attributes.getValue("rate")));
                currency.setDate(date);
                service.save(currency);
                map.put(attributes.getValue("currency"), Double.parseDouble(attributes.getValue("rate")));
            }
        }
    }
}