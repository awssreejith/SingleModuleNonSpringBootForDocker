package com.sreejith;

import java.io.*;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.IntStream;

public class MyController {

    private final String windowsOutPath = "C:\\MyTemp\\sreejith\\";

    private final String LinuxsOutPath = "/tmp/sreejith/";

    private final String fileName = "MyProgOut.txt";

    private BufferedWriter bufferedWriter;

    public void init() throws IOException {
        String os =  System.getProperty("os.name");
        String pathToSelect = os.contains("Windows") ? windowsOutPath : LinuxsOutPath;
        if (os.contains("Windows")) {
            System.out.println("This is windows system. Initializing Windows file path");
        } else {
            System.out.println("This is NON windows system.Possible Linux. Initializing Linux file path");
        }
        bufferedWriter = new BufferedWriter(new FileWriter(new File(pathToSelect+fileName)));
    }

    public void doWork()
    {
       String os =  System.getProperty("os.name");
        Scanner scanner = new Scanner(System.in);
        String line = "";
        String count = "";
        while(true)
        {
            System.out.print("Enter the text (type exit to stop program): ");
            line = scanner.nextLine();
            if(line.equals("exit"))
                break;
            System.out.print("Enter the count: ");
            count = scanner.nextLine();
            String finalLine = line;
            IntStream.range(0,Integer.parseInt(count)).forEach(p -> {
                try {
                    bufferedWriter.write(finalLine+" = "+os+"\n");
                    bufferedWriter.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

        }
    }

    @Override
    protected void finalize() throws IOException {
        bufferedWriter.close();
        System.out.println("Closed the writer");
    }
}
