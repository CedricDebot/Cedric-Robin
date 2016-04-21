/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domein;

/**
 *
 * @author Robin Lanneer
 */
public class IcoonType {
    private String icoonPad;
    private String naam;

    public IcoonType(String icoonPad, String naam) {
        this.icoonPad = icoonPad;
        this.naam = naam;
    }

    public String getIcoonPad() {
        return icoonPad;
    }

    public String getNaam() {
        return naam;
    }
    
    
}
