
object MyGit extends App {

  override def main(args: Array[String]) = {
    import FileHelper._
    import GitHelper._
    val depth = args.headOption.getOrElse("1").toInt
    listing(dir, depth)
  }

}