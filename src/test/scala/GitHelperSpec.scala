import java.io.File
import org.specs2.mutable.Specification

object GitHelperSpec extends Specification {

  "Git helper" should {
    "get git repo contents" in {
      GitHelper.initialize
      GitHelper.dir.listFiles().length > 0 mustEqual true
    }

  }

}