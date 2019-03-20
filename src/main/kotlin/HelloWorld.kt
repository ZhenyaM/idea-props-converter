import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.ui.Messages

import io.github.props.converter.core.SuperHellower;

class HelloWorld: AnAction("Hasdaksljd") {
    override fun actionPerformed(event: AnActionEvent?) {
        val project = event?.project
//        println(sayHi())
        println(SuperHellower().sayHello())
        Messages.showMessageDialog(project, "Hello world!", "Greeting", Messages.getInformationIcon())
    }

}