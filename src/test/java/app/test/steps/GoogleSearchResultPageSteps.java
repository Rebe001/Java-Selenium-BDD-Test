package app.test.steps;

import app.test.hooks.CucumberHooks;
import com.example.app.pages.GoogleSearchResultPage;
import io.cucumber.java.en.Given;

public class GoogleSearchResultPageSteps {

    private GoogleSearchResultPage googleSearchResultPage = new GoogleSearchResultPage(CucumberHooks.driver);

    @Given("I click on first result on Google")
    public void clickOnFirstLinkMatchedWith() {
        googleSearchResultPage.clickOnFirstResult();
    }

}
