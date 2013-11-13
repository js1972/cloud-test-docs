cloud-test-docs
======================

Test the HANA Cloud Document Service.


This app is managed with maven.

 The CMIS api jars are propvided in the neo sdk.

This app is made up of two servlets. The first one SetupCMISRepository (urlPatterns = "/*") is a copy of the example given in the online help (https://help.hana.ondemand.com/help/frameset.htm?e62cd24abb571014b73792d85402f104.html). This servlet needs to be run first to setup the CMIS Repository.
The second servlet ProxyBridgeServlet (urlPatterns = "/cmis/*") is a Proxy Bridge which extends com.sap.ecm.api.AbstractCmisProxyServlet. This servlet allows external tools, such as the CMIS Workbench, to proxy through to the underlying document storage. Note that we have setup a security role that must be assigned to any users.

The CMIS Workbench can be downloaded from chemistry.apache.org/java/download.html -> "OpenCMIS Workbench".

Use the following instead of the standard CMIS Workbench batch file to handle settings the path and proxy options:

SET PATH=%PATH%;C:\MyScratchFolder\sapjvm_7\bin

cd %~dp0\lib

rem use variable CUSTOM_JAVA_OPTS to set additional JAVA options
set "JAVA_OPTS=-Djava.net.useSystemProxies=true -Dorg.apache.chemistry.opencmis.binding.webservices.jaxws.impl=sunjre -Dhttps.proxyHost=localhost -Dhttps.proxyPort=3128"

start /B javaw %JAVA_OPTS% %CUSTOM_JAVA_OPTS% -classpath ".;*" org.apache.chemistry.opencmis.workbench.Workbench
