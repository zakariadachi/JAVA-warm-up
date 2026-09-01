# 1 - Java — Lambda Expressions

## Documentation + Exercices pratiques

**Objectif :** comprendre les expressions lambda, leur syntaxe, leur rôle et leur lien avec les Functional Interfaces, puis pratiquer sans regarder les solutions.

---

# 1. C'est quoi une Lambda ?

Une expression lambda est une manière courte d'écrire un **comportement** (une action ou une règle) qu'on peut notamment passer à une méthode.

Les lambdas ont été introduites avec **Java 8**.

### Exemple

```java
x -> x * 2
```

Cela signifie :

> « prends `x` et retourne `x` multiplié par 2 ».

---

# 2. Syntaxe

### Forme générale

```java
(parameters) -> expression
```

### Pour plusieurs instructions

```java
(parameters) -> {
    instructions;
    return result;
}
```

---

# 3. Les différents cas

## Aucun paramètre

```java
() -> System.out.println("Hello")
```

---

## Un paramètre

```java
x -> x * 2
```

Les parenthèses sont facultatives lorsqu'il n'y a qu'un seul paramètre.

---

## Un paramètre avec parenthèses

```java
(x) -> x * 2
```

Les deux formes sont valides :

```java
x -> x * 2
```

```java
(x) -> x * 2
```

---

## Deux paramètres

```java
(a, b) -> a + b
```

---

## Plusieurs instructions

```java
x -> {
    System.out.println(x);
    return x * 2;
}
```

Lorsque le corps contient plusieurs instructions, on utilise `{}`.

---

# 4. Pourquoi utiliser les Lambdas ?

Les Lambda Expressions permettent notamment de :

* réduire le code répétitif ;
* passer un comportement comme argument ;
* travailler facilement avec les collections ;
* utiliser des APIs comme `forEach`, `removeIf` et `sort` ;
* utiliser les Streams ;
* faciliter la programmation fonctionnelle.

---

# 5. Lambda et Functional Interface

Une lambda a besoin d'un **contexte** qui indique la forme du comportement attendu.

En Java, ce contexte est souvent une **Functional Interface**.

Une Functional Interface possède **une seule méthode abstraite**.

### Exemple

```java
@FunctionalInterface
interface Calculator {
    int calculate(int x);
}
```

On peut ensuite utiliser une Lambda :

```java
Calculator calc = x -> x * 2;
```

Puis appeler la méthode :

```java
System.out.println(calc.calculate(5));
```

Résultat :

```text
10
```

---

# 6. @FunctionalInterface

`@FunctionalInterface` indique au compilateur que l'interface doit respecter la règle d'une seule méthode abstraite.

L'annotation n'est **pas obligatoire** pour qu'une interface soit fonctionnelle.

Cependant, elle permet au compilateur de vérifier que l'interface respecte bien cette règle.

Exemple :

```java
@FunctionalInterface
interface Calculator {
    int calculate(int x);
}
```

Si on ajoute une deuxième méthode abstraite :

```java
@FunctionalInterface
interface Calculator {

    int calculate(int x);

    int multiply(int x);
}
```

Le compilateur signalera une erreur.

---

# 7. Interfaces fonctionnelles Java à connaître

Java fournit plusieurs interfaces fonctionnelles très utilisées.

| Interface       | Forme         | Exemple                      |
| --------------- | ------------- | ---------------------------- |
| `Predicate<T>`  | `T → boolean` | `age -> age >= 18`           |
| `Function<T,R>` | `T → R`       | `s -> s.length()`            |
| `Consumer<T>`   | `T → void`    | `s -> System.out.println(s)` |
| `Supplier<T>`   | `() → T`      | `() -> Math.random()`        |

---

## Predicate<T>

Un `Predicate` reçoit une valeur et retourne un `boolean`.

```java
Predicate<Integer> isAdult = age -> age >= 18;
```

Exemple :

```java
System.out.println(isAdult.test(20));
```

Résultat :

```text
true
```

---

## Function<T, R>

Une `Function` reçoit une valeur et retourne une autre valeur.

```java
Function<String, Integer> length = s -> s.length();
```

Exemple :

```java
System.out.println(length.apply("Java"));
```

Résultat :

```text
4
```

---

## Consumer<T>

Un `Consumer` reçoit une valeur mais ne retourne rien.

```java
Consumer<String> print = s -> System.out.println(s);
```

Exemple :

```java
print.accept("Hello");
```

---

## Supplier<T>

Un `Supplier` ne reçoit aucun paramètre mais retourne une valeur.

