public class Merge 
{
    
    //Merge array after comparing
    private static void merge(int[] a, int[] aux, int lo, int mid, int hi)
     {
        for (int k = lo; k <= hi; k++)
         {
            aux[k] = a[k]; 
        }

        int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++) 
        {
            if(i > mid){
                a[k] = aux[j++];
            }              
            else if(j > hi) {
                a[k] = aux[i++];
            }                
            else if (less(aux[j], aux[i]))
             {
                a[k] = aux[j++];
            }
            else {
                a[k] = aux[i++];
            }
        }
    }

    //Whole sorting of array will be done here
    private static void sort(int[] a, int[] aux, int lo, int hi) 
    {
        if (hi <= lo) return;
        int mid = (lo + hi) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid + 1, hi);
        merge(a, aux, lo, mid, hi);

    }

    public static void sort(int[] a) 
    {
        int[] aux = new int[a.length];
        int lo = 0;
        int hi = a.length - 1;

        sort(a,aux,lo,hi);
    }

    private static boolean less(Comparable v, Comparable w) 
    {
        return v.compareTo(w) < 0;
    }
   
    private static boolean isSorted(int[] a) 
    {
        return isSorted(a, 0, a.length - 1);
    }

    private static boolean isSorted(int[] a, int lo, int hi) 
    {
        for (int i = lo + 1; i <= hi; i++)
            if (less(a[i], a[i-1])) 
            {
                return false;
            }
        return true;
    }

    private static void show(int[] a) 
    {
        for (int i = 0; i < a.length; i++) 
        {
            System.out.println(a[i]);
        }
    }

    public static void main(String[] args) 
    {
        int[] a = {10,90,40,80,60,20,70,50,30,100};
        Merge.sort(a);
        show(a);
    }
}