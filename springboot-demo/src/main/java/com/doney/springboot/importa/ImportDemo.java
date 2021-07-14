package com.doney.springboot.importa;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ImportService.class,ImportSelectorService.class})
public class ImportDemo {

}