```java
Supplier<Double> random = () -> Math.random();
```

Exemple :

```java
System.out.println(random.get());
```

---

# 8. Exemples d'utilisation

Les Lambda Expressions sont très utilisées avec les collections.

## forEach

```java
List<String> names = List.of("Ali", "Sara", "Omar");

names.forEach(name -> System.out.println(name));
```

La lambda :

```java
name -> System.out.println(name)
```

est exécutée pour chaque élément de la liste.

---

## removeIf

```java
List<Integer> numbers =
        new ArrayList<>(List.of(1, 2, 3, 4, 5));

numbers.removeIf(n -> n % 2 == 0);
```

La condition :

```java
n -> n % 2 == 0
```

signifie :

> supprimer les nombres qui sont pairs.

Résultat :

```text
1
3
5
```

---

## sort

```java
List<Integer> numbers =
        new ArrayList<>(List.of(5, 2, 8, 1, 3));

numbers.sort((a, b) -> a - b);
```

Résultat :

```text
1
2
3
5
8
```

---

# 9. Lambda avec une méthode

Une Lambda peut être passée directement comme argument à une méthode.

Exemple :

```java
List<String> names =
        List.of("Ali", "Sara", "Omar");

names.forEach(name -> System.out.println(name));
```

Ici :

```java
name -> System.out.println(name)
```

est passée à :

```java
forEach()
```

La méthode `forEach()` sait comment utiliser ce comportement grâce à une **Functional Interface**.

---

# 10. Lambda vs méthode classique

### Méthode classique

```java
public static int doubleNumber(int x) {
    return x * 2;
}
```

### Lambda

```java
x -> x * 2
```

La Lambda permet donc d'exprimer le même comportement de manière plus concise lorsqu'elle est utilisée dans un contexte approprié.

---

# 11. Points importants

Une Lambda :

```java
x -> x * 2
```

ne représente pas simplement une méthode indépendante.

Elle est utilisée dans un contexte où Java sait **quel type de comportement est attendu**, généralement grâce à une Functional Interface.

Exemple :

```java
Calculator calc = x -> x * 2;
```

Ici :

```text
Calculator
     ↓
Functional Interface
     ↓
int calculate(int x)
     ↓
x -> x * 2
```

---

# 12. À retenir

```text
Lambda
  ↓
Manière courte d'écrire un comportement

Functional Interface
  ↓
Interface avec une seule méthode abstraite

Lambda + Functional Interface
  ↓
Permet de fournir le comportement attendu
```

Les points essentiels à retenir :

* Une Lambda permet d'écrire un comportement de manière concise.
* Les Lambda Expressions ont été introduites avec **Java 8**.
* La syntaxe principale est :

```java
(parameters) -> expression
```

* Une Lambda est généralement utilisée avec une **Functional Interface**.
* Une Functional Interface possède une seule méthode abstraite.
* `@FunctionalInterface` permet au compilateur de vérifier cette règle.
* Les interfaces fonctionnelles importantes sont `Predicate`, `Function`, `Consumer` et `Supplier`.
* Les Lambdas sont très utilisées avec les **Collections** et les **Streams**.
* Elles sont notamment utilisées avec `forEach()`, `removeIf()` et `sort()`.


# 2 - Les différentes versions du JDK en Java

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

# 3 - Les structures de données en Java

## Introduction

En Java, les structures de données permettent de **stocker et organiser plusieurs données** dans un programme.

Les principales structures à connaître sont :

* `Array`
* `List`
* `Set`
* `Map`
* `Queue`

Elles ne servent pas toutes au même objectif.

Le choix dépend principalement de :

* Est-ce que l'ordre est important ?
* Est-ce que les doublons sont autorisés ?
* Est-ce qu'on veut accéder aux éléments par leur position ?
* Est-ce qu'on veut accéder à une valeur à partir d'une clé ?
* Est-ce qu'on a besoin de performances particulières ?

---

# 1. Array (Tableau)

Un `Array` permet de stocker plusieurs éléments du **même type**.

Sa taille est **fixe** après sa création.

## Exemple

```java
int[] numbers = {10, 20, 30, 40};
```

On peut accéder à un élément grâce à son index :

```java
System.out.println(numbers[0]);
```

Résultat :

```text
10
```

Les index commencent à `0`.

```text
Index :   0    1    2    3
          ↓    ↓    ↓    ↓
Value :  10   20   30   40
```

## Modifier un élément

```java
numbers[1] = 50;
```

Le tableau devient :

```text
10 50 30 40
```

## Taille

La taille est fixe :

```java
int[] numbers = new int[5];
```

