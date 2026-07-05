import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.lang.reflect.*;
import java.net.*;
import java.net.http.*;
import java.sql.*;
import java.util.concurrent.*;

class Ex01_HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}

class Ex02_Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number: ");
        double a = sc.nextDouble();
        System.out.print("Enter second number: ");
        double b = sc.nextDouble();
        System.out.print("Choose operation (+, -, *, /): ");
        char op = sc.next().charAt(0);

        double result;
        switch (op) {
            case '+' -> result = a + b;
            case '-' -> result = a - b;
            case '*' -> result = a * b;
            case '/' -> {
                if (b == 0) { System.out.println("Error: Division by zero."); return; }
                result = a / b;
            }
            default -> { System.out.println("Unknown operator."); return; }
        }
        System.out.printf("Result: %.2f %c %.2f = %.2f%n", a, op, b, result);
    }
}

class Ex03_EvenOrOdd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int n = sc.nextInt();
        System.out.println(n + " is " + (n % 2 == 0 ? "Even" : "Odd"));
    }
}

class Ex04_LeapYear {
    static boolean isLeap(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a year: ");
        int year = sc.nextInt();
        System.out.println(year + (isLeap(year) ? " is a leap year." : " is NOT a leap year."));
    }
}

class Ex05_MultiplicationTable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();
        System.out.println("Multiplication table for " + n + ":");
        for (int i = 1; i <= 10; i++) {
            System.out.printf("%d x %2d = %d%n", n, i, n * i);
        }
    }
}

class Ex06_DataTypes {
    public static void main(String[] args) {
        int intVal = 42;
        float floatVal = 3.14f;
        double doubleVal = 2.718281828;
        char charVal = 'J';
        boolean boolVal = true;

        System.out.println("int     : " + intVal);
        System.out.println("float   : " + floatVal);
        System.out.println("double  : " + doubleVal);
        System.out.println("char    : " + charVal);
        System.out.println("boolean : " + boolVal);
    }
}

class Ex07_TypeCasting {
    public static void main(String[] args) {
        double d = 9.99;
        int fromDouble = (int) d;
        System.out.println("double " + d + " cast to int: " + fromDouble);

        int i = 7;
        double fromInt = (double) i;
        System.out.println("int " + i + " cast to double: " + fromInt);
    }
}

class Ex08_OperatorPrecedence {
    public static void main(String[] args) {
        int r1 = 10 + 5 * 2;
        int r2 = (10 + 5) * 2;
        int r3 = 20 / 4 * 2;
        int r4 = 10 + 3 * 4 - 2 / 2;

        System.out.println("10 + 5 * 2       = " + r1 + "  (* before +)");
        System.out.println("(10 + 5) * 2     = " + r2 + "  (parentheses first)");
        System.out.println("20 / 4 * 2       = " + r3 + "  (left-to-right)");
        System.out.println("10+3*4-2/2       = " + r4 + "  (combined)");
    }
}

class Ex09_GradeCalculator {
    static char grade(int marks) {
        if (marks >= 90) return 'A';
        if (marks >= 80) return 'B';
        if (marks >= 70) return 'C';
        if (marks >= 60) return 'D';
        return 'F';
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter marks (0-100): ");
        int marks = sc.nextInt();
        if (marks < 0 || marks > 100) { System.out.println("Invalid marks."); return; }
        System.out.println("Grade: " + grade(marks));
    }
}

class Ex10_NumberGuessing {
    public static void main(String[] args) {
        Random rnd = new Random();
        int secret = rnd.nextInt(100) + 1;
        Scanner sc = new Scanner(System.in);
        int attempts = 0;

        System.out.println("Guess the number between 1 and 100!");
        while (true) {
            System.out.print("Your guess: ");
            int guess = sc.nextInt();
            attempts++;
            if (guess < secret) System.out.println("Too low!");
            else if (guess > secret) System.out.println("Too high!");
            else {
                System.out.println("Correct! You got it in " + attempts + " attempt(s).");
                break;
            }
        }
    }
}

