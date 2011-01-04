import org.apache.chemistry.opencmis.client.api.{CmisObject, Session}
import org.apache.chemistry.opencmis.commons.enums.BindingType
import org.apache.chemistry.opencmis.commons.{SessionParameter => SP}
import scala.collection.mutable.Map
import scala.collection.JavaConversions._
import org.apache.chemistry.opencmis.client.runtime.SessionFactoryImpl


class CMIS(url: String, repositoryId: String, user: String, password: String) {
  val factory = SessionFactoryImpl.newInstance
  val params = Map(
    SP.ATOMPUB_URL -> url,
    SP.REPOSITORY_ID -> repositoryId,
    SP.USER -> user,
    SP.PASSWORD -> password,
    SP.BINDING_TYPE -> BindingType.ATOMPUB.value
  )
  val session: Session = factory.createSession(params)
}

object CMIS {
  def main(args: Array[String]) {
    val cmis = new CMIS("http://localhost:8080/alfresco/service/cmis", "3a3e64a2-f586-4d9e-ba61-11a953d0dd42", "admin", "admin")
    //val root = cmis.session.getRootFolder
    val child=cmis.session.getObjectByPath("/Sites/testsite/dataLists/6c90835b-4157-47b2-bddd-1d10b727f022/1678331a-c200-49f5-ad3a-999b96ea81a2")
    for (//child <- root.getChildren;
         prop <- child.getProperties) {
      println(prop.getDefinition.getDisplayName+": "+prop.getValuesAsString)
    }
  }
}
