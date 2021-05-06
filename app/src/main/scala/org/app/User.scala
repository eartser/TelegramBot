package org.app

import scala.util.Try

case class User(login: String,
                emknID: Int,
                preferences: List[EventType], //our user want to receive
                                              // notifications about such events
                subscribedEvents: EventRepository[Try]) {
  def subscribe(event: Event): Try[Unit] = subscribedEvents.save(event)
  def unsubscribe(event: Event): Try[Unit] = subscribedEvents.remove(event)
}

trait UserRepository[F[_]] {
  def save(user: User): F[Unit]
  def remove(user: User): F[Unit]
  def getAll: F[List[User]]
  def findByLogin(login: String): F[User]
}
