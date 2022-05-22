package com.example.ProiectPao1.comparators;

import com.example.ProiectPao1.model.Antrenor;

import java.util.Comparator;

public class AntrenorComparator implements Comparator<Antrenor> {
    @Override
    public int compare(Antrenor o1, Antrenor o2) {
        return Integer.compare(o1.getAni_experienta(),o2.getAni_experienta());
    }
}