Ce tableau peut contenir exactement **5 éléments**.

On ne peut pas simplement faire :

```java
numbers.add(60); // ❌
```

Les Arrays n'ont pas de méthode `add()`.

---

## Quand utiliser un Array ?

Utilise un `Array` lorsque :

* tu connais la taille à l'avance ;
* la taille ne doit pas changer ;
* tu veux une structure simple et rapide ;
* tu travailles avec des données simples.

Exemple :

```java
String[] days = {
    "Monday",
    "Tuesday",
    "Wednesday"
};
```

---

# 2. List

Une `List` est une collection **ordonnée** qui permet généralement les **doublons**.

Contrairement à un Array, une `List` peut changer de taille.

Exemple :

```java
List<String> names = new ArrayList<>();

names.add("Ali");
names.add("Sara");
names.add("Omar");
```

On peut ajouter des éléments :

```java
names.add("Yassine");
```

Supprimer :

```java
names.remove("Ali");
```

Accéder à un élément avec son index :

```java
System.out.println(names.get(0));
```

---

# 3. ArrayList

`ArrayList` est l'implémentation de `List` la plus utilisée.

```java
List<String> names = new ArrayList<>();
```

Elle conserve l'ordre d'insertion.

Exemple :

```java
names.add("Ali");
names.add("Sara");
names.add("Omar");
```

Résultat :

```text
Ali
Sara
Omar
```

Les doublons sont autorisés :

```java
names.add("Ali");
```

Résultat :

```text
Ali
Sara
Omar
Ali
```

---

## Quand utiliser ArrayList ?

Utilise `ArrayList` lorsque :

* l'ordre est important ;
* tu veux accéder aux éléments par index ;
* tu peux avoir des doublons ;
* tu veux une collection dont la taille peut évoluer.

Dans la majorité des cas, si tu as simplement besoin d'une liste, `ArrayList` est un excellent choix.

---

# 4. LinkedList

`LinkedList` est une autre implémentation de `List`.

```java
List<String> names = new LinkedList<>();
```

Elle fonctionne différemment d'une `ArrayList` au niveau interne.

Elle peut être intéressante lorsqu'on effectue beaucoup d'ajouts ou de suppressions à certains endroits de la liste.

Cependant, pour beaucoup de cas classiques, `ArrayList` reste le choix par défaut.

---

# 5. Set

Un `Set` représente une collection qui **n'autorise pas les doublons**.

Exemple :

```java
Set<String> names = new HashSet<>();

names.add("Ali");
names.add("Sara");
names.add("Ali");
```

Même si `"Ali"` est ajouté deux fois, le Set ne conservera qu'une seule occurrence.

```text
Ali
Sara
```

---

## HashSet

`HashSet` est l'implémentation la plus courante de `Set`.

```java
Set<String> names = new HashSet<>();
```

Il est particulièrement adapté lorsque l'objectif principal est :

> Vérifier si une valeur existe et éviter les doublons.

Exemple :

```java
Set<Integer> numbers = new HashSet<>();

numbers.add(10);
numbers.add(20);
numbers.add(10);
numbers.add(30);
```

Résultat conceptuel :

```text
10
20
30
```

---

## LinkedHashSet

`LinkedHashSet` conserve l'ordre d'insertion.

```java
Set<String> names = new LinkedHashSet<>();

names.add("Ali");
names.add("Sara");
names.add("Omar");
```

L'ordre sera conservé :

```text
Ali
Sara
Omar
```

---

## TreeSet

`TreeSet` maintient les éléments dans un ordre trié.

```java
Set<Integer> numbers = new TreeSet<>();

numbers.add(30);
numbers.add(10);
numbers.add(20);
```

Résultat :

```text
10
20
30
```

---

# 6. Map

Une `Map` fonctionne différemment de `List` et `Set`.

Elle stocke des données sous forme :

```text
KEY → VALUE
```

Par exemple :

```text
"username" → "Zakaria"
"age"      → 24
```

Exemple Java :

```java
Map<String, String> users = new HashMap<>();

users.put("user1", "Ali");
users.put("user2", "Sara");
users.put("user3", "Omar");
```

Pour récupérer une valeur :

```java
System.out.println(users.get("user1"));
```

Résultat :

```text
Ali
```

---

# 7. HashMap

`HashMap` est l'implémentation de `Map` la plus utilisée.

```java
Map<String, Integer> ages = new HashMap<>();

ages.put("Ali", 20);
ages.put("Sara", 25);
ages.put("Omar", 22);
```

On peut récupérer l'âge :

```java
System.out.println(ages.get("Sara"));
```

