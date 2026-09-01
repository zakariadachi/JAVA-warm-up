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

# Les différentes versions du JDK en Java

## Introduction

Le **JDK (Java Development Kit)** est l'ensemble des outils nécessaires pour développer des applications Java.

Java évolue régulièrement avec de nouvelles versions. Parmi elles, certaines sont des versions **LTS (Long-Term Support)**, qui bénéficient d'un support à long terme.

Les principales versions LTS à connaître sont :

| Version | Année | LTS | Principales nouveautés                              |
|---------|------:|:---:|-----------------------------------------------------|
| Java 8  |  2014 | ✅  | Lambda, Stream API, Functional Interfaces, Optional |
| Java 11 |  2018 | ✅  | HTTP Client, nouvelles méthodes String              |
| Java 17 |  2021 | ✅  | Records, Sealed Classes, Pattern Matching           |
| Java 21 |  2023 | ✅  | Virtual Threads, Pattern Matching avancé            |
| Java 25 |  2025 | ✅  | Nouvelle version LTS                                |

---

# 1. Java 8

Java 8 est une version très importante dans l'histoire de Java.

Elle a introduit plusieurs fonctionnalités qui ont changé la manière d'écrire du code Java.

## Lambda Expressions

Les Lambda Expressions permettent d'écrire une fonction de manière beaucoup plus concise.

### Avant Java 8

```java
Calculator calc = new Calculator() {
    @Override
    public int calculate(int x) {
        return x * 2;
    }
};
```

### Avec Java 8

```java
Calculator calc = x -> x * 2;
```

---

## Functional Interfaces

Une interface fonctionnelle est une interface qui contient **une seule méthode abstraite**.

On peut utiliser l'annotation `@FunctionalInterface` :

```java
@FunctionalInterface
interface Calculator {
    int calculate(int x);
}
```

Puis :

```java
Calculator calc = x -> x * 2;

System.out.println(calc.calculate(5));
```

Résultat :

```text
10
```

---

## Stream API

Java 8 introduit également la **Stream API**, qui permet de traiter des collections de manière déclarative.

Exemple :

```java
List<Integer> numbers = List.of(1, 2, 3, 4, 5);

numbers.stream()
       .filter(n -> n > 2)
       .map(n -> n * 2)
       .forEach(System.out::println);
```

Résultat :

```text
6
8
10
```

Les opérations comme `filter()`, `map()` et `forEach()` sont très utilisées dans le développement Java moderne.

---

## Optional

`Optional` permet de représenter une valeur qui peut être présente ou absente.

Exemple :

```java
Optional<String> name = Optional.of("Zakaria");

name.ifPresent(System.out::println);
```

---

## À retenir de Java 8

```text
Lambda
Functional Interface
Stream API
Optional
Method References
```

---

# 2. Java 11

Java 11 est une autre version **LTS**.

Elle apporte principalement des améliorations de la JVM et de nombreuses API.

## Nouvelles méthodes String

Exemple :

```java
String text = "Hello";

System.out.println(text.isBlank());
```

On peut également utiliser :

```java
"Hello\nWorld".lines();
```

---

## HTTP Client

Java 11 fournit une API HTTP moderne avec :

```java
HttpClient
HttpRequest
HttpResponse
```

Exemple simplifié :

```java
HttpClient client = HttpClient.newHttpClient();

HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create("https://example.com"))
        .build();

HttpResponse<String> response =
        client.send(request, HttpResponse.BodyHandlers.ofString());

System.out.println(response.body());
```

Cette API est particulièrement intéressante pour les applications qui communiquent avec des APIs REST.

---

## À retenir de Java 11

```text
HTTP Client
Nouvelles méthodes String
Améliorations de la JVM
Modernisation des API
```

---

# 3. Java 17

Java 17 est une version **LTS** très importante pour apprendre le Java moderne.

Elle introduit notamment les **Sealed Classes** et finalise plusieurs fonctionnalités modernes du langage.

---

## Records

Les Records permettent de créer rapidement des classes principalement destinées à transporter des données.

### Classe classique

```java
public class User {

    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
```

### Avec un Record

```java
public record User(String name, int age) {
}
```

Le Record génère automatiquement plusieurs éléments comme le constructeur, les accesseurs, `equals()`, `hashCode()` et `toString()`.

---

## Sealed Classes

Les Sealed Classes permettent de contrôler quelles classes peuvent hériter d'une classe.

```java
public sealed class Animal
        permits Dog, Cat {
}
```

Puis :

```java
public final class Dog extends Animal {
}
```

```java
public final class Cat extends Animal {
}
```

Ici, seules `Dog` et `Cat` peuvent hériter de `Animal`.

---

## Pattern Matching avec instanceof

Avant :

