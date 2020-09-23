package com.project;

import javax.print.DocFlavor;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        int N, j=0, t=1, v=0, k=0;
        char C=' ';
        String fileLocation = "c://Users/mehdi/Desktop/file.txt";
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        DataInputStream in = new DataInputStream(new FileInputStream(fileLocation));
        boolean EOF=false;
        do {
            try {
                C = in.readChar();

              if((C==' ')||(C=='\n')||(C=='.')||(C==',')||(C=='\r')||(C=='?')||(C=='«')||(C==')')||(C=='(')||(C=='»')){
                  C = in.readChar();
                    j++;

                    while ((C==' ')||(C=='\n')||(C=='.')||(C==',')||(C=='\r')||(C=='?')||(C=='«')||(C==')')||(C=='(')||(C=='»'))
                    {
                        C = in.readChar();
                        j++;

                    }

                            System.out.print((j+1) + "\t\t");


                  v++;

                  if(v-(t*10)==0) {

                      System.out.print("\n");

                      t++;

                  }

                 }
                j++;
            }catch (IOException e){
                EOF=true;
            }

        }while (!EOF);

        System.out.println("\n");

        do {
            int i=0;
            char[] charArray = new char[100];
            System.out.println("enter the index of the word");
            N = Integer.parseInt(buffer.readLine());
            if (N!=0) {
                RandomAccessFile word = new RandomAccessFile(new File(fileLocation), "r");


                do {
                    word.seek((2*(N-1+i)));
                    C = word.readChar();
                    charArray[i] = C;
                    i++;
                }while(charArray[i-1] != ' ' && charArray[i-1] != '\n' && charArray[i-1] != '.'
                        && charArray[i-1] != ','&& charArray[i-1] != '?'&& charArray[i-1] != '«'&& charArray[i-1] != ')' );

                System.out.print(" the word of index " + N + " is: " );

                charArray[i-1] = ' ';
                String charArrayS = String.valueOf(charArray);
                System.out.print(charArrayS);
                System.out.print("\n");

            }
        }while(N!=0);
        buffer.close();
    }
}