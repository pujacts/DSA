package com;

import com.sun.xml.internal.bind.v2.runtime.output.StAXExStreamWriterOutput;

public class Test implements InterfaceSample{

    public static void main(String[] args) {
        InterfaceSample t = new Test();
        System.out.println(t.defautlMethod());
    }

    @Override
    public void method() {

    }
}
