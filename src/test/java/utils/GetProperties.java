package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GetProperties {
    public void leerPropiedades() throws IOException {
        Properties properties = new Properties();
        String namePropertiesFile="qa.properties";

        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(namePropertiesFile);
        if(inputStream != null)
        properties.load(inputStream);

        ConfigEnv.host=properties.getProperty("host");
        ConfigEnv.user=properties.getProperty("user");
        ConfigEnv.password=properties.getProperty("password");

        System.out.println("-----------------------------");
        System.out.println("ConfigEnv.host: "+ConfigEnv.host);
        System.out.println("ConfigEnv.user: "+ConfigEnv.user);
        System.out.println("ConfigEnv.password: "+ConfigEnv.password);
        System.out.println("-----------------------------");

        inputStream.close();

    }
}