class Ex11_Factorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a non-negative integer: ");
        int n = sc.nextInt();
        if (n < 0) { System.out.println("Factorial not defined for negative numbers."); return; }
        long fact = 1;
        for (int i = 2; i <= n; i++) fact *= i;
        System.out.println(n + "! = " + fact);
    }
}

class Ex12_MethodOverloading {
    static int add(int a, int b) { return a + b; }
    static double add(double a, double b) { return a + b; }
    static int add(int a, int b, int c) { return a + b + c; }

    public static void main(String[] args) {
        System.out.println("add(3, 4)     = " + add(3, 4));
        System.out.println("add(1.5, 2.7) = " + add(1.5, 2.7));
        System.out.println("add(1, 2, 3)  = " + add(1, 2, 3));
    }
}

class Ex13_Fibonacci {
    static long fibonacci(int n) {
        if (n <= 1) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        System.out.println("Fibonacci(" + n + ") = " + fibonacci(n));
    }
}

class Ex14_ArraySumAverage {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("How many elements? ");
        int size = sc.nextInt();
        int[] arr = new int[size];
        System.out.println("Enter " + size + " integers:");
        for (int i = 0; i < size; i++) arr[i] = sc.nextInt();

        long sum = 0;
        for (int x : arr) sum += x;
        double avg = (double) sum / size;
        System.out.println("Sum     = " + sum);
        System.out.printf("Average = %.2f%n", avg);
    }
}

class Ex15_StringReversal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        String reversed = new StringBuilder(input).reverse().toString();
        System.out.println("Reversed: " + reversed);
    }
}

class Ex16_Palindrome {
    static boolean isPalindrome(String s) {
        String clean = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        String rev = new StringBuilder(clean).reverse().toString();
        return clean.equals(rev);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        System.out.println("\"" + input + "\" is " + (isPalindrome(input) ? "" : "NOT ") + "a palindrome.");
    }
}

class Car {
    String make, model;
    int year;

    Car(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }
    void displayDetails() {
        System.out.println(year + " " + make + " " + model);
    }
}
class Ex17_ClassAndObject {
    public static void main(String[] args) {
        Car c1 = new Car("Toyota", "Corolla", 2022);
        Car c2 = new Car("Honda", "Civic", 2021);
        c1.displayDetails();
        c2.displayDetails();
    }
}

class Animal {
    void makeSound() { System.out.println("Some generic animal sound"); }
}
class Dog extends Animal {
    @Override
    void makeSound() { System.out.println("Bark"); }
}
class Ex18_Inheritance {
    public static void main(String[] args) {
        Animal a = new Animal();
        Dog d = new Dog();
        a.makeSound();
        d.makeSound();

        Animal polymorphic = new Dog();
        polymorphic.makeSound();
    }
}

interface Playable {
    void play();
}
class Guitar implements Playable {
    @Override
    public void play() { System.out.println("Strumming the Guitar"); }
}
class Piano implements Playable {
    @Override
    public void play() { System.out.println("Playing the Piano"); }
}
class Ex19_Interface {
    public static void main(String[] args) {
        List<Playable> instruments = List.of(new Guitar(), new Piano());
        instruments.forEach(Playable::play);
    }
}

class Ex20_TryCatch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter dividend: ");
        int a = sc.nextInt();
        System.out.print("Enter divisor: ");
        int b = sc.nextInt();
        try {
            int result = a / b;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error: Cannot divide by zero.");
        }
    }
}

class InvalidAgeException extends Exception {
    InvalidAgeException(String msg) { super(msg); }
}
class Ex21_CustomException {
    static void checkAge(int age) throws InvalidAgeException {
        if (age < 18) throw new InvalidAgeException("Age " + age + " is below 18.");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your age: ");
        int age = sc.nextInt();
        try {
            checkAge(age);
            System.out.println("Access granted. Welcome!");
        } catch (InvalidAgeException e) {
            System.out.println("Access denied: " + e.getMessage());
        }
    }
}

class Ex22_FileWriting {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text to write: ");
        String text = sc.nextLine();
        try (PrintWriter pw = new PrintWriter(new FileWriter("output.txt"))) {
            pw.println(text);
        }
        System.out.println("Data written to output.txt successfully.");
    }
}

