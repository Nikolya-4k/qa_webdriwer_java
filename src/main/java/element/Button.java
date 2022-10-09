package element;

import org.openqa.selenium.WebElement;

public class Button {
    private WebElement button;

    public void setElement(WebElement element) {
        this.button = button;
    }

    public String getValue() {
        return button.getAttribute("localName");
    }

    public void clickButton() {
        button.click();
    }
}
