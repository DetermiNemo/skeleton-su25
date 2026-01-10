import org.junit.Rule;
import org.junit.Test;
import static com.google.common.truth.Truth.assertWithMessage;
public abstract class TriangleTest {

    /** For autograding purposes; do not change this line. */
    abstract Triangle getNewTriangle();

    /* ***** TESTS ***** */

    // FIXME: Add additional tests for Triangle.java here that pass on a
    //  correct Triangle implementation and fail on buggy Triangle implementations.

    @Test
    public void sidesFormTest() {
        Triangle t = getNewTriangle();
        assertWithMessage("Wrong").that(t.sidesFormTriangle(2, 2, 3)).isTrue();
        assertWithMessage("Wrong").that(t.sidesFormTriangle(1, 2, 3)).isFalse();
        assertWithMessage("Wrong").that(t.sidesFormTriangle(-1, 2, 3)).isFalse();
        assertWithMessage("Wrong").that(t.sidesFormTriangle(0, 2, 3)).isFalse();
        assertWithMessage("Wrong").that(t.sidesFormTriangle(1000, 2, 3)).isFalse();
        assertWithMessage("Wrong").that(t.sidesFormTriangle(1, 2000, 3)).isFalse();
        assertWithMessage("Wrong").that(t.sidesFormTriangle(1, 2, 3000)).isFalse();
        // remember that you'll have to call on Triangle methods like
        // t.functionName(arguments), where t is a Triangle object
    }

    @Test
    public void pointsFormTest() {
        Triangle t = getNewTriangle();
        assertWithMessage("Wrong").that(t.pointsFormTriangle(0, 0, 3, 0, 0, 4)).isTrue();
        assertWithMessage("Wrong").that(t.pointsFormTriangle(2, 3, 3, 9, 12, 4)).isTrue();
        assertWithMessage("Wrong").that(t.pointsFormTriangle(2, 3, 2, 9, 2, 4)).isFalse();
    }

    @Test
    public void triangleTypeTest() {
        Triangle t = getNewTriangle();
        assertWithMessage("Wrong").that(t.triangleType(1, 1, 1)).isEqualTo("Equilateral");
        assertWithMessage("Wrong").that(t.triangleType(1, 2, 2)).isEqualTo("Isosceles");
        assertWithMessage("Wrong").that(t.triangleType(2, 4, 3)).isEqualTo("Scalene");
    }

    @Test
    public void squaredHypotenuseTest() {
        Triangle t = getNewTriangle();
        assertWithMessage("Wrong").that(t.squaredHypotenuse(3, 4)).isEqualTo(25);
        assertWithMessage("Wrong").that(t.squaredHypotenuse(5, 4)).isEqualTo(41);
    }


}
