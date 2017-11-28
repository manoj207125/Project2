package com.verizon.masking;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class PipeToCsv {



	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String source = "C:/Ajay/Verizon_BI/Datafiles/EHealthReportDaily.txt";
		
		String destination = "C:/Ajay/Verizon_BI/Datafiles/EHealthReportDaily_Masked.xlsx";
		
		
		List<String[]> records = new ArrayList<String[]>();
		
		System.out.println("Reading CSV File");
		readCSVFile(source, destination, records);
		
		}

	public static void readCSVFile(String csvFile, String destination, List records){
		
		
		try {
			
			File file = new File(csvFile);
			
			 
			FileReader fr = new FileReader(file);

			BufferedReader br = new BufferedReader(fr);
	        // Get first sheet from the workbook
	                
			List<String[]> list = new ArrayList<String[]>();
			String[] str;
			String line;
			int count =0;
			String circuit_mod = "";
			String cust_mod = "";
			String device_clli = "";
			
	        while((line = br.readLine()) !=null){
	        	str = line.split("\\|",-1);
	        	
	        	//Code to modify circuitname, customer name and device_clli
	        	if(count>0){
	        		circuit_mod = replace_circuitName(str[0]);
	        		str[0] = circuit_mod;
	        		cust_mod = replace(str[1]);
	        		str[1] = cust_mod;
	        		device_clli = replace_deviceCLLI(str[9]);
	        		str[9] = device_clli;
	        	}
	        	
	        	list.add(str);  
	        	count++;
	        }
	        
	        XSSFWorkbook workbook = new XSSFWorkbook();
	        XSSFSheet sheet_2 = workbook.createSheet("EHealthReportDaily_Masked");
	        
	        int rowNum =0;
	        System.out.println("Creating Excel");
	        
	        	        
	        
	        for(String[] s:list){
	        	Row row_write = sheet_2.createRow(rowNum++);
	        	int colNum=0;
	        	for(String s2: s){
	        		
	        		Cell cell_write = row_write.createCell(colNum++);
	        		
	        		cell_write.setCellValue(s2);
	        		
	        	}
	        }
	        
	        
	        try {
	            FileOutputStream outputStream = new FileOutputStream(destination);
	            
	            workbook.write(outputStream);
	            workbook.close();
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        System.out.println("Done");
	        
			

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}

	public static String replace(String property){
		int k=0;
		int length = property.length();
		String b="";
		property = property.toUpperCase();
		while(k<length){
			char ch = property.charAt(k);
			switch(ch){
            case 'A':b+='B'; break;
            case 'B':b+='C'; break;
            case 'C':b+='D'; break;
            case 'D':b+='E'; break;
            case 'E':b+='F'; break;
            case 'F':b+='G'; break;
            case 'G':b+='H'; break;
            case 'H':b+='I'; break;
            case 'I':b+='J'; break;
            case 'J':b+='K'; break;
            case 'K':b+='L'; break;
            case 'L':b+='M'; break;
            case 'M':b+='N'; break;
            case 'N':b+='O'; break;
            case 'O':b+='P'; break;
            case 'P':b+='Q'; break;
            case 'Q':b+='R'; break;
            case 'R':b+='S'; break;
            case 'S':b+='T'; break;
            case 'T':b+='U'; break;
            case 'U':b+='V'; break;
            case 'V':b+='W'; break;
            case 'W':b+='X'; break;
            case 'X':b+='Y'; break;
            case 'Y':b+='Z'; break;
            case 'Z':b+='A'; break;
            case ' ':b+=' ';break;
            case '-':b+='-';break;
            case ',':b+=',';break;
            case '.':b+='.';break;
            case '&':b+='&';break;
            case '0':b+='1';break;
            case '1':b+='2';break;
            case '2':b+='3';break;
            case '3':b+='4';break;
            case '4':b+='5';break;
            case '5':b+='6';break;
            case '6':b+='7';break;
            case '7':b+='8';break;
            case '8':b+='9';break;
            case '9':b+='0';break;
    }
    k++;
		}
		
		return b;
	}
	
	public static String replace_circuitName(String circuitName){
		
		int k = 0;
		String b ="";
		int length = circuitName.length();
		int m=circuitName.length()-2;
		while(k<2){
            char ch = circuitName.charAt(m++);
            
            switch(ch){
                    case 'A':b+='B'; break;
                    case 'B':b+='C'; break;
                    case 'C':b+='D'; break;
                    case 'D':b+='E'; break;
                    case 'E':b+='F'; break;
                    case 'F':b+='G'; break;
                    case 'G':b+='H'; break;
                    case 'H':b+='I'; break;
                    case 'I':b+='J'; break;
                    case 'J':b+='K'; break;
                    case 'K':b+='L'; break;
                    case 'L':b+='M'; break;
                    case 'M':b+='N'; break;
                    case 'N':b+='O'; break;
                    case 'O':b+='P'; break;
                    case 'P':b+='Q'; break;
                    case 'Q':b+='R'; break;
                    case 'R':b+='S'; break;
                    case 'S':b+='T'; break;
                    case 'T':b+='U'; break;
                    case 'U':b+='V'; break;
                    case 'V':b+='W'; break;
                    case 'W':b+='X'; break;
                    case 'X':b+='Y'; break;
                    case 'Y':b+='Z'; break;
                    case 'Z':b+='A'; break;
                    case ' ':b+=' ';break;
                    case '-':b+='-';break;
                    case '.':b+='.';break;
                    case '&':b+='&';break;
                    case '/':b+='/';break;
                    case '0':b+='1';break;
                    case '1':b+='2';break;
                    case '2':b+='3';break;
                    case '3':b+='4';break;
                    case '4':b+='5';break;
                    case '5':b+='6';break;
                    case '6':b+='7';break;
                    case '7':b+='8';break;
                    case '8':b+='9';break;
                    case '9':b+='0';break;
            }
            k++;
        }

        circuitName = circuitName.substring(0,length-2)+b;
		return circuitName;
	}
	
	public static String replace_deviceCLLI(String device){
		
		String b="";
		int m=4;
		int k=0;
		
		if(device.isEmpty()||device.equalsIgnoreCase("")||device.length()<=m)return "";
		
		while(k<2){
            
            char ch = device.charAt(m++);
            
            
            switch(ch){
                case 'A':b+='B'; break;
                case 'B':b+='C'; break;
                case 'C':b+='D'; break;
                case 'D':b+='E'; break;
                case 'E':b+='F'; break;
                case 'F':b+='G'; break;
                case 'G':b+='H'; break;
                case 'H':b+='I'; break;
                case 'I':b+='J'; break;
                case 'J':b+='K'; break;
                case 'K':b+='L'; break;
                case 'L':b+='M'; break;
                case 'M':b+='N'; break;
                case 'N':b+='O'; break;
                case 'O':b+='P'; break;
                case 'P':b+='Q'; break;
                case 'Q':b+='R'; break;
                case 'R':b+='S'; break;
                case 'S':b+='T'; break;
                case 'T':b+='U'; break;
                case 'U':b+='V'; break;
                case 'V':b+='W'; break;
                case 'W':b+='X'; break;
                case 'X':b+='Y'; break;
                case 'Y':b+='Z'; break;
                case 'Z':b+='A'; break;
            }
               
            
            k++;
        }
		device = device.substring(0,4)+b+device.substring(6);
		return device;
	}

}
