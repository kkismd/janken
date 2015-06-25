import janken.Addressing._
import janken.CPU
import janken.Instruction._
import org.scalatest.FunSpec

class CPUSpec extends FunSpec {
  describe("lda") {
    it("immediate") {
      val cpu = new CPU
      val program = List(
        LDA(Immediate(1))
      )
      cpu.load(program)
      cpu.run()
      assert{ cpu.R.A == 1 }
    }

    it("absolute") {
      val cpu = new CPU
      val program = List(
        LDA(Absolute(1))
      )
      cpu.load(program)
      cpu.memory(1) = 9
      cpu.run()
      assert{ cpu.R.A == 9 }
    }

    it("absolute X") {
      val cpu = new CPU
      val program = List(
        LDX(Immediate(1)),
        LDA(AbsoluteX(0x10))
      )
      cpu.load(program)
      cpu.memory(0x11) = 9
      cpu.run()
      assert{ cpu.R.A == 9 }
    }

    it("absolute Y") {
      val cpu = new CPU
      val program = List(
        LDY(Immediate(1)),
        LDA(AbsoluteY(0xff))
      )
      cpu.load(program)
      cpu.memory(0x100) = 9
      cpu.run()
      assert{ cpu.R.A == 9 }
    }
  }

}
