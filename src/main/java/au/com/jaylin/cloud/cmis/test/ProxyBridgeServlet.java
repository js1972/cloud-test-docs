package au.com.jaylin.cloud.cmis.test;

import javax.servlet.annotation.WebServlet;


/**
 * Access this servlet @ https://cmisproxyp1081110trial.hanatrial.ondemand.com/cloud-test-docs/cmis/json
 * using the following settings in the CMIS Workbench tool:
 * url: as above
 * binding: browser
 * user: <neo username> (without the trial postfix)
 * password: <neo password>
 * Default settings for the rest...
 * 
 */
@WebServlet(urlPatterns = "/cmis/*")
public class ProxyBridgeServlet extends com.sap.ecm.api.AbstractCmisProxyServlet {
	private static final long serialVersionUID = -671235170832024834L;

	@Override
	protected String getRepositoryKey() {
		return "secretkey1234567890";
	}

	@Override
	protected String getRepositoryUniqueName() {
		return "p1081110_TestCMISRepository";
	}

}
