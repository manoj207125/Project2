package com.verizon.masking;

import java.io.File;
import java.io.FileWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XmlToJavaDOM {

	public static void main(String[] args){
		
	try {
        File inputFile = new File("C:/Ajay/Verizon_BI/Datafiles/EHealthReportDaily_20171023_030000.xml");
        String destination = "C:/Ajay/Verizon_BI/Datafiles/EHealthReportDaily.txt";
        
        
        
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(inputFile);
        doc.getDocumentElement().normalize();
        System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
        NodeList nList = doc.getElementsByTagName("UNI_CIRCUIT");
        
        int length = nList.getLength()+1;
        String[] full = new String[length];
        
        
        String header = "UNI_CIRCUIT_NAME" + "|" + "CUSTOMER_NAME" + "|" + "MANAGEMENT_IP" + "|" + "PRODUCT_TYPE" + "|"
        				+ "SERVICE" + "|" +"FAR_END_IP" +"|" +"FAR_END_MODEL" + "|" +"NID_MODEL" 
        				+ "|" +"TLS_UNI_TYPE" + "|" +"DEVICE_CLLI" +"|" + "DEVICE_HOSTNAME" +"|"
        				+ "DEVICE_MODEL" +"|" +"DEVICE_SLOT" +"|" +"DEVICE_SUBSLOT" +"|" + "DEVICE_PORT"
        				+"|" +"TLSMID"+"|" +"SVID" +"|" +"LAGID" +"|" +"NID_ENVIRONMENT" +"|"
        				+ "LAG_CIRCUIT_ID" +"|" +"NUMERIC_LAG_ID";
       
        
        full[0] = header;
       
        String circuit_name = "";
        String cust_name ="";
        String managementIP = "";
        String product_Type = "";
        String service ="";
        String far_End_IP = "";
        String far_End_Model ="";
        String nid_Model = "";
        String tls_uni_Type = "";
        String device_Clli = "";
        String device_HostName = "";
        String device_Model = "";
        String device_Slot = "";
        String device_Subslot = "";
        String device_Port = "";
        String tlsmid_domain = "";
        String svid = "";
        String lagId = "";
        String nid_Environment = "";
        String lag_Circuit_ID = "";
        String numeric_Lag_ID = "";
        for (int temp = 0; temp < nList.getLength(); temp++) {
           Node nNode = nList.item(temp);
           String fullText = "";
           System.out.println("\nCurrent Element :" + nNode.getNodeName());
           
           if (nNode.getNodeType() == Node.ELEMENT_NODE) {
              Element eElement = (Element) nNode;
              
            
              
              
              if(eElement.getElementsByTagName("UNI_CIRCUIT_NAME").item(0)!=null){
            	   circuit_name = eElement.getElementsByTagName("UNI_CIRCUIT_NAME").item(0).getTextContent();
                 }
              
              if(eElement.getElementsByTagName("CUSTOMER_NAME").item(0)!=null){
            	  cust_name  = eElement.getElementsByTagName("CUSTOMER_NAME").item(0).getTextContent(); 
              }
             
              if(eElement.getElementsByTagName("MANAGEMENT_IP").item(0)!=null){
            	  managementIP  = eElement.getElementsByTagName("MANAGEMENT_IP").item(0).getTextContent();
              }
              
              if(eElement.getElementsByTagName("PRODUCT_TYPE").item(0)!=null){
            	  managementIP  = eElement.getElementsByTagName("PRODUCT_TYPE").item(0).getTextContent();
              }
              
              if(eElement.getElementsByTagName("SERVICE").item(0)!=null){
            	   service  = eElement.getElementsByTagName("SERVICE").item(0).getTextContent();
              }
              
             if(eElement.getElementsByTagName("FAR_END_IP").item(0)!=null){
            	 far_End_IP  = eElement.getElementsByTagName("FAR_END_IP").item(0).getTextContent();
             }
             
              if(eElement.getElementsByTagName("FAR_END_MODEL").item(0)!=null){
            	  far_End_Model  = eElement.getElementsByTagName("FAR_END_MODEL").item(0).getTextContent();
              }
              
              if(eElement.getElementsByTagName("NID_MODEL").item(0)!=null){
            	  nid_Model  = eElement.getElementsByTagName("NID_MODEL").item(0).getTextContent();
              }
              
              if(eElement.getElementsByTagName("TLS_UNI_TYPE").item(0)!=null){
            	   tls_uni_Type  = eElement.getElementsByTagName("TLS_UNI_TYPE").item(0).getTextContent();
              }

              if(eElement.getElementsByTagName("DEVICE_CLLI").item(0)!=null){
            	   device_Clli  = eElement.getElementsByTagName("DEVICE_CLLI").item(0).getTextContent();
              }
              
              if(eElement.getElementsByTagName("DEVICE_HOSTNAME").item(0)!=null){
            	   device_HostName  = eElement.getElementsByTagName("DEVICE_HOSTNAME").item(0).getTextContent();
              }
             
              if(eElement.getElementsByTagName("DEVICE_MODEL").item(0)!=null){
            	   device_Model  = eElement.getElementsByTagName("DEVICE_MODEL").item(0).getTextContent();
              }
              
              if(eElement.getElementsByTagName("DEVICE_SLOT").item(0)!=null){
            	   device_Slot  = eElement.getElementsByTagName("DEVICE_SLOT").item(0).getTextContent();
              }
              
              if(eElement.getElementsByTagName("DEVICE_SUBSLOT").item(0)!=null){
            	   device_Subslot  = eElement.getElementsByTagName("DEVICE_SUBSLOT").item(0).getTextContent();
              }
             
              if(eElement.getElementsByTagName("DEVICE_PORT").item(0)!=null){
            	   device_Port  = eElement.getElementsByTagName("DEVICE_PORT").item(0).getTextContent();
              }
              
              if(eElement.getElementsByTagName("TLSMID").item(0)!=null){
            	   tlsmid_domain  = eElement.getElementsByTagName("TLSMID").item(0).getTextContent();
              }else if(eElement.getElementsByTagName("DOMAIN").item(0)!=null){
            	  tlsmid_domain  = eElement.getElementsByTagName("DOMAIN").item(0).getTextContent();
              }
             
              if(eElement.getElementsByTagName("SVID").item(0)!=null){
            	   svid  = eElement.getElementsByTagName("SVID").item(0).getTextContent();
              }
              
              if(eElement.getElementsByTagName("LAGID").item(0)!=null){
            	   lagId  = eElement.getElementsByTagName("LAGID").item(0).getTextContent();
              }
              
              if(eElement.getElementsByTagName("NID_ENVIRONMENT").item(0)!=null){
            	   nid_Environment  = eElement.getElementsByTagName("NID_ENVIRONMENT").item(0).getTextContent();
              }
              
              if(eElement.getElementsByTagName("LAG_CIRCUIT_ID").item(0)!=null){
            	   lag_Circuit_ID  = eElement.getElementsByTagName("LAG_CIRCUIT_ID").item(0).getTextContent();
              }
              
              
             if(eElement.getElementsByTagName("NUMERIC_LAG_ID").item(0)!=null){
            	  numeric_Lag_ID  = eElement.getElementsByTagName("NUMERIC_LAG_ID").item(0).getTextContent();
             }
              
                       		  			
              fullText = fullText + circuit_name + "|" + cust_name + "|" + managementIP + "|" + product_Type + "|" + service + "|" + far_End_IP + "|" + far_End_Model + "|" + nid_Model + "|"
            		   + tls_uni_Type + "|" + device_Clli + "|" + device_HostName + "|" + device_Model + "|" + device_Slot + "|" + device_Subslot + "|" + device_Port + "|" + tlsmid_domain +"|"
            		   + svid + "|" + lagId + "|" + nid_Environment + "|" + lag_Circuit_ID + "|" + numeric_Lag_ID;
              
              System.out.println(fullText);
              
                             
              full[temp+1] = fullText;
                        
              
           }
        }
        System.out.println(nList.getLength());
               
        //Writing to Text  File
        
        FileWriter writer = new FileWriter(new File(destination));
        
        
        for(int i=0;i<full.length;i++){
        	writer.write(full[i]);
        	writer.write("\n");
        }
        
        writer.flush();
        writer.close();
        
                     
     } catch (Exception e) {
        e.printStackTrace();
     }
	}
	
}
