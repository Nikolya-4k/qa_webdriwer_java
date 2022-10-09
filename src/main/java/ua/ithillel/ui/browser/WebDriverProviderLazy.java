package ua.ithillel.ui.browser;

public class WebDriverProviderLazy {

    private static WebDriverProviderLazy instance = new WebDriverProviderLazy();

    private final Object driver;

    private WebDriverProviderLazy() {
        driver = new Object();
    }

    public static WebDriverProviderLazy getInstance() {
        if (instance == null) {
            instance = new WebDriverProviderLazy();
        }
        return instance;
    }
    public Object getDriver() {
        return driver;
    }

    public static void main(String[] args) {
        WebDriverProviderLazy lazy = WebDriverProviderLazy.getInstance();
        Object driver = lazy.getDriver();
        System.out.println(driver);
    }
}