Résultat :

```text
25
```

---

## Les clés sont uniques

Une `Map` ne peut pas avoir deux fois la même clé.

```java
Map<String, Integer> ages = new HashMap<>();

ages.put("Ali", 20);
ages.put("Ali", 25);
```

La deuxième valeur remplace la première.

Résultat :

```text
Ali → 25
```

---

# 8. LinkedHashMap

`LinkedHashMap` conserve l'ordre d'insertion des clés.

```java
Map<String, Integer> ages = new LinkedHashMap<>();

ages.put("Ali", 20);
ages.put("Sara", 25);
ages.put("Omar", 22);
```

L'ordre est conservé :

```text
Ali
Sara
Omar
```

---

# 9. TreeMap

`TreeMap` trie les clés.

```java
Map<String, Integer> ages = new TreeMap<>();

ages.put("Omar", 22);
ages.put("Ali", 20);
ages.put("Sara", 25);
```

Les clés seront triées :

```text
Ali
Omar
Sara
```

---

# 10. Queue

Une `Queue` représente généralement une file d'attente.

Le principe classique est :

```text
First In → First Out
```

ou **FIFO**.

Le premier élément ajouté est généralement le premier à sortir.

Exemple :

```java
Queue<String> queue = new LinkedList<>();

queue.add("Ali");
queue.add("Sara");
queue.add("Omar");
```

La file ressemble à :

```text
Ali → Sara → Omar
```

Si on retire un élément :

```java
queue.poll();
```

`Ali` est retiré.

Il reste :

```text
Sara → Omar
```

---

# 11. Stack

Une Stack fonctionne généralement selon le principe :

```text
Last In → First Out
```

ou **LIFO**.

Le dernier élément ajouté est le premier à sortir.

Conceptuellement :

```text
       Omar ← dernier ajouté
       Sara
       Ali  ← premier ajouté
```

En Java moderne, `Deque` est généralement préférable à l'ancienne classe `Stack`.

Exemple :

```java
Deque<String> stack = new ArrayDeque<>();

stack.push("Ali");
stack.push("Sara");
stack.push("Omar");
```

Puis :

```java
stack.pop();
```

retire :

```text
Omar
```

---

# 12. Comparaison des principales structures

| Structure     | Ordre             | Doublons    | Accès par index | Clé → valeur | Taille    |
| ------------- | ----------------- | ----------- | --------------- | ------------ | --------- |
| Array         | ✅                 | ✅           | ✅               | ❌            | Fixe      |
| ArrayList     | ✅                 | ✅           | ✅               | ❌            | Dynamique |
| LinkedList    | ✅                 | ✅           | ✅               | ❌            | Dynamique |
| HashSet       | ❌ garanti         | ❌           | ❌               | ❌            | Dynamique |
| LinkedHashSet | ✅                 | ❌           | ❌               | ❌            | Dynamique |
| TreeSet       | Trié              | ❌           | ❌               | ❌            | Dynamique |
| HashMap       | ❌ garanti         | Valeurs : ✅ | ❌               | ✅            | Dynamique |
| LinkedHashMap | ✅                 | Valeurs : ✅ | ❌               | ✅            | Dynamique |
| TreeMap       | Trié par clé      | Valeurs : ✅ | ❌               | ✅            | Dynamique |
| Queue         | Généralement FIFO | ✅           | ❌               | ❌            | Dynamique |

---

# 13. Comment choisir ?

La question la plus importante est :

> **De quelle manière vais-je accéder à mes données ?**

## Cas 1 : J'ai besoin d'une simple liste

```java
List<String> names = new ArrayList<>();
```

Utilise généralement :

**ArrayList**

---

## Cas 2 : Je ne veux aucun doublon

```java
Set<String> names = new HashSet<>();
```

Utilise :

**Set / HashSet**

---

## Cas 3 : J'ai besoin de clé → valeur

```java
Map<String, Integer> ages = new HashMap<>();
```

Utilise :

**Map / HashMap**

---

## Cas 4 : Je veux conserver l'ordre d'insertion sans doublons

```java
Set<String> names = new LinkedHashSet<>();
```

Utilise :

**LinkedHashSet**

---

## Cas 5 : Je veux que les éléments soient triés

```java
Set<Integer> numbers = new TreeSet<>();
```

ou :

```java
Map<String, Integer> users = new TreeMap<>();
```

Utilise :

**TreeSet / TreeMap**

---

## Cas 6 : Je connais la taille à l'avance

```java
int[] numbers = new int[5];
```

Utilise :

**Array**

---

