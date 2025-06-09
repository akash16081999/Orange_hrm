package com.qa.utils;

import org.testng.annotations.DataProvider;

public class TestDataProvider {

    @DataProvider(name = "InvalidPassword")
    public String[][] loginWithInvalidPassword() {
        return new String[][]{
                {System.getProperty("email"), "sahdkahd"}
        };

    }

    @DataProvider(name = "Emptyusername")
    public String[][] loginWithInEmptyUsername() {
        return new String[][]{{"", System.getProperty("password")}

        };
    }

    @DataProvider(name = "Emptypassword")
    public String[][] loginWithInEmptyPassword() {
        return new String[][]{{System.getProperty("email"), ""}

        };

    }
}

