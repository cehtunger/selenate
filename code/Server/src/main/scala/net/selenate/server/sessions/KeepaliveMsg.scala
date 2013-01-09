package net.selenate
package server
package sessions

import common.comms.req.SeCommsReq
import common.comms.req.SeReqStartKeepalive

import akka.util.Duration
import akka.util.duration._
import scala.collection.JavaConversions._

object KeepaliveMsg {
  def fromReq(req: SeReqStartKeepalive) = {
    val delay = req.delayMillis.milliseconds
    val reqList = req.reqList.toIndexedSeq

    KeepaliveMsg(delay, reqList)
  }
}
case class KeepaliveMsg(delay: Duration, reqList: IndexedSeq[SeCommsReq])
