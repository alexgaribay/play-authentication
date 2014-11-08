package scala.models

import play.api.db.slick.Config.driver.simple._

case class User(id: Option[Int] = None, username: String)

class UserTable(tag: Tag) extends Table[User](tag, "ScalaUsers") {
  def id = column[Int]("id", O.PrimaryKey, O.AutoInc)
  def username = column[String]("username")
  def * = (id.?, username) <>((User.apply _).tupled, User.unapply _)
}
