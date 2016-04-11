import com.researchworx.cresco.library.plugin.core.CPlugin;

public class Launcher extends CPlugin {
    public void importExecutor() {
        setExec(new Executor(this));
    }

    public void execute() {
        System.out.println("Executing Skeleton Plugin");
    }

    @Override
    public void cleanUp() {

    }
}
