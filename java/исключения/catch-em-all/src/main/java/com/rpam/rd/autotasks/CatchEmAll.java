package com.rpam.rd.autotasks;

import java.io.FileNotFoundException;
import java.io.IOException;

public class CatchEmAll {

    //You may set another exception in this field;
    static Exception exception = new FileNotFoundException();

    public static void riskyMethod() throws Exception {
        throw exception;
    }

    public static void main(String[] args) throws Exception {
        try{
            riskyMethod();
        } catch(FileNotFoundException exc){
            throw  new IllegalArgumentException("Resource is missing", exc);
        } catch (IOException exc){
            throw new IllegalArgumentException("Resource error", exc);
        } catch (ArithmeticException | NumberFormatException exc){
            System.err.println(exc.getMessage());
        }

    }
}