```java
if (obj instanceof String) {
    String text = (String) obj;

    System.out.println(text.length());
}
```

Avec le Pattern Matching :

```java
if (obj instanceof String text) {
    System.out.println(text.length());
}
```

Le cast est automatiquement effectué.

---

## À retenir de Java 17

```text
Records
Sealed Classes
Pattern Matching
Modernisation du langage
```

---

# 4. Java 21

Java 21 est une version **LTS** et apporte plusieurs fonctionnalités importantes.

Elle est particulièrement intéressante pour le développement backend.

---

## Virtual Threads

Les Virtual Threads sont l'une des fonctionnalités les plus importantes de Java 21.

Ils permettent de gérer efficacement un très grand nombre de tâches concurrentes.

Exemple :

```java
Thread.startVirtualThread(() -> {
    System.out.println("Hello from Virtual Thread");
});
```

Les Virtual Threads sont particulièrement intéressants pour les applications serveur qui effectuent beaucoup d'opérations d'entrée/sortie (I/O).

---

## Pattern Matching avec switch

Java 21 permet d'utiliser le Pattern Matching avec `switch`.

Exemple :

```java
static String getType(Object obj) {

    return switch (obj) {
        case Integer i -> "Integer";
        case String s -> "String";
        case Double d -> "Double";
        default -> "Other";
    };
}
```

Cela rend certains traitements beaucoup plus lisibles.

---

## Record Patterns

Les Record Patterns permettent d'extraire directement les données contenues dans un Record.

Exemple :

```java
record User(String name, int age) {
}
```

On peut ensuite utiliser un pattern pour accéder directement aux composants du Record.

---

## Sequenced Collections

Java 21 introduit de nouvelles interfaces pour les collections qui possèdent un ordre défini.

Elles permettent notamment d'utiliser des opérations communes pour accéder au premier et au dernier élément.

---

## À retenir de Java 21

```text
Virtual Threads
Pattern Matching for switch
Record Patterns
Sequenced Collections
```

---

# 5. Java 25

Java 25 est une nouvelle version **LTS** sortie en 2025.

Elle continue l'évolution de Java avec de nouvelles fonctionnalités et améliorations du langage, de la JVM et des performances.

Pour un débutant, il n'est pas nécessaire de mémoriser toutes les nouveautés de Java 25.

Il est plus important de maîtriser les fonctionnalités fondamentales introduites entre Java 8 et Java 21.

---

# 6. Comparaison générale

On peut résumer l'évolution de Java comme ceci :

```text
Java 8
│
├── Lambda Expressions
├── Functional Interfaces
├── Stream API
├── Optional
└── Method References
        │
        ▼
Java 11
│
├── HTTP Client
├── Nouvelles API
└── Améliorations JVM
        │
        ▼
Java 17
│
├── Records
├── Sealed Classes
└── Pattern Matching
        │
        ▼
Java 21
│
├── Virtual Threads
├── Pattern Matching avec switch
├── Record Patterns
└── Sequenced Collections
        │
        ▼
Java 25
│
└── Nouvelle génération LTS
```

---

# 7. Quelle version utiliser aujourd'hui ?

Pour apprendre Java, il est recommandé d'utiliser une version LTS récente.

Si on travaille avec **JDK 21**, on peut apprendre :

```text
Java 8 concepts
        ↓
Java 11 concepts
        ↓
Java 17 concepts
        ↓
Java 21 concepts
```

Il n'est pas nécessaire d'installer chaque version du JDK pour apprendre ces fonctionnalités.

---

# 8. Ce qu'il faut apprendre en priorité

Pour un développeur Java débutant/intermédiaire, l'ordre conseillé est :

### Java 8

* [ ] Lambda Expressions
* [ ] Functional Interfaces
* [ ] Stream API
* [ ] Optional
* [ ] Method References

### Java 11

* [ ] HTTP Client
* [ ] Nouvelles méthodes de `String`
* [ ] Comprendre les principales évolutions

### Java 17

* [ ] Records
* [ ] Sealed Classes
* [ ] Pattern Matching
* [ ] Switch Expressions

### Java 21

* [ ] Virtual Threads
* [ ] Pattern Matching avec `switch`
* [ ] Record Patterns
* [ ] Sequenced Collections

---

# Conclusion

Les différentes versions du JDK ne représentent pas des langages complètement différents.

Java reste le même langage, mais il évolue progressivement avec de nouvelles fonctionnalités, de meilleures performances et de nouvelles API.

Les versions les plus importantes à connaître sont :

```text
Java 8  → Lambda + Stream
Java 11 → API modernes + HTTP Client
Java 17 → Records + Sealed Classes
Java 21 → Virtual Threads + Pattern Matching
Java 25 → Nouvelle LTS
```

Pour apprendre le Java moderne, **JDK 21 est un excellent choix**.

