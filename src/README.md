___1___- ____Java—Lambda Expressions___

Documentation + Exercices pratiques

Objectif : comprendre les expressions lambda, leur syntaxe, leur rôle et leur lien avec les Functional Interfaces, puis pratiquer sans regarder les solutions.

1. C’est quoi une Lambda ?

Une expression lambda est une manière courte d’écrire un comportement (une action ou une règle) qu’on peut notamment passer à une méthode. Les lambdas ont été introduites avec Java 8.

Exemple :

x -> x * 2

Cela signifie : « prends x et retourne x multiplié par 2 ».

2. Syntaxe

Forme générale :

(parameters) -> expression

Ou, pour plusieurs instructions :

(parameters) -> {
instructions;
return result;
}

3. Les différents cas

Aucun paramètre

() -> System.out.println("Hello")

Un paramètre

x -> x * 2

Un paramètre avec parenthèses

(x) -> x * 2

Deux paramètres

(a, b) -> a + b

Plusieurs instructions

x -> {
System.out.println(x);
return x * 2;
}

4. Pourquoi utiliser les Lambdas ?

Réduire le code répétitif.

Passer un comportement comme argument.

Travailler facilement avec les collections.

Utiliser des APIs comme forEach, removeIf et sort.

Utiliser les Streams et la programmation fonctionnelle.

5. Lambda et Functional Interface

Une lambda a besoin d’un contexte qui indique la forme du comportement attendu. En Java, ce contexte est souvent une Functional Interface.

Une Functional Interface possède une seule méthode abstraite.

@FunctionalInterface
interface Calculator {
int calculate(int x);
}

Calculator calc = x -> x * 2;

System.out.println(calc.calculate(5));

Résultat : 10

6. @FunctionalInterface

@FunctionalInterface indique au compilateur que l’interface doit respecter la règle d’une seule méthode abstraite. L’annotation n’est pas obligatoire pour qu’une interface soit fonctionnelle, mais elle permet au compilateur de vérifier cette règle.

7. Interfaces fonctionnelles Java à connaître

Interface

Forme

Exemple

Predicate<T>

T → boolean

age -> age >= 18

Function<T,R>

T → R

s -> s.length()

Consumer<T>

T → void

s -> System.out.println(s)

Supplier<T>

() → T

() -> Math.random()

8. Exemples d’utilisation

forEach :

List<String> names = List.of("Ali", "Sara", "Omar");

names.forEach(name -> System.out.println(name));

removeIf :

List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5));

numbers.removeIf(n -> n % 2 == 0);

sort :

numbers.sort((a, b) -> a - b);

9. À retenir

Lambda = manière courte d’écrire un comportement.

Syntaxe principale : (parameters) -> expression.

Une lambda est généralement utilisée avec une Functional Interface.

Une Functional Interface possède une seule méthode abstraite.

Java 8 a introduit les lambdas.

Les lambdas sont très utilisées avec les collections et les Streams.

___1___- ____Java—Lambda Expressions___
