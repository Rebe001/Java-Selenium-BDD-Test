package app.test.steps;

import app.test.hooks.CucumberHooks;
import com.example.app.pages.GithubAboutPage;
import io.cucumber.java.en.Then;

public class GithubAboutPageSteps {
    final String aboutUrl = "https://github.com/about";

    private GithubAboutPage githubAboutPage = new GithubAboutPage(CucumberHooks.driver);

    @Then("I landed on Github About page")
    public void landedOnGithubPage() { githubAboutPage.verifyCurrentUrl(aboutUrl);}

}
