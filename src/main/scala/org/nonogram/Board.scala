package org.nonogram

class Board(columnHints: Seq[Seq[Int]], rowHints: Seq[Seq[Int]]) {
  val columns: Int = columnHints.size
  val rows: Int = rowHints.size

  def isValid: Boolean = {
    columnHints.map(_.sum).sum == rowHints.map(_.sum).sum
  }

  override def toString: String = {
    val longestColumnSize = columnHints.map(_.size).max
    val longestRowSize = rowHints.map(_.size).max

    def reformatNumbers(prefix: String)(row: Seq[Int]) = {
      row.map {
          case 0 => "  "
          case n => n.toString
        }.mkString(prefix, "\t", "\n")
    }

    val formattedRows = rowHints
      .map(row => {
        val prefixSize = longestRowSize - row.size
        new Array[Int](prefixSize).toSeq ++ row
      })
      .map(reformatNumbers(""))
      .mkString("")

    val rowPrefix = Stream.continually(" ").take(longestRowSize).mkString("\t")
    val formattedColumns = columnHints
      .map(column => {
        val prefixSize = longestColumnSize - column.size
        new Array[Int](prefixSize) ++ column
      })
      .transpose
      .map(reformatNumbers(rowPrefix))
      .mkString("")

    formattedColumns + formattedRows
  }
}
