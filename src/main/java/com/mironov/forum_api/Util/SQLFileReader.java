package main.java.com.mironov.forum_api.Util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SQLFileReader {

    private BufferedReader br;

    private StringBuilder sb;

    private String fileName;

    public SQLFileReader(String fileName) {
        this.fileName=fileName;
        sb=new StringBuilder();
    }

    public String getAsString() throws IOException {

        br=new BufferedReader(new FileReader(fileName));

        String line=br.readLine();

        while (line!=null){
            sb.append(line+"\n");

            line=br.readLine();
        }
        return sb.toString();
    }
}
