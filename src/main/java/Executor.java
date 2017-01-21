import com.researchworx.cresco.library.messaging.MsgEvent;
import com.researchworx.cresco.library.plugin.core.CExecutor;
import com.researchworx.cresco.library.plugin.core.CPlugin;
import com.researchworx.cresco.library.utilities.CLogger;

public class Executor extends CExecutor {
    private IaaSEngine iaas;
    private Plugin plugin;
    private CLogger logger;

    public Executor(CPlugin plugin, IaaSEngine iaas) {
        super(plugin);
        this.iaas = iaas;

    }

    @Override
    public MsgEvent processConfig(MsgEvent msg) {
        logger.trace("Processing Config message");
        if (msg.getParam("configtype") == null) return null;
        logger.debug("Config-type is properly set, as well as message body");
        switch (msg.getParam("configtype")) {
            case "addresource":
                logger.debug("Add Resource message type found");
                if(msg.getParam("instance_name") == null) return null;
                String addinstanceId = iaas.createInstance(msg.getParam("instance_name"));
                if(addinstanceId != null) {
                    msg.setParam(addinstanceId,"added");
                }
                return msg;
            case "rmresource":
                logger.debug("Add Resource message type found");
                if(msg.getParam("instance_name") == null) return null;
                if(iaas.deleteInstance(msg.getParam("instance_name"))) {
                    msg.setParam(msg.getParam("instance_name"),"removed");
                }
                return msg;
            default:
                logger.debug("Unknown configtype found: {}", msg.getParam("configtype"));
                return null;
        }
    }

}
