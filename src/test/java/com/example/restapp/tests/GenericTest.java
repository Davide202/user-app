package com.example.restapp;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Logger;

public class GenericTest {

    private static final Logger logger = Logger.getGlobal();

    @Test
    void init(){


        Integer tot = 0;
        Integer pageSize = 20;
        Integer resto = tot%pageSize;
        Integer pages = tot > 0 && resto == 0 ? tot/20 : (tot/pageSize)+1;

        logger.info("pages: "+ pages);

        Collection<String> collection = new ArrayList<>();
        logger.info(String.valueOf(collection.size()));
    }
}
