package com.mypractice.datastructure.arrayprograms.algorithm.array;

import java.util.*;

class Studnet  {
    private int id;
    private String name;

    public Studnet(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

//    @Override
//    public int compareTo(Studnet studnet) {
//       return Integer.compare(this.getId(), studnet.getId());
//    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Studnet studnet = (Studnet) o;
        return id == studnet.id && Objects.equals(name, studnet.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Studnet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

class MyStudenComparator implements Comparator<Studnet>{
    @Override
    public int compare(Studnet studnet, Studnet t1) {
       // return Integer.compare(t1.getId(), studnet.getId() );
        return t1.getName().compareTo(studnet.getName());
    }
}
public class ComparableDemo {
    public static void main(String[] args) {
        Studnet st =  new Studnet(10, "Z khan");
        Studnet st2 =  new Studnet(103, "Y khan");
        Studnet st3 =  new Studnet(2, "A khan");
        Studnet st4 =  new Studnet(2, "A khan");

        Studnet st1 = new Studnet(102, "Wadood khan");
        List<Studnet> studnets = new ArrayList<>();
        studnets.add(st1);
        studnets.add(st);
        studnets.add(st2);
        studnets.add(st3);
        studnets.add(st4);
        for (Studnet student : studnets){
            System.out.println(student);
        }
        Collections.sort( studnets, new MyStudenComparator());
        System.out.println("After sorting");
       // System.out.println(studnets);
        for (Studnet student : studnets){
            System.out.println(student);
        }
    Set<Integer> hs = new TreeSet<>(( t1,  t2) -> Integer.compare(t2, t1));
        hs.add(10);
        hs.add(50);
        hs.add(1);
        hs.add(4);
        System.out.println(hs);

       Set<Studnet> sts = new HashSet<>(studnets);
        System.out.println(sts);
  Map mp = new HashMap();
  mp.put(null, 10);
  mp.put(null, 20);
        System.out.println(mp);
        System.out.println(50>>1);
    }


}
