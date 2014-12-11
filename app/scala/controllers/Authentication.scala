package scala.controllers

import play.api.mvc.{Results, Controller, RequestHeader, Security}
import play.api.Play.current
import scala.models.{userTokens, User}

trait Authentication {

  val AUTH_TOKEN_HEADER = "X-AUTH-TOKEN"

  object Authenticated extends Security.AuthenticatedBuilder(checkTokenAndGetUser(_), onUnauthorized(_))

  def checkTokenAndGetUser(request: RequestHeader): Option[User] = {
    request.headers.get(AUTH_TOKEN_HEADER).flatMap( token =>

      play.api.db.slick.DB.withSession { implicit session =>
        userTokens.getUserFromToken(token)
      }
    )
  }

  def onUnauthorized(request: RequestHeader) = Results.Unauthorized
}

trait ScalaAuthenticatedController extends Controller with Authentication
