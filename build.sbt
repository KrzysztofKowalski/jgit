// http://www.eclipse.org/jgit/download/

name := "scala git getter"
 
resolvers += "jgit-repo" at "http://download.eclipse.org/jgit/maven"
 
libraryDependencies += "org.eclipse.jgit" % "org.eclipse.jgit" % "+"

libraryDependencies += "org.slf4j" % "slf4j-log4j12" % "1.7.5"

libraryDependencies += "org.specs2" %% "specs2" % "+"