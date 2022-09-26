/**
 * This program creates two sphere objects, and compares their volumes and surface areas given a specified radius.
 * @author Brian Gerkens
 * @version 1
 */
public class Sphere extends Object implements Comparable<Sphere> {

    private double radius;
    private double volume;
    private double surfaceArea;

    /**
     * public Sphere()     This is the default constructor with radius = 0.
     */
    public Sphere() {
        this.radius = 0;
    }

    /**
     * public Sphere(double newRadius)      This is a constructor that will set the radius to the variable 'NewRadius'.
     *
     * @param newRadius                     The double parameter used in the setRadius method; This will be the radius of the second sphere.
     */
    public Sphere(double newRadius) {
        this.setRadius(newRadius);
    }

    /**
     * this.setRadius(newRadius)     This method takes the specified radius from main method and sets it equal to
     *                               variable 'newRadius'. Then, the area and volume are calculated based on this value.
     *                               If the specified radius is less than 0, then the radius will automatically be set to 0.
     *
     * @param newRadius              The radius specified in the main method; Will be set equal to 'this.radius', the new initialized radius.
     */
    public void setRadius(double newRadius) {
        if (newRadius >= 0) {
            this.radius = newRadius;
            getVolume();
            getSurfaceArea();
        }
        else {
            this.radius = 0;
            getVolume();
            getRadius();
        }
    }

    /**
     * mySphereA.getRadius()                 Gets the radius of sphere A.
     * mySphereB.getRadius()                 Gets the radius of sphere B.
     *
     * @return this.radius                   'this.radius' returns the specified radius that is set to the variable 'newRadius' as long as 'newRadius'
     *                                       is greater than or equal to 0. If less than 0, then 'newRadius' will automatically be set to 0.
     */
    public double getRadius() {
        return this.radius;

    }

    /**
     * mySphereA.getVolume()                 Gets the volume of sphere A.
     * mySphereB.getVolume()                 Gets the volume of sphere B.
     *
     * @return this.volume                   'this.volume' returns the value of the updated volume when there is a specified radius.
     */
    public double getVolume() {
        return this.volume = ((4 / 3) * Math.PI * Math.pow(radius, 3));
    }

    /**
     * mySphereA.getSurfaceArea()                 Gets the surface area of sphere A.
     * mySphereB.getSurfaceArea()                 Gets the surface area of sphere B.
     *
     * @return this.surfaceArea                   'this.surfaceArea' returns the value of the updated surface area when there is a specified radius.
     */
    public double getSurfaceArea() {
        return this.surfaceArea = (4 * Math.PI * Math.pow(radius, 2));
    }


    /**
     * mySphereA.toString()   Returns string representation of sphere A.
     * mySphereB.toString()   Returns string representation of sphere B.
     *
     * @return temp           'temp' is the variable that holds the value of the string representation of both spheres, including the radius, volume, and surface area.
     */
    public String toString() {
        String temp = "I am a sphere with a radius of " + this.radius + " units, a volume of " + this.volume + " cubic units, and a surface area of " + this.surfaceArea + " square units.";
        return temp;
    }

    /**
     * mySphereA.compareTo(mySphereB)  Compares the radius of the spheres.
     *
     * @param compTo                   'compTo' is the radius that will be compared to Sphere B.
     * @return -1, 1, 0               -1 if B's radius is less than compTo's, 1 if B's radius is greater than compTo's, and 0 if they are equal.
     */
    public int compareTo(Sphere compTo) {

        if (this.radius < compTo.radius) {
            return -1;
        }
        else if (this.radius > compTo.radius) {
            return 1;
        }
        else {
            return 0;
        }
    }

