package app.test.steps;

import app.test.hooks.CucumberHooks;
import com.example.app.pages.GithubRepositoryPage;
import io.cucumber.java.en.Then;

public class GithubRepositoryPageSteps {

    private GithubRepositoryPage githubRepositoryPage = new GithubRepositoryPage(CucumberHooks.driver);

    @Then("I can view Github Repository titled {string}")
    public void landedOnGitHubHomePage(String repoName) {
        githubRepositoryPage.verifyHeader(repoName);
    }
}
