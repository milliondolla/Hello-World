package za.co.milliondolla.rest;


import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map.Entry;
import java.util.Properties;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.Credentials;
import org.apache.http.auth.NTCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class GenericRestApiClient {

	private CloseableHttpClient httpclient;
	private CredentialsProvider credsProvider;
	private HttpClientContext context;
	private HttpHost target;
	private String theResponse;
	private String pathToPropertiesFile;
	private String pathToHttpHeaders;
	private Properties properties = new java.util.Properties();
	private Properties httpHeaders = new java.util.Properties();
	
	public static void main(String[] args) throws Exception {

		new GenericRestApiClient().init(
				"file:///path/to/some/app.conf", 
				"file:///path/to/some/headers.conf"
				)
		.getDataFromApi("/api/someresturi")
		.closeConnections();

	}

	public GenericRestApiClient init(final String pathToPropertiesFile, final String pathToHttpHeaders) throws Exception {
		
		setPathToPropertiesFile(pathToPropertiesFile);
		setPathToHttpHeaders(pathToHttpHeaders);

		final String localHostName = java.net.InetAddress.getLocalHost().getHostName();

		// NTLM auth WITHOUT Username & Password. Using just the Token
		// System.out.println(configureHttpClient().callApi(configureCredentials()));

		loadProperties().configureHttpClient(configureNTCredentials(properties.getProperty("USERNAME"),
				properties.getProperty("PASSWORD"), localHostName, properties.getProperty("DOMAIN")));

		return this;
	}
	
	private GenericRestApiClient loadProperties() throws Exception{

		if (pathToPropertiesFile == null || pathToPropertiesFile.trim().length() == 0)
			throw new Exception("Path to properties file not supplied in command line arguments");

		properties.load(Files.newInputStream(Paths.get(new URI(pathToPropertiesFile))));
		
		return this;
	}

	private GenericRestApiClient configureHttpClient(final CredentialsProvider cp) throws IOException {

		setCredsProvider(cp);

		if (this.httpclient == null || target == null || context == null) {

			// Configure a target
			target = new HttpHost(properties.getProperty("HOST"), Integer.parseInt(properties.getProperty("PORT")),
					properties.getProperty("PROTOCOL"));

			// Configure HTTP Context
			context = HttpClientContext.create();
			context.setCredentialsProvider(getCredsProvider());

			setHttpclient(HttpClients.createDefault());
		}

		return this;
	}

	@SuppressWarnings("rawtypes")
	public GenericRestApiClient getDataFromApi(final String restResource) throws IOException {

		// Configure the Get
		HttpRequest httpget = new HttpGet(restResource);

		CloseableHttpResponse response1 = null;
		StringWriter writer = null;
		setTheResponse("No response!!");
		InputStream is = null;
		try {
			
			if(httpHeaders == null || httpHeaders.isEmpty()) loadHttpHeaders();
			
			for(Entry o : httpHeaders.entrySet()){
				httpget.setHeader(o.getKey().toString(), o.getValue().toString());
			}

			response1 = httpclient.execute(target, httpget, context);

			HttpEntity entity1 = response1.getEntity();
			is = entity1.getContent();

			writer = new StringWriter();
			IOUtils.copy(is, writer, properties.getProperty("ENCODING"));
			setTheResponse(writer.toString());

		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			writer.close();
			is.close();
			response1.close();
		}

		return this;

	}

//	private CredentialsProvider configureCredentials() {
//		return new BasicCredentialsProvider();
//	}

	private CredentialsProvider configureNTCredentials(final String username, final String password,
			final String localHostName, final String domain) {
		CredentialsProvider credsProvider = new BasicCredentialsProvider();
		Credentials cred = new NTCredentials(username, password, localHostName, domain);
		credsProvider.setCredentials(AuthScope.ANY, cred);
		return credsProvider;
	}

	public CloseableHttpClient getHttpclient() {
		return httpclient;
	}

	private final void setHttpclient(CloseableHttpClient httpclient) {
		this.httpclient = httpclient;
	}
	
	private void loadHttpHeaders() throws Exception{
		
		if (pathToHttpHeaders == null || pathToHttpHeaders.trim().length() == 0)
			throw new Exception("Path to HTTP Header properties file not supplied in command line arguments");

		httpHeaders.load(Files.newInputStream(Paths.get(new URI(pathToHttpHeaders))));
	}

	private void closeConnections() throws IOException {
		this.httpclient.close();
	}

	public String getTheResponse() {
		return theResponse;
	}

	private final void setTheResponse(String theResponse) {
		this.theResponse = theResponse;
	}

	public CredentialsProvider getCredsProvider() {
		return credsProvider;
	}

	private final void setCredsProvider(CredentialsProvider credsProvider) {
		this.credsProvider = credsProvider;
	}

	public String getPathToPropertiesFile() {
		return pathToPropertiesFile;
	}

	private final void setPathToPropertiesFile(String pathToPropertiesFile) {
		this.pathToPropertiesFile = pathToPropertiesFile;
	}

	public String getPathToHttpHeaders() {
		return pathToHttpHeaders;
	}

	private final void setPathToHttpHeaders(String pathToHttpHeaders) {
		this.pathToHttpHeaders = pathToHttpHeaders;
	}

	@Override
	public String toString() {
		return this.theResponse;
	}

}
