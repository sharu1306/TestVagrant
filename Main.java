// "static void main" must be defined in a public class.
import java.util.*;
public class Main {
    public static class NewsPaper {
        double [] week = new double[7];
        double total = 0.0;
        String name;
        NewsPaper(double[] price, String name) {
            this.name = name;
            for(int i=0; i<week.length; i++) {
                week[i] = price[i];
                total += week[i];
            }
        }
    }
    static void solve(double ip, NewsPaper[] arr, int it, ArrayList<String> ans) {
        //ArrayList<String> ans = new ArrayList<>();
        for(int i=0; i<arr.length; i++) {
            if(i == it) continue;
            else if(ip >= arr[i].total) {
                ip = ip - arr[i].total;
                ans.add(arr[i].name);
            }
        }
        //return ans;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        double[] one = {3,3,3,3,3,5,6};
        double[] two = {2.5,2.5,2.5,2.5,2.5,4,4};
        double[] three = {4,4,4,4,4,4,10};
        double[] four = {1.5,1.5,1.5,1.5,1.5,1.5,1.5};
        double[] five = {2,2,2,2,2,4,4};

        NewsPaper toi = new NewsPaper(one, "toi");//26
        NewsPaper hindu = new NewsPaper(two, "hindu");//20.5
        NewsPaper et = new NewsPaper(three, "et");//24
        NewsPaper bm = new NewsPaper(four, "bm");
        NewsPaper ht = new NewsPaper(five, "ht");
        NewsPaper arr[] = {toi, hindu, et, bm, ht};


        double input = scn.nextInt();

        ArrayList<ArrayList<String>> res = new ArrayList<>();
        for(int i=0; i<arr.length; i++) {
            double val = input - arr[i].total;
            ArrayList<String> ans = new ArrayList<>();
            ans.add(arr[i].name);
            solve(val, arr, i, ans);
            if(ans.size() > 0)
                res.add(ans);
        }
        System.out.println(res);
    }
}