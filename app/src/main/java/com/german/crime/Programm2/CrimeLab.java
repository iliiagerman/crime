package com.german.crime.Programm2;

import android.content.Context;


//Синглетный класс -- это класс допускает создание тоько одного экземпляра
public class CrimeLab {

    //в название присутстует s для того чтобы показать что переменная является статичной
    private static CrimeLab sCrimeLab;

    // другие классы не смогут создать экземпляр в обход методы get
    public static CrimeLab get(Context context) {
        if (sCrimeLab == null) {
            sCrimeLab = new CrimeLab(context);
        }
        return sCrimeLab;
    }

    private CrimeLab(Context context) {
    }
}
