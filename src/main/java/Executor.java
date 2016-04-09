import com.researchworx.cresco.library.messaging.MsgEvent;
import com.researchworx.cresco.library.plugin.core.CExecutor;
import com.researchworx.cresco.library.plugin.core.CPlugin;

public class Executor extends CExecutor {
    public Executor(CPlugin plugin) {
        super(plugin);
    }

    @Override
    public void processExec(MsgEvent msg) {
        switch (msg.getParam("cmd")) {
            default:
                break;
        }
    }
}
