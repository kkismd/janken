package janken

import janken.Addressing._
import janken.Instruction._

/**
 * 扱う数値の大きさ
 * オーバーフローや符号のためどちらもIntを使う
 */
trait Typing {
  type b8 = Int
  type b16 = Int
}

class CPU extends Typing {
  val memory = Array.fill(1024)(0)
  var program: Seq[Instruction] = Seq()

  object R {
    var A: b8 = 0
    var X: b8 = 0
    var Y: b8 = 0
    var S: b8 = 0
    var PC: b16 = 0
    var P: b8 = 0
  }

  def run(): Unit = {
    program.foreach { instruction =>
      interpret(instruction)
    }
  }

  def interpret(instruction: Instruction): Unit = {
    instruction match {
      case LDA(addressing) => lda(addressing)
      case LDX(addressing) =>
      case LDY(addressing) =>
      case STA(addressing) => sta(addressing)
      case STX(addressing) =>
      case STY(addressing) =>
      case TAX => tax()
      case TAY => tay()
      case TSX =>
      case TXA =>
      case TXS =>
      case TYA =>
      case ADC(addressing) => adc(addressing)

      case _ => error
    }
  }

  def zeroPage(address: b8): Int = address.toInt

  def lda(addressing: Addressing): Unit = {
    R.P = 0
    R.A = addressing match {
      case Immediate(b8)  => b8
      case _ => memory(address(addressing))
    }
  }

  def sta(addressing: Addressing): Unit = {
    R.P = 0
    memory(address(addressing)) = R.A
  }

  def tax(): Unit = {
    R.P = 0
    R.X = R.A
  }

  def tay(): Unit = {
    R.P = 0
    R.Y = R.A
  }
  def adc(addressing: Addressing): Unit = {

  }

  def address(addressing: Addressing): b16 = {
    addressing match {
      case ZeroPage(b8)   => zeroPage(b8)
      case ZeroPageX(b8)  => zeroPage(b8 + R.X)
      case Absolute(b16)  => b16
      case AbsoluteX(b16) => b16 + R.X
      case AbsoluteY(b16) => b16 + R.Y
      case IndirectX(b8)  => memory(b8 + R.X)
      case IndirectY(b8)  => memory(b8) + R.Y
      case _ => error
    }
  }

  def load(program: Seq[Instruction]): Unit = {
    this.program = program
  }

  private[this] def error = throw new RuntimeException

  def dump(): String = {
    memory.map { "%02X".format(_) }
      .grouped(0x20)
      .map(_.mkString(" "))
      .mkString("\n")
  }

  def memset(): Unit = {
    0 to 1023 foreach { i =>
      memory(i) = i % 0x100
    }
  }
}
