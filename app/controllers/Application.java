package controllers;

import play.mvc.*;

public class Application extends Controller {

    public static Result unauthenticatedAction() {
        return ok();
    }

    @Security.Authenticated(ActionAuthenticator.class)
    public static Result authenticatedAction() {
        return ok("Hi, " + request().username());
    }

    @With(SecuredAction.class)
    public static Result securedAction() {
        return ok("Hi, " + request().username());
    }

}
