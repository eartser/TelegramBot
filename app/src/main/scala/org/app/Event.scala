package org.app

object EventType extends Enumeration {
  type EventType = Value
  val Lecture, Seminar, Homework, Test = Value
}

import EventType._

case class Event(name: String, eventType: EventType)

trait EventRepository {
  def save(event: Event)
  def remove(event: Event)
  def getAll: List[Event]
}
