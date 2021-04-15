package org.app

case class User(login: String, password: String)

trait UserRepository {
  def save(user: User)
  def remove(user: User)
  def getAll: List[User]
  def findByLogin(login: String): User
}
