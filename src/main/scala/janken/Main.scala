package janken

class Main {

}

sealed trait Instruction
object Instruction {
  case class LDA(addressing: Addressing) extends Instruction
  case class LDX(addressing: Addressing) extends Instruction
  case class LDY(addressing: Addressing) extends Instruction
  case class STA(addressing: Addressing) extends Instruction
  case class STX(addressing: Addressing) extends Instruction
  case class STY(addressing: Addressing) extends Instruction
  case object TAX extends Instruction
  case object TAY extends Instruction
  case object TXA extends Instruction
  case object TYA extends Instruction
  case object TXS extends Instruction
}

sealed trait Addressing
object Addressing {
  case class Implied() extends Addressing
  case class Accumulator() extends Addressing
  case class Immediate(operand: Byte) extends Addressing
  case class Absolute(operand: Short) extends Addressing
  case class AbsoluteX(operand: Short) extends Addressing
  case class AbsoluteY(operand: Short) extends Addressing
  case class Zeropage(operand: Byte) extends Addressing
  case class ZeropageX(operand: Byte) extends Addressing
  case class ZeropageY(operand: Byte) extends Addressing
  case class Relative(operand: Byte) extends Addressing
  case class Indirect(operand: Byte) extends Addressing
  case class IndirectX(operand: Byte) extends Addressing
  case class IndirectY(operand: Byte) extends Addressing
}

class

class CPU {
  val memory = Array.fill(1024)(0.toByte)
  var program: Seq[Instruction] = Seq()

  object registers {
    var A: Byte = 0
    var X: Byte = 0
    var Y: Byte = 0
    var PC: Short = 0
    var SP: Short = 0

  }

  def run(): Unit = {
    dump()
  }

  def load(program: Seq[Instruction]): Unit = {

  }

  def dump(): String = {
    memory.map { "%X".format(_) } mkString " "
  }

}

object Main {
  def main (args: Array[String]) {
    val cpu = new CPU()
  }
}