## Cas 7 : Je veux une file d'attente

```java
Queue<String> queue = new LinkedList<>();
```

Utilise :

**Queue**

---

# 14. Exemple concret

Imaginons une application de gestion d'utilisateurs.

### Liste des utilisateurs

```java
List<String> users = new ArrayList<>();

users.add("Ali");
users.add("Sara");
users.add("Omar");
```

Pourquoi `List` ?

Parce que l'ordre peut être important et les doublons sont éventuellement autorisés.

---

### Emails uniques

```java
Set<String> emails = new HashSet<>();

emails.add("ali@gmail.com");
emails.add("sara@gmail.com");
emails.add("ali@gmail.com");
```

Pourquoi `Set` ?

Parce qu'un email doit être unique.

---

### Utilisateur → âge

```java
Map<String, Integer> ages = new HashMap<>();

ages.put("Ali", 20);
ages.put("Sara", 25);
```

Pourquoi `Map` ?

Parce qu'on veut associer une **clé** à une **valeur**.

---

# 15. Interface vs implémentation

Un concept très important en Java est de distinguer :

```java
List<String> names = new ArrayList<>();
```

Ici :

```text
List       → interface
ArrayList  → implémentation
```

Même chose :

```java
Set<String> names = new HashSet<>();
```

```text
Set       → interface
HashSet   → implémentation
```

Et :

```java
Map<String, Integer> ages = new HashMap<>();
```

```text
Map       → interface
HashMap   → implémentation
```

Cette façon d'écrire le code est généralement recommandée :

```java
List<String> names = new ArrayList<>();
```

plutôt que :

```java
ArrayList<String> names = new ArrayList<>();
```

Cela permet de changer plus facilement l'implémentation si nécessaire.

---

# 16. Résumé rapide

```text
Array
  ↓
Taille fixe + accès par index

List
  ↓
Liste ordonnée + doublons autorisés

Set
  ↓
Pas de doublons

Map
  ↓
Clé → Valeur

Queue
  ↓
File d'attente (FIFO)

Deque
  ↓
File dans les deux directions + comportement Stack possible
```

---

# 17. Le plus important à retenir

```text
J'ai besoin d'une liste ?
        ↓
      List
        ↓
   ArrayList

J'ai besoin d'éviter les doublons ?
        ↓
      Set
        ↓
    HashSet

J'ai besoin de clé → valeur ?
        ↓
      Map
        ↓
    HashMap

J'ai besoin d'une taille fixe ?
        ↓
      Array

J'ai besoin d'une file d'attente ?
        ↓
      Queue

J'ai besoin d'un ordre trié ?
        ↓
   TreeSet / TreeMap
```

## Conclusion

Il n'existe pas une structure de données qui soit toujours meilleure que les autres.

Le choix dépend du problème à résoudre.

Les quatre structures essentielles à maîtriser en premier sont :

```text
Array
List
Set
Map
```

Puis il faut apprendre leurs implémentations principales :

```text
ArrayList
HashSet
LinkedHashSet
TreeSet
HashMap
LinkedHashMap
TreeMap
```

Une bonne connaissance de ces structures est indispensable pour travailler efficacement avec les collections Java, les Streams, les APIs REST et les frameworks comme Spring Boot.


# 4 - Java — Programmation fonctionnelle

## Documentation + Exercices pratiques

**Objectif :** comprendre les grands principes de la programmation fonctionnelle en Java, le rôle des interfaces fonctionnelles, des Lambda Expressions et des Streams, puis pratiquer sans regarder les solutions.

---

# 1. C'est quoi la programmation fonctionnelle ?

La programmation fonctionnelle est une manière de programmer qui consiste notamment à **manipuler des fonctions et des comportements comme des données**.

En Java, elle permet d'écrire du code plus déclaratif, notamment grâce aux :

* Lambda Expressions
* Functional Interfaces
* Streams
* Method References

Java n'est pas un langage purement fonctionnel. C'est un langage principalement orienté objet qui intègre des fonctionnalités de programmation fonctionnelle.

---

# 2. Les grands principes

La programmation fonctionnelle repose sur plusieurs idées importantes.

## Fonction comme comportement

On peut représenter un comportement et le transmettre à une méthode.

Exemple :

```java
x -> x * 2
```

Cette Lambda représente une règle :

> prendre `x` et retourner `x * 2`.

---

## Éviter les modifications inutiles

La programmation fonctionnelle privilégie généralement la création de résultats plutôt que la modification directe des données existantes.

Exemple :

