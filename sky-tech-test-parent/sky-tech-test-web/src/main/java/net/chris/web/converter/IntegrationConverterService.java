/**
 * 
 */
package net.chris.web.converter;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.support.GenericConversionService;
import org.springframework.stereotype.Service;

/**
 * Service used for handling custom type conversions (e.g, from domain to page bean) used within the application.
 * 
 */
@Service
public class IntegrationConverterService extends GenericConversionService {

    @SuppressWarnings("rawtypes")
    @Autowired
    @IntegrationConverter
    private List<Converter> converters;

    @SuppressWarnings("rawtypes")
    @PostConstruct
    public void initialiseConverters() {

        for (final Converter converter : converters) {
            this.addConverter(converter);
        }
    }
}
