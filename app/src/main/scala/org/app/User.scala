package org.app

case class User(login: String,
               emknID: Int,
               preferences: List[EventType], //our user want to receive
                                             // notifications about such events
               subscriptions: List[UID])  //here we store ids of events which user subscribed on

trait UserRepository[F[_]] {
  def save(user: User): F[Unit]
  def remove(user: User): F[Unit]
  def getAll: F[List[User]]
  def findByLogin(login: String): F[User]
}
