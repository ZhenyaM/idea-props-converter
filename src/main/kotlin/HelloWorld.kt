import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.ui.Messages

class HelloWorld: AnAction("Hasdaksljd") {
    override fun actionPerformed(event: AnActionEvent?) {
        val project = event?.project
        println("HUI is here")
        Messages.showMessageDialog(project, "Hello world!", "Greeting", Messages.getInformationIcon())
    }

}