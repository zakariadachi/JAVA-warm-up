package Exercices;

import java.util.*;


/*@FunctionalInterface
interface Calculator{
   int calculate(int x);
}
public class Main {
    public static void main(String[] args) {
        Calculator calc = x -> x*2;
        System.out.print(calc.calculate(20));
    }
}*/


/*@FunctionalInterface
interface Operation {
   int execute(int a, int b);
}
public class Main {
    public static void main(String[] args) {
        Operation calc = Integer::sum;
        System.out.print(calc.execute(15,20));
    }
}*/



//exercices java


public class Main {
    private static String[] array;
    private static String element;
    private static int index;

    public static int factoriele(int n) {
        if (n == 1 || n==0) {
            return 1;
        }
        return n * factoriele(n-1);
    }


    public static int fibonacci(int n){
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        return fibonacci(n-1) + fibonacci(n-2);
    }

    public static int expon(int base, int expo){
        if(expo==0){
            return 1;
        }
        return base * expon(base,expo - 1);
    }

    public static int occurence(String[] array, String element, int index){

        if(array.length==index){
            return 0;
        }
        if(array[index].equals(element)) {
            return 1 + occurence(array, element, index + 1);
        }
        return  occurence(array,element,index+1);
    }



    public static int len(String str){
        if(str.isEmpty()){
            return 0;
        }
        return 1+len(str.substring(1));
    }


//    public static  boolean isPalindrome(String str,int right,int left){
//        if(str.charAt(right)!=str.charAt(left)){
//            return false;
//        }
//        if(right<=left){
//            return true;
//        }
//        return isPalindrome( str, right+1, left-1);
//    }



    public static int max(int []array, int index, int max){
        if(array.length == index){
            return max;
        }
        if(array[index]>max){
            max = array[index];
        }
        return max(array,index+1,max);
    }


    public static String reverse(String str){
        if(str.length() <= 1){
            return str;
        }
        return  reverse(str.substring(1)) + str.charAt(0);
    }

    public static  int pgcd(int a , int b){
        if(b==0){
            return a;
        }
        return pgcd(b,a%b);
    }


    public static String filst(ArrayList<String> array){
        String first = array.get(0);
        String last = array.getLast();
        return "le premier element est " + first + "\n le dernier element est " + last;
    }


    public static String deletelm(ArrayList<String> arr,String element){
        for (int i = 0; i<arr.size() ; i++){
            if(arr.get(i).equalsIgnoreCase(element)){
                arr.remove(i);
                return "l'element supprimé avec succés";
            }
        }

        return  "element non trouvé";

    }

    public static String del(ArrayList<String> array){
        if(array.size() <= 0){
            return "list vide!";
        }
        String first = array.getFirst();
        String last = array.getLast();
        array.remove(first);
        array.remove(last);

        return "element supprimé: " + first + "\nelement supprimé: " + last;


    }




