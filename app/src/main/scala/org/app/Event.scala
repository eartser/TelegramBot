package org.app

import java.net.URL
import java.time.ZonedDateTime

sealed trait EventType
case object Assignment extends EventType
case object Class extends EventType

case class Event(uid: String,
                 summary: String,
                 eventType: EventType,
                 dateStart: ZonedDateTime,
                 dateEnd: ZonedDateTime,
                 dateLastModified: ZonedDateTime,
                 dateLastUpdated: ZonedDateTime, //when we updated this event last time in our program
                 description: String,
                 url: URL)

trait EventRepository[F[_]] {
  def save(event: Event): F[Unit]
  def remove(event: Event): F[Unit]
  def getByUID(uid: String): F[Event]
  def getAll: F[List[Event]]
  def getByTime(dateStart: ZonedDateTime, dateEnd: ZonedDateTime): F[List[Event]]
  def getByType(eventType: EventType): F[List[Event]]
  def getByTimeAndType(dateStart: ZonedDateTime, dateEnd: ZonedDateTime, eventType: EventType): F[List[Event]]
}
