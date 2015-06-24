package janken

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
  case object TSX extends Instruction
  case object TXA extends Instruction
  case object TYA extends Instruction
  case object TXS extends Instruction
  case class ADC(addressing: Addressing) extends Instruction
}

sealed trait Addressing
object Addressing extends Typing {
  case class Implied() extends Addressing
  case class Accumulator() extends Addressing
  case class Immediate(operand: b8) extends Addressing
  case class Absolute(operand: b16) extends Addressing
  case class AbsoluteX(operand: b16) extends Addressing
  case class AbsoluteY(operand: b16) extends Addressing
  case class ZeroPage(operand: b8) extends Addressing
  case class ZeroPageX(operand: b8) extends Addressing
  case class ZeroPageY(operand: b8) extends Addressing
  case class Relative(operand: b8) extends Addressing
  case class Indirect(operand: b8) extends Addressing
  case class IndirectX(operand: b8) extends Addressing
  case class IndirectY(operand: b8) extends Addressing
}

