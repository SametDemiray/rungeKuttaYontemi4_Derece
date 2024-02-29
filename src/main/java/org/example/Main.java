package org.example;

// y'=2x+y-3z
// z'=3x-2y+z  diferansiyel denklem sisteminin girilen başlangıç koşu, adım miktarıve değer sayısınca sayısal çözümünü 4. derece
// "Runge-Kutta" yöntemiyle gerçekleştiren program.


import java.util.Scanner;

public class Main {

    public static float f(float v,float w,float t){
        return 2*v+w-3*t;
    }
    public static float g(float p,float r,float s){
        return 3*p-2*r+s;
    }
    public static void main(String[] args) {

        int i,n;
        float x,y,z,x0,y0,z0,h,k1,k2,k3,k4,l1,l2,l3,l4;

        Scanner scanner = new Scanner(System.in);
        System.out.print("x(0) : ");
        x0 = scanner.nextFloat();
        System.out.print("y(0) : ");
        y0 = scanner.nextFloat();
        System.out.print("z(0) : ");
        z0 = scanner.nextFloat();
        System.out.print("Adım Değeri : ");
        h = scanner.nextFloat();
        System.out.print("Değer Sayısı : ");
        n = scanner.nextInt();

        x=x0;
        y=y0;
        z=z0;

        System.out.printf("\nSonuçlar (x,y,z)\n");

        for (i=0; i<n; i++){
            k1=h*f(x,y,z);
            l1=h*g(x,y,z);

            k2=h*f(x+h/2,y+k1/2,z+l1/2);
            l2=h*g(x+h/2,y+k1/2,z+l1/2);

            k3=h*f(x+h/2,y+k2/2,z+l2/2);
            l3=h*g(x+h/2,y+k2/2,z+l2/2);

            k4=h*f(x+h,y+k3,z+l3);
            l4=h*g(x+h,y+k3,z+l3);

            y+=(k1+2*k2+2*k3+k4)/6;
            z+=(l1+2*l2+2*l3+l4)/6;
            x+=h;

            System.out.printf("%f\t%f\t%f\n",x,y,z);

        }
    }
}