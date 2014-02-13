import java.io.File
import org.eclipse.jgit.api.{Git, CloneCommand}
import org.eclipse.jgit.api.errors.JGitInternalException
import org.eclipse.jgit.internal.storage.file.FileRepository

/**
 * Created by k on 13.02.14.
 */
object GitHelper {

  require {
    initialize
  }

  def dir = {
    val f = new File("./questions")
    f.mkdirs()
    f
  }

  def cloneRepository = try {
    new CloneCommand().setURI("git://github.com/10sheet/interview-repo.git").setDirectory(dir).call()
  } catch {
    case e: JGitInternalException =>
  }

  def git = {
    val repo = new FileRepository(dir.getAbsolutePath + "/.git")
    new Git(repo)
  }

  def initialize = {
    cloneRepository
    git.pull
    true
  }

}