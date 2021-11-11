package app.test.steps;

import app.test.hooks.CucumberHooks;
import com.example.app.pages.GoogleHomePage;
import io.cucumber.java.en.Given;

public class GoogleHomePageSteps {

    private final GoogleHomePage googleHomePage = new GoogleHomePage(CucumberHooks.driver);

    @Given("I search query {string} on Goggle")
    public void searchQueryOnGoogle(String query) {
        googleHomePage.setSearchQuery(query);
    }

}
