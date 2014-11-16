/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dvdlibrary.domain;

/**
 *
 * @author apprentice
 */
public class DVDtest {
    public static void main(String[] args) {
        DVD dvd = new DVD("The Lord Of The Rings","2001-12-10","R","Peter Jackson",
                          "Paramount","Movie!##Must See##2 thumbs up!");
        String[] arr = dvd.getNotesArray();
        System.out.println(arr.length);
        for (int i = 0; i < arr.length; i++) {
        System.out.println(arr[i]);
        }
    }
}
