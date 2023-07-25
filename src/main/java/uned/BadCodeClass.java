package uned;

import java.io.*;

public class BadCodeClass {

    //TODO Añadir la prioridad de los operadores (* y / antes que + y -).
    //TODO Añadir soporte de operaciones con paréntesis.
    //TODO Devolver resultado en formato decimal para evitar el truncado final.

    /**
     * Calcula una operación matemática con números enteros.
     * Por ejemplo: "1 - 2 * 3 * 3 + 5 / 2 + 3 - 9".
     *
     * @param op Operación en formato texto.
     * @return
     * @throws Exception
     */
    public static int c(String op) throws Exception {
        int result;
        int p = op.length() - 1;
        result = 0;
        if (p > -1) {
            while (p > -1 && op.charAt(p) == ' ') p = p - 1;
            char c = op.charAt(p);
            String nStr = new String() + c;
            if (p == 0) {
            } else {
                int p2 = p - 1;
                while (p2 < op.length() && !(op.charAt(p2) == ' ' || op.charAt(p2) == '+' || op.charAt(p2) == '-' || op.charAt(p2) == '*' || op.charAt(p2) == '/')) {
                    char c2 = op.charAt(p2);
                    nStr = c2 + nStr;
                    p2--;
                }
                p = p2;
            }
            boolean enc = false;
            int n = new Integer(nStr);
            result = n;
            while (p > -1 && op.charAt(p) == ' ') p = p - 1;
            int l = op.length();
            String errorMsg;
            if (p > -1)
                switch (op.charAt(p)) {
                    case '+':
                        while (p > -1 && op.charAt(p) == ' ') {
                            enc = true;
                            p = p - 1;
                        }
                        if (enc && "0123456789".indexOf(op.charAt(p)) == -1) {
                            Exception e = new BadOperationException();
                            throw e;
                        } else {
                            p--;
                        }
                        result = new BadCodeClass().calc2(n, '+', p, op, "0123456789", l);
                        break;
                    case '-':
                        while (p > -1 && op.charAt(p) == ' ') {
                            enc = true;
                            p = p - 1;
                        }
                        try {
                            if (enc && "0123456789".indexOf(op.charAt(p)) == -1) {
                                Exception e = new BadOperationException();
                                throw e;
                            } else {
                                p--;
                            }
                        } catch (Exception e) {
                            errorMsg = "Substraction error";
                            // System.out.println(errorMsg);
                            throw new BadOperationException();
                        }
                        result = new BadCodeClass().calc2(n, '-', p, op, "0123456789", l);
                        break;
                    case '*':
                        while (p > -1 && op.charAt(p) == ' ') {
                            enc = true;
                            p = p - 1;
                        }
                        if (enc && "0123456789".indexOf(op.charAt(p)) == -1) {
                            Exception e = new BadOperationException();
                            throw e;
                        } else {
                            p--;
                        }
                        result = new BadCodeClass().calc2(n, '*', p, op, "0123456789", l);
                        break;
                    case '/':
                        while (p > -1 && op.charAt(p) == ' ') {
                            enc = true;
                            p = p - 1;
                        }
                        if (enc && "0123456789".indexOf(op.charAt(p)) == -1) {
                            Exception e = new BadOperationException();
                            throw e;
                        } else {
                            p--;
                        }
                        result = new BadCodeClass().calc2(n, '/', p, op, "0123456789", l);
                        break;
                    default:
                        break;
                }
            else {
                // p = p + 1;
            }
            p = p - 1;
        }
        if (op.trim().length() == 0)
            throw (Exception) new BadOperationException();
        return result;
    }

    public int calc2(int result, char c, int p, String op, String s, int l) throws Exception {
        switch (c) {
            case '+':
                return c(op.substring(0, p + 1)) + result;
            case '-':
                return c(op.substring(0, p + 1)) - result;
            case '*':
                return c(op.substring(0, p + 1)) * result;
            case '/':
                return c(op.substring(0, p + 1)) / result;
            default:
                break;
        }
        return 0;
    }
}
