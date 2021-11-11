package app.test.steps;

import app.test.hooks.CucumberHooks;
import com.example.app.pages.GithubHomePage;
import io.cucumber.java.en.Then;

public class GithubHomePageSteps{

    private GithubHomePage githubHomePage = new GithubHomePage(CucumberHooks.driver);

    final String githubHomePageUrl = "https://github.com/";

    @Then("I landed on Github home page")
    public void landedOnGitHubHomePage() {
        githubHomePage.verifyCurrentUrl(githubHomePageUrl);
    }
}
