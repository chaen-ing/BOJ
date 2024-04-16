package boj18870;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        ArrayList<OrderAndX> arrayList = new ArrayList<>();
        ArrayList<OrderAndValue> arrayList2 = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arrayList.add(new OrderAndX(i,Integer.parseInt(st.nextToken())));
        }

        Collections.sort(arrayList);    // x좌표 오름차순 정렬

        int cnt = 0;
        for(int i = 0; i < N; i++){
            OrderAndX orderAndX = arrayList.get(i);
            if(i == 0){ // 처음은 무조건 0
                arrayList2.add(new OrderAndValue(orderAndX.order,0));
            }else{
                OrderAndX prevOrderAndX = arrayList.get(i-1);
                if(orderAndX.x != prevOrderAndX.x)  cnt++;
                arrayList2.add(new OrderAndValue(orderAndX.order,cnt));
            }
        }

        Collections.sort(arrayList2);

        for(OrderAndValue orderAndValue:arrayList2){
            bw.write(orderAndValue.value+" ");
        }

        bw.flush();
    }
}

class OrderAndX implements Comparable<OrderAndX>{
    int order, x;

    public OrderAndX(int order, int x) {
        this.order = order;
        this.x = x;
    }


    // 오름차순 정렬
    @Override
    public int compareTo(OrderAndX o) {
        return this.x - o.x;
    }
}

class OrderAndValue implements Comparable<OrderAndValue>{
    int order, value;

    public OrderAndValue(int order, int value) {
        this.order = order;
        this.value = value;
    }

    // 오름차순
    @Override
    public int compareTo(OrderAndValue o) {
        return this.order-o.order;
    }
}
