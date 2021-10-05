package com.german.crime.programm2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.german.crime.programm2.database.CrimeBaseHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


//Синглетный класс -- это класс допускает создание тоько одного экземпляра
public class CrimeLab {

    //в название присутстует s для того чтобы показать что переменная является статичной
    private static CrimeLab sCrimeLab;
    private List<Crime> mCrimes;
    //исполльзование базы данных
    private Context mContext;
    private SQLiteDatabase mDatabase;

    // другие классы не смогут создать экземпляр в обход методы get
    public static CrimeLab get(Context context) {
        if (sCrimeLab == null) {
            sCrimeLab = new CrimeLab(context);
        }
        return sCrimeLab;
    }

    private CrimeLab(Context context) {
        mContext = context.getApplicationContext();
        mDatabase = new CrimeBaseHelper(mContext)
                .getWritableDatabase();
        mCrimes = new ArrayList<>();
        //     удалил то что что создавала 100 преступлений ниже поставил так чтоб пользователь мог сам добавлять преступления
//        for (int i = 0; i < 100; i++) {
//            Crime crime = new Crime();
//            crime.setTitle("Crime #" + i);
//            crime.setSolved(i % 2 == 0); // Для каждого второго объекта
//            mCrimes.add(crime);
//        }
    }

    // теперь пользователь сможет сам добавлять преступления
    public void addCrime(Crime c) {
        mCrimes.add(c);
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
