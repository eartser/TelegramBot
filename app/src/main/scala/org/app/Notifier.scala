package org.app

trait Notifier {
  def subscribe(user: User)
  def unsubscribe(user: User)
  def notifyAll()
}
