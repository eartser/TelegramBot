package org.app

case class User(login: String, emknID: Int)

trait UserRepository[F[_]] {
  def save(user: User): F[Unit]
  def remove(user: User): F[Unit]
  def getAll: F[List[User]]
  def findByLogin(login: String): F[User]
}
