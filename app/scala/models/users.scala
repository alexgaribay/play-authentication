package scala.models

import scala.slick.lifted.TableQuery

import play.api.db.slick.Config.driver.simple._

object users extends TableQuery(new UserTable(_)) {

}