package com.example.Synesis.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.net.URL;

@Component
public class SaxMyParser {
    @Autowired
    private SaxParserHandler handler;
    private SAXParser parser;

    public void parse() {
        try {
            String URL = "https://www.ecb.europa.eu/stats/eurofxref/eurofxref-daily.xml";
            parser.parse(new InputSource(new URL(URL).openStream()), handler);
        } catch (SAXException e) {
            System.out.println("Sax parsing error " + e.toString());
        } catch (IOException e) {
            System.out.println("IO parsing error " + e.toString());
        }
        handler.Print();
    }

    @Bean
    public SAXParser getSAXParser() throws ParserConfigurationException, SAXException {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            return parser = factory.newSAXParser();
    }
}
