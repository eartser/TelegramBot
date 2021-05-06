package org.app

case class Calendar[F](user: User[F], events: List[Event])
