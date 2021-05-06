package org.app

case class Calendar[F[_]](user: User[F], events: List[Event])
