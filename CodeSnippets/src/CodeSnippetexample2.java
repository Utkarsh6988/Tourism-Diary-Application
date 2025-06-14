
public class CodeSnippetexample2 {
static int count = 0;
public static synchronized void inc() { count++; }
public static void main(String[] args) {
Runnable r = () -> { for (int i = 0; i < 1000; i++) inc(); };
new Thread(r).start();
new Thread(r).start();
System.out.print(count);
}
}

//With synchronization