/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package formula1;

import com.google.gson.Gson;
import formula1.controller.ObradaTimovi;
import formula1.model.Timovi;
import formula1.util.EdunovaException;
import formula1.util.PocetniInsert;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kesimator
 */
public class Start {

    public static void main(String[] args) {

        // HibernateUtil.getSession();
        new PocetniInsert();

        // System.out.println(new Gson().toJson(new ObradaTimovi().read()));
    }
}
