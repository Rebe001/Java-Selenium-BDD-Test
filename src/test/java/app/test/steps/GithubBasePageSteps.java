package app.test.steps;

import app.test.hooks.CucumberHooks;
import com.example.app.pages.GithubBasePage;
import io.cucumber.java.en.When;

public class GithubBasePageSteps {

    private GithubBasePage githubBasePage = new GithubBasePage(CucumberHooks.driver);

    @When("I search query {string} on Github global navigation")
    public void searchQueryOnGitHubGlobalNavigation (String query) {
        githubBasePage.setSearchQuery(query);
    }

    @When("I click on nav item {string} on Github global navigation")
    public void clickOnNavItem(String item) { githubBasePage.clickOnNavItem(item);}

    @When("I click on {string} on footer")
    public void clickOnFooterItem(String item) {
        githubBasePage.clickOnFooterItem(item);
    }

    @When("I scroll to bottom on {string}")
    public void scrollToBottom(String item){
        githubBasePage.scrollToBottom();
    }
}
