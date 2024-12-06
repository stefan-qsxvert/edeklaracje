package org.mnapp.app;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.KeyStore;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.net.ssl.SSLContext;
import com.test.edeklaracje.GateService;
import com.test.edeklaracje.GateServicePortType;
import com.test.edeklaracje.RequestUPO;
import jakarta.xml.ws.Holder; 

public class Bady {
	
	Holder<String> refId;
	Holder<Integer> status;
	Holder<String> statusOpis;
	Holder<String> upo;
//	byte[] document;
	String id;
	
	public Bady(byte[] document, Holder<String> refId, Holder<Integer> status, Holder<String> statusOpis) {
//		this.document = document;
		this.refId = refId;
		this.status = status;
		this.statusOpis = statusOpis;
	}
	
	public Bady(Holder<String> refId, Holder<Integer> status, Holder<String> statusOpis) {
		this.refId = refId;
		this.status = status;
		this.statusOpis = statusOpis;
	}
	
	public Bady() {
	}
	
		public void sendDoc(byte[] document) {
			try { 
				// Załaduj klucz prywatny z keystore 
				 KeyStore keyStore = KeyStore.getInstance("JKS"); 
				 keyStore.load(new FileInputStream("/home/tee/eclipse-workspace/keystore.jks"), "qqq111".toCharArray()); 
				 // Załaduj zaufane certyfikaty z truststore 
				 KeyStore trustStore = KeyStore.getInstance("JKS"); 
				 trustStore.load(new FileInputStream("/home/tee/eclipse-workspace/keystore.jks"), "qqq111".toCharArray()); 
				 // Skonfiguruj SSLContext 
				 SSLContext sslContext = SSLContext.getInstance("TLS"); 
				 // Inicjalizuj SSLContext z trustManager i keyManager 
				
					GateService service = new GateService(); 
					GateServicePortType port = service.getGateServiceSOAP11Port(); // Przykładowe wywołanie operacji 
					
					//document = new Byte{0,1,0,1};
					
					refId = new Holder();
					status = new Holder();
					statusOpis = new Holder();
					
					port.sendDocument(document, refId, status, statusOpis); 
					System.out.println("Response: " + refId.value );
					System.out.println("Response: " + status.value );
					System.out.println("Response: " + statusOpis.value );
					
					BufferedWriter bfw = new BufferedWriter(new FileWriter("/home/tee/test.list", true));
					bfw.newLine();
					bfw.write(ZonedDateTime.now().toString() + "_" + refId.value + "_" + status.value + " " + statusOpis.value);
					bfw.flush();
					bfw.close();
					
				} catch (Exception e) { 
						e.printStackTrace();
				} 

		}
		
		public void listOfDocument(String list) throws IOException {
			File file = new File(list);
			BufferedReader bfReader = new BufferedReader(new FileReader(file));
			String listOfRfIds = bfReader.lines().toArray().toString();
//			List<String> listOfRfIds = bfReader.lines().toList();
//			for (int i =0; listOfRfIds != null; i++) {
//			String[] listRfIds = bfReader.lines().toList().toString().split(", ");
//				String listOfRfIds = bfReader.readLine();
			
//			while ((line = rd.readLine()) != null) {
//		        // buffer.append(line);
//		        message += line;
//		    }
			
			bfReader.close();
			System.out.println(file.exists());
			System.out.println(listOfRfIds);
//			}
			
		}
		
		public void getUPO() {
			try { 
//				// Załaduj klucz prywatny z keystore 
				 KeyStore keyStore = KeyStore.getInstance("JKS"); 
				 keyStore.load(new FileInputStream("/home/tee/eclipse-workspace/keystore.jks"), "qqq111".toCharArray()); 
				 // Załaduj zaufane certyfikaty z truststore 
				 KeyStore trustStore = KeyStore.getInstance("JKS"); 
				 trustStore.load(new FileInputStream("/home/tee/eclipse-workspace/keystore.jks"), "qqq111".toCharArray()); 
				 // Skonfiguruj SSLContext 
				 SSLContext sslContext = SSLContext.getInstance("TLS"); 
				 // Inicjalizuj SSLContext z trustManager i keyManager 
				
//				// Utwórz instancję usługi 
				GateService service = new GateService(); 
				GateServicePortType port = service.getGateServiceSOAP11Port(); 
				// Utwórz żądanie UPO 
				RequestUPO requestUPO = new RequestUPO(); 
				
				id = new String("88a60f9d03045f163e10790ace36ebc3");
				requestUPO.setRefId(id); // Ustaw refID dokumentu 
				
				upo = new Holder();
				status = new Holder();
				statusOpis = new Holder();
				
				// Wywołaj metodę requestUPO 
				port.requestUPO(id, "pl", upo, status, statusOpis);
				
				System.out.println("UPO status: " + upo.value + " " + status.value + " " + statusOpis.value);
			} catch (Exception e) { 
				e.printStackTrace(); 
//				System.out.println("nydyrydy!!!");
				}
			System.out.println("end");
			}

		public Holder<String> getRefId() {
			return refId;
		}

		public void setRefId(Holder<String> refId) {
			this.refId = refId;
		}

		public Holder<Integer> getStatus() {
			return status;
		}

		public void setStatus(Holder<Integer> status) {
			this.status = status;
		}

		public Holder<String> getStatusOpis() {
			return statusOpis;
		}

		public void setStatusOpis(Holder<String> statusOpis) {
			this.statusOpis = statusOpis;
		}

		public Holder<String> getUpo() {
			return upo;
		}

		public void setUpo(Holder<String> upo) {
			this.upo = upo;
		}

//		public byte[] getDocument() {
//			return document;
//		}
//
//		public void setDocument(byte[] document) {
//			this.document = document;
//		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

	}
