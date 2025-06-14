
public class CodeSnippetExample {
static int count = 0;
public static void main(String[] args) {
Runnable r = () -> { for (int i = 0; i < 1000; i++) count++; };
new Thread(r).start();
new Thread(r).start();
System.out.print(count);
}
}

//Without synchronization 
//0 (if main prints before threads start).