class Ex23_FileReading {
    public static void main(String[] args) throws IOException {
        System.out.println("Contents of output.txt:");
        try (BufferedReader br = new BufferedReader(new FileReader("output.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found. Run Ex22 first.");
        }
    }
}

class Ex24_ArrayList {
    public static void main(String[] args) {
        List<String> students = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter student names (blank line to stop):");
        while (true) {
            System.out.print("> ");
            String name = sc.nextLine().trim();
            if (name.isEmpty()) break;
            students.add(name);
        }
        System.out.println("\nAll students:");
        students.forEach(s -> System.out.println("  " + s));
    }
}

class Ex25_HashMap {
    public static void main(String[] args) {
        Map<Integer, String> students = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Add students (enter 0 to stop):");
        while (true) {
            System.out.print("  ID: ");
            int id = sc.nextInt(); sc.nextLine();
            if (id == 0) break;
            System.out.print("  Name: ");
            students.put(id, sc.nextLine());
        }
        System.out.print("Look up ID: ");
        int lookup = sc.nextInt();
        System.out.println(students.containsKey(lookup)
            ? "Found: " + students.get(lookup)
            : "No student with ID " + lookup);
    }
}

class PrintTask implements Runnable {
    private final String label;
    private final int times;

    PrintTask(String label, int times) {
        this.label = label;
        this.times = times;
    }

    @Override
    public void run() {
        for (int i = 1; i <= times; i++) {
            System.out.println(label + " - message " + i + " [" + Thread.currentThread().getName() + "]");
        }
    }
}
class Ex26_Threads {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new PrintTask("Thread-A", 5));
        Thread t2 = new Thread(new PrintTask("Thread-B", 5));
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Both threads finished.");
    }
}

class Ex27_Lambda {
    public static void main(String[] args) {
        List<String> words = new ArrayList<>(Arrays.asList("banana", "apple", "cherry", "date", "elderberry"));
        System.out.println("Before: " + words);
        words.sort((a, b) -> a.compareToIgnoreCase(b));
        System.out.println("After : " + words);
        words.sort((a, b) -> b.compareToIgnoreCase(a));
        System.out.println("Reverse: " + words);
    }
}

class Ex28_StreamAPI {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);

        List<Integer> evens = numbers.stream()
                                     .filter(n -> n % 2 == 0)
                                     .collect(Collectors.toList());
        System.out.println("Even numbers: " + evens);

        int sum = evens.stream().mapToInt(Integer::intValue).sum();
        System.out.println("Sum of evens: " + sum);
    }
}

record Person(String name, int age) {}

class Ex29_Records {
    public static void main(String[] args) {
        List<Person> people = List.of(
            new Person("Alice", 30),
            new Person("Bob", 17),
            new Person("Carol", 25),
            new Person("Dave", 15)
        );
        System.out.println("All: " + people);

        List<Person> adults = people.stream()
                                    .filter(p -> p.age() >= 18)
                                    .collect(Collectors.toList());
        System.out.println("Adults: " + adults);
    }
}

class Ex30_PatternSwitch {
    static String describe(Object obj) {
        return switch (obj) {
            case Integer i -> "Integer with value " + i;
            case String s  -> "String of length " + s.length() + ": \"" + s + "\"";
            case Double d  -> "Double: " + d;
            case int[] a   -> "int[] of length " + a.length;
            case null      -> "null reference";
            default        -> "Unknown type: " + obj.getClass().getSimpleName();
        };
    }
    public static void main(String[] args) {
        Object[] samples = { 42, "Hello", 3.14, new int[]{1, 2, 3}, null, true };
        for (Object o : samples) System.out.println(describe(o));
    }
}

class Ex31_JdbcBasic {
    static final String URL = "jdbc:sqlite:school.db";

