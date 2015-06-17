package janken

object Main {
  def main (args: Array[String]) {
    val cpu = new CPU()
  }
}

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

