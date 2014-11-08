package controllers;

import play.mvc.Controller;
import play.mvc.With;

/**
 * A class where all actions require authentication which is provided by the
 * SecuredAction class
 */
@With(SecuredAction.class)
public abstract class SecuredController extends Controller {}
