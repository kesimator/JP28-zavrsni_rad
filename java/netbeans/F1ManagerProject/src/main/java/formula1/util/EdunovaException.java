/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package formula1.util;

/**
 *
 * @author Kesimator
 */
public class EdunovaException extends Exception {

    private String poruka;

    public EdunovaException(String poruka) {
        super(poruka);
        this.poruka = poruka;
    }

    public String getPoruka() {
        return poruka;
    }

}
