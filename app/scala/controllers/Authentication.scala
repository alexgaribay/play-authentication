package scala.controllers

import play.api.mvc.{Results, Controller, RequestHeader, Security}

import scala.models.{userTokens, User}

trait Authentication {

  val AUTH_TOKEN_HEADER = "X-AUTH-TOKEN"

  object Authenticated extends Security.AuthenticatedBuilder(req => getUserFromRequest(req))

  def getUserFromRequest(request: RequestHeader): Option[User] = {
    request.headers.get(AUTH_TOKEN_HEADER) match {
      case Some(token) => {
        import play.api.Play.current
        play.api.db.slick.DB.withSession { implicit session =>
          userTokens.getUserFromToken(token)
        }
      }
      case _ => None
    }
  }

  def onUnauthorized(request: RequestHeader) = Results.Unauthorized
}

trait AuthenticatedController extends Controller with Authentication
