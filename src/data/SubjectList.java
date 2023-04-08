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
public class SubjectList extends ArrayList<Subject> {

    public SubjectList() {
        super();
    }

    @Override
    public String toString() {
        String S = "";
        for (Subject st : this) {
            S += st.toString() + "\n";
        }
        return S;
    }

}
