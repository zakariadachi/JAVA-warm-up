package Exercices;

public class Complex {
    int reel;
    int imaginaire;

    Complex(int reel,int imaginaire){
        this.reel = reel;
        this.imaginaire=imaginaire;
    }

    Complex add(Complex other){
        return new Complex(
            this.reel + other.reel,
            this.imaginaire+other.imaginaire
        );
    }
}
