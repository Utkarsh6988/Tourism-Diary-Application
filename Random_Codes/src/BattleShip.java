import java.util.*;

public class BattleShip {
    public static void main(String[] args) {
        long map = -1150950973573693440L;

        String binary = Long.toBinaryString(map);
        StringBuilder b2s = new StringBuilder(binary);
        System.out.println(binary);

        List<Object> shots = List.of("A1", "B2", "C3", "D4");

        for (int i = 0; i < shots.size(); i++) {
            String s = (String) shots.get(i);
            char first = s.charAt(0);
            char second = s.charAt(1);
            // System.out.println((int) 'a');

            int pos = ((int) first - 65) * 8 + (int) second - 49;
            // System.out.println(pos);

            if (binary.charAt(pos) == '0') {
                b2s.setCharAt(pos, '2');
            } else if (binary.charAt(pos) == '1') {
                b2s.setCharAt(pos, '3');
            }

        }

        for (int i = 0; i < binary.length(); i++) {

            char ch = b2s.charAt(i);
            if (ch == '0') {
                System.out.print('.');
            } else if (ch == '1') {
                System.out.print('y');
            } else if (ch == '2') {
                System.out.print('x');
            } else if (ch == '3') {
                System.out.print('z');
            }

            if ((i + 1) % 8 == 0)
                System.out.println();
        }

        for (int i = 0; i < binary.length(); i++) {

            char ch = b2s.charAt(i);
            if (ch == '0') {
                System.out.print('.');
            } else if (ch == '1') {
                System.out.print('☐');
            } else if (ch == '2') {
                System.out.print('×');
            } else if (ch == '3') {
                System.out.print('☒');
            }

            if ((i + 1) % 8 == 0)
                System.out.println();
        }
        System.out.println(b2s.toString());
        /*
         * for (Object s : shots) {
         * String new = (String) s;
         * int pos = (int) s.charAt(0);
         * }
         * 
         * 
         * System.out.println((char) 65);
         * 
         * System.out.println(binary);
         */
    }
}