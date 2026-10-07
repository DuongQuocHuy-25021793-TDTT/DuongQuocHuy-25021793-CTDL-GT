package week4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class b4 {
    private int id;
    private String fname;
    private double cgpa;

    public b4(int id, String fname, double cgpa) {
        this.id = id;
        this.fname = fname;
        this.cgpa = cgpa;
    }

    public int getId() {
        return id;
    }

    public String getFname() {
        return fname;
    }

    public double getCgpa() {
        return cgpa;
    }
}


class StudentComparator implements Comparator<b4> {
    @Override
    public int compare(b4 s1, b4 s2) {

        if (s1.getCgpa() != s2.getCgpa()) {
            return Double.compare(s2.getCgpa(), s1.getCgpa());
        }


        int nameCompare = s1.getFname().compareTo(s2.getFname());
        if (nameCompare != 0) {
            return nameCompare;
        }


        return Integer.compare(s1.getId(), s2.getId());
    }
}

class Solution1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        if (!in.hasNextInt()) {
            in.close();
            return;
        }

        int testCases = in.nextInt();
        List<b4> studentList = new ArrayList<>();

        while (testCases > 0) {
            int id = in.nextInt();
            String fname = in.next();
            double cgpa = Double.parseDouble(in.next());

            b4 st = new b4(id, fname, cgpa);
            studentList.add(st);

            testCases--;
        }

        Collections.sort(studentList, new StudentComparator());

        for (b4 st : studentList) {
            System.out.println(st.getFname());
        }

        in.close();
    }
}
