/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


interface Functions {
    String getName();
    double f(double x);
}

class f1 implements Functions {
    @Override
    public String getName() {
        return "|x|";
    }
    
    @Override
    public double f(double x) {
        return Math.abs(x);
    }
}

class f2 implements Functions {
    @Override
    public String getName() {
        return "cos(x)";
    }
    
    @Override
    public double f(double x) {
        return Math.cos(x);
    }
}

class f3 implements Functions {
    @Override
    public String getName() {
        return "2exp(x)-3";
    }
    
    @Override
    public double f(double x) {
        return 2*Math.exp(x)-3;
    }
}

class f4 implements Functions {
    private final int[] a = {1,2,-5,3,-1};
	
    private String sign(int i) {
        if (i == 0 & a[i] > 0) return "";
        return a[i] < 0 ? "-" : "+";
    }

    private String coef(int i) {
        if (i != a.length-1 & Math.abs(a[i]) == 1) return "";
        return "" + Math.abs(a[i]);
    }

    private String power(int i) {
        if (i == a.length-1) return "";
        if (i == a.length-2) return "x";
        return "x^" + (a.length - 1 - i);
    }
    
    @Override
    public String getName() {
        String s = "";
        for (int i = 0; i < a.length; i++) {
            if (a[i] !=0)
               s += "" + sign(i) + coef(i) + power(i);
        }
        return "exp(-x) * "+s;
    }
    
    @Override
    public double f(double x) {
        double result = a[0];
        for (int i = 1; i < a.length; i++) {
            result *= x;
            result += a[i];
        }
        return Math.exp(-x) * result;
    }
}