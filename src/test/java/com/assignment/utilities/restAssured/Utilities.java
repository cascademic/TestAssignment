package com.assignment.utilities.restAssured;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.*;

public class Utilities {



    public JSONObject getInputJSONObject(String fileName) {
        JSONParser parser = new JSONParser();
        try {
            //Object obj = parser.parse(new FileReader(System.getProperty("user.dir").replace("/target","") + "/src/main/resources/com/asda/qa/data/apiInputs.json"));
             Object obj = parser.parse(readFile(new FileInputStream("src/test/resources/"+fileName)));
            //Object obj = parser.parse(readFile(CreateOrderUtils.class.getClassLoader().getResourceAsStream ("createOrderApiInputs.json")));
            JSONObject jsonObject = (JSONObject) obj;

            return jsonObject;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Read file.
     *
     * @param inputStream
     * @return the json content as string
     * @throws IOException
     * @author a0s07pd(Abhishek Singh)
     */
    public  String readFile(InputStream inputStream) throws IOException {
        String content = null;
        Reader reader = new InputStreamReader(inputStream);
        try (BufferedReader br = new BufferedReader(reader)) {

            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            content = sb.toString();
            br.close();
        } catch (IOException e) {

            throw new IOException("Unable to read/load json file requested " + e.toString());
        } catch (NullPointerException e) {

            throw new NullPointerException("Unable to find json file requested(NULLPointerException) " + e.toString());
        }
        return content;
    }

    /**
     * Read file.
     *
     * @param filePath
     * @return the json content as string
     * @throws IOException
     * @author a0s07pd(Abhishek Singh)
     */
    public  String readFile(String filePath) throws IOException {
       InputStream inputStream = new FileInputStream(filePath);
        String content = null;
        Reader reader = new InputStreamReader(inputStream);
        try (BufferedReader br = new BufferedReader(reader)) {

            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            content = sb.toString();
            br.close();
        } catch (IOException e) {

            throw new IOException("Unable to read/load json file requested " + e.toString());
        } catch (NullPointerException e) {

            throw new NullPointerException("Unable to find json file requested(NULLPointerException) " + e.toString());
        }
        return content;
    }


}
