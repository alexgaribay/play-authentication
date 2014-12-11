package scala.controllers

object SomeController extends ScalaAuthenticatedController {
  def authAction = Authenticated { request =>
    val user = request.user
    // do something with user
    Ok
  }
}