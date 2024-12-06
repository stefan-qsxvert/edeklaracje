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
					
//					refId = new Holder("88a60f9d03045f163e10790ace36ebc3");
					
					port.sendDocument(document, refId, status, statusOpis); 
					System.out.println("Response: " + refId.value );
					System.out.println("Response: " + status.value );
					System.out.println("Response: " + statusOpis.value );
					
					File file = new File("/home/tee/refIds/" + refId.value);
					file.createNewFile();
					System.out.println(file.exists());
					BufferedWriter bfw = new BufferedWriter(new FileWriter(file));
					bfw.newLine();
					bfw.write(ZonedDateTime.now().toString() + "_" + refId.value + "_" + status.value + "_" + statusOpis.value);
					bfw.flush();
					bfw.close();
					
					
					
				} catch (Exception e) { 
						e.printStackTrace();
				} 

		}
		
		public void listOfDocument(String list) throws IOException {
			File file = new File(list);
			BufferedReader bfReader = new BufferedReader(new FileReader(file));
//			String listOfRfIds = bfReader.lines().toArray().toString();
//			List<String> listOfRfIds = bfReader.lines().toList();
			String[] listOfRfIds = bfReader.lines().toList().toString().split(";");
			bfReader.close();
			for (int i =0; i < listOfRfIds.length; i++) {
				System.out.println(listOfRfIds[i]);
		    }
			
			
			System.out.println(file.exists());
			
//			}
			
		}
		
		public void getUPO(String refId) {
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
				
//				id = new String("88a60f9d03045f163e10790ace36ebc3");
				requestUPO.setRefId(refId); // Ustaw refID dokumentu 
				
				upo = new Holder();
				status = new Holder();
				statusOpis = new Holder();
				
				// Wywołaj metodę requestUPO 
				port.requestUPO(refId, "pl", upo, status, statusOpis);
				
				
				System.out.println("UPO status: " + upo.value + " " + status.value + " " + statusOpis.value);
				BufferedWriter bfw = new BufferedWriter(new FileWriter("/home/tee/refIds/" + refId));
//				bfw.newLine();
				if (upo.value == null) {
					upo = new Holder("0");
				}
				bfw.write(ZonedDateTime.now().toString() + "_" + refId + "_" + status.value + "_" + statusOpis.value);
				bfw.newLine();
				bfw.write(upo.value);
				bfw.flush();
				bfw.close();
			
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
