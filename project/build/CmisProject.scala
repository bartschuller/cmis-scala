import sbt._

class CmisProject(info: ProjectInfo) extends DefaultProject(info) {
  val jbossReleases = "JBoss Releases" at "http://repository.jboss.org/maven2/"
  val opencmis = "org.apache.chemistry.opencmis" % "chemistry-opencmis-client-impl" % "0.1.0-incubating" % "compile" // extra("docUrl" -> "http://incubator.apache.org/chemistry/javadoc/")
}