    /**
     * This method creates two sphere objects by calling their constructors, and printing out a series
     * of information, including radius, volume, surface area, string representation of sphere, and the
     * compareTo function, based on the specified radii. (radius = 0 for default constructor, radius = 10
     * for second constructor).
     *
     * @param args      Command-line arguments.
     */
    public static void main(String[] args) {
        Sphere mySphereA = new Sphere();    //Calling default constructor with radius set to 0
        Sphere mySphereB = new Sphere(5);   //Calling second constructor with radius set to 5

        // TESTING
        Sphere testSphere = new Sphere();
        System.out.println();
        System.out.println("Beginning tests...");
        System.out.println();

        // Using for-loops to pass through radius values between 0 and 1,000,000.
        for (double i = 0; i < 100000; i++) {
            testSphere.setRadius(i);

            // For the if-statements below, we use != instead of == because 'testSphere.getRadius()' should be equivalent
            // to each iteration of i >= 0. We must use a break statement because if a failed test occurs, the print
            // statement will be printed through each iteration of the loop. 'break;' allows us to break the loop once
            // a failure has been spotted.

            if (i != testSphere.getRadius()) {
                System.out.println("   FAILED set/get radius method for looping radius values from 0 to 100,000.");
            }
            else {
                System.out.println("   PASSED set/get radius method for looping radius values from 0 to 100,000.");
            }
            break;
        }
        //getVolume()
        for (double i = 0; i < 100000; i++) {
            testSphere.setRadius(i);
            if (testSphere.getVolume() != (4 / 3) * Math.PI * Math.pow(i, 3)) {
                System.out.println("   FAILED getVolume() method for looping radius values from 0 to 100,000.");
            }
            else {
                System.out.println("   PASSED getVolume() method for looping radius values from 0 to 100,000.");
            }
            break;
        }
        //getSurfaceArea()
        for (double i = 0; i < 100000; i++) {
            testSphere.setRadius(i);
            if (testSphere.getSurfaceArea() != (4 * Math.PI * Math.pow(i, 2))) {
                System.out.println("   FAILED getSurfaceArea() method for looping radius values from 0 to 100,000.");
            }
            else {
                System.out.println("   PASSED getSurfaceArea() method for looping radius values from 0 to 100,000.");
            }
            break;
        }

        // Using for-loops to pass through radius values between -1,000,000 and 0.
        for (double i = -100000; i < 0; i++) {
            testSphere.setRadius(i);

            // For the if-statements below, we use == instead of != because testSphere.getRadius() should not be equivalent
            // to each iteration of i < 0. This is because in the setRadius() method, we set any given radius value
            // below 0, to 0. (i.e. negative values will automatically be set to 0)

            if (testSphere.getRadius() == i) {
                System.out.println("   FAILED set/get radius method for looping radius values from -100,000 to 0.");
            }
            else {
                System.out.println("   PASSED getS/get radius method for looping radius values from -100,000 to 0.");
            }
            break;
        }
        //getVolume()
        for (double i = -100000; i < 0; i++) {
            testSphere.setRadius(i);
            if (testSphere.getVolume() == (4 / 3) * Math.PI * Math.pow(i, 3)) {
                System.out.println("   FAILED getVolume() method for looping radius values from -100,000 to 0.");
            }
            else {
                System.out.println("   PASSED getVolume() method for looping radius values from -100,000 to 0.");
            }
            break;
        }
        //getSurfaceArea
        for (double i = -100000; i < 0; i++) {
            testSphere.setRadius(i);
            if (testSphere.getSurfaceArea() == (4 * Math.PI * Math.pow(i, 2))) {
                System.out.println("   FAILED getSurfaceArea() method for looping radius values from -100,000 to 0.");
            }
            else {
                System.out.println("   PASSED getSurfaceArea() method for looping radius values from -100,000 to 0.");
            }
            break;
        }

        // Passing through a large positive double value
        testSphere.setRadius(50000.505);
        if (testSphere.getRadius() != 50000.505) {
            System.out.println("   FAILED set/get Radius for double value 50,000.505");
        }
        else {
            System.out.println("   PASSED set/get Radius for double value 50,000.505");
        }
        //getVolume()
        if (testSphere.getVolume() != (4 / 3) * Math.PI * Math.pow(50000.505, 3)) {
            System.out.println("   FAILED getVolume() for Radius of double value 50,000.505");
        }
        else {
            System.out.println("   PASSED getVolume() for Radius of double value 50,000.505");
        }
        //getSurfaceArea
        if (testSphere.getSurfaceArea() != (4 * Math.PI * Math.pow(50000.505, 2))) {
            System.out.println("   FAILED getSurfaceArea() for Radius of 50,000.505");
        }
        else {
            System.out.println("   PASSED getSurfaceArea() for Radius of double value 50,000.505");
        }

        // Passing through a large negative double value
        testSphere.setRadius(-50000.505);
        if (testSphere.getRadius() != 0) {
            System.out.println("   FAILED set/get Radius for negative double value -50,000.505");
        }
        else {
            System.out.println("   PASSED set/get Radius for negative double value -50,000.505");
        }
        //getVolume()
        if (testSphere.getVolume() != 0) {
            System.out.println("   FAILED getVolume() for Radius of negative double value -50,000.505");
        }
        else {
            System.out.println("   PASSED getVolume() for negative double value -50,000.505");
        }
        //getSurfaceArea()
        if (testSphere.getSurfaceArea() != 0) {
            System.out.println("   FAILED getSurfaceArea() for Radius of negative double value -50,000.505");
        }
        else {
            System.out.println("   PASSED getSurfaceArea() for negative double value -50,000.505");
        }

        //toString() method using a for-loop, iterating values between 0 and 100,000.
        for (double i = 0; i < 100000; i++) {
             testSphere.setRadius(i);
             String s = "I am a sphere with a radius of " + i + " units, a volume of " + (4 / 3) * Math.PI * Math.pow(i, 3) + " cubic units, and a surface area of " + (4 * Math.PI * Math.pow(i, 2)) + " square units.";
             if (testSphere.toString() != s) {
                 System.out.println("   FAILED toString() method for looping radius values from 0 to 100,000.");
             }
             else {
                 System.out.println("   PASSED toString() method for looping radius values from 0 to 100,000.");
             }
             break;
         }
        //toString() method using a for-loop, iterating values between -100,000 and 0.
        for (double i = -100000; i < 0; i++) {
            testSphere.setRadius(i);
            String s = "I am a sphere with a radius of " + i + " units, a volume of " + (4 / 3) * Math.PI * Math.pow(i, 3) + " cubic units, and a surface area of " + (4 * Math.PI * Math.pow(i, 2)) + " square units.";
            if (testSphere.toString() != s) {
                System.out.println("   FAILED toString() method for looping radius values from -100,000 to 0.");
            }
            else {
                System.out.println("   PASSED toString() method for for looping radius values from -100,000 to 0.");
            }
            break;
        }

        //compareTo() method using for-loop between values 0 and 4.
        for (double i = -100000; i < 4; i++) {
            testSphere.setRadius(i);
            if (testSphere.compareTo(mySphereB) != -1) {
                System.out.println("   FAILED compareTo() method with values ranging from -100,000 to 4.");
            }
            else {
                System.out.println("   PASSED compareTo() method with values ranging from -100,000 to 4.");
            }
            break;
        }
        //compareTo() method using for-loop between values 6 and 100,000.
        for (double i = 6; i < 100000; i++) {
            testSphere.setRadius(i);
            if (testSphere.compareTo(mySphereB) != 1) {
                System.out.println("   FAILED compareTo() method with values ranging from 6 to 100,000.");
            }
            else {
                System.out.println("   PASSED compareTo() method with values ranging from 6 to 100,000.");
            }
            break;
        }
        //compareTo() method using radius as 5
        testSphere.setRadius(5);
        if (testSphere.compareTo(mySphereB) != 0) {
            System.out.print("   FAILED compareTo() method with value of 5");
        }
        else {
            System.out.println("   PASSED compareTo() method with value of 5");
        }
        System.out.println();
        System.out.println("Tests complete.");
        System.out.println();


        //Sphere A execution
        System.out.println();
        System.out.println("SPHERE A:");
        System.out.println(mySphereA.toString());
        System.out.println("Radius: " + mySphereA.getRadius());
        System.out.println("Volume: " + mySphereA.getVolume());
        System.out.println("Surface area: " + mySphereA.getSurfaceArea());
        System.out.println();
        //Sphere B execution
        System.out.println("SPHERE B:");
        System.out.println(mySphereB.toString());
        System.out.println("Radius: " + mySphereB.getRadius());
        System.out.println("Volume: " + mySphereB.getVolume());
        System.out.println("Surface area: " + mySphereB.getSurfaceArea());
        System.out.println();
        System.out.println("compareTo function result: " + mySphereA.compareTo(mySphereB));
        System.out.println();
    }
}