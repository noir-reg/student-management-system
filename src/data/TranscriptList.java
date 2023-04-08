/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public final class TranscriptList extends ArrayList<Transcript> {

    public TranscriptList() {
        super();
    }

    public boolean containsStudent(String stID) {
        for (Transcript t : this) {
            if (t.getStObj().getStID().equals(stID)) {
                return true;
            }
        }
        return false;
    }
    public boolean containsSubject(String subID) {
        for (Transcript t : this) {
            if (t.getsObj().getSubID().equals(subID)) {
                return true;
            }
        }
        return false;
    }
}
