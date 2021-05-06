package org.app

import scala.util.Try

case class User[F[_]](login: String,
                      emknID: Int,
                      preferences: List[EventType], //our user want to receive
                                              // notifications about such events
                      subscribedEvents: EventRepository[F]) {
  def subscribe(event: Event): F[Unit] = subscribedEvents.save(event)
  def unsubscribe(event: Event): F[Unit] = subscribedEvents.remove(event)
}

trait UserRepository[G[_], F[_]] {
  def save(user: User[F]): G[Unit]
  def remove(user: User[F]): G[Unit]
  def getAll: G[List[User[F]]]
  def findByLogin(login: String): G[User[F]]
}
