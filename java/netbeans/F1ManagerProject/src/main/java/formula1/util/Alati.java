/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package formula1.util;

import formula1.model.Operater;

/**
 *
 * @author Kesimator
 */
public class Alati {

    public static final String NAZIV_APP = "Formula 1 Manager APP";
    public static Operater OPERATER;

    public static String getOperater() {
        return OPERATER.getIme() + " " + OPERATER.getPrezime() + " (" + OPERATER.getUloga() + ")";
    }

}
