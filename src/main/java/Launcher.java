import com.researchworx.cresco.library.plugin.core.CPlugin;

public class Launcher extends CPlugin {
    public void importExecutor() {
        setExec(new Executor(this));
    }

    public void execute() {

    }

    @Override
    public void cleanUp() {

    }
}
