package scala.models

import scala.slick.lifted.TableQuery

import play.api.db.slick.Config.driver.simple._

object userTokens extends TableQuery(new UserTokenTable(_)) {

  def getUserFromToken(token: String)(implicit session: Session): Option[User] = {
    userTokens.filter(_.token === token).firstOption match {
      case Some(userToken: UserToken) => Some(users.filter(_.id === userToken.userId).first)
      case _ => None
    }
  }
  
}