package scala.models

import play.api.db.slick.Config.driver.simple._


case class UserToken(id: Option[Int] = None, token: String, userId: Int)

class UserTokenTable(tag: Tag) extends Table[UserToken](tag, "ScalaUserTokens") {
  def id = column[Int]("id", O.PrimaryKey, O.AutoInc)
  def token = column[String]("token")
  def userId = column[Int]("user_id")
  def * = (id.?, token, userId) <>((UserToken.apply _).tupled, UserToken.unapply _)

  def user = foreignKey("user_id", userId, users)(_.id)
}
