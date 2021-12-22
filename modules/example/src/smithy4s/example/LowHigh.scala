package smithy4s.example

import smithy4s.syntax._

sealed abstract class LowHigh(val value: String, val ordinal: Int) extends Product with Serializable
object LowHigh extends smithy4s.Enumeration[LowHigh] {
  def namespace: String = NAMESPACE
  val name: String = "LowHigh"

  case object Low extends LowHigh("Low", 0)
  case object High extends LowHigh("High", 1)

  val values: List[LowHigh] = List(
    Low,
    High,
  )

  def to(e: LowHigh) : (String, Int) = (e.value, e.ordinal)
  val schema: smithy4s.Schema[LowHigh] = enumeration(to, valueMap, ordinalMap)
  implicit val staticSchema : schematic.Static[smithy4s.Schema[LowHigh]] = schematic.Static(schema)
}