```java
List<Integer> numbers = List.of(1, 2, 3, 4, 5);

List<Integer> doubled = numbers.stream()
        .map(n -> n * 2)
        .toList();
```

La liste originale `numbers` n'est pas modifiée.

Une nouvelle liste est créée :

```text
numbers
1 2 3 4 5

        ↓ map

doubled
2 4 6 8 10
```

---

# 3. Lambda Expressions

Les Lambda Expressions permettent d'écrire un comportement de manière concise.

Exemple :

```java
x -> x * 2
```

Avec une Functional Interface :

```java
@FunctionalInterface
interface Calculator {
    int calculate(int x);
}
```

On peut écrire :

```java
Calculator calc = x -> x * 2;
```

Puis :

```java
System.out.println(calc.calculate(5));
```

Résultat :

```text
10
```

Les Lambdas sont donc un élément important de la programmation fonctionnelle en Java.

---

# 4. Functional Interfaces

Une Functional Interface est une interface qui possède **une seule méthode abstraite**.

Exemple :

```java
@FunctionalInterface
interface Calculator {
    int calculate(int x);
}
```

Une Lambda peut ensuite être utilisée pour fournir l'implémentation :

```java
Calculator calc = x -> x * 2;
```

---

# 5. Les principales interfaces fonctionnelles

Java fournit plusieurs interfaces fonctionnelles dans le package `java.util.function`.

## Predicate<T>

`Predicate` reçoit une valeur et retourne un `boolean`.

Forme :

```text
T → boolean
```

Exemple :

```java
Predicate<Integer> isEven = n -> n % 2 == 0;
```

Utilisation :

```java
System.out.println(isEven.test(4));
```

Résultat :

```text
true
```

---

## Function<T, R>

`Function` reçoit une valeur et retourne une autre valeur.

Forme :

```text
T → R
```

Exemple :

```java
Function<String, Integer> length = s -> s.length();
```

Utilisation :

```java
System.out.println(length.apply("Java"));
```

Résultat :

```text
4
```

---

## Consumer<T>

`Consumer` reçoit une valeur mais ne retourne rien.

Forme :

```text
T → void
```

Exemple :

```java
Consumer<String> print = s -> System.out.println(s);
```

Utilisation :

```java
print.accept("Hello");
```

---

## Supplier<T>

`Supplier` ne reçoit aucun paramètre et retourne une valeur.

Forme :

```text
() → T
```

Exemple :

```java
Supplier<Double> random = () -> Math.random();
```

Utilisation :

```java
System.out.println(random.get());
```

---

# 6. C'est quoi un Stream ?

Un `Stream` permet de traiter les éléments d'une collection **sous forme d'un flux de données**.

Il permet notamment de :

* filtrer des éléments ;
* transformer des éléments ;
* trier ;
* rechercher ;
* calculer ;
* collecter les résultats.

Exemple :

```java
List<Integer> numbers =
        List.of(1, 2, 3, 4, 5);
```

On peut créer un Stream :

```java
numbers.stream();
```

Le Stream permet ensuite d'appliquer différentes opérations.

---

# 7. Pipeline d'un Stream

Un Stream fonctionne généralement comme un pipeline :

```text
Source
  ↓
Opération intermédiaire
  ↓
Opération intermédiaire
  ↓
Opération terminale
```

Exemple :

```java
numbers.stream()
       .filter(n -> n % 2 == 0)
       .map(n -> n * 2)
       .toList();
```

On peut le comprendre comme :

```text
Liste
 ↓
stream()
 ↓
filter()
 ↓
map()
 ↓
toList()
 ↓
Résultat
```

---

# 8. filter()

`filter()` permet de garder uniquement les éléments qui respectent une condition.

Exemple :

```java
List<Integer> numbers =
        List.of(1, 2, 3, 4, 5);
```

On veut garder uniquement les nombres pairs :

```java
List<Integer> evenNumbers = numbers.stream()
        .filter(n -> n % 2 == 0)
        .toList();
```

Résultat :

```text
2
4
```

La Lambda :

```java
n -> n % 2 == 0
```

est une condition.

Elle correspond au fonctionnement d'un `Predicate`.

---

# 9. map()

`map()` permet de **transformer chaque élément**.

Exemple :

```java
List<Integer> numbers =
        List.of(1, 2, 3, 4, 5);
```

Multiplier chaque nombre par 2 :

```java
List<Integer> doubled = numbers.stream()
        .map(n -> n * 2)
        .toList();
```

Résultat :

```text
2
4
6
8
10
```

Ici :

```java
n -> n * 2
```

transforme un `Integer` en un autre `Integer`.

Cela correspond au fonctionnement d'une `Function`.

