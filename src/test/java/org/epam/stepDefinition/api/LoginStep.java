package org.epam.stepDefinition.api;

import com.energyx.models.User;
import org.epam.contexts.APITestContext;
import io.cucumber.java.en.*;
import org.testng.Assert;

public class LoginStep {

    private final APITestContext apiTestContext;

    public LoginStep(APITestContext context){
        this.apiTestContext = context;
    }

    @Given("User credentials {string} and {string}")
    public void userCredentialsAnd(String email, String password) {
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        apiTestContext.setRequestPayload(user);
    }

    @And("Store token from response")
    public void storeTokenFromResponse() {
        String token = apiTestContext.getResponse().jsonPath().getString("data.token");
        Assert.assertNotNull(token, "Token Should not be null");
        apiTestContext.setToken(token);
    }
}
