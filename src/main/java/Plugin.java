import com.google.auto.service.AutoService;
import com.google.common.io.Closeables;
import com.researchworx.cresco.library.plugin.core.CPlugin;

@AutoService(CPlugin.class)
public class Plugin extends CPlugin {

    IaaSEngine iaas;

    @Override
    public void setExecutor() {
        setExec(new Executor(this, iaas));
    }

    public void start() {

        //String serverAddress = "127.0.0.1";
        //String tenantName = "CrescoDynamic";
        //String userName = "cresco";
        //String password = "u$cresco01";

        String serverAddress = this.config.getStringParam("iaas_host");
        String tenantName = this.config.getStringParam("tenant_name");
        String userName = this.config.getStringParam("user_name");
        String password = this.config.getStringParam("password");

        if((serverAddress != null) && (tenantName != null) && (userName !=null) && (password != null)) {
            iaas = new IaaSEngine(serverAddress,tenantName,userName,password);
        }
        else {
            logger.error("Start() IaaS must provide host, tenant, user, password config");
        }

        /*
         ssd
         *  Insert your startup code here
         */
    }

    @Override
    public void cleanUp() {
        try {
            Closeables.close(iaas, true);
        }
        catch(Exception ex) {
            logger.error("cleanUp() " + ex.getMessage());
        }
    }
}
