/**
 * 
 */
package net.chris.integration.test.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;

/**
 * Class containing common utilities required within unit tests.
 * 
 * @author Chris Hern
 * 
 */
public final class TestResources {

    public static String getJsonResource(final String resourceName) {

        final String resourceLocation = "json/" + resourceName + ".json";

        try {
            InputStream resourceAsStream = TestResources.class.getClassLoader().getResourceAsStream(resourceLocation);
            return IOUtils.toString(resourceAsStream, "UTF-8");
        } catch (final IOException ex) {
            throw new IllegalArgumentException("cannot find resource: " + resourceLocation);
        }
    }
}