---

# 10. filter() + map()

On peut combiner plusieurs opérations.

Exemple :

```java
List<Integer> numbers =
        List.of(1, 2, 3, 4, 5, 6);
```

Objectif :

> garder les nombres pairs puis les multiplier par 10.

```java
List<Integer> result = numbers.stream()
        .filter(n -> n % 2 == 0)
        .map(n -> n * 10)
        .toList();
```

Résultat :

```text
20
40
60
```

On peut visualiser :

```text
1  2  3  4  5  6
      ↓
filter()
      ↓
2  4  6
      ↓
map()
      ↓
20  40  60
```

---

# 11. forEach()

`forEach()` permet d'exécuter une action pour chaque élément.

Exemple :

```java
List<String> names =
        List.of("Ali", "Sara", "Omar");

names.stream()
     .forEach(name -> System.out.println(name));
```

Résultat :

```text
Ali
Sara
Omar
```

La Lambda :

```java
name -> System.out.println(name)
```

correspond au fonctionnement d'un `Consumer`.

---

# 12. sorted()

`sorted()` permet de trier les éléments.

Exemple :

```java
List<Integer> numbers =
        List.of(5, 2, 8, 1, 3);
```

```java
List<Integer> sorted = numbers.stream()
        .sorted()
        .toList();
```

Résultat :

```text
1
2
3
5
8
```

---

# 13. collect() et toList()

Après avoir traité les éléments d'un Stream, on veut souvent récupérer le résultat dans une collection.

Avec Java moderne :

```java
List<Integer> result = numbers.stream()
        .filter(n -> n > 2)
        .toList();
```

On peut également utiliser `collect()` :

```java
List<Integer> result = numbers.stream()
        .filter(n -> n > 2)
        .collect(Collectors.toList());
```

`toList()` est une manière plus simple de récupérer le résultat sous forme de liste.

---

# 14. count()

`count()` permet de compter le nombre d'éléments.

Exemple :

```java
List<Integer> numbers =
        List.of(1, 2, 3, 4, 5);
```

```java
long count = numbers.stream()
        .filter(n -> n % 2 == 0)
        .count();
```

Résultat :

```text
2
```

Il y a deux nombres pairs :

```text
2
4
```

---

# 15. reduce()

`reduce()` permet de combiner plusieurs éléments pour obtenir une seule valeur.

Exemple :

```java
List<Integer> numbers =
        List.of(1, 2, 3, 4, 5);
```

Calculer la somme :

```java
int sum = numbers.stream()
        .reduce(0, (a, b) -> a + b);
```

Résultat :

```text
15
```

On peut visualiser :

```text
1 + 2 + 3 + 4 + 5
        ↓
       15
```

---

# 16. Method References

Une Method Reference permet d'utiliser une méthode existante au lieu d'écrire une Lambda.

Exemple avec `forEach()` :

```java
List<String> names =
        List.of("Ali", "Sara", "Omar");

names.forEach(name -> System.out.println(name));
```

On peut écrire :

```java
names.forEach(System.out::println);
```

Les deux formes réalisent la même action.

---

# 17. Stream vs Collection

Il est important de comprendre que `Stream` et `Collection` ne sont pas la même chose.

Une `Collection` sert principalement à **stocker les données**.

Exemple :

```java
List<Integer> numbers =
        List.of(1, 2, 3, 4, 5);
```

Un `Stream` sert principalement à **traiter les données**.

```java
numbers.stream()
       .filter(n -> n > 2)
       .map(n -> n * 2)
       .toList();
```

On peut donc retenir :

```text
Collection
    ↓
Stocker les données

Stream
    ↓
Traiter les données
```

---

# 18. Stream ne modifie généralement pas la Collection source

Exemple :

```java
List<Integer> numbers =
        List.of(1, 2, 3, 4, 5);

List<Integer> result = numbers.stream()
        .filter(n -> n > 2)
        .toList();
```

La collection originale reste :

```text
1 2 3 4 5
```

Le résultat est :

```text
3 4 5
```

Le Stream permet donc de construire un nouveau résultat sans modifier directement la collection source dans cet exemple.

---

# 19. Les opérations intermédiaires et terminales

Les opérations de Stream sont généralement divisées en deux catégories.

## Opérations intermédiaires

Elles transforment ou filtrent le Stream et retournent généralement un nouveau Stream.

Exemples :

```text
filter()
map()
sorted()
distinct()
limit()
```

Exemple :

```java
numbers.stream()
       .filter(n -> n > 2)
       .map(n -> n * 2);
```

---

