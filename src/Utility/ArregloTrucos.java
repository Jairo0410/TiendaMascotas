/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utility;

import Domain.Truco;
import java.util.ArrayList;

/**
 *
 * @author Kevin
 */
public class ArregloTrucos {

    public static ArrayList<Truco> ListaTrucos() {
        ArrayList<Truco> trucos = new ArrayList<>();

        trucos.add(new Truco("Saltar", 0, 500, 300));
        trucos.add(new Truco("Rodar", 1000, 300, 500));
        trucos.add(new Truco("Cantar", 2000, 1000, 600));
        trucos.add(new Truco("Sentarse", 500, 1500, 400));
        trucos.add(new Truco("Detenerse", 3000, 700, 300));

        return trucos;
    }

}
