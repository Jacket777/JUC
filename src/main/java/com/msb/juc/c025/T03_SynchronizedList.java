package com.msb.juc.c025;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class T03_SynchronizedList {

	public static void main(String[] args) {
    List<String>str = new ArrayList<>();
    List<String>strSync = Collections.synchronizedList(str);
	}

}
