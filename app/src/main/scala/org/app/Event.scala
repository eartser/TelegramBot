package org.app

sealed trait EventType
case object Lecture extends EventType
case object Seminar extends EventType
case object Homework extends EventType
case object Test extends EventType

case class Event(name: String, eventType: EventType)

trait EventRepository {
  def save(event: Event)
  def remove(event: Event)
  def getAll: List[Event]
}
