package com.university.project;

public class Calc extends Compf {
    private StackInt s;
    private static int char2int(char c) {
        return (int)c - (int) '0';
    }
    protected int symOther(char c) {
        if (c < '0' || c > '9') {
            System.out.println("Недопустимый символ: " + c);
            System.exit(0);
        }
        return SYM_OTHER;
    }
    protected void nextOper(char c) {
        int second = s.pop();
        int first = s.pop();
        switch (c) {
            case '+':
                s.push(first + second);
                break;
            case '-':
                s.push(first - second);
                break;
            case '*':
                s.push(first * second);
                break;
            case '/':
                s.push(first / second);
                break;
            case '^' :
                int tmp = first;
                for (int i = 0; i < second - 1; i++)
                    first = first * tmp;
                s.push(first);
                break;
        }
    }
    protected void nextOther(char c) {
        if (flag) s.push(10 * s.pop() + char2int(c));
        else s.push(char2int(c)); flag = true;

    }
    public Calc() {
        s = new StackInt();
    }
    public final void compile(char[] str) {
        super.compile(str);
        System.out.println("" + s.top());
    }
}
