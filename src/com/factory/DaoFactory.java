package com.factory;

import java.io.IOException;
import java.util.Properties;



public class DaoFactory {

	private static Properties daoconfig = new Properties();
    static {
        try {
            daoconfig.load(DaoFactory.class.getClassLoader().getResourceAsStream("dao.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public DaoFactory() { }

    private static final DaoFactory instance = new DaoFactory();

    public static DaoFactory getInstance() {
        return instance;
    }

    public <T> T createDao(Class<T> interfaceClass) {

        String name = interfaceClass.getSimpleName();
        String daoClassName = daoconfig.getProperty(name);

        try {
            return (T) Class.forName(daoClassName).newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } 

    }
}