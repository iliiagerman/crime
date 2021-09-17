package com.german.crime.Programm2;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


//Синглетный класс -- это класс допускает создание тоько одного экземпляра
public class CrimeLab {

    //в название присутстует s для того чтобы показать что переменная является статичной
    private static CrimeLab sCrimeLab;

    private List<Crime> mCrimes;

    // другие классы не смогут создать экземпляр в обход методы get
    public static CrimeLab get(Context context) {
        if (sCrimeLab == null) {
            sCrimeLab = new CrimeLab(context);
        }
        return sCrimeLab;
    }

    private CrimeLab(Context context) {
        mCrimes = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Crime crime = new Crime();
            crime.setTitle("Crime #" + i);
            crime.setSolved(i % 2 == 0); // Для каждого второго объекта
            mCrimes.add(crime);
        }
    }

    public List<Crime> getCrimes() {
        return mCrimes;
    }

    public Crime getCrime(UUID id) {
        for (Crime crime : mCrimes) {
            if (crime.getId().equals(id)) {
                return crime;
            }
        }
        return null;
    }
}
