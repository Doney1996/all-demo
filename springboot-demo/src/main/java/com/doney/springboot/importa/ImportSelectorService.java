package com.doney.springboot.importa;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.function.Predicate;

public class ImportSelectorService implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{"com.doney.springboot.importa.ImportService2"};
    }

    @Override
    public Predicate<String> getExclusionFilter() {
        return null;
    }
}
