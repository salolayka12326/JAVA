package oleg.work.one;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Test {
    private StudInterface studInterface;
    private int res=0;

    public Test(StudInterface studInterface) {
        this.studInterface = studInterface;
    }

    public void startTest() throws IOException {
        int answer;
        BufferedReader reader = new BufferedReader(new FileReader(
                "src/main/resources/testQuestions.csv"));
        String line = null;
        Scanner scanner = null;
        int index = 0;
        Scanner in = new Scanner(System.in);

        while ((line = reader.readLine()) != null) {
            System.out.println(line);
            answer=in.nextInt();
            if(answer==4)res++;
        }
        in.close();
        reader.close();
        studInterface.setMark(res);
        res=0;
    }

    public void getMark() {
        studInterface.getMark();
    }


}