    public static void main(String[] args) {




//        System.out.println(pgcd(18,48));
        String s = "java";
//    System.out.println(len(s));
//    System.out.println(reverse(s));

        String[] lang = {"fr","en","ar","vin","ar","dtc","ar","rs"};

        int [] n = {1,90,102,200,15,20};

//        System.out.println(max(n,0,0));

//        System.out.println(occurence(lang,"en", 0));


//    System.out.println(expon(5,4));

//        String str = "radar";
//        boolean bool = isPalindrome(str,0,str.length() - 1);
//        System.out.println(bool);

//        System.out.println(fibonacci(6));
//        Scanner clavier = new Scanner(System.in);
//
//        System.out.println("entrer un char: ");
//        char caractere = clavier.next().charAt(0);
//        int ascii = (int) caractere;
//        System.out.println(ascii);



        ArrayList<Integer> numbers = new ArrayList<>();

        numbers.add(11);
        numbers.add(-5);
        numbers.add(-8);
        numbers.add(4);
        numbers.add(-1);
        numbers.add(8);
        ArrayList<Integer> numbers1 = new ArrayList<>();

        numbers1.add(9);
        numbers1.add(-5);
        numbers1.add(-8);
        numbers1.add(4);
        numbers1.add(-1);
        numbers1.add(8);

//        int temp = numbers.get(0);
//        numbers.set(0, numbers.get(2));
//        numbers.set(2,temp);
//        System.out.println(numbers);





//        ArrayList<Boolean> result = new ArrayList<>();
//        for(int i = 0; i<numbers.toArray().length; i++){
//            for(int j = i; j<i+1; j++ ){
//                if(Objects.equals(numbers.get(i), numbers1.get(j))){
//                    result.add(true);
//                }else {
//                    result.add(false);
//                }
//            }
//        }
//        System.out.println(result);
//        int some = 0;
//        for(int n : numbers){
//            if(n<0){
//                some+=n;
//            }
//        }
//        System.out.println(some);


        ArrayList<String> names = new ArrayList<>();

        names.add("PHP");
        names.add("CSS");
        names.add("HTML");
        names.add("JAVA");
        names.add("POO");
        names.add("JS");
        ArrayList<String> names1 = new ArrayList<>();

        names1.add("PHP");
        names1.add("CSS");
        names1.add("HTML");
        names1.add("JAVA");
        names1.add("POO");
        names1.add("JS");


//        System.out.println(deletelm(names1,"Java"));;
        System.out.println(del(names1));
        System.out.println(names1);




//        for (int i = 0; i < names.toArray().length; i++){
//            if(names.get(i).length()>=4){
//                names.remove(names.get(i));
//                i--;
//
//            }
//        }
//        System.out.println(names);

//        System.out.println("entrer le mot que tu veux rechercher: ");
//        Scanner clavier = new Scanner(System.in);
//        boolean found = false;
//        String str = clavier.nextLine().toLowerCase(Locale.ROOT);
//        for(String s : names){
//            if(s.toLowerCase(Locale.ROOT).equals(str)){
//                System.out.println(s + " est dans la liste");
//                found = true;
//
//            }
//        }
//        if(!found){
//            System.out.println(" not found");
//        }
//        ArrayList<String> result = new ArrayList<>();
//
//        for(int i = 0; i<names.size(); i++){
//                result.add(names.get(i));
//                result.add(names1.get(i));
//        }
//        System.out.println(result);
//
//        for(int i = 0 ; i < names.size() ; i++){
//            System.out.println("element a l'index " + i + " est " + names.get(i));
//        }





//        System.out.println(names);

//        System.out.println(names.get(2));

//        for(String n : names){
//            System.out.println(n);
//        }

//        names.add(0,"Pascal");

//        names.remove(2);
//        ArrayList<String> result = new ArrayList<>();
//        for(int i=names.toArray().length-1; i>=0;i--){
//               result.add(names.get(i));
//        }
//        System.out.println(result);









        /*System.out.println(factoriele(8));*/

//        Scanner clavier = new Scanner(System.in);
//
//        System.out.print("Entrer x : ");
//        int x = clavier.nextInt();
//
//        System.out.print("Entrer y : ");
//        int y = clavier.nextInt();
//
//        while (y != 0) {
//            int reste = x % y;
//            x = y;
//            y = reste;
//        }
//
//        System.out.println("Le PGCD est : " + x);




//        Scanner clavier = new Scanner(System.in);
//        System.out.print("Entrer un nombre : ");
//        int n = clavier.nextInt();
//        boolean premier = true;
//        if (n <= 1) {
//            premier = false;
//        } else {
//            for (int i = 2; i < n; i++) {
//                if (n % i == 0) {
//                    premier = false;
//                    break;
//                }
//            }
//        }
//        if (premier) {
//            System.out.println("Nombre premier");
//        } else {
//            System.out.println("Pas un nombre premier");
//        }





//        Scanner clavier = new Scanner(System.in);
//
//        System.out.print("entrer le path de fichier: ");
//
//        String path = clavier.nextLine();
//        File file = new File(path);
//        System.out.print(file.length);



//        Scanner clavier = new Scanner(System.in);
//
//        System.out.print("entrer un lettre: ");
//        char lettre = clavier.next().charAt(0);
//        int ascii = (int) lettre;
//        System.out.print(ascii);

//        Scanner clavier = new Scanner(System.in);
//
//        int[] numbers= {1, 2, 9, 4};
//        int max = numbers[0];
//        for(int i=0; i<numbers.length;i++){
//            if(numbers[i]>max){
//                max = numbers[i];
//            }
//        }
//        System.out.print(max);



//        Scanner clavier = new Scanner(System.in);

//        System.out.print("entrer le premier nombre reel: ");
//        int reel1 = clavier.nextInt();
//        System.out.print("entrer le deuxieme nombre reel: ");
//        int reel2 = clavier.nextInt();
//        System.out.print("entrer le premier nombre imaginaire: ");
//        int imaginaire1 = clavier.nextInt();
//        System.out.print("entrer le deuxieme nombre imaginaire: ");
//        int imaginaire2 = clavier.nextInt();
//
//        Complex c1 = new Complex(reel1,imaginaire1);
//        Complex c2 = new Complex(reel2,imaginaire2);
//        Complex result = c1.add(c2);
//        System.out.println("partie reel: " + result.reel + "\npartie imaginaire: " + result.imaginaire);

//        Student moyen = new Student();
//
//        Scanner clavier = new Scanner(System.in);
//
//        System.out.print("Entrer votre nom: ");
//        String nom = clavier.nextLine();
//        System.out.print("Entrer votre premier note: ");
//        int note1 = clavier.nextInt();
//        System.out.print("Entrer votre 2eme note: ");
//        int note2 = clavier.nextInt();
//
//        System.out.println("nom: " + nom +"\nmoyenne: " + moyen.calc_moyen(note1,note2));





//                Somme somme = new Somme();
//
//                Scanner clavier = new Scanner(System.in);
//
//                System.out.println("Entrer le nombre 1 : ");
//                int n1 = clavier.nextInt();
//
//                System.out.println("Entrer le nombre 2 : ");
//                int n2 = clavier.nextInt();
//
//                System.out.println("La somme = " + somme.sum(n1, n2));





//        int [] numbers = {15,8,9,5,2};
//        int total=0;
//        int average=0;
//        int pair = 0;
//        String name = "zakaria";
//        String reversed = "";
//        int vowels = 0;
//        for(int n : numbers){
//            total+=n;
//            if(n%2==0){
//                pair++;
//            }
//        }
//        average=total/numbers.length;
//        for (int i = name.length() - 1; i >= 0; i--) {
//            reversed += name.charAt(i);
//
//            char c = name.charAt(i);
//            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
//                    c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
//                vowels++;
//            }
//        }
//        System.out.print("\nTotal: " + total + "\naverage: " + average + "\nles pairs: " + pair + "\nreversed name: " + reversed + "\nvowels: " + vowels);
    }
}