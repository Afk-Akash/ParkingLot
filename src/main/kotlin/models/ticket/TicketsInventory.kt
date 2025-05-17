package org.parkingLot.models.ticket

object TicketsInventory {
    var activeTicket : MutableSet<ParkingTicket> = mutableSetOf()
    var inActiveTicket: MutableSet<ParkingTicket> = mutableSetOf()
}
