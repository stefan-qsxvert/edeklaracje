//ssh-keygen -t rsa -b 4096 -C "qsxvert@gmail.com"

package org.mnapp.bin;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.util.Scanner;

import org.mnapp.app.Bady;
import org.mnapp.app.WsdlToJavaGenerator;


public class Run {

	private static Scanner scan;

	public static void main(String[] args) throws IOException {
		
		Bady bady = new Bady();
		
		System.out.println("1- wysyłka");
		System.out.println("2- UPO");
		System.out.println("3- generuj źródła test");
		System.out.println("");
		System.out.print("Twój wybór: ");
		scan = new Scanner(System.in);
		
		File file = new File("/home/tee/test1");
		byte[] docInByteArr = file.toString().getBytes();
		
		switch (scan.next().toString()) {
		case "1" :
				bady.sendDoc(docInByteArr);
			break;
		case "2":
				bady.getUPO();
			break;
		case "3":
				String wsdl = "https://test-bramka.edeklaracje.gov.pl/uslugi/dokumenty?wsdl";
				WsdlToJavaGenerator ws2j = new WsdlToJavaGenerator();
				ws2j.generateTestWsdlSource("test", wsdl);
			break;
		case "4":

				BufferedWriter bfw = new BufferedWriter(new FileWriter("/home/tee/test.list", true));
				bfw.newLine();
				bfw.write(ZonedDateTime.now().toString());
				bfw.flush();
				bfw.close();
			break;
			
		case "5":
			
			String lista = new String("/home/tee/test.list");
			bady.listOfDocument(lista);
			
			break;
		default:
			break;
		}
		

//		for (int i = 0; i < docInByteArr.length; i++) {
//			System.out.println(docInByteArr[i]);
//		}
		
//		BufferedWriter ot = new BufferedWriter(new FileWriter(file));
//		byte[] ex = {0,1,0,1};
//		char[] st = ex.toString().toCharArray();
//		String a = st.toString();
//		System.out.println(a);
//		ot.write(ex.toString().toCharArray());
//		ot.flush();
//		ot.close();
//		file.createNewFile();
//		file.delete();
	}
}
