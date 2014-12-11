import models.User;
import org.junit.Assert;
import org.junit.Test;
import play.mvc.Result;
import play.test.FakeRequest;
import play.test.WithApplication;

import java.util.UUID;

import static play.mvc.Http.Status.OK;
import static play.mvc.Http.Status.UNAUTHORIZED;
import static play.test.Helpers.route;
import static play.test.Helpers.status;

public class AuthenticatedControllerTest extends WithApplication {
    @Test
    public void testAuthenticatedAction() {
        User testUser = createTestUser();
        FakeRequest request = new FakeRequest("GET", "/authRequest");

        Result unauthorizedResult = route(request);
        Assert.assertEquals(UNAUTHORIZED, status(unauthorizedResult));

        Result authorizedResult = route(request.withHeader("X-AUTH-TOKEN", testUser.token));
        Assert.assertEquals(OK, status(authorizedResult));
    }

    private User createTestUser() {
        User testUser = new User();
        testUser.username = "test";
        testUser.token = UUID.randomUUID().toString();
        testUser.save();
        return testUser;
    }
}
