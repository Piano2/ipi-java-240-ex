package com.ipiecoles.java.java240;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class SpringConfig {

    @Bean
    @Scope(value = "singleton") //facultatif >> singleton par defaut
    public BitcoinService bitcoinService(){
        BitcoinService b = new BitcoinService();
        b.setWebPageManager(webPageManager());
        return new BitcoinService();
    }

    @Bean
    public ProduitManager produitManager(){
        ProduitManager p = new ProduitManager();
        //injection de Webpagemanager ert bitcoin service
        p.setWebPageManager(webPageManager());
        p.setBitcoinService(bitcoinService());
        return p;
    }

    @Bean
    public WebPageManager webPageManager(){
        return new WebPageManager();
    }

}
