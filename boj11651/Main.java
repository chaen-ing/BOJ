package boj11651;

import java.io.*;
import java.util.*;



public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw  = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        ArrayList<Point> arrayList = new ArrayList<>();

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            arrayList.add(new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }

        Collections.sort(arrayList);

        for(Point point : arrayList){
            bw.write(point.getX()+" "+point.getY());
            bw.newLine();
        }

        bw.flush();



    }


}

class Point implements Comparable<Point>{
    private int x, y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point o){
        if(this.y > o.y)    return 1;
        else if (this.y == o.y) return this.x - o.x;
        else return -1;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}


