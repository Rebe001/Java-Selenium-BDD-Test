package app.test.steps;

import app.test.hooks.CucumberHooks;
import com.example.app.pages.BasePage;
import io.cucumber.java.en.Given;

public class BasePageSteps {

    private BasePage basePage = new BasePage(CucumberHooks.driver);

    @Given("I navigate to {string}")
    public void navigateToGoogle(String url) {
        basePage.navigateToUrl(url);
    }

}