## Opérations terminales

Elles terminent le traitement du Stream et produisent généralement un résultat ou un effet.

Exemples :

```text
forEach()
toList()
collect()
count()
reduce()
```

Exemple :

```java
numbers.stream()
       .filter(n -> n > 2)
       .count();
```

---

# 20. Exemple complet

Supposons une liste de prix :

```java
List<Double> prices =
        List.of(10.0, 25.0, 5.0, 40.0, 15.0);
```

Objectif :

> garder les prix supérieurs ou égaux à 15 €, appliquer une réduction de 10 %, puis récupérer les résultats.

```java
List<Double> result = prices.stream()
        .filter(price -> price >= 15)
        .map(price -> price * 0.9)
        .toList();
```

Résultat :

```text
22.5
36.0
13.5
```

On peut comprendre le pipeline :

```text
10.0  25.0  5.0  40.0  15.0
             ↓
          filter()
             ↓
      25.0  40.0  15.0
             ↓
           map()
             ↓
      22.5  36.0  13.5
             ↓
          toList()
```

---

# 21. Pourquoi utiliser la programmation fonctionnelle ?

Elle permet notamment de :

* écrire un code plus concis ;
* séparer les données du traitement ;
* éviter certaines modifications directes des données ;
* rendre certains traitements de collections plus lisibles ;
* manipuler facilement des données avec les Streams ;
* utiliser des comportements réutilisables grâce aux Functional Interfaces.

Cependant, il ne faut pas utiliser les Streams et les Lambdas partout.

Pour un traitement simple, une boucle classique peut parfois être plus claire.

---

# 22. Programmation impérative vs fonctionnelle

## Approche impérative

On décrit principalement **comment** effectuer le traitement.

Exemple :

```java
List<Integer> numbers =
        List.of(1, 2, 3, 4, 5);

List<Integer> result = new ArrayList<>();

for (Integer number : numbers) {
    if (number % 2 == 0) {
        result.add(number * 2);
    }
}
```

---

## Approche fonctionnelle

On décrit davantage **ce qu'on veut obtenir**.

```java
List<Integer> result = numbers.stream()
        .filter(n -> n % 2 == 0)
        .map(n -> n * 2)
        .toList();
```

Les deux approches peuvent produire le même résultat.

---

# 23. Les méthodes importantes à connaître

Pour les Streams, commence par maîtriser :

```text
stream()
    ↓
filter()
    ↓
map()
    ↓
sorted()
    ↓
distinct()
    ↓
forEach()
    ↓
toList()
    ↓
collect()
    ↓
count()
    ↓
reduce()
```

Tu n'as pas besoin de mémoriser toutes les méthodes immédiatement.

Commence surtout par :

```text
filter()
map()
forEach()
toList()
```

Puis ajoute progressivement :

```text
sorted()
distinct()
count()
reduce()
collect()
```

---

# 24. Relation entre Lambda, Functional Interface et Stream

Ces trois concepts sont fortement liés.

```text
Lambda
   ↓
Fournit un comportement
   ↓
Functional Interface
   ↓
Permet de définir le type du comportement
   ↓
Stream
   ↓
Utilise ces comportements pour traiter les données
```

Exemple :

```java
numbers.stream()
       .filter(n -> n % 2 == 0)
       .map(n -> n * 2)
       .forEach(System.out::println);
```

Ici :

```text
filter()
   ↓
Predicate

map()
   ↓
Function

forEach()
   ↓
Consumer
```

C'est l'un des concepts les plus importants à comprendre.

---

# 25. À retenir

```text
Programmation fonctionnelle
        ↓
Manipuler des comportements et transformer des données

Lambda
        ↓
Écrire un comportement de manière concise

Functional Interface
        ↓
Définit la forme du comportement

Stream
        ↓
Traiter les données d'une collection
```

Les interfaces fonctionnelles principales sont :

```text
Predicate
    ↓
T → boolean

Function
    ↓
T → R

Consumer
    ↓
T → void

Supplier
    ↓
() → T
```

Les méthodes Stream les plus importantes :

```text
filter()   → filtrer
map()      → transformer
sorted()   → trier
forEach()  → effectuer une action
toList()   → récupérer une liste
count()    → compter
reduce()   → combiner les valeurs
```

Enfin :

```text
Collection
    ↓
Stocker les données

Stream
    ↓
Traiter les données
```

La programmation fonctionnelle en Java repose donc principalement sur l'utilisation des **Lambda Expressions**, des **Functional Interfaces** et des **Streams** pour écrire des traitements de données plus déclaratifs et souvent plus concis.
