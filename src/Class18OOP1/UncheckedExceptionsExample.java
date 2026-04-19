package Class18OOP1;

// Unchecked Exceptions are exceptions that happen at runtime and are NOT checked by the compiler.
//      - You are not forced to handle them.
//      - i.e. These are usually programmer bugs.
// Examples:
//      NullPointerException
//      ArithmeticException
//      ArrayIndexOutOfBoundsException
//      ClassCastException
//      IllegalArgumentException
public class UncheckedExceptionsExample {
    public static void main(String[] args) {
        try {
            // badCalculation();
            goodCalculation();
            
            return;
        } catch (ArithmeticException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Unexpected exception caught: ");
            e.printStackTrace();
        } finally {
            // Finally block will always be executed (without exception or not), even with a return.
            // Where will finally block be mostly used?
            // In a multithreading environment where we want to acquire locks or shared resources.
            // We must release the lock or the shared resources in the finally block such that other threads can access them.
            // Deadlock 
            // Agent A --> resource X --> and tries to acquire Y before it can finish work and release X
            // Agent B --> resource Y --> and tries to acquire X before it can finish work and release Y
            System.out.println("We survived!!!!");
        }
    }

    public static void badCalculation() throws ArithmeticException {
        try {
            System.out.println(10 / 0); // ArithmeticException, No compiler warning.
        } catch (ArithmeticException e) {
            // catch了但是不知道怎么处理
            // 我的上一层的caller可能有更多的info，那我就原模原样的throw这个exception，让上级处理
            throw e;
        }
    }

    public static void goodCalculation() {
        System.out.println(10 / 1);
    }

    // public static void WrongWayOfCatchingExceptions() {
    //     try {
    //         badCalculation();
    //     } catch (Exception e) {
    //         System.out.println("Exception is caught");
    //     } catch (ArithmeticException e) {
    //         // Compile error since IOException is an Exception, it will never reach here
    //         System.out.println("ArithmeticException is caught");
    //     }
    // }
}
