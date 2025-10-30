import java.io.*;
import java.util.*;

/**
 * 202411340 김준영
 */

public class Main {

    public static void main(String[] args) throws IOException {

//        1. 자바 소스 파일을 읽어들여서 맨 앞에 행 번호를 붙여서 출력하는 프로그램을 작성하라.
        File file = new File("test.java");
        List<String> contents = new ArrayList<>();
        List<String> exContent = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(file));
        int counter = 1;
        String s;
        while ((s = reader.readLine()) != null) {
            contents.add(s);
        }
        for(String content : contents) {
            exContent.add( counter +" "+ content);
            counter++;
        }
        for(String content : exContent) {
            System.out.println(content);
        }


        File image = new File("cudac.png");
        File copiedImage = new File("cudac_copied.png");
        BufferedInputStream bufferedReader = new BufferedInputStream(new FileInputStream(image));
        BufferedOutputStream bufferedWriter = new BufferedOutputStream(new FileOutputStream(copiedImage));
        byte[] buffer = new byte[1024];
        int read;
        int progress = 0;
        long total = image.length();
        long tenPercent = total / 10;

        do{
             read =bufferedReader.read(buffer,0,buffer.length);
             progress += read;
             if(progress>=tenPercent) {
                 System.out.print("*");
                 progress=0;
             }
            bufferedWriter.write(buffer,0,read);
        }while(read == buffer.length);
        bufferedReader.close();
        bufferedWriter.close();


//        2. 이미지 파일 a.jpg를 b.jpg로 복사하는 프로그램을 작성하라. 한 번에 1KB 단위로 복사하며, 복사를 진행하는 동안 10% 진행할 때마다 ‘*’ 하나씩 출력하도록 하라.


    }
}
