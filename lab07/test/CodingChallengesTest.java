import org.junit.Test;

import static com.google.common.truth.Truth.assertWithMessage;

public class CodingChallengesTest {

    @Test
    public void testMissingNumber() {
        assertWithMessage("normal MissingNumber failed").that(CodingChallenges.missingNumber(new int[]{1, 3, 5, 4, 0})).isEqualTo(2);
        assertWithMessage("One number MissingNumber failed").that(CodingChallenges.missingNumber(new int[]{1})).isEqualTo(0);
    }

    @Test
    public void testIsPermutation() {
        assertWithMessage("Wrong comparision of abcde and ecbda").that(CodingChallenges.isPermutation("abcde", "ecbda")).isTrue();
        assertWithMessage("Wrong comparision of bcde and ebda").that(CodingChallenges.isPermutation("bcde", "ebda")).isFalse();
        assertWithMessage("Wrong comparision of 1234 and 3214").that(CodingChallenges.isPermutation("1234", "3214")).isTrue();
        assertWithMessage("Wrong comparision of empty strings").that(CodingChallenges.isPermutation("", "")).isTrue();
    }
}
