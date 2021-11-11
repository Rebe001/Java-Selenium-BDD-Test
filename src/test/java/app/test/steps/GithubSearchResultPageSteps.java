package app.test.steps;

import app.test.hooks.CucumberHooks;
import com.example.app.pages.GithubSearchResultPage;
import io.cucumber.java.en.When;

public class GithubSearchResultPageSteps {

    private GithubSearchResultPage githubSearchResultPage = new GithubSearchResultPage(CucumberHooks.driver);

    @When("I click on search result {string} on Github search result page")
    public void clickOnSearchResultItems (String item) {
        githubSearchResultPage.clickSearchResult(item);
    }

}
