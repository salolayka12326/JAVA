package oleg.work.one;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class Test {
    private StudInterface studInterface;
    private StudInterface studInterface1;
    private int res=0;

    public Test(@Qualifier("student1") StudInterface studInterface,
                @Qualifier("studentka1") StudInterface studInterface1) {
        this.studInterface=studInterface;
        this.studInterface1=studInterface1;
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
        studInterface1.setMark(res);
        res=0;
    }

    public void getMark() {
        studInterface.getMark();
        studInterface1.getMark();
    }


}
