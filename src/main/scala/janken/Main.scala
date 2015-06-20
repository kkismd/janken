package janken

import janken.Addressing._
import janken.Instruction._

object Main {
  def main (args: Array[String]) {
    val program = List(
      LDA(Immediate(0xff)),
      STA(ZeroPage(1))
    )
    val cpu = new CPU()
    cpu.load(program)
//    println(cpu.dump())
    cpu.memset()
    cpu.run()
    println(cpu.dump())
  }
}

