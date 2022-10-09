/*
* ID: 6388019
* FullName:Sorawanan Jeamjantarasakhon
* Section: 1
* */
import java.util.*;

public class MySorting {

    public static  <T> void splitData(List<T> a, T pivot, List<T> le, List<T> eq, List<T> ge, Comparator<T> cc){
        /*for (Integer i:a ){
            if(i<pivot) {
                le.add(i);
            }
            else if(i==pivot){
                eq.add(i);
            }
            else {
                ge.add(i);
            }
        }/*

         */
        for (T i: a) {
            if((cc.compare(i,pivot))==0){
                eq.add(i);
            }
            else if(cc.compare(i,pivot)<0){
                le.add(i);
            }
            else{
                ge.add(i);
            }
        }
    }

    public static <T> void QuickSort_list(List<T> a, Comparator<T> cc){
        int n=a.size();
        if(n<=1)
            return ;
        /*
        List<Integer> le=new ArrayList<>();
        List<Integer> eq=new ArrayList<>();
        List<Integer> ge=new ArrayList<>();*/

        List<T> le = new ArrayList<>();
        List<T> eq = new ArrayList<>();
        List<T> ge = new ArrayList<>();

        Random r = new Random();
        T pivot = a.get(r.nextInt(n));

        //int pivot=a.get(0);
        splitData(a,pivot,le,eq,ge,cc);
        QuickSort_list(le,cc);
        QuickSort_list(ge,cc);

        a.clear();
        // System.out.println(le+" "+eq+" "+ge);
      /*  System.out.println(le);
        System.out.println(eq);
        System.out.println(ge);*/
        a.addAll(le);
        a.addAll(eq);
        a.addAll(ge);
    }

    public static <T> void mereData(T[] a, T[] b, T[] c, Comparator<T> cc){
        int idxA=0;
        int idxB=0;
        for(int i=0;i<c.length;i++){
            //runout of a
            if(idxA>=a.length){
                c[i]=b[idxB];
                idxB++;

            }
            else if(idxB>=b.length){
                c[i]=a[idxA];
                idxA++;
            }
          /*  else if(a[idxA]<b[idxB]){
                c[i]=a[idxA];
                idxA++;
            }*/
            else if(cc.compare(a[idxA],b[idxB])<0){
                c[i]=a[idxA++];
            }
            else{
                c[i]=b[idxB];
                idxB++;
            }
        }
    }

    //TODO: You are free to write any helper function

    static <T> void insertionSort(T[] array, Comparator<T> cc){
        //TODO: insertion Sort
        int n = array.length;

        if(n<=1)
            return;

        for(int i=1;i< n; i ++){
            T unsortedIndex = array[i];
            int j=i;
            while(j>0){
                T array_j = array[j-1];
                if(cc.compare(unsortedIndex,array_j)>=0){
                    break;
                }
                array[j]=array_j;
                j--;
            }
            array[j]=unsortedIndex;
        }
    }

    static <T> void quickSort(T[] array, Comparator<T> cc){
        //TODO: quick sort
        List<T> list = new ArrayList<>(Arrays.asList(array));
        QuickSort_list(list,cc);
        for(int i= 0;i<array.length;i++){
            array[i]=list.get(i);
        }
    }

    static <T> void mergeSort(T[] array, Comparator<T> cc){
        //TODO: merge sort
        int n=array.length;
        if(n<=1)
            return;
        //Divide data in to half
        /*int[] left=Arrays.copyOfRange(array,0,n/2);
        int[] right=Arrays.copyOfRange(array,n/2,n);*/

        T[] left=Arrays.copyOfRange(array,0,n/2);
        T[] right=Arrays.copyOfRange(array,n/2,n);

        mergeSort(left,cc);
        mergeSort(right,cc);
        //merge up
        mereData(left,right, array,cc);

    }

    public static void main(String[] args) {
        Integer[] a = { 6,4,1,8,3,2,7,5};
        Integer[] b = { 3,2,7,5,6,4,1,8};
        Integer[] c = { 6,4,7,5,1,8,3,2};

        //TODO: uncomment for testing
       System.out.println("insertion sort");
       System.out.println(Arrays.toString(a));
       insertionSort(a, Integer::compare);
       System.out.println(Arrays.toString(a));

       System.out.println("quick sort");
       System.out.println(Arrays.toString(b));
       quickSort(b, Integer::compare);
       System.out.println(Arrays.toString(b));

       System.out.println("merge sort");
       System.out.println(Arrays.toString(c));
       mergeSort(c, Integer::compare);
       System.out.println(Arrays.toString(c));
    }

}