    public static void main(String[] args) throws Exception {
        try (Connection conn = DriverManager.getConnection(URL);
             Statement stmt = conn.createStatement()) {

            stmt.execute("CREATE TABLE IF NOT EXISTS students (id INTEGER PRIMARY KEY, name TEXT, grade TEXT)");
            stmt.execute("INSERT OR IGNORE INTO students VALUES (1,'Alice','A')");
            stmt.execute("INSERT OR IGNORE INTO students VALUES (2,'Bob','B')");

            ResultSet rs = stmt.executeQuery("SELECT * FROM students");
            System.out.println("ID | Name  | Grade");
            System.out.println("---|-------|------");
            while (rs.next()) {
                System.out.printf("%-2d | %-5s | %s%n",
                    rs.getInt("id"), rs.getString("name"), rs.getString("grade"));
            }
        }
    }
}

class StudentDAO {
    private final Connection conn;

    StudentDAO(Connection conn) { this.conn = conn; }

    void insert(int id, String name, String grade) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(
                "INSERT OR REPLACE INTO students(id,name,grade) VALUES(?,?,?)")) {
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setString(3, grade);
            ps.executeUpdate();
        }
    }

    void update(int id, String newGrade) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(
                "UPDATE students SET grade=? WHERE id=?")) {
            ps.setString(1, newGrade);
            ps.setInt(2, id);
            ps.executeUpdate();
        }
    }
}
class Ex32_JdbcInsertUpdate {
    public static void main(String[] args) throws Exception {
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:school.db")) {
            conn.createStatement().execute(
                "CREATE TABLE IF NOT EXISTS students(id INTEGER PRIMARY KEY, name TEXT, grade TEXT)");
            StudentDAO dao = new StudentDAO(conn);
            dao.insert(3, "Carol", "C");
            System.out.println("Inserted Carol.");
            dao.update(3, "A");
            System.out.println("Updated Carol's grade to A.");
        }
    }
}

class Ex33_JdbcTransaction {
    static final String URL = "jdbc:sqlite:bank.db";

    static void transfer(Connection conn, int from, int to, double amount) throws SQLException {
        conn.setAutoCommit(false);
        try {
            try (PreparedStatement debit = conn.prepareStatement(
                    "UPDATE accounts SET balance = balance - ? WHERE id = ?")) {
                debit.setDouble(1, amount);
                debit.setInt(2, from);
                debit.executeUpdate();
            }
            try (PreparedStatement credit = conn.prepareStatement(
                    "UPDATE accounts SET balance = balance + ? WHERE id = ?")) {
                credit.setDouble(1, amount);
                credit.setInt(2, to);
                credit.executeUpdate();
            }
            conn.commit();
            System.out.println("Transfer of $" + amount + " successful.");
        } catch (SQLException e) {
            conn.rollback();
            System.out.println("Transfer failed, rolled back: " + e.getMessage());
            throw e;
        } finally {
            conn.setAutoCommit(true);
        }
    }

    public static void main(String[] args) throws Exception {
        try (Connection conn = DriverManager.getConnection(URL)) {
            conn.createStatement().execute(
                "CREATE TABLE IF NOT EXISTS accounts(id INTEGER PRIMARY KEY, balance REAL)");
            conn.createStatement().execute("INSERT OR IGNORE INTO accounts VALUES(1, 1000.0)");
            conn.createStatement().execute("INSERT OR IGNORE INTO accounts VALUES(2, 500.0)");
            transfer(conn, 1, 2, 200.0);
        }
    }
}

class Ex34_Modules {
    public static void main(String[] args) {
        System.out.println("Module structure (run from separate directories):");
        System.out.println("  module com.utils  { exports com.utils; }");
        System.out.println("  module com.greetings { requires com.utils; }");
        System.out.println("Compile: javac --module-source-path src -d out -m com.utils,com.greetings");
        System.out.println("Run:     java --module-path out -m com.greetings/com.greetings.Main");
    }
}

