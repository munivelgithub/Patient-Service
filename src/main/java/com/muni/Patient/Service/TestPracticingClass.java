package com.muni.Patient.Service;


import org.springframework.stereotype.Component;


public class TestPracticingClass {
    int ab=0;
    public int addition(int a){
        ab+=a;
        return ab;
    }
    public int addition(int a, int b, int c){
        return a+b+c;
    }
}
