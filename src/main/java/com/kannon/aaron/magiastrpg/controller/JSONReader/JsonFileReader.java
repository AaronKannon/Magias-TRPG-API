package com.kannon.aaron.magiastrpg.controller.JSONReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class JsonFileReader {

    public Scanner fileToScanner() throws FileNotFoundException {
        FileInputStream fis = new FileInputStream("C:/db.json");
        Scanner sc = new Scanner(fis,"UTF-8");    //file to be scanned
        return sc;
    }

}