class Ex35_Server {
    public static void main(String[] args) throws IOException {
        int port = 9090;
        System.out.println("Server listening on port " + port + "...");
        try (ServerSocket ss = new ServerSocket(port);
             Socket client = ss.accept();
             BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
             PrintWriter out = new PrintWriter(client.getOutputStream(), true);
             Scanner sc = new Scanner(System.in)) {

            System.out.println("Client connected: " + client.getInetAddress());
            out.println("Welcome to the Java chat server!");
            String msg;
            while ((msg = in.readLine()) != null) {
                System.out.println("Client: " + msg);
                System.out.print("Server> ");
                String reply = sc.nextLine();
                out.println(reply);
                if ("bye".equalsIgnoreCase(reply)) break;
            }
        }
    }
}
class Ex35_Client {
    public static void main(String[] args) throws IOException {
        try (Socket socket = new Socket("localhost", 9090);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             Scanner sc = new Scanner(System.in)) {

            System.out.println("Server: " + in.readLine());
            while (true) {
                System.out.print("Client> ");
                String msg = sc.nextLine();
                out.println(msg);
                String reply = in.readLine();
                System.out.println("Server: " + reply);
                if ("bye".equalsIgnoreCase(reply)) break;
            }
        }
    }
}

class Ex36_HttpClient {
    public static void main(String[] args) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("https://api.github.com/users/torvalds"))
            .header("Accept", "application/json")
            .GET()
            .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("Status: " + response.statusCode());
        String body = response.body();
        System.out.println("Body: " + body.substring(0, Math.min(500, body.length())) + "...");
    }
}

class SampleForBytecode {
    public int addNumbers(int a, int b) { return a + b; }
    public String greet(String name) { return "Hello, " + name; }
}
class Ex37_Bytecode {
    public static void main(String[] args) {
        System.out.println("After compiling, run: javap -c SampleForBytecode");
        SampleForBytecode s = new SampleForBytecode();
        System.out.println("addNumbers(3, 4) = " + s.addNumbers(3, 4));
        System.out.println("greet(Java) = " + s.greet("Java"));
    }
}

class Ex38_Decompile {
    public static void main(String[] args) {
        System.out.println("Decompile with CFR: java -jar cfr.jar SampleForBytecode.class");
        System.out.println("Or open the .class file in JD-GUI.");
    }
}

class TargetClass {
    private String secret = "hidden value";
    public int square(int n) { return n * n; }
    public String greet(String name) { return "Hi, " + name + "!"; }
}
class Ex39_Reflection {
    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("TargetClass");
        System.out.println("Class: " + clazz.getName());

        System.out.println("\nDeclared methods:");
        for (Method m : clazz.getDeclaredMethods()) {
            System.out.println("  " + m);
        }

        Object obj = clazz.getDeclaredConstructor().newInstance();

        Method square = clazz.getMethod("square", int.class);
        System.out.println("\nsquare(7) = " + square.invoke(obj, 7));

        Method greet = clazz.getMethod("greet", String.class);
        System.out.println("greet(Reflection) = " + greet.invoke(obj, "Reflection"));

        Field f = clazz.getDeclaredField("secret");
        f.setAccessible(true);
        System.out.println("private field 'secret' = " + f.get(obj));
    }
}

class Ex40_VirtualThreads {
    public static void main(String[] args) throws InterruptedException {
        int count = 100_000;
        List<Thread> threads = new ArrayList<>(count);

        long start = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            final int id = i;
            threads.add(Thread.startVirtualThread(() -> {
                if (id < 3) System.out.println("Virtual thread #" + id + " running");
            }));
        }
        for (Thread t : threads) t.join();
        long elapsed = System.currentTimeMillis() - start;

        System.out.println("Launched " + count + " virtual threads in " + elapsed + " ms");
    }
}

class Ex41_ExecutorCallable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(4);

        List<Callable<Integer>> tasks = new ArrayList<>();
        for (int i = 1; i <= 8; i++) {
            final int n = i;
            tasks.add(() -> {
                int result = n * n;
                System.out.println(Thread.currentThread().getName() + " computed " + n + "^2 = " + result);
                return result;
            });
        }

        List<Future<Integer>> futures = executor.invokeAll(tasks);

        int total = 0;
        for (Future<Integer> f : futures) total += f.get();
        System.out.println("Sum of squares 1..8 = " + total);

        executor.shutdown();
    }
}
