import java.io.File

/**
 * Created by k on 13.02.14.
 */
object FileHelper {

  val logger = java.util.logging.Logger.getLogger("FileHelper")

  def log(msg: String) = println(msg)

  def list(dir: File) = dir.listFiles().filter(!_.getName.startsWith(".git"))

  def dirs(dir: File) = list(dir).filter(_.isDirectory)

  def sort(dir: File) = list(dir).filter(!_.isDirectory).sortBy(_.length()).reverse

  def listing(dir: File, level: Int) = recur(dir, level)

  protected def recur(dir: File, level: Int = 0, tab: Int = 0): Boolean = (level > 0) match {
    case true =>
      val tabs = """  """ * (tab - 1)
      if (tab > 0) log(s"${tabs}${dir.getName}/")
      dirs(dir).map(recur(_, level - 1, tab + 1))
      sort(dir).map(a => log( s"""    ${tabs}${a.getName}"""))
      true
    case false => true
  }
}