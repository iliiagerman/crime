package com.german.crime.programm2;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.german.crime.programm2.database.CrimeBaseHelper;
import com.german.crime.programm2.database.CrimeDbSchema;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


//Синглетный класс -- это класс допускает создание тоько одного экземпляра
public class CrimeLab {

    //в название присутстует s для того чтобы показать что переменная является статичной
    private static CrimeLab sCrimeLab;
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
    }

    public List<Crime> getCrimes() {
    }

    public Crime getCrime(UUID id) {
        return null;
    }
    private static ContentValues getContentValues(Crime crime) {
        ContentValues values = new ContentValues();
        values.put(CrimeDbSchema.CrimeTable.Cols.UUID, crime.getId().toString());
        values.put(CrimeDbSchema.CrimeTable.Cols.TITLE, crime.getTitle());
        values.put(CrimeDbSchema.CrimeTable.Cols.DATE, crime.getDate().getTime());
        values.put(CrimeDbSchema.CrimeTable.Cols.SOLVED, crime.isSolved() ? 1 : 0);
}
