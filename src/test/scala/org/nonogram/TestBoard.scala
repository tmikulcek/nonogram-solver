package org.nonogram

import org.scalatest.{FlatSpec, Matchers}

class TestBoard extends FlatSpec with Matchers {

  "A board" should "be valid" in {
    val columns = Seq(
      Seq(1),
      Seq(2),
      Seq(2, 1),
      Seq(3, 1),
      Seq(3)
    )

    val rows = Seq(
      Seq(3),
      Seq(3),
      Seq(2),
      Seq(3),
      Seq(1, 1)
    )

    val board = new Board(columns, rows)

    board.columns should be (5)
    board.rows should be (5)
    board shouldBe 'valid

    println(board)
  }
}