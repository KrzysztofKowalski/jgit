
object MyGit extends App {

  override def main(args: Array[String]) = {
    import FileHelper._
    import GitHelper._
    val depth = try {
      args.headOption.getOrElse("0").toInt
    } catch {
      case n: NumberFormatException => 0
    }
    listing(dir, depth + 1)
  }

}