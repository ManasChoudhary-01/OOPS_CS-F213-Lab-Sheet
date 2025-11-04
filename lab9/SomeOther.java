package lab9;

class StaticOuter {

    String a = "Static Outer string";
    static String b = "Static Outer static string";

    void seeStaticInner() {
        // System.out.println(nonstatic); // ❌ Error: nonstatic is not static
        // System.out.println(StaticInner.nonstatic); // ❌ Error: Cannot make static reference to non-static field
        System.out.println(new StaticInner().nonstatic); // ✅ OK - Accessing non-static member through object
        System.out.println(StaticInner.s);                // ✅ OK - 's' is static
    }

    public static void main(String[] args) {
        // System.out.println(s); // ❌ Error: Needs explicit class reference
        System.out.println(StaticInner.s); // ✅ Accessing static inner class's static variable
        StaticOuter so = new StaticOuter();
        so.seeStaticInner();
    }

    static class StaticInner {
        String nonstatic = "Static Inner nonstatic string";
        static String s = "Static Inner static string";

        public static void main(String[] args) {
            // System.out.println(nonstatic); // ❌ Error: nonstatic cannot be referenced from a static context
            System.out.println(s); // ✅ OK - Accessing static member
            System.out.println(b); // ✅ OK - 'b' is a static member of StaticOuter
        }
    }
}

class SomeOther {
    public static void main(String[] args) {
        System.out.println(StaticOuter.StaticInner.s); // ✅ OK: Static reference to static member

        StaticOuter.StaticInner si = new StaticOuter.StaticInner();
        System.out.println(si.nonstatic); // ✅ Accessing non-static member through object
        // System.out.println(si.s);         // ⚠️ Works, but not recommended for static members
    }
}

